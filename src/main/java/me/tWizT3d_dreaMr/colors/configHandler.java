package me.tWizT3d_dreaMr.colors;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class configHandler {
public static FileConfiguration config;
public static File Config;
public static void enable(){
if(!(new File("plugins/tWizT3dColors/Players.yml").exists())){
	try {
		new File("plugins/tWizT3dColors/Players.yml").createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
Config =new File("plugins/tWizT3dColors/Players.yml");
config= YamlConfiguration.loadConfiguration(Config);
try {
	config.save(Config);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
if(!config.contains("Server")) {
	config.set("Server", Arrays.asList("&f","&d"));
	try {
		config.save(Config);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
public static void setColor(Player player, String list){

List<String> color = new ArrayList<>();
Scanner scan=new Scanner(list);int i=0;
while(scan.hasNext()) {
	String temp=scan.next();
	if(temp.startsWith("&")) {
		color.add(temp);i++;
	}
}scan.close();
if(i<2) {color.add("&d");}
config.set(player.getUniqueId().toString(), color);
try {
	config.save(Config);
} catch (IOException e) {
	e.printStackTrace();
}
}public static void removeColor(Player player){
	config.set(player.getUniqueId().toString(), "empty");
	try {
		config.save(Config);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public static void setColorserv(String list){
List<String> color = new ArrayList<>();
Scanner scan=new Scanner(list);int i=0;
while(scan.hasNext()) {
	String temp=scan.next();
	if(temp.startsWith("&")) {
		color.add(temp);i++;
	}
}scan.close();
if(i<2) {color.add("&d");}
config.set("Server", color);
try {
	config.save(Config);
} catch (IOException e) {
	e.printStackTrace();
}
}
@SuppressWarnings("unchecked")
public static List<String> playerColors(Player p){
	List<String> conf=(List<String>) config.getList("Server");
	if(has(p)){
		if(!config.getString(p.getUniqueId().toString()).equalsIgnoreCase("empty"))
			conf=(List<String>) config.getList(p.getUniqueId().toString());
	}
	return conf;
}
public static boolean has(Player p){

return config.contains(p.getUniqueId().toString());

}
public static void setServer(Player p){
config.set(p.getUniqueId().toString(), config.get("Server"));

}
}
