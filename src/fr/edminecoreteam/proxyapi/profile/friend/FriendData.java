package fr.edminecoreteam.proxyapi.profile.friend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.edminecoreteam.proxyapi.fetcher.UUIDFetcher;
import fr.edminecoreteam.proxyapi.mysql.MySQL;
import net.md_5.bungee.api.ProxyServer;

public class FriendData
{
    protected static String table;
    private String p;
    private String t;

    public FriendData(String p)
    {
        this.p = p;
    }
    public FriendData(String p, String t)
    {
        this.p = p;
        this.t = t;
    }

    static {
        FriendData.table = "ed_friends";
    }

    public void addFriend()
    {
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO " + table + " (player_name, uuid_player, friend_name, uuid_friend, isFavoris) VALUES (?, ?, ?, ?, 0)");
            ps.setString(1, p);
            ps.setString(2, ProxyServer.getInstance().getPlayer(p).getUniqueId().toString());
            ps.setString(3, t);
            ps.setString(4, ProxyServer.getInstance().getPlayer(t).getUniqueId().toString());
            ps.execute();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addFriendOffline() throws Exception
    {
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO " + table + " (player_name, uuid_player, friend_name, uuid_friend, isFavoris) VALUES (?, ?, ?, ?, 0)");
            ps.setString(1, p);
            ps.setString(2, UUIDFetcher.getUUID(p).toString());
            ps.setString(3, t);
            ps.setString(4, UUIDFetcher.getUUID(t).toString());
            ps.execute();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void removeFriend()
    {
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE FROM " + table + " WHERE player_name = ? and friend_name = ?");
            ps.setString(1, p);
            ps.setString(2, t);
            ps.execute();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addRequest()
    {
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO " + table + " (request_name, request_uuid, request_friend, request_frienduuid) VALUES (?, ?, ?, ?)");
            ps.setString(1, p);
            ps.setString(2, ProxyServer.getInstance().getPlayer(p).getUniqueId().toString());
            ps.setString(3, t);
            ps.setString(4, ProxyServer.getInstance().getPlayer(t).getUniqueId().toString());
            ps.execute();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void setStatusDemand(int status)
    {
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE " + table + " SET status_demand = ? WHERE request_uuid = ? AND request_friend = ?");
            ps.setInt(1, status);
            ps.setString(2, ProxyServer.getInstance().getPlayer(p).getUniqueId().toString());
            ps.setString(3, t);
            ps.execute();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void removeRequest()
    {
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE FROM " + table + " WHERE request_name = ? and request_friend = ?");
            ps.setString(1, p);
            ps.setString(2, t);
            ps.execute();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void setFavoris(int isFavoris){
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE " + table + " SET isFavoris = ? WHERE player_name = ? AND friend_name = ?");
            ps.setInt(1, isFavoris);
            ps.setString(2, p);
            ps.setString(3, t);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getFavList(){
        List<String> favList = new ArrayList<String>();
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT friend_name FROM " + table + " WHERE player_name = ? AND isFavoris = 1");
            ps.setString(1, p);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                favList.add(rs.getString("friend_name"));
            }
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
            return favList;
        }
        return favList;
    }

    public List<String> getFriendList()
    {
        List<String> friendList = new ArrayList<String>();
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT friend_name FROM " + table + " WHERE player_name = ?");
            ps.setString(1, p);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                friendList.add(rs.getString("friend_name"));
            }
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return friendList;
        }
        return friendList;
    }

    public List<String> getFriendRequest()
    {
        List<String> requestList = new ArrayList<String>();
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT request_friend FROM " + table + " WHERE request_name = ? AND status_demand = '2'");
            ps.setString(1, p);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                requestList.add(rs.getString("request_friend"));
            }
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return requestList;
        }
        return requestList;
    }

    public List<String> getFriendRequestSend()
    {
        List<String> requestList = new ArrayList<String>();
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT request_friend FROM " + table + " WHERE request_name = ? AND status_demand = '1'");
            ps.setString(1, p);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                requestList.add(rs.getString("request_friend"));
            }
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return requestList;
        }
        return requestList;
    }

    public boolean getFDemand() {
        return getFriendDemand() == 0;
    }

    public int getFriendDemand()
    {
        try
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT frienddemand FROM settings WHERE uuid_player = ?");
            preparedStatement.setString(1, ProxyServer.getInstance().getPlayer(p).getUniqueId().toString());
            ResultSet rs = preparedStatement.executeQuery();
            float value = 0.0f;
            while (rs.next())
            {
                value = rs.getFloat("frienddemand");
            }
            preparedStatement.close();
            return (int)value;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public int getStatusDemand()
    {
        try
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT status_demand FROM " + table + " WHERE request_uuid = ?");
            preparedStatement.setString(1, ProxyServer.getInstance().getPlayer(p).getUniqueId().toString());
            ResultSet rs = preparedStatement.executeQuery();
            float value = 0.0f;
            while (rs.next())
            {
                value = rs.getFloat("status_demand");
            }
            preparedStatement.close();
            return (int)value;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isFriendWith() {
        return getFriendList().contains(ProxyServer.getInstance().getPlayer(t).getUniqueId().toString());
    }

    public boolean isRequestWith() {
        return getFriendRequest().contains(ProxyServer.getInstance().getPlayer(t).getUniqueId().toString());
    }

    public Integer getFriendCount()
    {
        Integer counter = 0;
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT friend_name FROM " + table + " WHERE player_name = ?");
            ps.setString(1, p);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                ++counter;
            }
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return counter;
        }
        return counter;
    }

    public Integer getRequestCount()
    {
        Integer counter = 0;
        try
        {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT request_friend FROM " + table + " WHERE request_name = ?");
            ps.setString(1, p);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                ++counter;
            }
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return counter;
        }
        return counter;
    }
}
