package fr.edminecoreteam.proxyapi.mysql;

import java.sql.SQLException;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class MySQL
{
    private String urlBase;
    private String host;
    private String database;
    private String userName;
    private String password;
    private static Connection connection;

    public MySQL(String urlBase, String host, String database, String userName, String password) {
        this.urlBase = urlBase;
        this.host = host;
        this.database = database;
        this.userName = userName;
        this.password = password;
        this.connexion();
    }

    public static Connection getConnection() {
        return connection;
    }

    public void connexion() {
        if (!isOnline()) {
            try {
                connection = DriverManager.getConnection(String.valueOf(this.urlBase) + this.host + "/" + this.database, this.userName, this.password);
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println("§cErreur de connexion a la base de donnée...");
            }
        }
    }

    public void deconnexion() {
        if (isOnline()) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isOnline() {
        try {
            return connection != null && !connection.isClosed();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void creatingTableMaintenance() {
        try {
            PreparedStatement stm = MySQL.connection.prepareStatement("CREATE TABLE IF NOT EXISTS ed_maintenance (`player_name` varchar(255) NOT NULL, PRIMARY KEY (`player_name`), UNIQUE(`player_name`), INDEX(`player_name`)) CHARACTER SET utf8");
            stm.execute();
            stm.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creatingTableFriends() {
        try {
            PreparedStatement stm = MySQL.connection.prepareStatement("CREATE TABLE IF NOT EXISTS ed_friends (player_name varchar(255), uuid_player varchar(255), friend_name varchar(255), uuid_friend varchar(255), request_name varchar(255), request_uuid varchar(255), request_friend varchar(255), request_frienduuid varchar(255), status_demand int(11)) CHARACTER SET utf8");
            stm.execute();
            stm.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creatingTablePartyList() {
        try {
            PreparedStatement stm = MySQL.connection.prepareStatement("CREATE TABLE IF NOT EXISTS ed_party_list (`group_name` int(11) NOT NULL, `group_leader` varchar(255), `group_player` varchar(255), `group_status` int(11), `group_player_limit` int(11), `group_chat` varchar(255), `group_tag` varchar(255), `group_player_rank` int(11), `group_player_is_ban` int(11)) CHARACTER SET utf8");
            stm.execute();
            stm.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creatingTablePartyBan() {
        try {
            PreparedStatement stm = MySQL.connection.prepareStatement("CREATE TABLE IF NOT EXISTS ed_party_ban (`group_name` int(11) NOT NULL, `group_player` varchar(255)) CHARACTER SET utf8");
            stm.execute();
            stm.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
