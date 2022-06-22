package me.tWizT3d_dreaMr.colors;

import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class color {
private static HashMap<String, ChatColor> colors;
public static void addColor(String key, String hex) {
//	if(colors == null)
	//	colors=new HashMap<String, ChatColor>();
if(hex.equalsIgnoreCase("random")) {
	colors.put(key, null);
}
key= key.replace("&", "");
hex= hex.replace("#", "");
hex= hex.replace("&", "");
hex= "&#"+hex;
if(Formatter.isHex(hex)) {
	ChatColor end= ChatColor.of(hex.replace("&", ""));
	if(end != null) {
		colors.put(key, end);
	}
} 
}
public static ChatColor getColor(String key) {
key= key.replace("&", "");
ChatColor get=colors.get(key);
if(get==null) {
	get=randomColor();
}
return get;
}
public static String getColorString(String key) {
key= key.replace("&", "");
ChatColor get=colors.get(key);
if(get==null) {
	return randomHexString();
}
Color c= get.getColor();

return "#"+Integer.toHexString(c.getRed())+Integer.toHexString(c.getGreen())+Integer.toHexString(c.getBlue());
}
public static ChatColor randomColor() {
String hex="#"+randomHexString();
return ChatColor.of(hex);
	
}
public static String randomHexString() {
String characters ="abcdef1234567890";
String hex="";
while(hex.length()!=6){
	int r=random(characters.length());
		if(r!=characters.length())
			hex=hex+characters.substring(r,r+1);
		else
			hex=hex+characters.substring(r);
}
return hex;
	
}

private static int random(int x){
Random randomGenerator = new Random();
int	rand = randomGenerator.nextInt((x+1));
return rand;
}
public static Set<String> getColorsCodes() {
return colors.keySet();
}
public static Collection<ChatColor> getColors() {
return colors.values();
}
public static void init() {
	colors= new HashMap<String, ChatColor>();
	//TODO
}
public static boolean isColor(String s) {
	return colors.containsKey(s);
}
public static boolean isRandomColor(String s) {
	return colors.get(s)==null;
}

public static String ColorfyString(String message, Player p, String Action, String Char) {
for(String key: colors.keySet()) {
	if(p != null && !(p.hasPermission("tc."+Action+"."+key)))
		continue;
	if(message.contains(Char+key)) {
		if(isRandomColor(key)) {
			while(message.contains(Char+key)) 
				message=message.replaceFirst(Char+key, ""+getColor(key));
			
		}
		else
			message=message.replace(Char+key, ""+getColor(key));
		
	}
}
if(p != null && Action.equalsIgnoreCase("chat") && !p.hasPermission("coreprotect.inspect") && main.isFilterOn()) {
	message=message.replace("&l", "");
	message=message.replace("&k", "");
	message=message.replace("&m", "");
	message=message.replace("&n", "");
	message=message.replace("&o", "");
}
if(p != null && (!Action.equalsIgnoreCase("chat")||p.hasPermission("tc.Chat.Defaults")))
	message=ChatColor.translateAlternateColorCodes(Char.toCharArray()[0], message);
return message;
}
}
