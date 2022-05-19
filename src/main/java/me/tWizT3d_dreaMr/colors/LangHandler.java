package me.tWizT3d_dreaMr.colors;

import java.io.File;
import java.io.IOException;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;



public class LangHandler {
public static FileConfiguration config;
public static File Config;
public static void enable(){
if(!(new File("plugins/tWizT3dColors/Lang.yml").exists())){
	System.out.println("Lang File doesn't exist. Attempting to create the file");
	try {
		new File("plugins/tWizT3dColors/Lang.yml").createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Could not create Lang file");
	}
}
Config =new File("plugins/tWizT3dColors/Lang.yml");
config= YamlConfiguration.loadConfiguration(Config);
try {
	config.save(Config);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
if(!config.contains("Config")) {
	config=defaultSet(config);
	try {
		config.save(Config);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
private static FileConfiguration defaultSet(FileConfiguration conf) {
	conf.set("Config",true);
	//General
	conf=set(conf,"General","NoPerms","&cYou do not have permission to perform this command");
	conf=set(conf,"General","NonSupportedSender","&cCommandSender not supported");
	conf=set(conf,"General","Reload","&8Reloaded tWizT3dColors Configs");
	conf=set(conf,"General","ArgsLong","&cLength too long");
	conf=set(conf,"General","ArgsShort","&cLength too short");
	conf=set(conf,"General","Incorrect","&cIncorrect Usage");
	conf=set(conf,"Grad","Success","&aYour lore has been updated.");
	conf=set(conf,"Grad","NoItem","&cGet an item first dummy");
	conf=set(conf,"Grad","NoLore","&chas no lore my dude");
	conf=set(conf,"Grad","h1h2","&cH1 or H2 null");
	
	conf.options().copyDefaults(true);
return conf;
}
private static FileConfiguration set(FileConfiguration conf,String Plugin,String part,String rest) {
conf.addDefault(Plugin+"."+part,rest);
return conf;
}
public static String get(String plugin, String part,String key,String keyRep) {
	if(config.get(plugin+"."+part)==null) {
		System.out.print("Missing config section "+plugin+"."+part);
		config=defaultSet(config);
		try {
			config.save(Config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
String out=config.getString(plugin+"."+part);
out=out.replaceAll("&", ";");
out=out.replaceAll("<", "\n");
if(!(key==null)) {
	out=replaceKey(out,keyRep,key);
}
out=ChatColor.translateAlternateColorCodes(';', out);

return out;
}
public static void reloadLang() {
Config =new File("plugins/tWizT3dColors/Lang.yml");
config= YamlConfiguration.loadConfiguration(Config);
}
public static String replaceKey(String str,String with,String key) {
	key=">"+key;
	str=str.replaceAll(key, with);
	return str;
	}
}
