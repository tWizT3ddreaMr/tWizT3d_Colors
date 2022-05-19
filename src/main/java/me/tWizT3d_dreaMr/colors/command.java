package me.tWizT3d_dreaMr.colors;

import java.util.Scanner;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class command implements org.bukkit.event.Listener
{
   public static FileConfiguration conf;
   
   @EventHandler
   public void Pcommand(PlayerCommandPreprocessEvent e)
   {
	
	  if(e.isCancelled()) return;
		if(e.getMessage().toLowerCase().contains("&h"))  {
			Scanner temp =new Scanner(e.getMessage()); String per="nop";if(temp.hasNext())per=temp.next(); temp.close(); per=per.replaceAll("/", "");
			if(e.getPlayer().hasPermission("Colorme.h.command."+per)||e.getPlayer().hasPermission("Colorme.h.command.all")) {
			if(!me.tWizT3d_dreaMr.colors.colorConfig.has(e.getPlayer())){me.tWizT3d_dreaMr.colors.colorConfig.setServer(e.getPlayer());}
			Scanner scan=new Scanner(e.getMessage());
			String s="";
			while(scan.hasNext()) {
				s=s+scan.next()+" ";
			}scan.close();
			String end = color.addc(s, colorConfig.playerColors(e.getPlayer()),e.getPlayer());
			e.setMessage(end);
		} }
		  if(!(e.getMessage().toLowerCase().startsWith("setcolor")||e.getMessage().toLowerCase().startsWith("/setcolor")))
			  e.setMessage(colorFile.ColorfyCommandP(e.getMessage(), e.getPlayer(), e.getMessage()));	
   }
   
}
