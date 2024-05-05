package fr.edminecoreteam.edmineproxy.commands;

import fr.edminecoreteam.api.management.PlayerManager;
import fr.edminecoreteam.edmineproxy.EdmineProxy;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandTest extends Command {
    public CommandTest(EdmineProxy edProxy){
        super("test");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer){
            ProxiedPlayer p = (ProxiedPlayer) sender;
            PlayerManager testPM = PlayerManager.getPlayer(p);
            p.sendMessage(TextComponent.fromLegacyText(String.valueOf(testPM.getMoney())));
        }
    }
}
