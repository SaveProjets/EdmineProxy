package fr.edminecoreteam.proxyapi.profile.friend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class FriendInfo
{
    private Map<String, FriendInfo> friendInfo;

    private String p;
    private String t;
    private FriendData friendData;
    //accountInfo = new HashMap<Player, AccountInfo>();

    public FriendInfo(String p) {
        this.p = p;
        this.friendInfo = new HashMap<String, FriendInfo>();
        this.friendData = new FriendData(p);
        this.friendInfo.put(p, this);
    }
    public FriendInfo(String p, String t) {
        this.p = p;
        this.t = t;
        this.friendInfo = new HashMap<String, FriendInfo>();
        this.friendData = new FriendData(p, t);
        this.friendInfo.put(p, this);
        this.friendInfo.put(t, this);
    }

    public String getPlayer() { return p; }
    public String getTarget() { return t; }

    public void addFriend() { friendData.addFriend(); }
    public void addFriendOffline() throws Exception  { friendData.addFriendOffline(); }
    public void removeFriend() { friendData.removeFriend(); }
    public void addRequest() { friendData.addRequest(); }
    public void setStatusDemand(int status) { friendData.setStatusDemand(status); }
    public void removeRequest() { friendData.removeRequest(); }
    public List<String> getFriendList() { return friendData.getFriendList(); }
    public List<String> getFriendRequest() { return friendData.getFriendRequest(); }
    public List<String> getFriendRequestSend() { return friendData.getFriendRequestSend(); }
    public int getFriendDemand() { return friendData.getFriendDemand(); }
    public int getStatusDemand() { return friendData.getStatusDemand(); }
    public Integer getFriendCount() { return friendData.getFriendCount(); }
    public Integer getRequestCount() { return friendData.getRequestCount(); }
}
