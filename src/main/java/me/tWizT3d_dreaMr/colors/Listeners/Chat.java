 package me.tWizT3d_dreaMr.colors.Listeners;
 
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.EventPriority;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.tWizT3d_dreaMr.colors.color;
 
 public class Chat implements Listener
 {
   @EventHandler(ignoreCancelled=true, priority=EventPriority.LOWEST)
   public void chat(AsyncPlayerChatEvent e) {
		e.setMessage(color.ColorfyString(e.getMessage(), e.getPlayer(), "chat", "&"));
	}
 }


