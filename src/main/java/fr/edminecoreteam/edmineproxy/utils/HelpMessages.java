package fr.edminecoreteam.edmineproxy.utils;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;

public class HelpMessages {

    public static void getHelpMessage(CommandSender sender, String arg){

         if(arg.equalsIgnoreCase("fragments")){
            sender.sendMessage(TextComponent.fromLegacyText(""));
            sender.sendMessage(TextComponent.fromLegacyText(" §7» §c§lCentre d'aide §c(Edmine-EcoSystem):"));
            sender.sendMessage(TextComponent.fromLegacyText(""));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine fragments §8§l» §7Gestion des fragments d'âmes."));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine fragments set §d[joueur] §6[nombre] §8§l» §7Set des fragments."));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine fragments add §d[joueur] §6[nombre] §8§l» §7Ajouter des fragments."));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine fragments remove §d[joueur] §6[nombre] §8§l» §7Créditer des fragments."));
            sender.sendMessage(TextComponent.fromLegacyText(""));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §fPage §e(1/1)"));
            sender.sendMessage(TextComponent.fromLegacyText(""));
            //CustomSounds.ecoSound(player));
        }else if(arg.equalsIgnoreCase("eclats")) {
            sender.sendMessage(TextComponent.fromLegacyText(""));
            sender.sendMessage(TextComponent.fromLegacyText(" §7» §c§lCentre d'aide §c(Edmine-EcoSystem):"));
            sender.sendMessage(TextComponent.fromLegacyText(""));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine eclats §8§l» §7Gestion des eclats divins."));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine eclats set §d[joueur] §6[nombre] §8§l» §7Set des eclats."));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine eclats add §d[joueur] §6[nombre] §8§l» §7Ajouter des eclats."));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine eclats remove §d[joueur] §6[nombre] §8§l» §7Créditer des eclats."));
            sender.sendMessage(TextComponent.fromLegacyText(""));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §fPage §e(1/1)"));
            sender.sendMessage(TextComponent.fromLegacyText(""));
            //CustomSounds.ecoSound(player));
        } else if (arg.equalsIgnoreCase("argent"))
            {
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7» §c§lCentre d'aide §c(Edmine-EcoSystem):"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine argent §8§l» §7Gestion de l'argent."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine argent set §d[joueur] §6[nombre] §8§l» §7Set de l'argent."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine argent add §d[joueur] §6[nombre] §8§l» §7Ajouter de l'argent."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine argent remove §d[joueur] §6[nombre] §8§l» §7Créditer de l'argent."));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fPage §e(1/1)"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                //CustomSounds.ecoSound(player);
            } else if (arg.equalsIgnoreCase("rank"))
            {
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7» §c§lCentre d'aide §c(Edmine-Rank):"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank §8§l» §7Gestion des grades."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank list §8§l» §7Liste des grades."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank set §d[joueur] §6[type] §e[mois] §c[rankID] §6[moduleID] §8§l» §7Définir un grade."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank tempo §d[joueur] §e[mois] §c[rankID] §8§l» §7Gestion des tempos."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank module §d[joueur] §c[moduleID] §8§l» §7Gestion des modules."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank static §d[joueur] §c[rankID] §8§l» §7Gestion des statics."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank staff §d[joueur] §c[moduleID] §8§l» §7Gestion des staffs."));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fPage §e(1/1)"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                //player.playSound(player.getLocation()), Sound.LEVEL_UP, 1.0f, 1.0f));
            } else if (arg.equalsIgnoreCase("module"))
            {
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7» §c§lCentre d'aide §c(Edmine-Rank):"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fPour l'utilisation du §dmodulable-rank§f,"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §fun §bmodule §fest un §6sous-grade §fqui s'ajoute au"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §egrade §fdéjà existant."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fDonc il peut §acommuniquer §favec l'ensemble"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §fdes §egrades §fà part les §bstaffs§f."));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank module §d[joueur] §c[moduleID]"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
              //  player.playSound(player.getLocation()), Sound.LEVEL_UP, 1.0f, 1.0f));
            } else if (arg.equalsIgnoreCase("static"))
            {
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7» §c§lCentre d'aide §c(Edmine-Rank):"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fPour l'utilisation du §dstatic-rank§f,"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §fun §bmodule static §fest un §6grade §fqui se"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §edéfini §fsans date d'échéance."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fIl peut §acommuniquer §favec l'ensemble"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §fdes §egrades §fà part les §btempos§f car"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §fils possèdent leurs propres avantages."));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank static §d[joueur] §c[rankID]"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
              //  player.playSound(player.getLocation()), Sound.LEVEL_UP, 1.0f, 1.0f));
            } else if (arg.equalsIgnoreCase("tempo"))
            {
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7» §c§lCentre d'aide §c(Edmine-Rank):"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fPour l'utilisation du §dtempo-rank§f,"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §fun §bmodule temporaire §fest un §6grade §fqui se"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §edéfinie §favec une date d'échéance."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fIl peut §acommuniquer §favec l'ensemble"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §fdes §egrades §fà part les §bstatics§f car"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §fils possèdent leurs propres avantages."));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank tempo §d[joueur] §e[mois] §c[rankID]"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
               // player.playSound(player.getLocation()), Sound.LEVEL_UP, 1.0f, 1.0f));
            } else if (arg.equalsIgnoreCase("staff"))
            {
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7» §c§lCentre d'aide §c(Edmine-Rank):"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fPour l'utilisation du §dstaff-rank§f,"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §fun §bmodule staff §fest un §6sous-grade §fqui s'ajoute au"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §egrade §fdéjà existant."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §fDonc il peut §acommuniquer §favec l'ensemble"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §fdes §egrades §fà part les §bmodules§f."));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank staff §d[joueur] §c[moduleID]"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
               // player.playSound(player.getLocation()), Sound.LEVEL_UP, 1.0f, 1.0f));
            } else if (arg.equalsIgnoreCase("list"))
            {
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7» §c§lCentre d'aide §c(Edmine-Rank):"));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §e§lStatic"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7 ➥ §7Joueur §f(0)§8, §5§lSTREAMER §f(6)§8,"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7   §6§lYOUTUBER §f(7)§8, §6§lFAMOUS §f(8)§8."));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §d§lTempo"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7 ➥ §f§lVIP §f(1)§8, §e§lSUPER-VIP §f(2)§8,"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7   §a§lSUPREME §f(3)§8, §b§lULTRA §f(4)§8, §3§lELITE §f(5)§8."));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                sender.sendMessage(TextComponent.fromLegacyText(" §7• §b§lModule"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7 ➥ §d§lFRIEND §f(9)§8."));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  §c§l(Staff)"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7  ➥ §e§lSTAFF §f(10)§8, §a§lBUILDER §f(11)§8, §b§lHELPER §f(12)§8,"));
                sender.sendMessage(TextComponent.fromLegacyText(" §7    §9§lMOD §f(13)§8, §5§lDEV §f(14)§8, §4§lRESP §f(15)§8, §c§lADMIN §f(16)§8."));
                sender.sendMessage(TextComponent.fromLegacyText(""));
                //player.playSound(player.getLocation()), Sound.LEVEL_UP, 1.0f, 1.0f));
            }else{
            sender.sendMessage(TextComponent.fromLegacyText(""));
            sender.sendMessage(TextComponent.fromLegacyText(" §7» §c§lCentre d'aide §c(Edmine):"));
            sender.sendMessage(TextComponent.fromLegacyText(""));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine rank §8§l» §7Gestion des grades."));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine fragments §8§l» §7Gestion des fragments d'âmes."));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine eclats §8§l» §7Gestion des eclats divins."));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §d/§fedmine argent §8§l» §7Gestion de l'argent."));
            sender.sendMessage(TextComponent.fromLegacyText(""));
            sender.sendMessage(TextComponent.fromLegacyText(" §7• §fPage §e(1/1)"));
            sender.sendMessage(TextComponent.fromLegacyText(""));
            //player.playSound(player.getLocation()), Sound.LEVEL_UP, 1.0f, 1.0f));
        }
    }

        public static void errorMessage(CommandSender sender, String error, String argument0)
        {
            if (error.equalsIgnoreCase("set"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur de synthaxe, utilisez /edmine rank set [joueur] [type] [mois] [rankID] [moduleID]."));
            }else if (error.equalsIgnoreCase("tempo"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur de synthaxe, utilisez /edmine rank tempo [joueur] [mois] [rankID]."));
            }else if (error.equalsIgnoreCase("errortempo"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur , un compte static comme ytb ou streamer ne peut pas avoir de grade tempo..."));
            }else if (error.equalsIgnoreCase("module"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur de synthaxe, utilisez /edmine rank module [joueur] [moduleID]."));
            }else if (error.equalsIgnoreCase("static"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur de synthaxe, utilisez /edmine rank static [joueur] [rankID]."));
            }else if (error.equalsIgnoreCase("staff"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur de synthaxe, utilisez /edmine rank staff [joueur] [moduleID]."));
            }else if (error.equalsIgnoreCase("targetoffline"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur, assurez-vous que le joueur ciblé est sur le même serveur que vous..."));
            }else if (error.equalsIgnoreCase("errorsetmodulestaff"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur, veuillez utilisez (10 -> 16)..."));
            }else if (error.equalsIgnoreCase("errorsetmodulesmodule"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur, veuillez utilisez (9)..."));
            }else if (error.equalsIgnoreCase("errorsetmodulestatic"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur, veuillez utilisez (0, 6, 7, 8)..."));
            }else if (error.equalsIgnoreCase("fragments"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur de synthaxe, utilisez /edmine fragments set/add/remove [joueur] [nombre]."));
            }else if (error.equalsIgnoreCase("eclats"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur de synthaxe, utilisez /edmine eclats set/add/remove [joueur] [nombre]."));
            }else if (error.equalsIgnoreCase("argent"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§cErreur de synthaxe, utilisez /edmine argent set/add/remove [joueur] [nombre]."));
            }else{
                getHelpMessage(sender, argument0);
            }
        }

        public static void successMessage(CommandSender sender, String success, String target, int i, int f)
        {
            if (success.equalsIgnoreCase("staff"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez défini le Module §bStaff §fde §e" + target + "§f sur §d" + i + "§f."));
            }
            if (success.equalsIgnoreCase("static"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez défini le Module §bStatic §fde §e" + target + "§f sur §d" + i + "§f."));
            }
            if (success.equalsIgnoreCase("module"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez défini le Module §bModule §fde §e" + target + "§f sur §d" + i + "§f."));
            }
            if (success.equalsIgnoreCase("tempo"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez défini le Module §bTempo §fde §e" + target + "§f sur §d" + i + "§f."));
            }
            if (success.equalsIgnoreCase("set"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez re-défini complètement le type de grade de §e" + target + "§f."));
            }


            if (success.equalsIgnoreCase("setfragments"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez re-défini complètement les fragments de §e" + target + "§f sur §b" + f + "§f."));
            }
            if (success.equalsIgnoreCase("addfragments"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez ajouter §b" + f + " §ffragments à §e" + target + "§f."));
            }
            if (success.equalsIgnoreCase("removefragments"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez créditer §b" + f + " §ffragments à §e" + target + "§f."));
            }
            if (success.equalsIgnoreCase("seteclats"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez re-défini complètement les eclats de §e" + target + "§f sur §b" + f + "§f."));
            }
            if (success.equalsIgnoreCase("addeclats"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez ajouter §b" + f + " §feclats à §e" + target + "§f."));
            }
            if (success.equalsIgnoreCase("removeeclats"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez créditer §b" + f + " §feclats à §e" + target + "§f."));
            }
            if (success.equalsIgnoreCase("setargent"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez re-défini complètement l'argent de §e" + target + "§f sur §b" + f + "§f."));
            }
            if (success.equalsIgnoreCase("addargent"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez ajouter §b" + f + " §fd'argents à §e" + target + "§f."));
            }
            if (success.equalsIgnoreCase("removeargent"))
            {
                sender.sendMessage(TextComponent.fromLegacyText("§aSuccès ! §fVous avez créditer §b" + f + " §fd'argents à §e" + target + "§f."));
            }
    }
}
