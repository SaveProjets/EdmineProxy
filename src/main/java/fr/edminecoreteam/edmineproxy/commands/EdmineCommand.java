package fr.edminecoreteam.edmineproxy.commands;


import fr.edminecoreteam.api.EdmineAPIBungee;
import fr.edminecoreteam.api.EdmineAPISpigot;
import fr.edminecoreteam.api.management.PlayerManager;
import fr.edminecoreteam.edmineproxy.EdmineProxy;
import fr.edminecoreteam.edmineproxy.utils.HelpMessages;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class EdmineCommand extends Command {

    public EdmineCommand(EdmineProxy edProxy) {
        super("edmine");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(TextComponent.fromLegacyText("§cLa commande va être refaites... Fais §e/corenetwork:edmine §cpour l'utiliser en attendant ;)"));
        //Code fonctionnel à décommenter lorsque cela sera implanté correctement côté API. Quelques erreurs par manque de vérification à régler.
        /*ProxiedPlayer p = null;

        if (sender instanceof ProxiedPlayer) {
            p = (ProxiedPlayer) sender;
        }

        //permission : if()
        if (args.length == 0) {
            HelpMessages.getHelpMessage(sender, "help");
            sender.sendMessage(TextComponent.fromLegacyText("0 argument, help"));
        } else if (args.length == 1) {
            HelpMessages.getHelpMessage(sender, args[0]);
            sender.sendMessage(TextComponent.fromLegacyText("1 argument, help"));
        } else if (args.length == 2 || args.length == 3) {
            if (args[0].equalsIgnoreCase("rank")) {
                HelpMessages.errorMessage(sender, args[1], args[0]);
                sender.sendMessage(TextComponent.fromLegacyText("2 ou 3 argument, rank"));
            } else {
                HelpMessages.errorMessage(sender, args[0], args[0]);
                sender.sendMessage(TextComponent.fromLegacyText("2 ou 3 argument, autre"));

            }
        } else if (args.length == 4) {
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
            PlayerManager pmT = PlayerManager.getPlayer(target);
            if (args[0].equalsIgnoreCase("rank")) {
                sender.sendMessage(TextComponent.fromLegacyText("§cLa commande va être refaites... Fais /corenetwork:edmine pour l'utiliser en attendant ;)"));
            } else if (args[0].equalsIgnoreCase("fragments")) {
                int number = Integer.parseInt(args[3]);
                if (args[1].equalsIgnoreCase("set")) {
                    pmT.setSoulFragment(number);
                    HelpMessages.successMessage(sender, "setfragments", target.getName(), 0, number);
                } else if (args[1].equalsIgnoreCase("add")) {
                    pmT.addSoulFragment(number);
                    HelpMessages.successMessage(sender, "addfragments", target.getName(), 0, number);
                } else if (args[1].equalsIgnoreCase("remove")) {
                    pmT.removeSoulFragment(number);
                    HelpMessages.successMessage(sender, "removefragments", target.getName(), 0, number);
                }else {
                    HelpMessages.errorMessage(sender, "fragments", args[0]);
                }
            }else if(args[0].equalsIgnoreCase("eclats")){
                int number = Integer.parseInt(args[3]);
                if(args[1].equalsIgnoreCase("set")){
                    pmT.setDivineRadiance(number);
                    HelpMessages.successMessage(sender, "seteclats", target.getName(), 0, number);
                }else if(args[1].equalsIgnoreCase("add")){
                    pmT.addDivineRadiance(number);
                    HelpMessages.successMessage(sender, "addeclats", target.getName(), 0, number);
                }else if(args[1].equalsIgnoreCase("remove")){
                    pmT.removeDivineRadiance(number);
                    HelpMessages.successMessage(sender, "removeeclats", target.getName(), 0, number);
                }

            }else if(args[0].equalsIgnoreCase("argent")){
                int number = Integer.parseInt(args[3]);
                if(args[1].equalsIgnoreCase("set")){
                    pmT.setMoney(number);
                    HelpMessages.successMessage(sender, "setargent", target.getName(), 0, number);
                }else if(args[1].equalsIgnoreCase("add")){
                    pmT.addMoney(number);
                    HelpMessages.successMessage(sender, "addargent", target.getName(), 0, number);
                }else if(args[1].equalsIgnoreCase("remove")){
                    pmT.removeMoney(number);
                    HelpMessages.successMessage(sender, "removeargent", target.getName(), 0, number);
                }

            }
        }else{
            HelpMessages.errorMessage(sender, args[0], args[0]);
        }*/
    }
}
