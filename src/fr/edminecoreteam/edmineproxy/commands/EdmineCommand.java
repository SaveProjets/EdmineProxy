package fr.edminecoreteam.edmineproxy.commands;


import fr.edminecoreteam.edmineproxy.EdmineProxy;
import fr.edminecoreteam.edmineproxy.utils.HelpMessages;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EdmineCommand extends Command {

    public EdmineCommand(EdmineProxy edProxy){
        super("edmine");
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = null;

        if(sender instanceof ProxiedPlayer){
            p = (ProxiedPlayer) sender;
        }

        //permission : if()
        if(args.length == 0){
            HelpMessages.getHelpMessage(sender, "help");
        }else if (args.length == 1){
            HelpMessages.getHelpMessage(sender, args[0]);
        }else{

        }
    }
}
