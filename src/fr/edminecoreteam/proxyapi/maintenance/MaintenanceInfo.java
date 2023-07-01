package fr.edminecoreteam.proxyapi.maintenance;

import java.util.HashMap;
import java.util.Map;

public class MaintenanceInfo
{
    private Map<String, MaintenanceInfo> maintenanceInfo;
    private String p;
    private MaintenanceData maintenanceData;
    //accountInfo = new HashMap<Player, AccountInfo>();

    public MaintenanceInfo(String p) {
        this.p = p;
        this.maintenanceInfo = new HashMap<String, MaintenanceInfo>();
        this.maintenanceData = new MaintenanceData(p);
        this.maintenanceInfo.put(p, this);
    }

    public MaintenanceInfo getAccountInfos(String player) { return maintenanceInfo.get(player); }

    public String getPlayerName() { return p; }

    public int getModuleRank() { return maintenanceData.getModuleRank(); }
    public String getRankType() { return maintenanceData.getRankType(); }

    public void addInMaintenanceWhitelist() { maintenanceData.addInMaintenanceWhitelist(); }
    public void removeFromMaintenanceWhitelist() { maintenanceData.removeFromMaintenanceWhitelist(); }
    public boolean isInMaintenanceWhitelist() { return maintenanceData.isInMaintenanceWhitelist(); }

}
