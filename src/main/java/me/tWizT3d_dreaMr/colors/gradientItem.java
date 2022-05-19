package me.tWizT3d_dreaMr.colors;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class gradientItem {
	
	public static void comgra(Player p,String args[]) {
	ItemStack item=p.getInventory().getItemInMainHand();
	if(item==null||item.getType()==Material.AIR) {
		p.sendMessage(ChatColor.RED+"Get an item first dummy");
		return;
	}
	if(!(item.hasItemMeta()&&item.getItemMeta().hasLore())) {
		p.sendMessage(ChatColor.RED+"has no lore my dude");
		return;
	}
	if(args.length<4) {
		p.sendMessage(ChatColor.RED+"Args error length");
		return;
	}
	Integer loc1=0;
	Integer loc2=0;
	ArrayList<String> hexes=new ArrayList<String>();
	for(int i=0;i<args.length;i++) {
		if(i<2) {
			
			if(i==0)loc1=Integer.parseInt(args[i].replaceAll("[^0-9]", ""))-1;
			if(i==1)loc2=Integer.parseInt(args[i].replaceAll("[^0-9]", ""))-1;
		}else {
			if(!ishex(args[i])) {
				p.sendMessage(ChatColor.RED+"Args error arg "+i);
				return;
			}
			else {
				hexes.add(args[i]);
			}
		}
	}
	Integer loch=Math.max(loc1, loc2);
	Integer locl=Math.min(loc1, loc2);
	if(item.getItemMeta().getLore().size()<(loch+1)) {
		p.sendMessage(ChatColor.RED+"Lore not long enough");
		return;
	}
	int dif=loch-locl+2;
	int garsize=dif/(hexes.size()-1);
	ArrayList<String> grabass=new ArrayList<String>();
	for(int n=0;n<(hexes.size()-1);n++) {
		grabass.addAll(GraMe(hexes.get(n),hexes.get(n+1),garsize));
	}
	List<String> lore=item.getItemMeta().getLore();

	for(String hx:grabass) {
		lore.set(locl,ChatColor.of("#"+hx)+ChatColor.stripColor(lore.get(locl)));
		locl++;
	}
	ItemMeta im =item.getItemMeta();
	im.setLore(lore);
	item.setItemMeta(im);
	p.getInventory().setItemInMainHand(item);
	p.updateInventory();
	p.sendMessage(ChatColor.GREEN+"Your lore has been updated.");
	}
	
	
	public static ArrayList<String> GraMe(String h2,String h1,int garsize){
	ArrayList<String> graout=new ArrayList<String>();

	h1=h1.replace("#", "");
	h2=h2.replace("#","");
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
		if(hg.length()==1)
			hg="0"+hg;
		if(hb.length()==1)
			hb="0"+hb;
		
		String hex=hr+hg+hb;
		graout.add(hex);
	}
	
	return graout;
	}
	public static ArrayList<Integer> numes(Integer a, Integer b, int gs){
		ArrayList<Integer> out=new ArrayList<Integer>();
		int dif=a-b;
		if(dif==0) {
			for(int i=0;i<(gs-1);i++) {
				out.add(a);
			}
		}
		else {
			int incr=Math.floorDiv(dif, gs-2)+1;
			if((dif/gs-2)!=0)
			for(int i=0;i<(gs-2);i++) {
				out.add(b+(incr*i));
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
