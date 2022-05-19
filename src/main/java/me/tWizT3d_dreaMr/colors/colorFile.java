package me.tWizT3d_dreaMr.colors;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class colorFile {
	private static ArrayList<String[]> colors;
	private static File Config;
	private static YamlConfiguration config;
	public static void enable(){
		
		colors=new ArrayList<String[]>();
	if(!(new File("plugins/tWizT3dColors/Color.yml").exists())){
		System.out.println("Lang File doesn't exist. Attempting to create the file");
		try {
			new File("plugins/tWizT3dColors/Color.yml").createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not create Color file");
		}
	}
	 Config = new File("plugins/tWizT3dColors/Color.yml");
	 config = YamlConfiguration.loadConfiguration(Config);
	try {
		config.save(Config);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(!config.contains("Config")) {
		try {
			createDef();
			config.save(Config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	for(String s:config.getConfigurationSection("ColorCodes").getKeys(false)) {
		String[] ad={s,config.getString("ColorCodes."+s)};
		colors.add(ad);
	}
	}
	public static void createDef() {
		config.set("Config", "1");
		config.set("ColorCodes.j", "ff6600");
	}
	public static ArrayList<String[]> getColorList() {
		return colors;
	}
public static ArrayList<String> colorcommand(Player p) {
	ArrayList<String> ret=new ArrayList<String>();
	ret.add(""+r()+ChatColor.STRIKETHROUGH+"                                                 ");
	ret.add(ChatColor.translateAlternateColorCodes('&',("        &c&lM&e&li&a&ln&b&le&9&lc&d&lr&c&la&e&lf&a&lt&b&l &9&lC&d&lo&c&ll&e&lo&a&lr&b&l &9&lC&d&lo&c&ld&e&le&a&ls")));
	ret.add(ChatColor.WHITE+"  &f "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+ChatColor.DARK_AQUA+"&3 "
			+ChatColor.DARK_RED+"&4 "+ChatColor.DARK_PURPLE+"&5 "+ChatColor.GOLD+"&6 "+ChatColor.GRAY+"&7 ");
	ret.add(ChatColor.DARK_GRAY+" &8 "+ChatColor.BLUE+"&9 "+ChatColor.YELLOW+"&e "+ChatColor.LIGHT_PURPLE+"&d "
			+ChatColor.RED+"&c "+ChatColor.AQUA+"&b "+ChatColor.GREEN+"&a "+ChatColor.BLACK+"&0* ");
	ret.add(ChatColor.WHITE+"        &l"+ChatColor.BOLD+" BOLD "+ChatColor.WHITE+"&o "+ChatColor.ITALIC+"ITALIC");
	ret.add(ChatColor.WHITE+"   &m "+ChatColor.STRIKETHROUGH+"STRIKE"+ChatColor.WHITE+" &n "+ChatColor.UNDERLINE+"ULINE"+ChatColor.WHITE+" &r");
	ret.add(""+r()+ChatColor.STRIKETHROUGH+"                                                 ");
	ret.add("         "+r()+"C"+r()+"u"+r()+"s"+r()+"t"+r()+"o"+r()+"m"+r()+" "+r()+"C"+r()+"o"+r()+"l"+r()+"o"+r()+"r"+r()+"s");
	int i=1;
	String temp="  ";
	for(String[] s:colors) {
			if(i==8) {
				if(!s[1].equalsIgnoreCase("random"))
					temp=temp+ChatColor.of("#"+s[1])+"&"+s[0];
				else temp=temp+r()+"&"+s[0]+"** ";
				ret.add(temp);
				temp="  ";
				i=0;
			}else if(!s[1].equalsIgnoreCase("random"))
				temp=temp+ChatColor.of("#"+s[1])+"&"+s[0]+" ";
			else temp=temp+r()+"&"+s[0]+"** ";
			i++;
		
	}
	if(!temp.equals("  ")) {
		ret.add(temp);
	}
	ret.add(""+r()+ChatColor.STRIKETHROUGH+"                                                 ");
	ret.add(ChatColor.translateAlternateColorCodes('&',"&3• &f&lCustoms with ** is random."));
	ret.add(""+r()+ChatColor.STRIKETHROUGH+"                                                 ");
	//		&c&e&a&b&9&d
	
	
	return ret;
	
}
public static ArrayList<String> colorcommandnp() {
	ArrayList<String> ret=new ArrayList<String>();

	ret.add(""+r()+ChatColor.STRIKETHROUGH+"                                                 ");
	ret.add(ChatColor.translateAlternateColorCodes('&',("        &c&lM&e&li&a&ln&b&le&9&lc&d&lr&c&la&e&lf&a&lt&b&l &9&lC&d&lo&c&ll&e&lo&a&lr&b&l &9&lC&d&lo&c&ld&e&le&a&ls")));
	ret.add(ChatColor.WHITE+"  &f "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+ChatColor.DARK_AQUA+"&3 "
			+ChatColor.DARK_RED+"&4 "+ChatColor.DARK_PURPLE+"&5 "+ChatColor.GOLD+"&6 "+ChatColor.GRAY+"&7 ");
	ret.add(ChatColor.DARK_GRAY+" &8 "+ChatColor.BLUE+"&9 "+ChatColor.YELLOW+"&e "+ChatColor.LIGHT_PURPLE+"&d "
			+ChatColor.RED+"&c "+ChatColor.AQUA+"&b* "+ChatColor.GREEN+"&a* "+ChatColor.BLACK+"&0* ");
	ret.add(ChatColor.WHITE+"        &l"+ChatColor.BOLD+" BOLD "+ChatColor.WHITE+"&o "+ChatColor.ITALIC+"ITALIC");
	ret.add(ChatColor.WHITE+"   &m "+ChatColor.STRIKETHROUGH+"STRIKE"+ChatColor.WHITE+" &n "+ChatColor.UNDERLINE+"ULINE"+ChatColor.WHITE+" &r");
	ret.add(""+r()+ChatColor.STRIKETHROUGH+"                                                 ");
	ret.add("         "+r()+"C"+r()+"u"+r()+"s"+r()+"t"+r()+"o"+r()+"m"+r()+" "+r()+"C"+r()+"o"+r()+"l"+r()+"o"+r()+"r"+r()+"s");
	int i=1;
	String temp="  ";
	for(String[] s:colors) {
			if(i==8) {
				if(!s[1].equalsIgnoreCase("random"))
					temp=temp+ChatColor.of("#"+s[1].replace("'", ""))+"&"+s[0];
				else temp=temp+r()+"&"+s[0]+"** ";
				ret.add(temp);
				temp="  ";
				i=0;
			}else if(!s[1].equalsIgnoreCase("random"))
				temp=temp+ChatColor.of("#"+s[1])+"&"+s[0]+" ";
			else temp=temp+r()+"&"+s[0]+"** ";
			i++;
		
	}
	return ret;
	
}
public static ChatColor r(){
	String characters ="abcdef1234567890";
	String hex="#";
	while(hex.length()!=7){
		int r=random(characters.length());
			if(r!=characters.length())
				hex=hex+characters.substring(r,r+1);
			else
				hex=hex+characters.substring(r);
	}
	
	return ChatColor.of(hex);
}public static String rh(){
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
public static int random(int x){
	Random randomGenerator = new Random();
	int	rand = randomGenerator.nextInt((x+1));
    return rand;
}
public static void addColor(String code, String Hex) {
	config.set("ColorCodes."+code, Hex);
	try {
		config.save(Config);
	} catch (IOException e) {
		e.printStackTrace();
	}
	String[] ad={code,Hex};
	colors.add(ad);
}
public static boolean isColorCode(String s) {
	if("abcdef1234567890lominkr".contains(s.toLowerCase())) return true;
	for(String st[]:colors) {
		if(st[0].equals(s)) return true;
	}
	return false;
}public static boolean isColorCodend(String s) {
	if("abcdef1234567890lominkr".contains(s.toLowerCase())) return true;
	for(String st[]:colors) {
		if(st[0].equals(s)) return true;
	}
	return false;
}public static String getColor(String s) {
return ColorfyNP("&"+s);
}
public static String ColorfyChat(String message,Player p) {
	for(String[]ad:colors) {
		if(!p.hasPermission("tc.chat."+ad[0]))
			continue;
		String code="&"+ad[0];
		String hex=ad[1];
		ChatColor cc;
		if(hex.equalsIgnoreCase("random"))
			cc=r();
		else
			cc=ChatColor.of("#"+hex);

			while(message.contains(code)) {
				if(hex.equalsIgnoreCase("random")) {
					message=message.replaceFirst(code, ""+cc);
					cc=r();
				} else {
					message=message.replace(code, ""+cc);}
			}
	}
	return message;
}public static String ColorfySign(String message,Player p) {
	for(String[]ad:colors) {
		if(!p.hasPermission("tc.sign."+ad[0]))
			continue;
		String code="&"+ad[0];
		String hex=ad[1];
		ChatColor cc;
		if(hex.equalsIgnoreCase("random"))
			cc=r();
		else
			cc=ChatColor.of("#"+hex);

			while(message.contains(code)) {
				if(hex.equalsIgnoreCase("random")) {
					message=message.replaceFirst(code, ""+cc);
					cc=r();
				} else {
					message=message.replace(code, ""+cc);}
			}
	}
	return message;
}public static String ColorfyAnvil(String message,Player p) {
	for(String[]ad:colors) {
		if(!p.hasPermission("tc.anvil."+ad[0]))
			continue;
		String code="&"+ad[0];
		String hex=ad[1];
		ChatColor cc;
		if(hex.equalsIgnoreCase("random"))
			cc=r();
		else
			cc=ChatColor.of("#"+hex);

			while(message.contains(code)) {
				if(hex.equalsIgnoreCase("random")) {
					message=message.replaceFirst(code, ""+cc);
					cc=r();
				} else {
					message=message.replace(code, ""+cc);}
			}
	}
	return message;
}public static String ColorfyNP(String message) {
	for(String[]ad:colors) {
		String code="&"+ad[0];
		String hex=ad[1];
		ChatColor cc;
		if(hex.equalsIgnoreCase("random"))
			cc=r();
		else
			cc=ChatColor.of("#"+hex);

			while(message.contains(code)) {
				if(hex.equalsIgnoreCase("random")) {
					message=message.replaceFirst(code, ""+cc);
					cc=r();
				} else {
					message=message.replace(code, ""+cc);}
			}
	}
	return message;
}
public static String Colorfyexclamation(String message) {
	for(String[]ad:colors) {
		String code="!"+ad[0];
		String hex=ad[1];
		ChatColor cc;
		if(hex.equalsIgnoreCase("random"))
			cc=r();
		else
			cc=ChatColor.of("#"+hex);

			while(message.contains(code)) {
				if(hex.equalsIgnoreCase("random")) {
					message=message.replaceFirst(code, ""+cc);
					cc=r();
				} else {
					message=message.replace(code, ""+cc);}
			}
	}
	message=ChatColor.translateAlternateColorCodes('!', message);
	return message;
}
public static String ColorfyCommandP(String message, Player p, String Command) {
	if(Command.equalsIgnoreCase("setcolor")) {return message;}
	for(String[]ad:colors) {
		if(!p.hasPermission("tc.command."+ad[0]))
			continue;
		
	String code="&"+ad[0];
	String hex=ad[1];
	ChatColor cc;
	if(hex.equalsIgnoreCase("random"))
		cc=r();
	else
		cc=ChatColor.of("#"+hex);
		while(message.contains(code)) {
			if(hex.equalsIgnoreCase("random")) {
				message=message.replaceFirst(code, ""+cc);
				cc=r();
			} else {
				message=message.replace(code, ""+cc);}
		}
	
	
}
	return message;
}
public static String ColorfyCommandNP(String message) {
	for(String[]ad:colors)
		if(message.contains("&"+ad[0])) {
			message=message.replace("&"+ad[0], ""+ChatColor.of("#"+ad[1]));
		}
	
	return message;
}

}
