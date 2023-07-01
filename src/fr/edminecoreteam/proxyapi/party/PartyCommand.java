package fr.edminecoreteam.proxyapi.party;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import fr.edminecoreteam.proxyapi.ProxyAPI;
import fr.edminecoreteam.proxyapi.profile.SettingData;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class PartyCommand extends Command
{
    private InvitationsManager invitationsManager;
    private static ProxyAPI api = ProxyAPI.getInstance();

    public PartyCommand(String name)
    {
        super(name);
        invitationsManager = new InvitationsManager();
    }

    @Override
    public void execute(CommandSender sender, String[] args)
    {
        if (!(sender instanceof ProxiedPlayer)) { return; }
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (p.getServer().getInfo().getName().contains("Login")) { return; }
        if (args.length == 0)
        {
            PartyMessage.getHelp(p, 1);
        }
        if (args.length > 1)
        {
            if (args[0].equalsIgnoreCase("chat"))
            {
                if (args[1].equalsIgnoreCase("toggle"))
                {
                    PartyData playerData = new PartyData(p.getName());
                    int id = playerData.getGroupName();
                    if (playerData.hasGroup())
                    {
                        if (playerData.getLeader(id).equalsIgnoreCase(p.getName()))
                        {
                            if (playerData.getChat(id, p.getName()).equalsIgnoreCase("enable"))
                            {
                                playerData.setChat("disable", id);
                                PartyMessage.messages(p, "disablechat");
                                return;
                            }
                            if (playerData.getChat(id, p.getName()).equalsIgnoreCase("disable"))
                            {
                                playerData.setChat("enable", id);
                                PartyMessage.messages(p, "enablechat");
                                return;
                            }
                        }
                        else
                        {
                            PartyMessage.messages(p, "errornotleader");
                            return;
                        }
                    }
                    else
                    {
                        PartyMessage.messages(p, "errornotingroup");
                        return;
                    }
                }
                String msg = "";
                for (int i = 1; i < args.length; i++)
                    msg = String.valueOf(msg) + args[i] + " ";
                PartyData playerData = new PartyData(p.getName());
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    int playerRank = playerData.getRank(groupID);
                    String getLeader = playerData.getLeader(groupID);
                    if (playerData.getChat(groupID, getLeader).equalsIgnoreCase("enable"))
                    {
                        for (String playersNameInGroup : playerData.getGroupPlayers(groupID))
                        {
                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                            if (t != null)
                            {
                                PartyMessage.sendGroupMessage(t, msg, playerRank, p.getName());
                            }
                        }
                        for (String playersNameInGroup : playerData.getGroupMods(groupID))
                        {
                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                            if (t != null)
                            {
                                PartyMessage.sendGroupMessage(t, msg, playerRank, p.getName());
                            }
                        }
                        for (String playersNameInGroup : playerData.getGroupLeader(groupID))
                        {
                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                            if (t != null)
                            {
                                PartyMessage.sendGroupMessage(t, msg, playerRank, p.getName());
                            }
                        }
                        return;
                    }
                    else
                    {
                        PartyMessage.messages(p, "errornchatdisable");
                        return;
                    }
                }
                else
                {
                    PartyMessage.messages(p, "errornotingroup");
                    return;
                }
            }
        }
        if (args.length == 1)
        {
            if (args[0].equalsIgnoreCase("list"))
            {
                PartyMessage.listGroup(p);
            }
            if (args[0].equalsIgnoreCase("help"))
            {
                PartyMessage.getHelp(p, 1);
            }
            if (args[0].equalsIgnoreCase("invite"))
            {
                PartyMessage.messages(p, "helpinvite");
            }
            if (args[0].equalsIgnoreCase("accept"))
            {
                PartyMessage.messages(p, "helpaccept");
            }
            if (args[0].equalsIgnoreCase("join"))
            {
                PartyMessage.messages(p, "helpjoin");
            }
            if (args[0].equalsIgnoreCase("promote"))
            {
                PartyMessage.messages(p, "helppromote");
            }
            if (args[0].equalsIgnoreCase("rank"))
            {
                PartyMessage.messages(p, "helprank");
            }
            if (args[0].equalsIgnoreCase("warp"))
            {
                PartyMessage.messages(p, "helpwarp");
            }
            if (args[0].equalsIgnoreCase("tp") || args[0].equalsIgnoreCase("teleport"))
            {
                PartyData playerData = new PartyData(p.getName());
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    if (!playerData.getLeader(groupID).equalsIgnoreCase(p.getName()))
                    {
                        String leaderName = playerData.getLeader(groupID);
                        ProxiedPlayer leader = ProxyServer.getInstance().getPlayer(leaderName);
                        if (leader != null)
                        {
                            PartyMessage.messages(p, "connectleader");
                            p.connect(leader.getServer().getInfo());
                        }
                        else
                        {
                            PartyMessage.messages(p, "errornotonline");
                            return;
                        }
                    }
                    else
                    {
                        PartyMessage.messages(p, "errornotsetrankbutisleader");
                        return;
                    }
                }
            }
            if (args[0].equalsIgnoreCase("private"))
            {
                PartyData playerData = new PartyData(p.getName());
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    if (playerData.getLeader(groupID).equalsIgnoreCase(p.getName()))
                    {
                        if (playerData.getGroupStatus() == 2)
                        {
                            playerData.setStatus(1, groupID);
                            PartyMessage.messages(p, "setprivate");
                        }
                        else if (playerData.getGroupStatus() == 1)
                        {
                            PartyMessage.messages(p, "errorprivate");
                        }
                    }
                }
            }
            if (args[0].equalsIgnoreCase("public"))
            {
                PartyData playerData = new PartyData(p.getName());
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    if (playerData.getLeader(groupID).equalsIgnoreCase(p.getName()))
                    {
                        if (playerData.getGroupStatus() == 1)
                        {
                            playerData.setStatus(2, groupID);
                            PartyMessage.messages(p, "setpublic");
                        }
                        else if (playerData.getGroupStatus() == 2)
                        {
                            PartyMessage.messages(p, "errorpublic");
                        }
                    }
                }
            }
            if (args[0].equalsIgnoreCase("leave"))
            {
                PartyData playerData = new PartyData(p.getName());
                int ID = playerData.getGroupName();
                String inviteurName = playerData.getLeader(ID);
                ProxiedPlayer inviteur = ProxyServer.getInstance().getPlayer(inviteurName);
                PartyData inviteurData = new PartyData(inviteurName);
                int groupID = inviteurData.getGroupName();
                if (playerData.hasGroup())
                {
                    if (!playerData.getLeader(groupID).equalsIgnoreCase(p.getName()))
                    {
                        for (String playersNameInGroup : inviteurData.getGroupPlayers(groupID))
                        {
                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                            if (t != null)
                            {
                                PartyMessage.leavePublicGroup(t, p.getName());
                            }
                        }
                        for (String playersNameInGroup : inviteurData.getGroupMods(groupID))
                        {
                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                            if (t != null)
                            {
                                PartyMessage.leavePublicGroup(t, p.getName());
                            }
                        }
                        for (String playersNameInGroup : playerData.getGroupLeader(groupID))
                        {
                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                            if (t != null)
                            {
                                PartyMessage.leavePublicGroup(inviteur, p.getName());
                            }
                        }
                        playerData.leaveGroup();
                        int groupSize = inviteurData.getGroupPlayers(groupID).size() + inviteurData.getGroupMods(groupID).size() + inviteurData.getGroupLeader(groupID).size();
                        if (groupSize == 1)
                        {
                            inviteurData.removeBan(groupID);
                            inviteurData.removeGroup(groupID);
                            if (inviteur != null)
                            {
                                PartyMessage.messages(inviteur, "errorstopgroup");
                            }
                            return;
                        }
                    }
                    else
                    {
                        PartyMessage.messages(p, "errorplayerleavebutisleader");
                        return;
                    }
                }
                else
                {
                    PartyMessage.messages(p, "errornotingroup");
                    return;
                }
            }
            if (args[0].equalsIgnoreCase("disband"))
            {
                PartyData playerData = new PartyData(p.getName());
                if (playerData.hasGroup())
                {
                    int id = playerData.getGroupName();
                    if (playerData.getLeader(id).equalsIgnoreCase(p.getName()))
                    {
                        for (String playersNameInGroup : playerData.getGroupPlayers(id))
                        {
                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                            if (t != null)
                            {
                                PartyMessage.messages(t, "closegroupe");
                            }
                        }
                        for (String playersNameInGroup : playerData.getGroupMods(id))
                        {
                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                            if (t != null)
                            {
                                PartyMessage.messages(t, "closegroupe");
                            }
                        }
                        PartyMessage.messages(p, "closegroupeforleader");
                        playerData.removeGroup(playerData.getGroupName());
                    }
                }
                else
                {
                    PartyMessage.messages(p, "errornotingroup");
                    return;
                }
            }
        }
        if (args.length == 2)
        {
            if (args[0].equalsIgnoreCase("help"))
            {
                Integer page = Integer.valueOf(args[1]);
                PartyMessage.getHelp(p, page);
            }
            if (args[0].equalsIgnoreCase("limit"))
            {
                //Integer limit = Integer.valueOf(args[1]);
                PartyData playerData = new PartyData(p.getName());
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    if (playerData.getLeader(groupID).equalsIgnoreCase(p.getName()))
                    {

                    }
                }
            }
            if (args[0].equalsIgnoreCase("kick"))
            {
                String targetName = args[1];
                PartyData playerData = new PartyData(p.getName());
                ProxiedPlayer t = ProxyServer.getInstance().getPlayer(targetName);
                PartyData targetData = new PartyData(targetName);
                ProxiedPlayer inviteur = ProxyServer.getInstance().getPlayer(playerData.getGroupLeader(playerData.getGroupName()).get(0));
                PartyData inviteurData = new PartyData(playerData.getGroupLeader(playerData.getGroupName()).get(0));
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    if (playerData.getLeader(groupID).equalsIgnoreCase(p.getName()) || playerData.getRank(groupID) == 1)
                    {
                        targetData.leaveGroup();
                        if (t != null)
                        {
                            PartyMessage.kickforGroup(p, t);
                        }
                        else
                        {
                            PartyMessage.kickforGroupOffline(p, targetName);
                        }
                        int groupSize = inviteurData.getGroupPlayers(groupID).size() + inviteurData.getGroupMods(groupID).size() + inviteurData.getGroupLeader(groupID).size();
                        if (groupSize == 1)
                        {
                            inviteurData.removeBan(groupID);
                            inviteurData.removeGroup(groupID);
                            if (inviteur != null)
                            {
                                PartyMessage.messages(inviteur, "errorstopgroup");
                            }
                            return;
                        }
                    }
                }
            }
            if (args[0].equalsIgnoreCase("ban"))
            {
                String targetName = args[1];
                PartyData playerData = new PartyData(p.getName());
                ProxiedPlayer t = ProxyServer.getInstance().getPlayer(targetName);
                PartyData targetData = new PartyData(targetName);
                ProxiedPlayer inviteur = ProxyServer.getInstance().getPlayer(playerData.getGroupLeader(playerData.getGroupName()).get(0));
                PartyData inviteurData = new PartyData(playerData.getGroupLeader(playerData.getGroupName()).get(0));
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    if (playerData.getLeader(groupID).equalsIgnoreCase(p.getName()) || playerData.getRank(groupID) == 1)
                    {
                        if (!targetData.isBan(groupID))
                        {
                            targetData.leaveGroup();
                            targetData.banPlayerFromAGroup(groupID);
                            if (t != null)
                            {
                                PartyMessage.banforGroup(p, t);
                            }
                            else
                            {
                                PartyMessage.banforGroupOffline(p, targetName);
                            }
                            int groupSize = inviteurData.getGroupPlayers(groupID).size() + inviteurData.getGroupMods(groupID).size() + inviteurData.getGroupLeader(groupID).size();
                            if (groupSize == 1)
                            {
                                inviteurData.removeBan(groupID);
                                inviteurData.removeGroup(groupID);
                                if (inviteur != null)
                                {
                                    PartyMessage.messages(inviteur, "errorstopgroup");
                                }
                                return;
                            }
                        }
                        else
                        {
                            PartyMessage.messages(p, "allraidyban");
                            return;
                        }
                    }
                }
            }
            if (args[0].equalsIgnoreCase("unban"))
            {
                String targetName = args[1];
                PartyData playerData = new PartyData(p.getName());
                ProxiedPlayer t = ProxyServer.getInstance().getPlayer(targetName);
                PartyData targetData = new PartyData(targetName);
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    if (playerData.getLeader(groupID).equalsIgnoreCase(p.getName()) || playerData.getRank(groupID) == 1)
                    {
                        if (targetData.isBan(groupID))
                        {
                            targetData.unbanPlayerFromAGroup(groupID);
                            if (t != null)
                            {
                                PartyMessage.unbanforGroup(p, t);
                            }
                            else
                            {
                                PartyMessage.unbanforGroupOffline(p, targetName);
                            }
                        }
                        else
                        {
                            PartyMessage.messages(p, "notban");
                            return;
                        }
                    }
                }
            }
            if (args[0].equalsIgnoreCase("promote"))
            {
                String targetName = args[1];
                ProxiedPlayer t = ProxyServer.getInstance().getPlayer(targetName);
                if (t == null) { PartyMessage.messages(p, "errornotonline"); return; }
                if (t.getServer().getInfo().getName().contains("Login")) { PartyMessage.messages(p, "errortargetisonlogin"); return; }
                if (p.getName().equalsIgnoreCase(targetName)) { return; }
                PartyData playerData = new PartyData(p.getName());
                PartyData targetData = new PartyData(t.getName());
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    if (playerData.getLeader(groupID).equalsIgnoreCase(p.getName()))
                    {
                        if (groupID != targetData.getGroupName()) { PartyMessage.messages(p, "errornotyourgroup"); return; }
                        List<String> groupList = new ArrayList<String>();
                        groupList.add(p.getName());
                        for (String playersNameInGroup : playerData.getGroupPlayers(groupID))
                        {
                            groupList.add(playersNameInGroup);
                            ProxiedPlayer tS = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                            if (t != null)
                            {
                                PartyMessage.newLeader(tS, t.getName());
                            }
                        }
                        for (String playersNameInGroup : playerData.getGroupMods(groupID))
                        {
                            groupList.add(playersNameInGroup);
                            ProxiedPlayer tS = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                            if (t != null)
                            {
                                PartyMessage.newLeader(tS, t.getName());
                            }
                        }
                        playerData.removeBan(groupID);
                        playerData.removeGroup(groupID);
                        PartyMessage.newLeader(p, t.getName());

                        targetData.createGroup();
                        int newGroupID = targetData.getGroupName();
                        for (String playersNameInGroup : groupList)
                        {
                            if (!t.getName().equalsIgnoreCase(playersNameInGroup))
                            {
                                PartyData playersNameInGroupData = new PartyData(playersNameInGroup);
                                playersNameInGroupData.joinGroup(newGroupID);
                            }
                        }
                    }
                }
            }
            if (args[0].equalsIgnoreCase("warp"))
            {
                String targetName = args[1];
                if (p.getName().equalsIgnoreCase(targetName)) { return; }
                PartyData playerData = new PartyData(p.getName());
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    if (playerData.getLeader(groupID).equalsIgnoreCase(p.getName()))
                    {
                        if (args[1].equalsIgnoreCase("all"))
                        {

                            List<String> groupList = new ArrayList<String>();
                            for (String playersNameInGroup : playerData.getGroupPlayers(groupID))
                            {
                                groupList.add(playersNameInGroup);
                            }
                            for (String playersNameInGroup : playerData.getGroupMods(groupID))
                            {
                                groupList.add(playersNameInGroup);
                            }

                            for (String s : groupList)
                            {
                                ProxiedPlayer sPlayer = ProxyServer.getInstance().getPlayer(s);
                                if (sPlayer != null)
                                {
                                    SettingData sData = new SettingData(sPlayer);
                                    if (sData.getGroupFollow().equalsIgnoreCase("activer"))
                                    {
                                        PartyMessage.messages(sPlayer, "connectleader");
                                        sPlayer.connect(p.getServer().getInfo());
                                    }
                                    else
                                    {
                                        PartyMessage.messages(sPlayer, "notconnectleader");
                                        PartyMessage.messages(p, "playernotteleport");
                                    }
                                }
                                else
                                {
                                    PartyMessage.messages(p, "errornotonline");
                                }
                            }
                            PartyMessage.messages(p, "teleportallplayers");
                        }
                        else
                        {
                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(targetName);
                            PartyData targetData = new PartyData(t.getName());

                            if (t.getServer().getInfo().getName().contains("Login")) { PartyMessage.messages(p, "errortargetisonlogin"); return; }
                            if (targetData.getGroupName() == groupID)
                            {
                                ProxiedPlayer sPlayer = ProxyServer.getInstance().getPlayer(targetName);
                                if (sPlayer != null)
                                {
                                    SettingData sData = new SettingData(sPlayer);
                                    if (sData.getGroupFollow().equalsIgnoreCase("activer"))
                                    {
                                        PartyMessage.warpPlayer(p, sPlayer.getName());
                                        PartyMessage.messages(sPlayer, "connectleader");
                                        sPlayer.connect(p.getServer().getInfo());
                                    }
                                    else
                                    {
                                        PartyMessage.messages(sPlayer, "notconnectleader");
                                        PartyMessage.messages(p, "playernotteleport");
                                    }
                                }
                                else
                                {
                                    PartyMessage.messages(p, "errornotonline");
                                }
                            }
                            else
                            {
                                PartyMessage.messages(p, "errornotyourgroup");
                            }
                        }
                    }
                    else
                    {
                        PartyMessage.messages(p, "errornotleader");
                    }
                }
                else
                {
                    PartyMessage.messages(p, "errornotingroup");
                }
            }
            if (args[0].equalsIgnoreCase("invite") || args[0].equalsIgnoreCase("add"))
            {
                String targetName = args[1];
                PartyData playerData = new PartyData(p.getName());
                PartyData checkBan = new PartyData(targetName);
                int groupID = playerData.getGroupName();
                if (checkBan.isBan(groupID))
                {
                    PartyMessage.messages(p, "errorisban");
                    return;
                }
                ProxiedPlayer t = ProxyServer.getInstance().getPlayer(targetName);
                if (t == null) { PartyMessage.messages(p, "errornotonline"); return; }
                if (t.getServer().getInfo().getName().contains("Login")) { PartyMessage.messages(p, "errortargetisonlogin"); return; }
                if (p.getName().equalsIgnoreCase(targetName)) { PartyMessage.messages(p, "erroraddyourself"); return; }
                if (playerData.hasGroup())
                {
                    if (!playerData.getLeader(groupID).equalsIgnoreCase(p.getName()))
                    {
                        if (playerData.getRank(groupID) == 1)
                        {
                            PartyData targetData = new PartyData(t.getName());
                            if (!targetData.hasGroup())
                            {
                                if (!invitationsManager.getPlayerIsInviteTarget(p.getName(), t.getName()))
                                {
                                    invitationsManager.addInvitation(p.getName(), t.getName());
                                    PartyMessage.sendInvitation(p, t);
                                    ProxyServer.getInstance().getScheduler().schedule((Plugin)api, (Runnable)new Runnable()
                                    {
                                        @Override
                                        public void run()
                                        {
                                            if (invitationsManager.getPlayerIsInviteTarget(p.getName(), t.getName()))
                                            {
                                                invitationsManager.removeInvitation(p.getName(), t.getName());
                                                if (p != null)
                                                {
                                                    PartyMessage.expireInvitation(p, t.getName());
                                                }
                                                return;
                                            }
                                            else
                                            {
                                                return;
                                            }
                                        }
                                    }, 60L, TimeUnit.SECONDS);
                                }
                                else
                                {
                                    PartyMessage.messages(p, "errorallraidyinvite");
                                }
                            }
                            else
                            {
                                PartyMessage.messages(p, "errorallraidyinparty");
                            }
                        }
                    }
                    else
                    {
                        PartyData targetData = new PartyData(t.getName());
                        if (!targetData.hasGroup())
                        {
                            if (!invitationsManager.getPlayerIsInviteTarget(p.getName(), t.getName()))
                            {
                                invitationsManager.addInvitation(p.getName(), t.getName());
                                PartyMessage.sendInvitation(p, t);
                                ProxyServer.getInstance().getScheduler().schedule((Plugin)api, (Runnable)new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        if (invitationsManager.getPlayerIsInviteTarget(p.getName(), t.getName()))
                                        {
                                            invitationsManager.removeInvitation(p.getName(), t.getName());
                                            if (p != null)
                                            {
                                                PartyMessage.expireInvitation(p, t.getName());
                                            }
                                            return;
                                        }
                                        else
                                        {
                                            return;
                                        }
                                    }
                                }, 60L, TimeUnit.SECONDS);
                            }
                            else
                            {
                                PartyMessage.messages(p, "errorallraidyinvite");
                            }
                        }
                        else
                        {
                            PartyMessage.messages(p, "errorallraidyinparty");
                        }
                    }
                }
                else
                {
                    PartyData targetData = new PartyData(t.getName());
                    if (!targetData.hasGroup())
                    {
                        if (!invitationsManager.getPlayerIsInviteTarget(p.getName(), t.getName()))
                        {
                            invitationsManager.addInvitation(p.getName(), t.getName());
                            PartyMessage.sendInvitation(p, t);
                            ProxyServer.getInstance().getScheduler().schedule((Plugin)api, (Runnable)new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    if (invitationsManager.getPlayerIsInviteTarget(p.getName(), t.getName()))
                                    {
                                        invitationsManager.removeInvitation(p.getName(), t.getName());
                                        if (p != null)
                                        {
                                            PartyMessage.expireInvitation(p, t.getName());
                                        }
                                        return;
                                    }
                                    else
                                    {
                                        return;
                                    }
                                }
                            }, 60L, TimeUnit.SECONDS);
                        }
                        else
                        {
                            PartyMessage.messages(p, "errorallraidyinvite");
                        }
                    }
                    else
                    {
                        PartyMessage.messages(p, "errorallraidyinparty");
                    }
                }
            }
            if (args[0].equalsIgnoreCase("accept") || args[0].equalsIgnoreCase("join"))
            {
                String inviteurName = args[1];
                PartyData accepteurData = new PartyData(p.getName());
                ProxiedPlayer inviteur = ProxyServer.getInstance().getPlayer(inviteurName);

                if (inviteur == null) { PartyMessage.messages(p, "errornotonline"); return; }
                if (inviteur.getServer().getInfo().getName().contains("Login")) { PartyMessage.messages(p, "errortargetisonlogin"); return; }
                if (p.getName().equalsIgnoreCase(inviteurName)) { PartyMessage.messages(p, "erroracceptyourself"); return; }

                PartyData inviteurData = new PartyData(inviteur.getName());

                if (!accepteurData.hasGroup())
                {
                    if (!inviteurData.hasGroup())
                    {
                        if (invitationsManager.getPlayerIsInviteTarget(inviteur.getName(), p.getName()))
                        {

                            invitationsManager.removeInvitation(inviteur.getName(), p.getName());
                            inviteurData.createGroup();
                            int groupID = inviteurData.getGroupName();
                            for (String playersNameInGroup : inviteurData.getGroupPlayers(groupID))
                            {
                                ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                                if (t != null)
                                {
                                    PartyMessage.joinPublicGroup(t, p.getName());
                                }
                            }
                            for (String playersNameInGroup : inviteurData.getGroupMods(groupID))
                            {
                                ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                                if (t != null)
                                {
                                    PartyMessage.joinPublicGroup(t, p.getName());
                                }
                            }
                            PartyMessage.acceptInvitation(p, inviteur);
                            accepteurData.joinGroup(groupID);
                            PartyMessage.messages(inviteur, "creategroup");
                        }
                        else
                        {
                            PartyMessage.messages(p, "errornotinviteby");
                        }
                    }
                    else
                    {
                        int groupID = inviteurData.getGroupName();
                        if (accepteurData.isBan(groupID))
                        {
                            PartyMessage.messages(p, "erroryourisban");
                            return;
                        }
                        if (!inviteurData.getLeader(groupID).equalsIgnoreCase(inviteur.getName()))
                        {
                            if (inviteurData.getRank(groupID) == 1)
                            {
                                if (!accepteurData.hasGroup())
                                {
                                    if (invitationsManager.getPlayerIsInviteTarget(inviteur.getName(), p.getName()))
                                    {
                                        invitationsManager.removeInvitation(inviteur.getName(), p.getName());
                                        for (String playersNameInGroup : inviteurData.getGroupPlayers(groupID))
                                        {
                                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                                            if (t != null)
                                            {
                                                PartyMessage.joinPublicGroup(t, p.getName());
                                            }
                                        }
                                        for (String playersNameInGroup : inviteurData.getGroupMods(groupID))
                                        {
                                            ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                                            if (t != null)
                                            {
                                                PartyMessage.joinPublicGroup(t, p.getName());
                                            }
                                        }
                                        accepteurData.joinGroup(groupID);
                                        PartyMessage.acceptInvitation(p, inviteur);
                                    }
                                    else
                                    {
                                        PartyMessage.messages(p, "errornotinviteby");
                                    }
                                }
                                else
                                {
                                    PartyMessage.messages(p, "errorallraidyinparty");
                                }
                            }
                        }
                        if (inviteurData.getGroupStatus() == 1)
                        {
                            if (invitationsManager.getPlayerIsInviteTarget(inviteur.getName(), p.getName()))
                            {
                                invitationsManager.removeInvitation(inviteur.getName(), p.getName());
                                for (String playersNameInGroup : inviteurData.getGroupPlayers(groupID))
                                {
                                    ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                                    if (t != null)
                                    {
                                        PartyMessage.joinPublicGroup(t, p.getName());
                                    }
                                }
                                for (String playersNameInGroup : inviteurData.getGroupMods(groupID))
                                {
                                    ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                                    if (t != null)
                                    {
                                        PartyMessage.joinPublicGroup(t, p.getName());
                                    }
                                }
                                accepteurData.joinGroup(groupID);
                                PartyMessage.acceptInvitation(p, inviteur);
                            }
                            else
                            {
                                PartyMessage.messages(p, "errornotinviteby");
                            }
                        }
                        else if (inviteurData.getGroupStatus() == 2)
                        {
                            if (invitationsManager.getPlayerIsInviteTarget(inviteur.getName(), p.getName()))
                            {
                                invitationsManager.removeInvitation(inviteur.getName(), p.getName());
                                for (String playersNameInGroup : inviteurData.getGroupPlayers(groupID))
                                {
                                    ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                                    if (t != null)
                                    {
                                        PartyMessage.joinPublicGroup(t, p.getName());
                                    }
                                }
                                for (String playersNameInGroup : inviteurData.getGroupMods(groupID))
                                {
                                    ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                                    if (t != null)
                                    {
                                        PartyMessage.joinPublicGroup(t, p.getName());
                                    }
                                }
                                accepteurData.joinGroup(groupID);
                                PartyMessage.acceptInvitation(p, inviteur);
                            }
                            else
                            {
                                for (String playersNameInGroup : inviteurData.getGroupPlayers(groupID))
                                {
                                    ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                                    if (t != null)
                                    {
                                        PartyMessage.joinPublicGroup(t, p.getName());
                                    }
                                }
                                for (String playersNameInGroup : inviteurData.getGroupMods(groupID))
                                {
                                    ProxiedPlayer t = ProxyServer.getInstance().getPlayer(playersNameInGroup);
                                    if (t != null)
                                    {
                                        PartyMessage.joinPublicGroup(t, p.getName());
                                    }
                                }
                                PartyMessage.joinPublicGroup(p, p.getName());
                                PartyMessage.joinPublicGroup(inviteur, p.getName());
                                accepteurData.joinGroup(groupID);
                            }
                        }
                    }
                }
                else
                {
                    PartyMessage.messages(p, "errorallraidyinparty");
                }
            }
        }
        if (args.length == 3)
        {
            if (args[0].equalsIgnoreCase("rank"))
            {
                String targetName = args[1];
                String rankName = args[2];
                PartyData playerData = new PartyData(p.getName());
                ProxiedPlayer inviteur = ProxyServer.getInstance().getPlayer(targetName);

                if (inviteur == null) { PartyMessage.messages(p, "errornotonline"); return; }
                if (inviteur.getServer().getInfo().getName().contains("Login")) { PartyMessage.messages(p, "errortargetisonlogin"); return; }
                if (p.getName().equalsIgnoreCase(targetName)) { PartyMessage.messages(p, "errornotsetrankbutisleader"); return; }

                PartyData targetData = new PartyData(inviteur.getName());
                if (playerData.hasGroup())
                {
                    int groupID = playerData.getGroupName();
                    if (playerData.getLeader(groupID).equalsIgnoreCase(p.getName()))
                    {
                        if (groupID != targetData.getGroupName()) { PartyMessage.messages(p, "errornotyourgroup"); return; }
                        if (rankName.equalsIgnoreCase("joueur"))
                        {
                            targetData.setRank(0, groupID);
                            PartyMessage.setRank(p, inviteur, 0);
                        }
                        if (rankName.equalsIgnoreCase("mod"))
                        {
                            targetData.setRank(1, groupID);
                            PartyMessage.setRank(p, inviteur, 1);
                        }
                    }
                }
            }
        }
    }

}
