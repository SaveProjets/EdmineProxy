package fr.edminecoreteam.proxyapi.profile.friend;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class FriendMessages
{

    public static void error(ProxiedPlayer p, String error)
    {
        if (error == "actionimpossible")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, action impossible..."));
        }
        if (error == "addyourself")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous ne pouvez pas vous ajouter vous même..."));
        }
        if (error == "removeyourself")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous ne pouvez pas vous supprimer vous même..."));
        }
        if (error == "requestby")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous avez déjà envoyé une requête a ce joueur..."));
        }
        if (error == "friendwith")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, il semble que vous êtes déjà amis..."));
        }
        if (error == "notfriendwith")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, il semble que vous n'êtes pas amis..."));
        }
        if (error == "notrequestwith")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, vous n'avez aucune demande d'amis de ce joueur..."));
        }
        if (error == "offlinetarget")
        {
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, ce joueur est hors-ligne..."));
        }
        if (error == "alreadyfavoris"){
            p.sendMessage((BaseComponent)new TextComponent("§cErreur, ce joueur fait déjà partis de vos favoris..."));
        }
    }

    @SuppressWarnings("deprecation")
    public static void continuee(ProxiedPlayer b, ProxiedPlayer p, Integer i) {
        b.sendMessage((BaseComponent)new TextComponent(""));
        b.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        b.sendMessage((BaseComponent)new TextComponent(" §7• §fRequête d'ami reçu de §b§l" + p.getName() + "§f."));
        TextComponent acceptDemandList = new TextComponent(" §f➡ ");

        TextComponent tokenComponent1 = new TextComponent("§a[Accepter]");
        tokenComponent1.setBold(true);
        tokenComponent1.setUnderlined(true);
        tokenComponent1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour accepter.")));
        tokenComponent1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/f accept " + p.getName()));

        TextComponent tokenComponent2 = new TextComponent("§c[Refuser]");
        tokenComponent2.setBold(true);
        tokenComponent2.setUnderlined(true);
        tokenComponent2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour refuser.")));
        tokenComponent2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/f deny " + p.getName()));

        acceptDemandList.addExtra(tokenComponent1);
        acceptDemandList.addExtra(" ");
        acceptDemandList.addExtra(tokenComponent2);
        b.sendMessage(acceptDemandList);
        b.sendMessage((BaseComponent)new TextComponent(""));

        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fRequête d'ami envoyé à §b§l" + b.getName() + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));
    }

    @SuppressWarnings("deprecation")
    public static void continueee(ProxiedPlayer b, String p) {
        b.sendMessage((BaseComponent)new TextComponent(""));
        b.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        b.sendMessage((BaseComponent)new TextComponent(" §7• §fVoulez vous accepter ou refuser §b" + p + "§f?"));

        TextComponent acceptDemandList = new TextComponent(" §f➡ ");

        TextComponent tokenComponent1 = new TextComponent("§a[Accepter]");
        tokenComponent1.setBold(true);
        tokenComponent1.setUnderlined(true);
        tokenComponent1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour accepter.")));
        tokenComponent1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/f accept " + p));

        TextComponent tokenComponent2 = new TextComponent("§c[Refuser]");
        tokenComponent2.setBold(true);
        tokenComponent2.setUnderlined(true);
        tokenComponent2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour refuser.")));
        tokenComponent2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/f deny " + p));

        acceptDemandList.addExtra(tokenComponent1);
        acceptDemandList.addExtra(" ");
        acceptDemandList.addExtra(tokenComponent2);
        b.sendMessage(acceptDemandList);
        b.sendMessage((BaseComponent)new TextComponent(""));

    }


    @SuppressWarnings("deprecation")
    public static void messages(ProxiedPlayer p, String msg)
    {
        if (msg == "help")
        {
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lCentre d'aide §d(Amis):"));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§ff add§8/§fremove §a[joueur] §8§l» §7Ajouter ou supprimer un ami."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§ff accept§8/§fdeny §a[joueur] §8§l» §7Gestion de demande d'ami."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§ff list §8§l» §7Liste d'amis."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§ff request §8§l» §7Liste de vos demandes d'amis."));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §d/§ff favoris add§8/§fremove §a[joueur] §8§l» §7Ajouter/supprimer §fun ami à vos §ffavoris."));
            p.sendMessage((BaseComponent)new TextComponent(""));
        }
        if (msg == "listnothing")
        {
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lListe d'amis:"));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7• §fNombre d'amis: §c0"));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §7➡ §fAmis en-ligne: §caucun"));
            p.sendMessage((BaseComponent)new TextComponent(" §7➡ §fAmis hors-ligne: §caucun"));
            p.sendMessage((BaseComponent)new TextComponent(""));
            p.sendMessage((BaseComponent)new TextComponent(" §8• §7Visionnez votre liste d'amis sur votre profil."));
            p.sendMessage((BaseComponent)new TextComponent(""));
        }
        if (msg == "list")
        {
            FriendInfo friendInfo = new FriendInfo(p.getName());
            List<String> friendOnline = new ArrayList<String>();
            List<String> friendOffline = new ArrayList<String>();
            for (String amis : friendInfo.getFriendList())
            {
                if (ProxyServer.getInstance().getPlayer(amis) == null)
                {
                    friendOffline.add(amis);
                }
                else
                {
                    friendOnline.add(amis);
                }
            }
            if (!friendOnline.isEmpty())
            {
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lListe d'amis:"));
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §7• §fNombre d'amis: §e" + friendInfo.getFriendCount()));
                p.sendMessage((BaseComponent)new TextComponent(""));
                TextComponent friendList = new TextComponent(" §7➡ §fAmis en-ligne: ");
                int counterFriend = 0;
                int finalCountFriend = friendOnline.size();
                for (String amis : friendOnline)
                {
                    TextComponent tokenComponent = new TextComponent("§a" + amis);
                    tokenComponent.setBold(true);
                    tokenComponent.setUnderlined(true);
                    tokenComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour voir son profil.")));
                    tokenComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/profil " + amis));

                    friendList.addExtra(tokenComponent);
                    counterFriend++;
                    if (counterFriend == finalCountFriend)
                    {
                        friendList.addExtra("§7.");
                    }
                    else
                    {
                        friendList.addExtra("§7, ");
                    }
                }
                p.sendMessage(friendList);
            }
            else
            {
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lListe d'amis:"));
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §7• §fNombre d'amis: §e" + friendInfo.getFriendCount()));
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §7➡ §fAmis en-ligne: §caucun"));
            }


            if (friendOffline.isEmpty())
            {
                p.sendMessage((BaseComponent)new TextComponent(" §7➡ §fAmis hors-ligne: §caucun"));
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §8• §7Visionnez votre liste d'amis sur votre profil."));
                p.sendMessage((BaseComponent)new TextComponent(""));
            }
            else
            {
                TextComponent friendOfflineList = new TextComponent(" §7➡ §fAmis hors-ligne: ");
                int counterOfflineFriend = 0;
                int finalCountOfflineFriend = friendOffline.size();
                for (String amis : friendOffline)
                {
                    TextComponent tokenComponent = new TextComponent("§8" + amis);
                    tokenComponent.setBold(true);
                    tokenComponent.setUnderlined(true);
                    tokenComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour voir son profil.")));
                    tokenComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/profil " + amis));

                    friendOfflineList.addExtra(tokenComponent);
                    counterOfflineFriend++;
                    if (counterOfflineFriend == finalCountOfflineFriend)
                    {
                        friendOfflineList.addExtra("§7.");
                    }
                    else
                    {
                        friendOfflineList.addExtra("§7, ");
                    }
                }
                p.sendMessage(friendOfflineList);
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §8• §7Visionnez votre liste d'amis sur votre profil."));
                p.sendMessage((BaseComponent)new TextComponent(""));
            }
        }
        if (msg == "request")
        {
            FriendInfo friendInfo = new FriendInfo(p.getName());
            List<String> friendDemand = new ArrayList<String>();
            List<String> friendDemandSend = new ArrayList<String>();
            for (String demand : friendInfo.getFriendRequest())
            {
                if (demand != null)
                {
                    friendDemand.add(demand);
                }
            }
            for (String demand : friendInfo.getFriendRequestSend())
            {
                if (demand != null)
                {
                    friendDemandSend.add(demand);
                }
            }

            if (!friendDemand.isEmpty())
            {
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lDemandes d'ami(s):"));
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §7• §fNombre de demande(s): §e" + friendInfo.getRequestCount()));
                p.sendMessage((BaseComponent)new TextComponent(""));
                TextComponent friendDemandList = new TextComponent(" §7➡ §fReçu(s): ");
                int counterDemandFriend = 0;
                int finalCountDemandFriend = friendDemand.size();
                for (String amis : friendDemand)
                {
                    TextComponent tokenComponent = new TextComponent("§a" + amis);
                    tokenComponent.setBold(true);
                    tokenComponent.setUnderlined(true);
                    tokenComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour accepter ou refuser.")));
                    tokenComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/f acceptwithrunaction " + amis));

                    friendDemandList.addExtra(tokenComponent);
                    counterDemandFriend++;
                    if (counterDemandFriend == finalCountDemandFriend)
                    {
                        friendDemandList.addExtra("§7.");
                    }
                    else
                    {
                        friendDemandList.addExtra("§7, ");
                    }
                }
                p.sendMessage(friendDemandList);
            }
            else
            {
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lDemandes d'amis:"));
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §7• §fNombre de demandes: §c0"));
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §7➡ §fReçu(s): §caucune"));
            }
            if (!friendDemandSend.isEmpty())
            {
                TextComponent friendDemandSendList = new TextComponent(" §7➡ §fEn-attente(s): ");
                int counterDemandSendFriend = 0;
                int finalCountDemandSendFriend = friendDemandSend.size();
                for (String amis : friendDemandSend)
                {
                    TextComponent tokenComponent = new TextComponent("§7" + amis);
                    tokenComponent.setBold(true);
                    tokenComponent.setUnderlined(true);
                    tokenComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Cliquez ici pour voir son profil.")));
                    tokenComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/profil " + amis));

                    friendDemandSendList.addExtra(tokenComponent);
                    counterDemandSendFriend++;
                    if (counterDemandSendFriend == finalCountDemandSendFriend)
                    {
                        friendDemandSendList.addExtra("§7.");
                    }
                    else
                    {
                        friendDemandSendList.addExtra("§7, ");
                    }
                }
                p.sendMessage(friendDemandSendList);
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §8• §7Visionnez vos demandes d'amis sur votre profil."));
                p.sendMessage((BaseComponent)new TextComponent(""));
            }
            else
            {
                p.sendMessage((BaseComponent)new TextComponent(" §7➡ §fEn-attente(s): §caucune"));
                p.sendMessage((BaseComponent)new TextComponent(""));
                p.sendMessage((BaseComponent)new TextComponent(" §8• §7Visionnez vos demandes d'amis sur votre profil."));
                p.sendMessage((BaseComponent)new TextComponent(""));
            }

        }
        if (msg == "addRequest")
        {

        }
        if (msg == "addOfflineRequest")
        {

        }
    }

    public static void removeFriend(ProxiedPlayer p, ProxiedPlayer t) {
        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous n'êtes plus amis avec §c§l" + t.getName() + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));
        t.sendMessage((BaseComponent)new TextComponent(""));
        t.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        t.sendMessage((BaseComponent)new TextComponent(" §7• §c§l" + p.getName() + "§f vous a supprimé de sa liste d'amis..."));
        t.sendMessage((BaseComponent)new TextComponent(""));
    }

    public static void removeFriend(ProxiedPlayer p, String t) {
        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous n'êtes plus amis avec §c§l" + t + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));
    }

    public static void AcceptDemandOffline(ProxiedPlayer p, String t) {
        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous avez accepté la demande de §a§l" + t + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));
    }

    public static void AcceptDemand(ProxiedPlayer p, ProxiedPlayer t) {
        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous avez accepté la demande de §a§l" + t.getName() + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));
        t.sendMessage((BaseComponent)new TextComponent(""));
        t.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        t.sendMessage((BaseComponent)new TextComponent(" §7• §a§l" + p.getName() + "§f a accepté votre demande d'amis."));
        t.sendMessage((BaseComponent)new TextComponent(""));
    }

    public static void RefuseDemandOffline(ProxiedPlayer p, String t) {
        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous avez refusé la demande de §c§l" + t + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));
    }

    public static void RefuseDemand(ProxiedPlayer p, ProxiedPlayer t) {
        p.sendMessage((BaseComponent)new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous avez refusé la demande de §c§l" + t.getName() + "§f."));
        p.sendMessage((BaseComponent)new TextComponent(""));
        t.sendMessage((BaseComponent)new TextComponent(""));
        t.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        t.sendMessage((BaseComponent)new TextComponent(" §7• §c§l" + p.getName() + "§f a refusé votre demande d'amis..."));
        t.sendMessage((BaseComponent)new TextComponent(""));
    }

    public static void AjoutFav(ProxiedPlayer p, String t){
        p.sendMessage((BaseComponent) new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous avez ajouté §e§l" + t + " §fen tant que favoris."));
        p.sendMessage((BaseComponent)new TextComponent(""));
    }

    public static void SuppFav(ProxiedPlayer p, ProxiedPlayer t){
        p.sendMessage((BaseComponent) new TextComponent(""));
        p.sendMessage((BaseComponent)new TextComponent(" §7» §d§lInformations §d(Amis):"));
        p.sendMessage((BaseComponent)new TextComponent(" §7• §fVous avez supprimé §c§l" + t + " §fde vos favoris."));
        p.sendMessage((BaseComponent)new TextComponent(""));
    }
}
