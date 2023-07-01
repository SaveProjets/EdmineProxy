package fr.edminecoreteam.proxyapi.maintenance;

import fr.edminecoreteam.proxyapi.ProxyAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MaintenanceCommand extends Command
{

    private String staff;

    public MaintenanceCommand(ProxyAPI api) {
        super("maintenance", "edmine.admin");
        this.staff = "staff";
    }



    @Override
    public void execute(CommandSender sender, String[] args)
    {
        if (args.length == 0)
        {
            help(sender);
        }
        if (args.length == 1)
        {
            if (args[0].equalsIgnoreCase("help"))
            {
                help(sender);
            }
            if (args[0].equalsIgnoreCase("reload"))
            {
                Manager.init();
                reloadData(sender);
            }
            if (args[0].equalsIgnoreCase("statut"))
            {
                statut(sender);
            }
            if (args[0].equalsIgnoreCase("on"))
            {
                if (Manager.cfg.getBoolean("maintenance.isInMaintenance") == true)
                {
                    allradyInMaintenance(sender);
                }
                else
                {
                    Manager.cfg.set("maintenance.isInMaintenance", (Object)true);
                    changeMaintenanceStatus(sender, true);
                    Manager.save();
                    for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers())
                    {
                        String target = p.getName();
                        MaintenanceInfo accountInfo = new MaintenanceInfo(target);
                        if (!accountInfo.getRankType().equalsIgnoreCase(staff))
                        {
                            p.disconnect(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&cUn admin a activé une maintenance forcer, rendez-vous sur discord pour plus d'infos.")));
                        }
                    }
                }
            }
            if (args[0].equalsIgnoreCase("off"))
            {
                if (Manager.cfg.getBoolean("maintenance.isInMaintenance") == false)
                {
                    allradyNotMaintenance(sender);
                }
                else
                {
                    Manager.cfg.set("maintenance.isInMaintenance", (Object)false);
                    changeMaintenanceStatus(sender, false);
                    Manager.save();
                }
            }
            if (args[0].equalsIgnoreCase("justadmin"))
            {
                if (Manager.cfg.getBoolean("maintenance.justAdmin") == false)
                {
                    Manager.cfg.set("maintenance.justAdmin", (Object)true);
                    changeJustAdmin(sender, true);
                    Manager.save();
                    for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers())
                    {
                        String target = p.getName();
                        MaintenanceInfo accountInfo = new MaintenanceInfo(target);
                        if (accountInfo.getModuleRank() != 16 && accountInfo.getModuleRank() != 15 && accountInfo.getModuleRank() != 14)
                        {
                            p.disconnect(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&cUn admin a activé une maintenance forcer, rendez-vous sur discord pour plus d'infos.")));
                        }
                    }

                }
                else
                {
                    Manager.cfg.set("maintenance.justAdmin", (Object)false);
                    changeJustAdmin(sender, false);
                    Manager.save();
                }
            }
        }
        if (args.length == 2)
        {
            if (args[0].equalsIgnoreCase("add"))
            {
                String target = args[1];
                MaintenanceInfo maintenanceInfo = new MaintenanceInfo(target);

                if (maintenanceInfo.isInMaintenanceWhitelist())
                {
                    allradyInWhitelist(sender);
                }
                else
                {
                    maintenanceInfo.addInMaintenanceWhitelist();
                    addInWhitelist(sender, target);
                }
            }

            if (args[0].equalsIgnoreCase("remove"))
            {
                String target = args[1];
                MaintenanceInfo maintenanceInfo = new MaintenanceInfo(target);

                if (maintenanceInfo.isInMaintenanceWhitelist())
                {
                    maintenanceInfo.removeFromMaintenanceWhitelist();
                    removeFromWhitelist(sender, target);
                }
                else
                {

                    allradyNotInWhitelist(sender);
                }
            }
        }
    }



    private void help(CommandSender sender) {
        sender.sendMessage(TextComponent.fromLegacyText(""));
        sender.sendMessage(TextComponent.fromLegacyText(" §7» §6§lCentre d'aide §6(EDMINE MAINTENANCE):"));
        sender.sendMessage(TextComponent.fromLegacyText(""));
        sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fmaintenance help §8§l» §7Afficher l'aide."));
        sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fmaintenance statut §8§l» §7Afficher l'aide."));
        sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fmaintenance on §8§l» §7Activer la maintenance."));
        sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fmaintenance off §8§l» §7Arrêter la maintenance."));
        sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fmaintenance add §b[joueur] §8§l» §7Ajouter dans la whitelist."));
        sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fmaintenance remove §b[joueur] §8§l» §7Suprimer de la whitelist."));
        sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fmaintenance justAdmin §8§l» §7Active ou non cette option."));
        sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fmaintenance reload §8§l» §7Reload le fichier (§emaintenance.yml§7)."));
        sender.sendMessage(TextComponent.fromLegacyText(""));
    }

    private void statut(CommandSender sender) {
        sender.sendMessage(TextComponent.fromLegacyText(""));
        sender.sendMessage(TextComponent.fromLegacyText(" §7» §6§lED-Maintenance §6(statut):"));
        sender.sendMessage(TextComponent.fromLegacyText(""));
        if (Manager.cfg.getBoolean("maintenance.isInMaintenance") == true)
        {
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §fMaintenance: §aActivée."));
            if (Manager.cfg.getBoolean("maintenance.justAdmin") == false)
            {
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fAccessibilité: §7Tous les §e§lSTAFF§7."));
            }
            else if (Manager.cfg.getBoolean("maintenance.justAdmin") == true)
            {
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fAccessibilité: §7(§c§lADMIN§7, §4§lRESP§7, §5§lDEV§7)."));
            }
        }
        else if (Manager.cfg.getBoolean("maintenance.isInMaintenance") == false)
        {
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §fMaintenance: §8Désactivée."));
        }
        sender.sendMessage(TextComponent.fromLegacyText(""));
    }

    private void allradyInWhitelist(CommandSender sender) {
        sender.sendMessage(TextComponent.fromLegacyText("§cErreur, ce joueur est déjà dans la whitelist..."));
    }

    private void allradyNotInWhitelist(CommandSender sender) {
        sender.sendMessage(TextComponent.fromLegacyText("§cErreur, ce joueur n'est pas dans la whitelist..."));
    }

    private void allradyInMaintenance(CommandSender sender) {
        sender.sendMessage(TextComponent.fromLegacyText("§cErreur, la maintenance est déjà activé..."));
    }

    private void allradyNotMaintenance(CommandSender sender) {
        sender.sendMessage(TextComponent.fromLegacyText("§cErreur, la maintenance est déjà désactivé..."));
    }

    private void addInWhitelist(CommandSender sender, String target) {
        sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez ajouter §e" + target + "§f dans la whitelist."));
    }

    private void removeFromWhitelist(CommandSender sender, String target) {
        sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez suprimer §c" + target + "§f de la whitelist."));
    }

    private void reloadData(CommandSender sender) {
        sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fLa configuration §emaintenance.yml §fà été reload."));
    }

    private void changeJustAdmin(CommandSender sender, boolean bool) {

        if (bool == true)
        {
            sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fSeuls les (§c§lADMIN§f, §4§lRESP§f, §5§lDEV§f) peuvent venir sur le network."));
        }
        else
        {
            sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fTous les §e§lSTAFF§f peuvent venir sur le network."));
        }
    }

    private void changeMaintenanceStatus(CommandSender sender, boolean bool) {

        if (bool == true)
        {
            if (Manager.cfg.getBoolean("maintenance.justAdmin") == true)
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fLe network est maintenant en maintenance."));
                sender.sendMessage(TextComponent.fromLegacyText("§fSeuls les (§c§lADMIN§f, §4§lRESP§f, §5§lDEV§f) peuvent venir sur le network."));
            }
            else
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fLe network est maintenant en maintenance."));
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fTous les §e§lSTAFF§f peuvent venir sur le network."));
            }

        }
        else
        {
            sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fLe network n'est plus en maintenance."));
            sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fTous les §7§lJoueurs§f peuvent venir sur le network."));
        }
    }

}
