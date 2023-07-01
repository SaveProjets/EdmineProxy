package fr.edminecoreteam.proxyapi.maintenance;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MaintenanceLogEvent implements Listener
{
    private String staff;

    public MaintenanceLogEvent() {
        this.staff = "staff";
    }

    @EventHandler
    public void onLogin(ServerConnectEvent e) {
        ProxiedPlayer p = e.getPlayer();
        String target = p.getName();
        MaintenanceInfo accountInfo = new MaintenanceInfo(target);

        if (Manager.cfg.getBoolean("maintenance.isInMaintenance") == true)
        {
            if (accountInfo.getRankType().equalsIgnoreCase(staff))
            {
                if (Manager.cfg.getBoolean("maintenance.justAdmin") == true)
                {
                    if (accountInfo.getModuleRank() != 16 && accountInfo.getModuleRank() != 15 && accountInfo.getModuleRank() != 14)
                    {
                        p.disconnect(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&cErreur de connexion, manipulation importante, seul les admins peuvent venir sur le network...")));
                    }
                    else
                    {
                        p.sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "§6⚠ &cLe network est actuellement en manipulation importante §6⚠")));
                    }
                }
                else if (Manager.cfg.getBoolean("maintenance.justAdmin") == false)
                {
                    p.sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&cIl peut y avoir des instabilitées en maintenance.")));
                }
            }
            else
            {
                if (!accountInfo.isInMaintenanceWhitelist())
                {
                    p.disconnect(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&cErreur de connexion, le network est en maintenance...")));
                }

            }
        }
    }
}
