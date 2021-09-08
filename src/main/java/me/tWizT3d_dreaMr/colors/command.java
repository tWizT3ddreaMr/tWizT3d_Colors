package me.tWizT3d_dreaMr.colors;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class command implements org.bukkit.event.Listener
{
   public static FileConfiguration conf;
   
   @EventHandler
   public void Pcommand(PlayerCommandPreprocessEvent e)
   {
	e.setMessage(colorFile.ColorfyCommandP(e.getMessage(), e.getPlayer(), e.getMessage()));	
   }
   
}
