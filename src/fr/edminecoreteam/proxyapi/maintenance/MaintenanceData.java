package fr.edminecoreteam.proxyapi.maintenance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.edminecoreteam.proxyapi.mysql.MySQL;

public class MaintenanceData
{
    private String p;

    public MaintenanceData(String p)
    {
        this.p = p;
    }

    public void addInMaintenanceWhitelist(String modName)
    {
        if (!isInMaintenanceWhitelist())
        {
            try
            {
                PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("INSERT INTO ed_maintenance (player_name, add_by_name) VALUES (?, ?)");
                preparedStatement.setString(1, p); /*player_name*/
                preparedStatement.setString(2, modName);
                preparedStatement.execute();
                preparedStatement.close();
            }
            catch (SQLException e)
            {
                e.toString();
            }
        }
    }

    public void removeFromMaintenanceWhitelist()
    {
        if (isInMaintenanceWhitelist())
        {
            try
            {
                PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("DELETE FROM ed_maintenance WHERE player_name = ?");
                preparedStatement.setString(1, p); /*player_name*/
                preparedStatement.execute();
                preparedStatement.close();
            }
            catch (SQLException e)
            {
                e.toString();
            }
        }
    }

    public boolean isInMaintenanceWhitelist()
    {
        try
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT player_name FROM ed_maintenance WHERE player_name = ?");
            preparedStatement.setString(1, p);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        }
        catch (SQLException e)
        {
            e.toString();
            return false;
        }
    }

    public int getModuleRank()
    {
        try
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT player_modulable_rank FROM ed_ranks WHERE player_name = ?");
            preparedStatement.setString(1, p);
            ResultSet rs = preparedStatement.executeQuery();
            int coins = 0;
            while (rs.next())
            {
                coins = rs.getInt("player_modulable_rank");
            }
            preparedStatement.close();
            return coins;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public String getRankType()
    {
        try
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT player_rank_type FROM ed_ranks WHERE player_name = ?");
            preparedStatement.setString(1, p);
            ResultSet rs = preparedStatement.executeQuery();
            String coins = "";
            while (rs.next())
            {
                coins = rs.getString("player_rank_type");
            }
            preparedStatement.close();
            return coins;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return "";
        }
    }
}
