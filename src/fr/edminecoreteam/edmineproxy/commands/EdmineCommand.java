package fr.edminecoreteam.edmineproxy.commands;

import fr.edminecoreteam.edmineproxy.EdmineProxy;
import fr.edminecoreteam.edmineproxy.utils.HelpMessages;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EdmineCommand extends Command {

    public EdmineCommand(EdmineProxy edProxy){
        super("edmine");
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = null;

        if(sender instanceof ProxiedPlayer){
            p = (ProxiedPlayer) sender;
        }

        //permission : if()
        if(args.length == 0){
            HelpMessages.getHelpMessage(sender, "help");
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("fragments"))
        {
            HelpMessages.getHelpMessage(sender, "fragments");
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("eclats"))
        {
            HelpMessages.getHelpMessage(sender, "eclats");
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("argent"))
        {
            HelpMessages.getHelpMessage(sender, "argent");
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("rank"))
        {
            HelpMessages.getHelpMessage(sender, "rank");
        }


        if (args.length == 2 && args[1].equalsIgnoreCase("set"))
        {
            if (args[0].equalsIgnoreCase("fragments"))
            {
                HelpMessages.errorMessage(sender, "fragments");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("add"))
        {
            if (args[0].equalsIgnoreCase("fragments"))
            {
                HelpMessages.errorMessage(sender, "fragments");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("remove"))
        {
            if (args[0].equalsIgnoreCase("fragments"))
            {
                HelpMessages.errorMessage(sender, "fragments");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("set"))
        {
            if (args[0].equalsIgnoreCase("eclats"))
            {
                HelpMessages.errorMessage(sender, "eclats");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("add"))
        {
            if (args[0].equalsIgnoreCase("eclats"))
            {
                HelpMessages.errorMessage(sender, "eclats");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("remove"))
        {
            if (args[0].equalsIgnoreCase("eclats"))
            {
                HelpMessages.errorMessage(sender, "eclats");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("set"))
        {
            if (args[0].equalsIgnoreCase("argent"))
            {
                HelpMessages.errorMessage(sender, "argent");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("add"))
        {
            if (args[0].equalsIgnoreCase("argent"))
            {
                HelpMessages.errorMessage(sender, "argent");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("remove"))
        {
            if (args[0].equalsIgnoreCase("argent"))
            {
                HelpMessages.errorMessage(sender, "argent");
            }
        }


        if (args.length == 2 && args[1].equalsIgnoreCase("set"))
        {
            if (args[0].equalsIgnoreCase("rank"))
            {
                HelpMessages.errorMessage(sender, "set");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("tempo"))
        {
            if (args[0].equalsIgnoreCase("rank"))
            {
                HelpMessages.getHelpMessage(sender, "tempo");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("module"))
        {
            if (args[0].equalsIgnoreCase("rank"))
            {
                HelpMessages.getHelpMessage(sender, "module");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("static"))
        {
            if (args[0].equalsIgnoreCase("rank"))
            {
                HelpMessages.getHelpMessage(sender, "static");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("staff"))
        {
            if (args[0].equalsIgnoreCase("rank"))
            {
                HelpMessages.getHelpMessage(sender, "staff");
            }
        }
        if (args.length == 2 && args[1].equalsIgnoreCase("list"))
        {
            if (args[0].equalsIgnoreCase("rank"))
            {
                HelpMessages.getHelpMessage(sender, "list");
            }
        }
        if (args.length == 3)
        {
            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("fragments"))
                {
                    HelpMessages.errorMessage(sender, "fragments");
                }
            }
            if (args[1].equalsIgnoreCase("add"))
            {
                if (args[0].equalsIgnoreCase("fragments"))
                {
                    HelpMessages.errorMessage(sender, "fragments");
                }
            }
            if (args[1].equalsIgnoreCase("remove"))
            {
                if (args[0].equalsIgnoreCase("fragments"))
                {
                    HelpMessages.errorMessage(sender, "fragments");
                }
            }
            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("eclats"))
                {
                    HelpMessages.errorMessage(sender, "eclats");
                }
            }
            if (args[1].equalsIgnoreCase("add"))
            {
                if (args[0].equalsIgnoreCase("eclats"))
                {
                    HelpMessages.errorMessage(sender, "eclats");
                }
            }
            if (args[1].equalsIgnoreCase("remove"))
            {
                if (args[0].equalsIgnoreCase("eclats"))
                {
                    HelpMessages.errorMessage(sender, "eclats");
                }
            }
            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("argent"))
                {
                    HelpMessages.errorMessage(sender, "argent");
                }
            }
            if (args[1].equalsIgnoreCase("add"))
            {
                if (args[0].equalsIgnoreCase("argent"))
                {
                    HelpMessages.errorMessage(sender, "argent");
                }
            }
            if (args[1].equalsIgnoreCase("remove"))
            {
                if (args[0].equalsIgnoreCase("argent"))
                {
                    HelpMessages.errorMessage(sender, "argent");
                }
            }



            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    HelpMessages.errorMessage(sender, "set");
                }
            }
            if (args[1].equalsIgnoreCase("tempo"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    HelpMessages.errorMessage(sender, "tempo");
                }
            }
            if (args[1].equalsIgnoreCase("module"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    HelpMessages.errorMessage(sender, "module");
                }
            }
            if (args[1].equalsIgnoreCase("static"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    HelpMessages.errorMessage(sender, "static");
                }
            }
            if (args[1].equalsIgnoreCase("staff"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    HelpMessages.errorMessage(sender, "staff");
                }
            }
        }
        if (args.length == 4)
        {
            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("fragments"))
                {
                   /* ProxiedProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    Float number = Float.valueOf(args[3]);

                    new EcoSysInfo(target);
                    EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                    ecoSysInfo.setFragmentsDames(number);
                    HelpMessages.successMessage(sender, "setfragments", target.getName(), 0, number);*/

                }
            }
            if (args[1].equalsIgnoreCase("add"))
            {
                if (args[0].equalsIgnoreCase("fragments"))
                {
                 /*   ProxiedPlayer target = ProxyServer.get.getPlayer(args[2]);
                    Float number = Float.valueOf(args[3]);

                    new EcoSysInfo(target);
                    EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                    ecoSysInfo.addFragmentsDames(number);
                    HelpMessages.successMessage(sender, "addfragments", target.getName(), 0, number);*/
                }
            }
            if (args[1].equalsIgnoreCase("remove"))
            {
                if (args[0].equalsIgnoreCase("fragments"))
                {
                   /* ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    Float number = Float.valueOf(args[3]);

                    new EcoSysInfo(target);
                    EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                    ecoSysInfo.removeFragmentsDames(number);
                    HelpMessages.successMessage(sender, "removefragments", target.getName(), 0, number);*/
                }
            }
            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("eclats"))
                {
                   /* ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    Float number = Float.valueOf(args[3]);

                    new EcoSysInfo(target);
                    EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                    ecoSysInfo.setEclatsDivins(number);
                    HelpMessages.successMessage(sender, "seteclats", target.getName(), 0, number);*/
                }
            }
            if (args[1].equalsIgnoreCase("add"))
            {
                if (args[0].equalsIgnoreCase("eclats"))
                {
                 /*   ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    Float number = Float.valueOf(args[3]);

                    new EcoSysInfo(target);
                    EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                    ecoSysInfo.addEclatsDivins(number);
                    HelpMessages.successMessage(sender, "addeclats", target.getName(), 0, number);*/
                }
            }
            if (args[1].equalsIgnoreCase("remove"))
            {
                if (args[0].equalsIgnoreCase("eclats"))
                {
                   /* ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    Float number = Float.valueOf(args[3]);

                    new EcoSysInfo(target);
                    EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                    ecoSysInfo.removeEclatsDivins(number);
                    HelpMessages.successMessage(sender, "removeeclats", target.getName(), 0, number);*/
                }
            }
            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("argent"))
                {
                    /*ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    Float number = Float.valueOf(args[3]);

                    new EcoSysInfo(target);
                    EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                    ecoSysInfo.setArgent(number);
                    HelpMessages.successMessage(sender, "setargent", target.getName(), 0, number);*/
                }
            }
            if (args[1].equalsIgnoreCase("add"))
            {
                if (args[0].equalsIgnoreCase("argent"))
                {
                    /*ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    Float number = Float.valueOf(args[3]);

                    new EcoSysInfo(target);
                    EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                    ecoSysInfo.addArgent(number);
                    HelpMessages.successMessage(sender, "addargent", target.getName(), 0, number);*/
                }
            }
            if (args[1].equalsIgnoreCase("remove"))
            {
                if (args[0].equalsIgnoreCase("argent"))
                {
                   /* ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    Float number = Float.valueOf(args[3]);

                    new EcoSysInfo(target);
                    EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                    ecoSysInfo.removeArgent(number);
                    HelpMessages.successMessage(sender, "removeargent", target.getName(), 0, number);*/
                }
            }


            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    HelpMessages.errorMessage(sender, "set");
                }
            }
            if (args[1].equalsIgnoreCase("tempo"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    HelpMessages.errorMessage(sender, "tempo");
                }
            }
            if (args[1].equalsIgnoreCase("module"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    int module = Integer.valueOf(args[3]);

                    if (target == null) { HelpMessages.errorMessage(sender, "targetoffline"); }

                    /*new RankInfo(target);
                    RankInfo rankInfo = new RankInfo(target);

                    if (module == 9)
                    {
                        rankInfo.updateRankModule(module);
                        rankInfo.updateRankType("module");
                        HelpMessages.successMessage(sender, "module", target.getName(), module, (float) 0.0);
                    }
                    else
                    {
                        HelpMessages.errorMessage(sender, "errorsetmodulesmodule");
                    }*/
                }
            }
            if (args[1].equalsIgnoreCase("static"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    int id = Integer.valueOf(args[3]);

                    if (target == null) { HelpMessages.errorMessage(sender, "targetoffline"); }

                   /* new RankInfo(target);
                    RankInfo rankInfo = new RankInfo(target);

                    if (id == 0 || id == 6 || id == 7 || id == 8)
                    {
                        rankInfo.updatePurchaseDate(null);
                        rankInfo.updateDeadLineDate(null);
                        rankInfo.updateRankID(id);
                        rankInfo.updateRankType("static");
                        rankInfo.updateRankModule(0);
                        HelpMessages.successMessage(sender, "static", target.getName(), id, (float) 0.0);
                    }
                    else
                    {
                        HelpMessages.errorMessage(sender, "errorsetmodulestatic");
                    }*/
                }
            }
            if (args[1].equalsIgnoreCase("staff"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    int id = Integer.valueOf(args[3]);

                    if (target == null) { HelpMessages.errorMessage(sender, "targetoffline"); }

                    /*new RankInfo(target);
                    RankInfo rankInfo = new RankInfo(target);

                    if (id >= 10 && id <= 16)
                    {
                        rankInfo.updateRankModule(id);
                        rankInfo.updateRankType("staff");
                        HelpMessages.successMessage(sender, "staff", target.getName(), id, (float) 0.0);
                    }
                    else
                    {
                        HelpMessages.errorMessage(sender, "errorsetmodulestaff");
                    }*/
                }
            }
        }
        if (args.length == 5)
        {
            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    HelpMessages.errorMessage(sender, "set");
                }
            }
            if (args[1].equalsIgnoreCase("tempo"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {/*
                    ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    int monthNumber = Integer.valueOf(args[3]);
                    int id = Integer.valueOf(args[4]);

                    if (target == null) { HelpMessages.errorMessage(sender, "targetoffline"); return false; }

                    new RankInfo(target);
                    RankInfo rankInfo = new RankInfo(target);
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
                    Date resultpurchasedate = cal.getTime();
                    String purchaseDate = sdf.format(resultpurchasedate);

                    cal.add(Calendar.MONTH, monthNumber);
                    Date resultdeadlinedate = cal.getTime();
                    String deadlineDate = sdf.format(resultdeadlinedate);

                    if (monthNumber >= 1)
                    {
                        if (id >= 1 && id <= 5)
                        {
                            if (rankInfo.getPurchaseDate() != null && rankInfo.getDeadLineDate() != null)
                            {
                                if (rankInfo.getRankType().equalsIgnoreCase("staff"))
                                {
                                    rankInfo.updateDeadLineDate(deadlineDate);
                                    rankInfo.updateRankID(id);
                                    return true;
                                }
                                if (rankInfo.getRankType().equalsIgnoreCase("module"))
                                {
                                    rankInfo.updateDeadLineDate(deadlineDate);
                                    rankInfo.updateRankID(id);
                                    return true;
                                }
                                if (rankInfo.getRankType().equalsIgnoreCase("static") && rankInfo.getRankID() == 0)
                                {
                                    rankInfo.updatePurchaseDate(purchaseDate);
                                    rankInfo.updateDeadLineDate(deadlineDate);
                                    rankInfo.updateRankModule(0);
                                    rankInfo.updateRankID(id);
                                    rankInfo.updateRankType("tempo");
                                    return true;
                                }
                                else if (rankInfo.getRankType().equalsIgnoreCase("static") && rankInfo.getRankID() == 6 || rankInfo.getRankID() == 7 || rankInfo.getRankID() == 8)
                                {
                                    HelpMessages.errorMessage(sender, "errortempo");
                                }

                            }
                            else if (rankInfo.getPurchaseDate() == null && rankInfo.getDeadLineDate() == null)
                            {
                                if (rankInfo.getRankType().equalsIgnoreCase("staff"))
                                {
                                    rankInfo.updatePurchaseDate(purchaseDate);
                                    rankInfo.updateDeadLineDate(deadlineDate);
                                    rankInfo.updateRankID(id);
                                    return true;
                                }
                                if (rankInfo.getRankType().equalsIgnoreCase("module"))
                                {
                                    rankInfo.updatePurchaseDate(purchaseDate);
                                    rankInfo.updateDeadLineDate(deadlineDate);
                                    rankInfo.updateRankID(id);
                                    return true;
                                }
                                if (rankInfo.getRankType().equalsIgnoreCase("static") && rankInfo.getRankID() == 0)
                                {
                                    rankInfo.updatePurchaseDate(purchaseDate);
                                    rankInfo.updateDeadLineDate(deadlineDate);
                                    rankInfo.updateRankID(id);
                                    rankInfo.updateRankType("tempo");
                                    return true;
                                }
                                else if (rankInfo.getRankType().equalsIgnoreCase("static") && rankInfo.getRankID() == 6 || rankInfo.getRankID() == 7 || rankInfo.getRankID() == 8)
                                {
                                    HelpMessages.errorMessage(sender, "errortempo");
                                }
                            }
                        }
                    }

*/
                }
            }
        }
        if (args.length == 6)
        {
            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    HelpMessages.errorMessage(sender, "set");
                }
            }
        }
        if (args.length == 7)
        {
            if (args[1].equalsIgnoreCase("set"))
            {
                if (args[0].equalsIgnoreCase("rank"))
                {
                    ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[2]);
                    String type = String.valueOf(args[3]);
                    int monthNumber = Integer.valueOf(args[4]);
                    int rankID = Integer.valueOf(args[5]);
                    int moduleID = Integer.valueOf(args[6]);

                    if (target == null) { HelpMessages.errorMessage(sender, "targetoffline"); }

                    /*new RankInfo(target);
                    RankInfo rankInfo = new RankInfo(target);

                    rankInfo.setRank(type, rankID, "", moduleID, monthNumber);
                    HelpMessages.successMessage(sender, "set", target.getName(), 0, (float) 0.0);*/
                }
            }
        }
    }
}
