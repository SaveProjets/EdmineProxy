package fr.edminecoreteam.edmineproxy;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

import fr.edminecoreteam.edmineproxy.commands.CommandTest;
import fr.edminecoreteam.edmineproxy.commands.EdmineCommand;
import fr.edminecoreteam.edmineproxy.maintenance.MaintenanceCommand;
import fr.edminecoreteam.edmineproxy.maintenance.MaintenanceLogEvent;
import fr.edminecoreteam.edmineproxy.maintenance.MaintenancePingListener;
import fr.edminecoreteam.edmineproxy.maintenance.Manager;
import fr.edminecoreteam.edmineproxy.mysql.MySQL;
import fr.edminecoreteam.edmineproxy.party.InvitationsManager;
import fr.edminecoreteam.edmineproxy.party.PartyCommand;
import fr.edminecoreteam.edmineproxy.party.PartyListener;
import fr.edminecoreteam.edmineproxy.party.PartyMessage;
import fr.edminecoreteam.edmineproxy.profile.friend.FriendCommand;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class EdmineProxy extends Plugin
{
    private static EdmineProxy instance;
    private static Plugin plugin;
    public static MySQL database;
    public InvitationsManager invitationManager;
    private Configuration config;


    public EdmineProxy() {
        invitationManager = new InvitationsManager();
    }

    @Override
    public void onEnable()
    {
        loadConfig();
        Manager.init();
        databaseConnect();

        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable()
    {
        EdmineProxy.database.deconnexion();
    }

    private void databaseConnect()
    {


        (EdmineProxy.database = new MySQL("jdbc:mysql://", config.getString("mysql.host"), config.getString("mysql.database"), config.getString("mysql.user"), config.getString("mysql.password"))).connexion();
        if (!database.isOnline()) { return; }
        refreshConnexion();
        EdmineProxy.database.creatingTableMaintenance();
        EdmineProxy.database.creatingTableFriends();
        EdmineProxy.database.creatingTablePartyList();
        EdmineProxy.database.creatingTablePartyBan();
    }

    private void registerListeners()
    {
        EdmineProxy.instance = this;
        getProxy().getPluginManager().registerListener(this, new MaintenanceLogEvent());
        getProxy().getPluginManager().registerListener(this, new MaintenancePingListener());
        getProxy().getPluginManager().registerListener(this, new PartyListener());
    }

    private void registerCommands()
    {
        getProxy().getPluginManager().registerCommand(this, (Command)new MaintenanceCommand(this));
        getProxy().getPluginManager().registerCommand((Plugin)this, (Command)new FriendCommand("Friend"));
        getProxy().getPluginManager().registerCommand((Plugin)this, (Command)new FriendCommand("F"));

        getProxy().getPluginManager().registerCommand((Plugin)this, (Command)new PartyCommand("Party"));
        getProxy().getPluginManager().registerCommand((Plugin)this, (Command)new PartyCommand("P"));

        getProxy().getPluginManager().registerCommand(this, new EdmineCommand(this));
        getProxy().getPluginManager().registerCommand(this, new CommandTest(this));
    }

    public void refreshConnexion()
    {
        ProxyServer.getInstance().getScheduler().schedule((Plugin)this, (Runnable)new Runnable()
        {
            @Override
            public void run()
            {
                if (!EdmineProxy.database.isOnline())
                {
                    EdmineProxy.database.connexion();
                    run();
                }
                else
                {
                    EdmineProxy.database.deconnexion();
                    EdmineProxy.database.connexion();
                }
            }
        }, 0L, 120L, TimeUnit.SECONDS);
    }

    private void loadConfig() {
        File ord = new File("plugins/API");
        if (!ord.exists()) {
            ord.mkdir();
        }
        File configFile = new File("plugins/API", "mysql.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Charger la configuration depuis le fichier
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void scheduleDelayedTaskForPlayer(ProxiedPlayer player, String targetName) {
        ProxyServer.getInstance().getScheduler().schedule((Plugin)this, (Runnable)new Runnable()
        {
            @Override
            public void run()
            {
                invitationManager = new InvitationsManager();
                invitationManager.removeInvitation(player.getName(), targetName);
                PartyMessage.expireInvitation(player, targetName);
                return;
            }
        }, 60L, TimeUnit.SECONDS);
    }

    public static EdmineProxy getInstance() { return EdmineProxy.instance; }
    public static Plugin getPlugin() { return EdmineProxy.plugin; }
    public static Connection getDatabase() { return MySQL.getConnection(); }
}
