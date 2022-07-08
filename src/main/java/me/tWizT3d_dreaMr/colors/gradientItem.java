package me.tWizT3d_dreaMr.colors;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class gradientItem {
	public static void gothrough(String[] args, Player p) {
		ItemStack item=p.getInventory().getItemInMainHand();
		if(!item.hasItemMeta()) {
			p.sendMessage(ChatColor.RED+"Your item doesnt have lore.");
			return;
			}
		ItemMeta im=item.getItemMeta();
		if(!im.hasLore()) {
			p.sendMessage(ChatColor.RED+"Your item doesnt have lore.");
			return;
			}
		//TODO replace with actual lore
		List<String> lorlis=im.getLore();
		
		String[] lore = lorlis.toArray(new String[lorlis.size()]);
		lorlis.toArray(lore);
		
		//
		ArrayList<String> hexes=new ArrayList<String>();
		if(args.length==4) {
			hexes.add(args[0]);
			hexes.add(args[1]);
			for(String h:hexes) {
				if(!ishex(h)) {
					p.sendMessage(ChatColor.RED+"h is not a hex");
				}
			}
			Integer a=Integer.parseInt(args[2]);
			Integer b=Integer.parseInt(args[3]);
			if(a==null||b==null) {
				p.sendMessage(ChatColor.RED+"Number for start or end is null");
				return;
			}
			if(lorlis.size()>a||lorlis.size()>b)
			{
				p.sendMessage(ChatColor.RED+"Lore not long enough.");
				return;
			}
			lore= comgra2(hexes,a,b,lore);
		}
		else if(args.length==5) {
			hexes.add(args[0]);
			hexes.add(args[1]);
			hexes.add(args[2]);
			for(String h:hexes) {
				if(!ishex(h)) {
					p.sendMessage(ChatColor.RED+"h is not a hex");
				}
			}
			Integer a=Integer.parseInt(args[3]);
			Integer b=Integer.parseInt(args[4]);
			if(a==null||b==null) {
				p.sendMessage(ChatColor.RED+"Number for start or end is null");
				return;
			}
			if(lorlis.size()>a||lorlis.size()>b)
			{
				p.sendMessage(ChatColor.RED+"Lore not long enough.");
				return;
			}
			lore= comgra3(hexes,a,b,lore);
		}
		if(lore==null) {
			p.sendMessage(ChatColor.GREEN+"Something went wrong! return is null");
			return;
		}
		List<String> endLore= new ArrayList<String>();
		for(String l: lore) {
			endLore.add(l);
		}
		im.setLore(endLore);
		item.setItemMeta(im);
		p.sendMessage(ChatColor.GREEN+"Your lore has been updated.");
	}
	public static String gradString(String[] strings,String st) {
		
		String ep="";
		if(st.contains("&")) {
			ep=st.substring(st.indexOf('&'));
			st=st.substring(0, st.indexOf('&'));
		}
		
		char[] lc=st.toCharArray();
		String[] ls=new String[lc.length];

		int i=0;
		for(char s:lc) {
			ls[i]=""+s;
			i++;
		}
		String[] end=comgra(strings, 1, ls.length, ls);
		String fin="";
		for(String s:end)
			fin=fin+s;
		st=fin+ep;
		
		return st;
	}

	public static String[] comgra(String[] strings, int start, int end, String[] lore) {
		Integer loch=Math.max(start, end);
		Integer locl=Math.min(start, end);
		int dif=loch-locl;
		int garsize=dif;
		
		ArrayList<String> grabass=new ArrayList<String>();
			ArrayList<String> temp;
			temp=GraMe(strings[0],strings[1],garsize);
			
			if(temp == null) {
				Bukkit.getLogger().log(Level.WARNING, "H1 or H2 null");//in lang
				return null;
			}
			grabass.addAll(temp);

		for(String hx:grabass) {
			if(hx.length()!=6) {
				Bukkit.getLogger().log(Level.WARNING, "hex "+hx+" malformed");
				Bukkit.getLogger().log(Level.WARNING, ""+locl);
				locl++;
				continue;
			}
			lore[locl-1]=ChatColor.of("#"+hx)+lore[locl-1];
			locl++;
		}
		return lore;
	}	

	public static String[] comgra2(ArrayList<String> hexes, int start, int end, String[] lore) {
		Integer loch=Math.max(start, end);
		Integer locl=Math.min(start, end);
		int dif=loch-locl;
		int garsize=dif;
		
		ArrayList<String> grabass=new ArrayList<String>();
			ArrayList<String> temp;
			temp=GraMe(hexes.get(0),hexes.get(1),garsize);
			
			if(temp == null) {
				Bukkit.getLogger().log(Level.WARNING, "H1 or H2 null");//in lang
				return null;
			}
			grabass.addAll(temp);
		

		for(String hx:grabass) {

			lore[locl-1]=""+hx+ChatColor.stripColor(lore[locl-1]);
			locl++;
		}
		return (String[]) lore;
	}	
	public static String[] comgra3(ArrayList<String> hexes, int start, int end, String[] lore) {


		Integer loch=Math.max(start, end)-1;
		Integer locl=Math.min(start, end);
		int dif=loch-locl;
		int garsize=dif/2;
		int gardif=dif%2;
		
		ArrayList<String> grabass=new ArrayList<String>();
		for(int n=0;n<2;n++) {
			ArrayList<String> temp;
			if(gardif>0) {
				temp=GraMe(hexes.get(n),hexes.get(n+1),garsize+1);
				gardif--;
				}
			else {
				temp=GraMe(hexes.get(n),hexes.get(n+1),garsize);
				
				}
			//if(if gardif not=0 set middle ones or last longer)
			if(temp == null) {
				Bukkit.getLogger().log(Level.WARNING, "H1 or H2 null");//in lang
				return null;
			}
			grabass.addAll(temp);
		}

		for(String hx:grabass) {
			lore[locl-1]=""+hx+ChatColor.stripColor(lore[locl-1]);
			locl++;
		}
		return (String[]) lore;
	}	

	public static ArrayList<String> GraMe(String h2,String h1,int garsize){
		ArrayList<String> graout=new ArrayList<String>();
		
		h1=h1.replace("#", "");
		h1=h1.replace("&", "");
		h2=h2.replace("#","");
		h2=h2.replace("&","");
		if(h1.length()!=6) {
			Bukkit.getLogger().log(Level.WARNING, "h1 not right length: "+h1);
			return null;
		}
		if(h2.length()!=6) {
			Bukkit.getLogger().log(Level.WARNING, "h2 not right length: "+h2);
			return null;
		}
		int h1r=Integer.parseInt(h1.substring(0, 2),16);
		int h1g=Integer.parseInt(h1.substring(2, 4),16);
		int h1b=Integer.parseInt(h1.substring(4),16);
		
		int h2r=Integer.parseInt(h2.substring(0, 2),16);
		int h2g=Integer.parseInt(h2.substring(2, 4),16);
		int h2b=Integer.parseInt(h2.substring(4),16);

		ArrayList<Integer> r=numes(h1r,h2r,garsize);
		ArrayList<Integer> g=numes(h1g,h2g,garsize);
		ArrayList<Integer> b=numes(h1b,h2b,garsize);
		for(int i=0;i<r.size();i++) {
			String hr=Integer.toHexString(r.get(i));
			String hg=Integer.toHexString(g.get(i));
			String hb=Integer.toHexString(b.get(i));
			
			if(hr.length()==1)
				hr="0"+hr;
			else if(hr.length()==3)
				hr="ff";
			if(hg.length()==1)
				hg="0"+hg;
			else if(hg.length()==3)
				hg="ff";
			if(hb.length()==1)
				hb="0"+hb;
			else if(hb.length()==3)
				hb="ff";
			
			String hex=ChatColor.of("#"+hr+hg+hb)+"";
			
			graout.add(hex);
		}
		
		return graout;
		}
	public static ArrayList<Integer> numes(Integer a, Integer b, int gs){
		ArrayList<Integer> out=new ArrayList<Integer>();
		int dif=a-b;
		if(dif==0) {
			for(int i=0;i<(gs+1);i++) {
				out.add(a);
			}
		}
		else {
			double incr=1.0*dif/gs;
			if((dif/gs)!=0)
			for(int i=0;i<(gs);i++) {
				out.add((int) Math.floor(b+(incr*i)));
			}
			out.add(a);
		}
		return out;
	}
	private static final Pattern pattern = Pattern.compile("(?<!\\\\)(#[a-fA-F0-9]{6})");

		  
	public static boolean ishex(String message) {
		Matcher matcher = pattern.matcher(message);
		if(matcher.find()) {
			return true; 
		}
		return false;
	}
}
