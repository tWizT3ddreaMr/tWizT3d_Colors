 package me.tWizT3d_dreaMr.colors;
 
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.EventPriority;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.AsyncPlayerChatEvent;
 
 public class Chat implements Listener
 {
   @EventHandler(priority=EventPriority.LOWEST)
   public void chat(AsyncPlayerChatEvent e) {
	if(e.isCancelled()) return;
		e.setMessage(colorFile.ColorfyChat(e.getMessage(), e.getPlayer()));
	}
 }


