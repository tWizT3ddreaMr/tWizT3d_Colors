package me.tWizT3d_dreaMr.colors.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.tWizT3d_dreaMr.colors.color;

public class Commands implements org.bukkit.event.Listener
{
   
   @EventHandler
   public void Pcommand(PlayerCommandPreprocessEvent e)
   {
	   if(!(e.getMessage().toLowerCase().startsWith("setcolor")||e.getMessage().toLowerCase().startsWith("/setcolor")||e.getMessage().toLowerCase().startsWith("pex")||e.getMessage().toLowerCase().startsWith("/pex")))
			e.setMessage(color.ColorfyString(e.getMessage(), e.getPlayer(), "command", "&"));	
   }
   
}
