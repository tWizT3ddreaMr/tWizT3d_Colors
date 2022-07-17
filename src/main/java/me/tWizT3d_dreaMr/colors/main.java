 package me.tWizT3d_dreaMr.colors;

 import me.tWizT3d_dreaMr.colors.Listeners.Chat;
 import me.tWizT3d_dreaMr.colors.Listeners.Commands;
 import me.tWizT3d_dreaMr.colors.Listeners.Stations.Anvil;
 import me.tWizT3d_dreaMr.colors.Listeners.Stations.Signs;
 import net.md_5.bungee.api.ChatColor;
 import org.bukkit.Bukkit;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandSender;
 import org.bukkit.configuration.file.FileConfiguration;
 import org.bukkit.entity.Player;
 import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
 
 public class main extends org.bukkit.plugin.java.JavaPlugin
 {
 public static FileConfiguration config;
 public static Plugin plugin;
 private static boolean bFFilter;
 private static boolean bOFilter;
 private static ArrayList<String> OFilter;
 private static ArrayList<String> FFilter;
public void onEnable() {
	LangHandler.enable();
	colorFile.enable();
	config = getConfig();
	config.options().copyDefaults(true);
	saveConfig();
	plugin=this;
	config = getConfig();
	
	me.tWizT3d_dreaMr.colors.configHandler.enable();
	Bukkit.getPluginManager().registerEvents(new Chat(), this);
	Bukkit.getPluginManager().registerEvents(new Anvil(), this);
	Bukkit.getPluginManager().registerEvents(new Commands(), this);
	Bukkit.getPluginManager().registerEvents(new Signs(), this);
	OFilter= new ArrayList<>();
	OFilter.add("Staff");
	FFilter.add("l");
	config.addDefault("FormatFilter.enable", true);
	config.addDefault("FormatFilter.filtered", FFilter);
	config.addDefault("OtherFilter.enable", true);
	config.addDefault("OtherFilter.filtered", OFilter);
	OFilter.clear();
	FFilter.clear();
	
	config.options().copyDefaults(true);
	saveConfig();
	
	if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
		new Expansion(this).register();
	}
	OFilter.addAll(config.getStringList("OtherFilter.filtered"));
	FFilter.addAll(config.getStringList("FormatFilter.filtered"));
	bOFilter=config.getBoolean("OtherFilter.enable");
	bFFilter=config.getBoolean("FormatFilter.enable");
}
 
public void onDisable() {}
public List<String> onTabComplete(CommandSender sender , Command cmd, String CommandLabel, String[] args){
	return null;
}
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
if (command.getName().equalsIgnoreCase("grad")) {
	if (sender instanceof Player) {
		if(!sender.hasPermission("Colorme.Grad")) {	
			sender.sendMessage(LangHandler.get("General","NoPerms",null,null));
			return true;
		}
		gradientItem.gothrough(args, (Player) sender);
	}
	else {
		sender.sendMessage(LangHandler.get("General","Incorrect",null,null));
	}
	return true;
}
if (command.getName().equalsIgnoreCase("colorme")) {
	if (sender instanceof Player) {
		if(!sender.hasPermission("Colorme.Create")) {
			sender.sendMessage(LangHandler.get("General","NoPerms",null,null));
			return true;
		}
	}
	if(args.length!=2) {
		sender.sendMessage(LangHandler.get("General","Incorrect",null,null));
		return true;
	}
	if(!(args[1].length()==6&&args[1].matches("([a-fA-F\\d]{6})"))) {
		sender.sendMessage(LangHandler.get("General","Incorrect",null,null));
		return true;
	}
	colorFile.addColor(args[0], args[1]);
	sender.sendMessage(ChatColor.of("#"+args[1])+"You have set &"+args[0]);
	return true;
}
if(command.getName().equalsIgnoreCase("colors")) {
	if(sender instanceof Player) {
		for(String s:colorFile.colorcommand()) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('!', color.ColorfyString(s, null, null, "!")));
		}
	}
	return true;
}
if(command.getName().equalsIgnoreCase("setcolor")) {
	if(sender instanceof Player p) {
		if(args.length==0) {
				ChatGui.Command(p);return true;
			}
		if(args.length==1) {
			if(args[0].equalsIgnoreCase("remove")) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user "+p.getName()+" suffix \"\"");
				p.sendMessage(ChatColor.RED +"You have removed your color");
				return true;
			} 
			sender.sendMessage("Incorrect format");return true;
		}
		if(args.length==2) {
			if(args[0].equalsIgnoreCase("set")) {
				if(color.isColor(args[1])) {
					if(!p.hasPermission("tc2.color."+args[1])) {
						p.sendMessage(color.ColorfyString("!cYou cannot set your color to !"+args[1]+"this color",null,null,"!"));
						return true;
					}
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user "+p.getName()+" suffix !"+args[1]);
					p.sendMessage(color.ColorfyString("!bYou have set your chatcolor to !"+args[1]+"this color",null,null,"!"));
					return true;
				}
				else if(Formatter.hasHex(args[1])) {
					if(!p.hasPermission("tc2.color."+args[1])) {
						p.sendMessage(color.ColorfyString("!cYou cannot set your color to !"+args[1]+"this color",null,null,"!"));
						return true;
					}
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user "+p.getName()+" suffix "+args[1]);
					p.sendMessage(Formatter.formatnp(color.ColorfyString("!bYou have set your chatcolor to "+args[1]+"this color",null,null,"!")));
					return true;
				}
				else {
					p.sendMessage(ChatColor.RED+"That is not a color");
					return true;
				}
			}
			if(args[0].equalsIgnoreCase("setg")) {
				if(color.isGrad(args[1])) {
					if(!p.hasPermission("tcg2.color."+args[1])) {
						p.sendMessage(color.ColorfyString("!cYou cannot set your color to !"+args[1]+"this color",null,null,"!"));
						return true;
					}
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user "+p.getName()+" suffix !"+args[1]);
					p.sendMessage(color.ColorfyString("!bYou have set your chatcolor to !"+args[1]+"this color",null,null,"!"));
				}
				else {
					p.sendMessage(ChatColor.RED+"That is not a gradient");
				}
				return true;
			}
			sender.sendMessage("Incorrect format");
			return true;
		}
	}
	else {
		sender.sendMessage("no");return true;
	}
}
return false;
}
public static boolean isFFilterOn() {
	return bFFilter;
}
public static ArrayList<String> oFilter() {
	return OFilter;
}
public static ArrayList<String> fFilter() {
	return FFilter;
}
public static boolean isOFfilterOn() {
	return bOFilter;
}
}


