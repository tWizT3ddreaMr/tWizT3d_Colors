package me.tWizT3d_dreaMr.colors;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import net.md_5.bungee.api.ChatColor;

public class colorFile {
	private static File Config;
	private static YamlConfiguration config;
	private static File ColorCodeFile;
	private static YamlConfiguration ColorCodeFileconfig;
	public static void enable(){
		
	color.init();
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
	

	if(!(new File("plugins/tWizT3dColors/ColorsCommand.yml").exists())){
		System.out.println("ColorsCommand File doesn't exist. Attempting to create the file");
		try {
			new File("plugins/tWizT3dColors/ColorsCommand.yml").createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not create Color file");
		}
	}
	ColorCodeFile = new File("plugins/tWizT3dColors/ColorsCommand.yml");
	ColorCodeFileconfig = YamlConfiguration.loadConfiguration(ColorCodeFile);
	try {
		ColorCodeFileconfig.save(ColorCodeFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(!ColorCodeFileconfig.contains("identifier")) {
		try {
			createDef2();
			ColorCodeFileconfig.save(ColorCodeFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	for(String s:config.getConfigurationSection("ColorCodes").getKeys(false)) {
		color.addColor(s,config.getString("ColorCodes."+s));
	}
	}
	private static void createDef() {
		config.set("Config", "1");
		config.set("ColorCodes.j", "ff6600");
		config.set("GradientCodes.gr", "ff00ff ffff00");
	}
	private static void createDef2() {
		ColorCodeFileconfig.set("identifier", "&");
		ArrayList<String> ret= new ArrayList<String>();
		ret.add("!z!m                                                 ");
		ret.add("        !c!lM!e!li!a!ln!b!le!9!lc!d!lr!c!la!e!lf!a!lt!b!l !9!lC!d!lo!c!ll!e!lo!a!lr!b!l !9!lC!d!lo!c!ld!e!le!a!ls");
		ret.add("  &f "+"&1 "+"&2 "+"&3 "
				+"&4 "+"&5 "+"&6 "+"&7 ");
		ret.add(" &8 "+"&9 "+"&e "+"&d "
				+"&c "+"&b "+"&a "+"&0* ");
		ret.add("        &l"+" BOLD "+"&o "+"ITALIC");
		ret.add("   &m "+"STRIKE"+" &n "+"ULINE"+" &r");
		ret.add("!z!m                                                 ");
		ret.add("         "+"!zC"+"!zu"+"!zs"+"!zt"+"!zo"+"!zm"+" "+"!zC"+"!zo"+"!zl"+"!zo"+"!zr"+"!zs");
		ColorCodeFileconfig.set("Start", ret);

		ArrayList<String> ret2= new ArrayList<String>();
		ret2.add("!z!m                                                 ");
		ret2.add(ChatColor.translateAlternateColorCodes('&',"&3* &f&lCustoms with ** is random."));
		ret2.add("!z!m                                                 ");

		ColorCodeFileconfig.set("End", ret2);
	}
@SuppressWarnings("unchecked")
public static ArrayList<String> colorcommand() {

	ArrayList<String> ret=new ArrayList<String>();
	for(String s:(List<String>) ColorCodeFileconfig.getList("Start"))
		ret.add(setT(s));
	
	int i=1;
	String temp="  ";

	for(String s:color.getColorsCodes()) {
			
			if(i==8) {
				if(color.isRandomColor(s))
					temp=temp+r()+"&"+s+"** ";
				else 
					temp=temp+color.getColor(s)+"&"+s;
				ret.add(temp);
				temp="  ";
				i=0;
			}else {
				if(color.isRandomColor(s))
					temp=temp+r()+"&"+s+"** ";
				else 
					temp=temp+color.getColor(s)+"&"+s+" ";
				i++;
			}
		
	}
	if(!temp.equals("  ")) {
		ret.add(temp);
	}
	
	for(String s:(List<String>) ColorCodeFileconfig.getList("End"))
		ret.add(setT(s));
	
	//		&c&e&a&b&9&d
	
	
	return ret;
	
}
public static ChatColor r(){
	return color.randomColor();
}
public static String setT(String s) {
	String identifier=ColorCodeFileconfig.getString("identifier");//get the identifier from config
	s= s.replace(identifier+"1", ChatColor.DARK_BLUE+"&1"+ChatColor.WHITE);
	s= s.replace(identifier+"2", ChatColor.DARK_GREEN+"&2"+ChatColor.WHITE);
	s= s.replace(identifier+"3", ChatColor.DARK_AQUA+"&3"+ChatColor.WHITE);
	s= s.replace(identifier+"4", ChatColor.DARK_RED+"&4"+ChatColor.WHITE);
	s= s.replace(identifier+"5", ChatColor.DARK_PURPLE+"&5"+ChatColor.WHITE);
	s= s.replace(identifier+"6", ChatColor.GOLD+"&6"+ChatColor.WHITE);
	s= s.replace(identifier+"7", ChatColor.GRAY+"&7"+ChatColor.WHITE);
	s= s.replace(identifier+"8", ChatColor.DARK_GRAY+"&8"+ChatColor.WHITE);
	s= s.replace(identifier+"9", ChatColor.BLUE+"&9"+ChatColor.WHITE);
	s= s.replace(identifier+"0", ChatColor.BLACK+"&0"+ChatColor.WHITE);
	
	s= s.replace(identifier+"a", ChatColor.GREEN+"&a"+ChatColor.WHITE);
	s= s.replace(identifier+"b", ChatColor.AQUA+"&b"+ChatColor.WHITE);
	s= s.replace(identifier+"c", ChatColor.RED+"&c"+ChatColor.WHITE);
	s= s.replace(identifier+"d", ChatColor.LIGHT_PURPLE+"&d"+ChatColor.WHITE);
	s= s.replace(identifier+"e", ChatColor.YELLOW+"&e"+ChatColor.WHITE);
	s= s.replace(identifier+"f", ChatColor.WHITE+"&f"+ChatColor.WHITE);
	

	s= s.replace(identifier+"l", ChatColor.BOLD+"&l"+ChatColor.WHITE);
	s= s.replace(identifier+"m", ChatColor.STRIKETHROUGH+"&m"+ChatColor.WHITE);
	s= s.replace(identifier+"n", ChatColor.UNDERLINE+"&n"+ChatColor.WHITE);
	s= s.replace(identifier+"o", ChatColor.ITALIC+"&o"+ChatColor.WHITE);
	s= s.replace(identifier+"r", ChatColor.WHITE+"&r"+ChatColor.WHITE);
	/*ret.add(ChatColor.WHITE+"  &f "+ChatColor.DARK_BLUE+"&1 "+ChatColor.DARK_GREEN+"&2 "+ChatColor.DARK_AQUA+"&3 "
			+ChatColor.DARK_RED+"&4 "+ChatColor.DARK_PURPLE+"&5 "+ChatColor.GOLD+"&6 "+ChatColor.GRAY+"&7 ");
	ret.add(ChatColor.DARK_GRAY+" &8 "+ChatColor.BLUE+"&9 "+ChatColor.YELLOW+"&e "+ChatColor.LIGHT_PURPLE+"&d "
			+ChatColor.RED+"&c "+ChatColor.AQUA+"&b "+ChatColor.GREEN+"&a "+ChatColor.BLACK+"&0* ");
	ret.add(ChatColor.WHITE+"        &l"+ChatColor.BOLD+" BOLD "+ChatColor.WHITE+"&o "+ChatColor.ITALIC+"ITALIC");
	ret.add(ChatColor.WHITE+"   &m "+ChatColor.STRIKETHROUGH+"STRIKE"+ChatColor.WHITE+" &n "+ChatColor.UNDERLINE+"ULINE"+ChatColor.WHITE+" &r");
	ret.add(""+r()+ChatColor.STRIKETHROUGH+"                                                 ");
	ret.add("         "+r()+"C"+r()+"u"+r()+"s"+r()+"t"+r()+"o"+r()+"m"+r()+" "+r()+"C"+r()+"o"+r()+"l"+r()+"o"+r()+"r"+r()+"s");
	int i=1;*/
	
	return s;
}
public static void addColor(String code, String Hex) {
	config.set("ColorCodes."+code, Hex);
	try {
		config.save(Config);
	} catch (IOException e) {
		e.printStackTrace();
	}
	color.addColor(code, Hex);
}
public static boolean isColorCode(String s) {
	if("abcdef1234567890lominkr".contains(s.toLowerCase())) return true;
	return color.isColor(s);
}

}
