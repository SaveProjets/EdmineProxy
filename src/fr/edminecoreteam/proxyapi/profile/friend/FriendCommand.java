package fr.edminecoreteam.proxyapi.profile.friend;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class FriendCommand extends Command
{

    public FriendCommand(String name)
    {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args)
    {
        if (!(sender instanceof ProxiedPlayer)) { return; }
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (args.length == 0)
        {
            FriendMessages.messages(p, "help");
        }
        if (args.length == 1)
        {
            if (args[0].equalsIgnoreCase("list"))
            {
                FriendInfo friendInfo = new FriendInfo(p.getName());
                if (friendInfo.getFriendList().size() != 0)
                {
                    FriendMessages.messages(p, "list");
                }
                else
                {
                    FriendMessages.messages(p, "listnothing");
                }
            }
            if (args[0].equalsIgnoreCase("request"))
            {
                FriendMessages.messages(p, "request");
            }
        }
        if (args.length == 2)
        {
            if (args[0].equalsIgnoreCase("add"))
            {
                String target = args[1];
                FriendInfo friendInfo = new FriendInfo(p.getName());
                if (BungeeCord.getInstance().getPlayer(target) == null)
                { FriendMessages.error(p, "offlinetarget"); return; }

                ProxiedPlayer t = ProxyServer.getInstance().getPlayer(target);
                if (ProxyServer.getInstance().getPlayer(target) == p)
                {
                    FriendMessages.error(p, "addyourself");
                    return;
                }
                if (friendInfo.getFriendRequestSend().contains(target))
                {
                    FriendMessages.error(p, "requestby");
                    return;
                }
                if (friendInfo.getFriendList().contains(target))
                {
                    FriendMessages.error(p, "friendwith");
                    return;
                }
                if(friendInfo.getFriendRequest().contains(target)){

                }

                FriendInfo finalFriendInfo = new FriendInfo(p.getName(), t.getName());
                FriendInfo finalTargetInfo = new FriendInfo(t.getName(), p.getName());

                finalFriendInfo.addRequest();
                finalTargetInfo.addRequest();
                finalFriendInfo.setStatusDemand(1);
                finalTargetInfo.setStatusDemand(2);
                for(String test : friendInfo.getFriendRequest()){
                    ProxyServer.getInstance().getPlayer("Ygroxie").sendMessage(TextComponent.fromLegacyText(test));
                }
                FriendMessages.continuee(t, p, 2);
                return;
            }
            if (args[0].equalsIgnoreCase("acceptwithrunaction"))
            {
                String target = args[1];

                FriendMessages.continueee(p, target);
                return;
            }
            if (args[0].equalsIgnoreCase("remove"))
            {
                String target = args[1];

                ProxiedPlayer t = ProxyServer.getInstance().getPlayer(target);
                FriendInfo friendInfo = new FriendInfo(p.getName());


                if (BungeeCord.getInstance().getPlayer(target) == null)
                {
                    FriendInfo finalFriendInfo = new FriendInfo(p.getName(), target);
                    FriendInfo finalTargetInfo = new FriendInfo(target, p.getName());
                    if (!friendInfo.getFriendList().contains(target))
                    {
                        FriendMessages.error(p, "notfriendwith");
                        return;
                    }
                    finalFriendInfo.removeFriend();
                    finalTargetInfo.removeFriend();
                    FriendMessages.removeFriend(p, target);
                    return;
                }
                else
                {
                    FriendInfo finalFriendInfo = new FriendInfo(p.getName(), t.getName());
                    FriendInfo finalTargetInfo = new FriendInfo(t.getName(), p.getName());
                    if (ProxyServer.getInstance().getPlayer(target) == p)
                    {
                        FriendMessages.error(p, "removeyourself");
                        return;
                    }
                    if (!friendInfo.getFriendList().contains(target))
                    {
                        FriendMessages.error(p, "notfriendwith");
                        return;
                    }
                    finalFriendInfo.removeFriend();
                    finalTargetInfo.removeFriend();
                    FriendMessages.removeFriend(p, t);
                    return;
                }

            }
            if (args[0].equalsIgnoreCase("accept"))
            {
                String target = args[1];
                FriendInfo friendInfo = new FriendInfo(p.getName());
                if (BungeeCord.getInstance().getPlayer(target) == null)
                {
                    if (!friendInfo.getFriendRequest().contains(target))
                    {
                        FriendMessages.error(p, "notrequestwith");
                        return;
                    }
                    if (friendInfo.getFriendList().contains(target))
                    {
                        FriendMessages.error(p, "friendwith");
                        return;
                    }
                    if (friendInfo.getStatusDemand() == 1)
                    {
                        FriendMessages.error(p, "actionimpossible");
                        return;
                    }
                    FriendInfo finalFriendInfo = new FriendInfo(p.getName(), target);
                    FriendInfo finalTargetInfo = new FriendInfo(target, p.getName());

                    finalFriendInfo.removeRequest();
                    finalTargetInfo.removeRequest();

                    try
                    {
                        finalFriendInfo.addFriendOffline();
                    } catch (Exception e)
                    {
                        e.toString();
                        return;
                    }

                    try
                    {
                        finalTargetInfo.addFriendOffline();
                    } catch (Exception e)
                    {
                        e.toString();
                        return;
                    }
                    FriendMessages.AcceptDemandOffline(p, target);


                }
                else
                {
                    ProxiedPlayer t = ProxyServer.getInstance().getPlayer(target);
                    FriendInfo finalFriendInfo = new FriendInfo(p.getName(), t.getName());
                    FriendInfo finalTargetInfo = new FriendInfo(t.getName(), p.getName());

                    if (!friendInfo.getFriendRequest().contains(t.getName()))
                    {
                        FriendMessages.error(p, "notrequestwith");
                        return;
                    }
                    if (friendInfo.getFriendList().contains(target))
                    {
                        FriendMessages.error(p, "friendwith");
                        return;
                    }
                    if (friendInfo.getStatusDemand() == 1)
                    {
                        FriendMessages.error(p, "actionimpossible");
                        return;
                    }

                    finalFriendInfo.removeRequest();
                    finalTargetInfo.removeRequest();
                    finalFriendInfo.addFriend();
                    finalTargetInfo.addFriend();
                    FriendMessages.AcceptDemand(p, t);
                    return;
                }

            }
            if (args[0].equalsIgnoreCase("deny"))
            {
                String target = args[1];
                FriendInfo friendInfo = new FriendInfo(p.getName());
                if (BungeeCord.getInstance().getPlayer(target) == null)
                {
                    if (friendInfo.getFriendList().contains(target))
                    {
                        FriendMessages.error(p, "friendwith");
                        return;
                    }
                    if (!friendInfo.getFriendRequest().contains(target))
                    {
                        FriendMessages.error(p, "notrequestwith");
                        return;
                    }
                    if (friendInfo.getStatusDemand() == 1)
                    {
                        FriendMessages.error(p, "actionimpossible");
                        return;
                    }

                    FriendInfo finalFriendInfo = new FriendInfo(p.getName(), target);
                    FriendInfo finalTargetInfo = new FriendInfo(target,p.getName());

                    finalFriendInfo.removeRequest();
                    finalTargetInfo.removeRequest();
                    finalFriendInfo.removeFriend();
                    finalTargetInfo.removeFriend();
                    FriendMessages.RefuseDemandOffline(p, target);
                    return;
                }
                else
                {
                    ProxiedPlayer t = ProxyServer.getInstance().getPlayer(target);
                    if (friendInfo.getFriendList().contains(target))
                    {
                        FriendMessages.error(p, "friendwith");
                        return;
                    }
                    if (!friendInfo.getFriendRequest().contains(target))
                    {
                        FriendMessages.error(p, "notrequestwith");
                        return;
                    }
                    if (friendInfo.getStatusDemand() == 1)
                    {
                        FriendMessages.error(p, "actionimpossible");
                        return;
                    }

                    FriendInfo finalFriendInfo = new FriendInfo(p.getName(), t.getName());
                    FriendInfo finalTargetInfo = new FriendInfo(t.getName(), p.getName());

                    finalFriendInfo.removeRequest();
                    finalTargetInfo.removeRequest();
                    finalFriendInfo.removeFriend();
                    finalTargetInfo.removeFriend();
                    FriendMessages.RefuseDemand(p, t);
                    return;
                }
            }
        }
        if (args.length == 3){
            if(args[0].equalsIgnoreCase("favoris")){
                if(args[1].equalsIgnoreCase("add")){
                    String target = args[2];
                    FriendInfo friendInfo = new FriendInfo(p.getName());
                    if (ProxyServer.getInstance().getPlayer(target) == p)
                    {
                        FriendMessages.error(p, "addyourself");
                        return;
                    }
                    if(!friendInfo.getFriendList().contains(target)){
                        FriendMessages.error(p,"notfriendwith");
                        return;
                    }
                    if(friendInfo.getFavList().contains(target)){
                        FriendMessages.error(p, "alreadyfavoris");
                        return;
                    }


                    FriendInfo finalFriendInfo = new FriendInfo(p.getName(), target);

                    finalFriendInfo.setFriendFavoris(1);
                    FriendMessages.AjoutFav(p, target);
                    return;
                }
                if (args[1].equalsIgnoreCase("remove")){
                    String target = args[2];
                    FriendInfo friendInfo = new FriendInfo(p.getName());
                    if (ProxyServer.getInstance().getPlayer(target) == p)
                    {
                        FriendMessages.error(p, "removeyourself");
                        return;
                    }
                    if(!friendInfo.getFriendList().contains(target)){
                        FriendMessages.error(p,"notfriendwith");
                        return;
                    }
                    if(!friendInfo.getFavList().contains(target)){
                        FriendMessages.error(p, "notfavoris");
                        return;
                    }

                    FriendInfo finalFriendInfo = new FriendInfo(p.getName(), target);

                    finalFriendInfo.setFriendFavoris(0);
                    FriendMessages.SuppFav(p, target);
                }
            }
        }
    }

}
