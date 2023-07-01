package fr.edminecoreteam.proxyapi.maintenance;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MaintenancePingListener implements Listener
{
    @EventHandler
    public void onProxyPing(ProxyPingEvent event)
    {
        ServerPing serverPing = event.getResponse();

        if (Manager.cfg.getBoolean("maintenance.isInMaintenance") == true)
        {
            serverPing.setVersion(new ServerPing.Protocol(ChatColor.RED + "Maintenance", serverPing.getVersion().getProtocol()-0));
            serverPing.setDescriptionComponent((BaseComponent)new TextComponent(ChatColor.translateAlternateColorCodes('&', Manager.cfg.getString("maintenance.motdFirstLine".replaceAll("&", "§")) + "\n" + Manager.cfg.getString("maintenance.motdSecondLine".replaceAll("&", "§")))));
        }
        else if (Manager.cfg.getBoolean("maintenance.isInMaintenance") == false)
        {
            serverPing.setDescriptionComponent((BaseComponent)new TextComponent(ChatColor.translateAlternateColorCodes('&', Manager.cfg.getString("motd.FirstLine".replaceAll("&", "§")) + "\n" + Manager.cfg.getString("motd.SecondLine".replaceAll("&", "§")))));
        }

        event.setResponse(serverPing);
    }

    public void joinTab(ProxiedPlayer player) {
        player.setTabHeader((BaseComponent)new TextComponent(
                        "\n§e§l• §6§lEDMINE §f§lNETWORK §e§l•\n §fwww.edmine.net\n"),
                (BaseComponent)new TextComponent("\n§7Serveur Mini-Jeux Francophone\n§fVous jouez actuellement sur §dplay.edmine.net\n"));
    }

    @EventHandler
    public void onJoin(PostLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();
        joinTab(player);
    }
}
