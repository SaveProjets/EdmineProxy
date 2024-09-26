package fr.edminecoreteam.edmineproxy.party;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import fr.edminecoreteam.edmineproxy.EdmineProxy;
import fr.edminecoreteam.edmineproxy.profile.AccountData;
import fr.edminecoreteam.edmineproxy.profile.SettingData;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class PartyListener implements Listener
{
    private static EdmineProxy api = EdmineProxy.getInstance();

    @EventHandler
    public void onLeave(PlayerDisconnectEvent e) {
        ProxiedPlayer p = e.getPlayer();
        PartyData pData = new PartyData(p.getName());
        int groupID = pData.getGroupName();
        List<String> groupList = new ArrayList<String>();
        for (String playersNameInGroup : pData.getGroupPlayers(groupID))
        {
            groupList.add(playersNameInGroup);
        }
        for (String playersNameInGroup : pData.getGroupMods(groupID))
        {
            groupList.add(playersNameInGroup);
        }

        for (String s : groupList)
        {
            ProxiedPlayer sPlayer = ProxyServer.getInstance().getPlayer(s);
            if (sPlayer != null)
            {
                PartyMessage.messages(sPlayer, "leaderleave");
            }
        }
        ProxyServer.getInstance().getScheduler().schedule((Plugin)api, (Runnable)new Runnable()
        {
            @Override
            public void run()
            {
                if (!p.isConnected())
                {
                    if (pData.hasGroup())
                    {
                        if (pData.getGroupLeader(groupID).get(0).equalsIgnoreCase(p.getName()))
                        {
                            for (String s : groupList)
                            {
                                ProxiedPlayer sPlayer = ProxyServer.getInstance().getPlayer(s);
                                if (sPlayer != null)
                                {
                                    PartyMessage.messages(sPlayer, "closegroup");
                                }
                            }
                            pData.removeBan(groupID);
                            pData.removeGroup(groupID);
                        }
                    }
                }
                else
                {
                    return;
                }
            }
        }, 300L, TimeUnit.SECONDS);
    }


    @EventHandler
    public void onServerSwitch(ServerConnectEvent e)
    {
        ProxiedPlayer p = e.getPlayer();
        AccountData aData = new AccountData(p.getUniqueId().toString());
        PartyData pData = new PartyData(p.getName());

        if (aData.getStatut() == 1)
        {
            if (pData.hasGroup())
            {
                int groupID = pData.getGroupName();
                if (pData.getLeader(groupID).equalsIgnoreCase(p.getName()))
                {
                    List<String> groupList = new ArrayList<String>();
                    for (String playersNameInGroup : pData.getGroupPlayers(groupID))
                    {
                        groupList.add(playersNameInGroup);
                    }
                    for (String playersNameInGroup : pData.getGroupMods(groupID))
                    {
                        groupList.add(playersNameInGroup);
                    }


                    ProxyServer.getInstance().getScheduler().schedule((Plugin)api, (Runnable)new Runnable()
                    {
                        @Override
                        public void run()
                        {
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
                                    }
                                }
                            }
                        }
                    }, 2L, TimeUnit.SECONDS);
                    PartyMessage.messages(p, "teleportallplayers");
                }
            }
        }
    }
}
