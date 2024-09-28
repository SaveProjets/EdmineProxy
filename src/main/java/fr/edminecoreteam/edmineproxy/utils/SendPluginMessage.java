package fr.edminecoreteam.edmineproxy.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class SendPluginMessage {
    public static void sendGestionRank(ProxiedPlayer p, ProxiedPlayer t){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("rankCommande");
        out.writeUTF(p.getName());
        out.writeUTF(t.getName());
        ProxyServer.getInstance().getServerInfo(p.getServer().getInfo().getName()).sendData("rankCommande", out.toByteArray());
    }
}
