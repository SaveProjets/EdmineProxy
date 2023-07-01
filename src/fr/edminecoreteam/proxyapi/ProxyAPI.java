package fr.edminecoreteam.proxyapi;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

import fr.edminecoreteam.proxyapi.maintenance.MaintenanceCommand;
import fr.edminecoreteam.proxyapi.maintenance.MaintenanceLogEvent;
import fr.edminecoreteam.proxyapi.maintenance.MaintenancePingListener;
import fr.edminecoreteam.proxyapi.maintenance.Manager;
import fr.edminecoreteam.proxyapi.mysql.MySQL;
import fr.edminecoreteam.proxyapi.party.InvitationsManager;
import fr.edminecoreteam.proxyapi.party.PartyCommand;
import fr.edminecoreteam.proxyapi.party.PartyListener;
import fr.edminecoreteam.proxyapi.party.PartyMessage;
import fr.edminecoreteam.proxyapi.profile.friend.FriendCommand;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class ProxyAPI extends Plugin
{
    private static ProxyAPI instance;
    private static Plugin plugin;
    public static MySQL database;
    public InvitationsManager invitationManager;

    public ProxyAPI() {
        invitationManager = new InvitationsManager();
    }

    @Override
    public void onEnable()
    {
        Manager.init();
        databaseConnect();

        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable()
    {
        ProxyAPI.database.deconnexion();
    }

    private void databaseConnect()
    {
        (ProxyAPI.database = new MySQL("jdbc:mysql://", "45.140.165.235", "22728-database", "22728-database", "S5bV5su4p9")).connexion();
        if (!database.isOnline()) { return; }
        refreshConnexion();
        ProxyAPI.database.creatingTableMaintenance();
        ProxyAPI.database.creatingTableFriends();
        ProxyAPI.database.creatingTablePartyList();
        ProxyAPI.database.creatingTablePartyBan();
    }

    private void registerListeners()
    {
        ProxyAPI.instance = this;
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
    }

    public void refreshConnexion()
    {
        ProxyServer.getInstance().getScheduler().schedule((Plugin)this, (Runnable)new Runnable()
        {
            @Override
            public void run()
            {
                if (!ProxyAPI.database.isOnline())
                {
                    ProxyAPI.database.connexion();
                    run();
                }
                else
                {
                    ProxyAPI.database.deconnexion();
                    ProxyAPI.database.connexion();
                }
            }
        }, 0L, 120L, TimeUnit.SECONDS);
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

    public static ProxyAPI getInstance() { return ProxyAPI.instance; }
    public static Plugin getPlugin() { return ProxyAPI.plugin; }
    public static Connection getDatabase() { return MySQL.getConnection(); }
}
