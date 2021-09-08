 package me.tWizT3d_dreaMr.colors;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import net.md_5.bungee.api.ChatColor;
 
 public class main extends org.bukkit.plugin.java.JavaPlugin
 {
   public static FileConfiguration config;
   public static Plugin plugin;
   public static boolean mute;
   public static Set<String> pinatas;
public void onEnable()
{	LangHandler.enable();
	config = getConfig();
	config.options().copyDefaults(true);
    saveConfig();
	plugin=this;
	config = getConfig();

		colorFile.enable();
		me.tWizT3d_dreaMr.colors.configHandler.enable();
		Bukkit.getPluginManager().registerEvents(new Chat(), this);
	     Bukkit.getPluginManager().registerEvents(new AnvilRoname(), this);
             Bukkit.getPluginManager().registerEvents(new command(), this);
	
	    
		config.options().copyDefaults(true);
		saveConfig();
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new Expansion(this).register();}
   }
   
   public void onDisable() {}
public List<String> onTabComplete(CommandSender sender , Command cmd, String CommandLabel, String[] args){
	return null;
}
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		  if (command.getName().equalsIgnoreCase("colorme"))
		    { 
		      if (sender instanceof Player)
		      {
		    	  if(!sender.hasPermission("Colorme.Create")) {

			    	sender.sendMessage(LangHandler.get("General","NoPerms",null,null));
		    		  return true;
		    	  }
		      }
		      if(args.length!=2) {
		          sender.sendMessage(LangHandler.get("General","Incorrect",null,null));
		    	  return true;
		      }
		      if(!(args[1].length()==6&&args[1].matches("([a-fA-F0-9]{6})"))) {
		          sender.sendMessage(LangHandler.get("General","Incorrect",null,null));
		    	  return true;
		      }
		      colorFile.addColor(args[0], args[1]);
		      sender.sendMessage(ChatColor.of("#"+args[1])+"You have set &"+args[0]);
		      return true;
		    }
		  if(command.getName().equalsIgnoreCase("colors")) {
			  if(sender instanceof Player) {
				  for(String s:colorFile.colorcommand((Player) sender)) {
					  sender.sendMessage(s);
				  }
			  }
			  else {
				  for(String s:colorFile.colorcommandnp()) {
					  sender.sendMessage(s);
				  }  
			  }
			  return true;
		  
    }		  if(command.getName().equalsIgnoreCase("color")) {
		  if(sender instanceof Player) {
			 Player p=(Player)sender;
			 if(args.length==0) {
				 ChatGui.Command(p);return true;
			 }
			 if(args.length==1) {
				 if(args[0].equalsIgnoreCase("remove")) {
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user "+p.getName()+" suffix \"\"");
					 p.sendMessage(ChatColor.RED+"You have removed your color");
					 return true;
				 }
			 }
			 if(args.length==2) {
				 if(args[0].equalsIgnoreCase("set")) {
					 if(colorFile.isColorCodend(args[1])) {
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user "+p.getName()+" suffix !"+args[1]);
					 p.sendMessage(colorFile.Colorfyexclamation("!bYou have set your chatcolor to !"+args[1]+"this color"));return true;}
					 else {p.sendMessage(ChatColor.RED+"That is not a color");return true;}
				 }
			 }
		  }
		  else {
			  sender.sendMessage("no");return true;
		  }
		  sender.sendMessage(ChatColor.RED+"Error in your syntax");
		  return true;
	  
}return false;
}
}

