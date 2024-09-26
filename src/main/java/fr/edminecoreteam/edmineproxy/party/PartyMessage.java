package fr.edminecoreteam.edmineproxy.party;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class PartyMessage
{
    public static void messages(ProxiedPlayer p, String msg)
    {
        if (msg == "helprank")
        {
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lCentre d'aide §b(Groupe):"));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §dGrades:"));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §7§lJoueur§8/§9§lMod§8."));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp rank §a[joueur] §7joueur§8/§7mod"));
            p.sendMessage((BaseComponent)new TextComponent(""));
        }
        if (msg == "helpinvite")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "Erreur de synthaxe, veuillez utiliser /p invite [joueur]."));
        }
        if (msg == "helpaccept")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "Erreur de synthaxe, veuillez utiliser /p accept [joueur]."));
        }
        if (msg == "helpjoin")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "Erreur de synthaxe, veuillez utiliser /p join [joueur]."));
        }
        if (msg == "helppromote")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "Erreur de synthaxe, veuillez utiliser /p promote [joueur]."));
        }
        if (msg == "helpwarp")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "Erreur de synthaxe, veuillez utiliser /p warp all/[joueur]."));
        }

        if (msg == "creategroup")
        {
            p.sendMessage((BaseComponent)new TextComponent(" §8➡ §fVisionnez votre groupe sur votre profil."));
            p.sendMessage((BaseComponent)new TextComponent(" "));
        }
        if (msg == "closegroupe")
        {
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lInformations §b(Groupe):"));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §fLe §6§lLeader§f de votre groupe"));
            p.sendMessage((BaseComponent)new TextComponent(" §7  §fvient de fermer le groupe."));
            p.sendMessage((BaseComponent)new TextComponent(""));
        }
        if (msg == "closegroupeforleader")
        {
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lInformations §b(Groupe):"));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous venez de fermer votre groupe."));
            p.sendMessage((BaseComponent)new TextComponent(""));
        }

        if (msg == "connectleader")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.GREEN + "Connexion en cours vers votre Leader..."));
        }
        if (msg == "notconnectleader")
        {
            p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVotre leader vient de changer de serveur. Pour le suivre utilisez §e/p tp§f."));
        }

        if (msg == "playernotfollow")
        {
            p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVotre leader vient de changer de serveur. Pour le suivre utilisez §e/p tp§f."));
        }

        if (msg == "teleportallplayers")
        {
            p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez téléporté tous les joueurs de votre groupe sur votre serveur."));
        }

        if (msg == "leaderleave")
        {
            p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVotre Leader s'est déconnecté, le groupe ferme dans §e5 §eminutes§f."));
        }
        if (msg == "closegroup")
        {
            p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fLe groupe est maintenant fermé."));
        }


        if (msg == "playernotteleport")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "Ce joueur a désactivé le suivi de groupe..."));
        }

        if (msg == "errorsynthax")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "Erreur de synthaxe..."));
        }
        if (msg == "errornotsetrankbutisleader")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "Erreur, vous êtes leader..."));
        }
        if (msg == "errornotyourgroup")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "Erreur, ce joueur n'est pas dans votre groupe..."));
        }
        if (msg == "errornotonline")
        {
            p.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "Erreur, ce joueur est hors-ligne..."));
        }
        if (msg == "erroraddyourself")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous ne pouvez pas vous ajouter vous-même..."));
        }
        if (msg == "erroracceptyourself")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous ne pouvez pas vous accepter vous-même..."));
        }
        if (msg == "errorallraidyinvite")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous avez déjà envoyé une demande à ce joueur..."));
        }
        if (msg == "errorallraidyinparty")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, ce joueur est déjà dans un groupe..."));
        }
        if (msg == "errorisingroup")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous ne pouvez pas inviter de joueurs dans ce groupe..."));
        }
        if (msg == "errortargetisonlogin")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, ce joueur n'est pas authentifié..."));
        }
        if (msg == "errornotinviteby")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, ce joueur ne vous a pas invité..."));
        }
        if (msg == "errornotingroup")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous n'êtes pas dans un groupe..."));
        }
        if (msg == "errornotleader")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous n'êtes pas leader..."));
        }
        if (msg == "errornchatdisable")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, le leader a désactivé le chat de groupe..."));
        }
        if (msg == "errorplayerleavebutisleader")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, utilisez plutôt /p disband..."));
        }

        if (msg == "errorstopgroup")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cVotre groupe vient d'être fermé, §cpuisque §cvous §cêtes §cseul..."));
        }

        if (msg == "allraidyban")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, ce joueur est déjà banni..."));
        }
        if (msg == "notban")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, ce joueur n'est pas banni..."));
        }
        if (msg == "errorisban")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, ce joueur est banni..."));
        }
        if (msg == "erroryourisban")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous êtes banni de ce groupe..."));
        }


        if (msg == "setprivate")
        {
            p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez défini le statut du groupe sur §cprivé§f."));
        }
        if (msg == "errorprivate")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, votre groupe est déjà privé..."));
        }
        if (msg == "setpublic")
        {
            p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez défini le statut du groupe sur §apublique§f."));
        }
        if (msg == "errorpublic")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, votre groupe est déjà publique..."));
        }

        if (msg == "enablechat")
        {
            p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez défini le chat du groupe sur §aactivé§f."));
        }
        if (msg == "disablechat")
        {
            p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez défini le chat du groupe sur §cdésactivé§f."));
        }
    }

    @SuppressWarnings("deprecation")
    public static void getHelp(ProxiedPlayer p, int page)
    {
        if (page == 1)
        {
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lCentre d'aide §b(Groupe):"));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp help §b[page] §8§l» §7Liste des commandes."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp invite §a[joueur] §8§l» §7Inviter un joueur."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp accept§8/§fjoin §a[joueur] §8§l» §7Accepter ou rejoindre."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp leave §8§l» §7Quitter un groupe."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp disband §8§l» §7Dissoudre votre groupe."));
            p.sendMessage((BaseComponent)new TextComponent(""));
            TextComponent acceptDemandList = new TextComponent(" §7• ");

            TextComponent tokenComponent1 = new TextComponent("§fPage §e(1/4)");
            tokenComponent1.setBold(true);
            tokenComponent1.setUnderlined(true);


            tokenComponent1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§8• §7Page Suivante.")));
            tokenComponent1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/p help 2"));

            acceptDemandList.addExtra(tokenComponent1);
            p.sendMessage(acceptDemandList);
            p.sendMessage((BaseComponent)new TextComponent(""));
        }
        if (page == 2)
        {
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lCentre d'aide §b(Groupe):"));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp promote §a[joueur] §8§l» §7Promouvoir un joueur Leader."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp rank §8§l» §7Voir votre grade de groupe."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp rank §a[joueur] §c[grade] §8§l» §7Définir un grade."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp chat §b[message] §8§l» §7Chat de groupe."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp chat toggle §8§l» §7Activer ou Désactiver le chat."));
            p.sendMessage((BaseComponent)new TextComponent(""));
            TextComponent acceptDemandList = new TextComponent(" §7• ");

            TextComponent tokenComponent1 = new TextComponent("§fPage §e(2/4)");
            tokenComponent1.setBold(true);
            tokenComponent1.setUnderlined(true);


            tokenComponent1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§8• §7Page Suivante.")));
            tokenComponent1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/p help 3"));

            acceptDemandList.addExtra(tokenComponent1);
            p.sendMessage(acceptDemandList);
            p.sendMessage((BaseComponent)new TextComponent(""));
        }
        if (page == 3)
        {
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lCentre d'aide §b(Groupe):"));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp private§8/§fpublic §8§l» §7Rendre votre groupe §7privé §7ou §7publique."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp limit §d[nombre] §8§l» §7Changer les slots du groupe."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp kick §a[joueur] §8§l» §7Expulser un joueur."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp ban §a[joueur] §8§l» §7Bannir un joueur."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp unban §a[joueur] §8§l» §7Pardonner un joueur."));
            p.sendMessage((BaseComponent)new TextComponent(""));
            TextComponent acceptDemandList = new TextComponent(" §7• ");

            TextComponent tokenComponent1 = new TextComponent("§fPage §e(3/4)");
            tokenComponent1.setBold(true);
            tokenComponent1.setUnderlined(true);


            tokenComponent1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§8• §7Page Suivante.")));
            tokenComponent1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/p help 4"));

            acceptDemandList.addExtra(tokenComponent1);
            p.sendMessage(acceptDemandList);
            p.sendMessage((BaseComponent)new TextComponent(""));
        }
        if (page == 4)
        {
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lCentre d'aide §b(Groupe):"));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp warp all§8/§fjoueur §8§l» §7Téléporter §7un/des §7membre(s) §7de §7votre §7groupe."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp tp §8§l» §7Se Téléporter vers §7votre §7chef §7de §7groupe."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§fp list §8§l» §7Liste des joueurs."));
            p.sendMessage((BaseComponent)new TextComponent(""));
            TextComponent acceptDemandList = new TextComponent(" §7• ");

            TextComponent tokenComponent1 = new TextComponent("§fPage §e(4/4)");
            tokenComponent1.setBold(true);
            tokenComponent1.setUnderlined(true);


            tokenComponent1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§8• §7Page Principal.")));
            tokenComponent1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/p help"));

            acceptDemandList.addExtra(tokenComponent1);
            p.sendMessage(acceptDemandList);
            p.sendMessage((BaseComponent)new TextComponent(""));
        }
    }

    @SuppressWarnings("deprecation")
    public static void listGroup(ProxiedPlayer p) {
        PartyData playerData = new PartyData(p.getName());
        if (playerData.hasGroup())
        {
            int groupID = playerData.getGroupName();
            List<String> groupPlayers = new ArrayList<String>();
            List<String> groupModerators = new ArrayList<String>();
            List<String> groupLeader = new ArrayList<String>();
            for (String name : playerData.getGroupPlayers(groupID))
            {
                groupPlayers.add(name);
            }
            for (String name : playerData.getGroupMods(groupID))
            {
                groupModerators.add(name);
            }
            for (String name : playerData.getGroupLeader(groupID))
            {
                groupLeader.add(name);
            }
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lListe du groupe:"));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §fLeader: §6§l" + groupLeader.get(0)));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §fNombre de mods: §9" + groupModerators.size()));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §fNombre de joueurs: §e" + groupPlayers.size()));
            p.sendMessage((BaseComponent)new TextComponent(""));
            TextComponent modsList = new TextComponent(" §7➡ §9Mods: ");
            int counterMods = 0;
            int finalCountMods = groupModerators.size();
            for (String mods : groupModerators)
            {
                TextComponent tokenComponent = new TextComponent("§9" + mods);
                tokenComponent.setBold(true);
                tokenComponent.setUnderlined(true);
                tokenComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour voir son profil.")));
                tokenComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/profil " + mods));

                modsList.addExtra(tokenComponent);
                counterMods++;
                if (counterMods == finalCountMods)
                {
                    modsList.addExtra("§7.");
                }
                else
                {
                    modsList.addExtra("§7, ");
                }
            }
            p.sendMessage(modsList);
            TextComponent playersList = new TextComponent(" §7➡ §7Joueurs: ");
            int counterPlayers = 0;
            int finalCountPlayers = groupPlayers.size();
            for (String players : groupPlayers)
            {
                TextComponent tokenComponent = new TextComponent("§e" + players);
                tokenComponent.setBold(true);
                tokenComponent.setUnderlined(true);
                tokenComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour voir son profil.")));
                tokenComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/profil " + players));

                playersList.addExtra(tokenComponent);
                counterPlayers++;
                if (counterPlayers == finalCountPlayers)
                {
                    playersList.addExtra("§7.");
                }
                else
                {
                    playersList.addExtra("§7, ");
                }
            }
            p.sendMessage(playersList);
        }
    }


    @SuppressWarnings("deprecation")
    public static void sendInvitation(ProxiedPlayer p, ProxiedPlayer t) {
        t.sendMessage((BaseComponent)new TextComponent(""));
        t.sendMessage((BaseComponent)new TextComponent(" §7» §b§lInformations §b(Groupe):"));
        t.sendMessage((BaseComponent)new TextComponent(" §7• §fInvitation dans un groupe reçue de §b§l" + p.getName() + "§f."));
        t.sendMessage((BaseComponent)new TextComponent(" §7• §fExpire dans §e1 minute§f."));
        TextComponent acceptDemandList = new TextComponent(" §f➡ ");

        TextComponent tokenComponent1 = new TextComponent("§a[Accepter]");
        tokenComponent1.setBold(true);
        tokenComponent1.setUnderlined(true);


        tokenComponent1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour accepter.")));
        tokenComponent1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/p accept " + p.getName()));

        acceptDemandList.addExtra(tokenComponent1);
        t.sendMessage(acceptDemandList);
        t.sendMessage((BaseComponent)new TextComponent(""));

        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lInformations §b(Groupe):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fInvitation dans un groupe envoyée à §b§l" + t.getName() + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fExpire dans §e1 minute§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));
    }
    public static void newLeader(ProxiedPlayer p, String name) {
        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lInformations §b(Groupe):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fChangement de propriétaire !"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fLe nouveau §6§lLeader§f est §a§l" + name + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));
    }
    public static void acceptInvitation(ProxiedPlayer p, ProxiedPlayer t) {
        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lInformations §b(Groupe):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous avez rejoint le groupe de §a§l" + t.getName() + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));
        t.sendMessage((BaseComponent)new TextComponent(""));
        t.sendMessage((BaseComponent)new TextComponent(" §7» §b§lInformations §b(Groupe):"));
        t.sendMessage((BaseComponent)new TextComponent(" §7• §a§l" + p.getName() + "§f a rejoint votre groupe."));
        t.sendMessage((BaseComponent)new TextComponent(""));
    }
    public static void setRank(ProxiedPlayer p, ProxiedPlayer t, int rank) {
        String rankName = "";

        if (rank == 0) { rankName = "§7§lJoueur"; }
        if (rank == 1) { rankName = "§9§lMod"; }

        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §b§lInformations §b(Groupe):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous avez défini le grade de"));
        p.sendMessage((BaseComponent)new TextComponent(" §7  §a§l" + t.getName() + " §fsur " + rankName + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));

        t.sendMessage((BaseComponent)new TextComponent(""));
        t.sendMessage((BaseComponent)new TextComponent(" §7» §b§lInformations §b(Groupe):"));
        t.sendMessage((BaseComponent)new TextComponent(" §7• §a§l" + p.getName() + "§f a défini votre grade"));
        t.sendMessage((BaseComponent)new TextComponent(" §7  §fsur " + rankName + "§f."));
        t.sendMessage((BaseComponent)new TextComponent(""));
    }
    public static void joinPublicGroup(ProxiedPlayer p, String name) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §e" + name + " §7a rejoint le groupe."));
    }
    public static void leavePublicGroup(ProxiedPlayer p, String name) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §e" + name + " §7a quitté le groupe."));
    }
    public static void broadcastBanforGroup(ProxiedPlayer p, String name) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §c" + name + " §fa été banni du groupe."));
    }
    public static void broadcastKickforGroup(ProxiedPlayer p, String name) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §c" + name + " §fa été kick du groupe."));
    }
    public static void banforGroupOffline(ProxiedPlayer p, String t) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez banni §e" + t + " §fde votre groupe."));
    }
    public static void banforGroup(ProxiedPlayer p, ProxiedPlayer t) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez banni §c" + t.getName() + " §fde votre groupe."));
        t.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez été banni par §e" + p.getName() + " §fdu groupe."));
    }
    public static void kickforGroupOffline(ProxiedPlayer p, String t) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez kick §c" + t + " §fde votre groupe."));
    }
    public static void kickforGroup(ProxiedPlayer p, ProxiedPlayer t) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez kick §c" + t.getName() + " §fde votre groupe."));
        t.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez été kick par §e" + p.getName() + " §fdu groupe."));
    }
    public static void unbanforGroupOffline(ProxiedPlayer p, String t) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez débanni §c" + t + " §fde votre groupe."));
    }
    public static void unbanforGroup(ProxiedPlayer p, ProxiedPlayer t) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez débanni §c" + t.getName() + " §fde votre groupe."));
        t.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fVous avez été débanni par §e" + p.getName() + " §fdu groupe."));
    }
    public static void sendGroupMessage(ProxiedPlayer p, String message, int rank, String messagerName) {
        String rankName = "";

        if (rank == 0) { rankName = "§7"; }
        if (rank == 1) { rankName = "§9§lM. §9"; }
        if (rank == 2) { rankName = "§6§lL. §6"; }

        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» " + rankName  + messagerName + " §8» §f" + message));
    }

    public static void warpPlayer(ProxiedPlayer p, String target) {
        p.sendMessage((BaseComponent)new TextComponent("§b§lGroupe §8» §fTéléportation de §a" + target + " §fen cours..."));
    }

    public static void expireInvitation(ProxiedPlayer p, String target) {
        p.sendMessage((BaseComponent)new TextComponent("§cVotre invitation de groupe pour §c" + target + " §cvient §cd'expirer..."));
    }
}
