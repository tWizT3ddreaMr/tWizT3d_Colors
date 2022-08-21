 package me.tWizT3d_dreaMr.colors.Listeners;
 
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.EventPriority;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerChatPreviewEvent;

import me.clip.placeholderapi.PlaceholderAPI;
import me.tWizT3d_dreaMr.colors.color;
 
 @SuppressWarnings("deprecation")
public class Chat implements Listener
 {
	   @EventHandler(ignoreCancelled=true, priority=EventPriority.LOWEST)
	   public void chatPreview( AsyncPlayerChatPreviewEvent e) {
		    if(color.isGrad(PlaceholderAPI.setPlaceholders(e.getPlayer(), "%vault_suffix%"))&&!e.getMessage().startsWith("#")&&!e.getMessage().startsWith("!")) {
		    	e.setMessage(color.replaceAllGrad(e.getMessage()));
		    	e.setMessage(PlaceholderAPI.setPlaceholders(e.getPlayer(), "%vault_suffix%").replace("!", "&")+e.getMessage());
		    }
			e.setMessage(color.ColorfyString(e.getMessage(), e.getPlayer(), "chat", "&"));
		}
	   @EventHandler(ignoreCancelled=true, priority=EventPriority.LOWEST)
	   public void chat(AsyncPlayerChatEvent e) {
		    //if(color.isGrad(PlaceholderAPI.setPlaceholders(e.getPlayer(), "%vault_suffix%"))&&!e.getMessage().startsWith("#")&&!e.getMessage().startsWith("!")) {
		    //	e.setMessage(color.replaceAllGrad(e.getMessage()));
		    // 	e.setMessage(PlaceholderAPI.setPlaceholders(e.getPlayer(), "%vault_suffix%").replace("!", "&")+e.getMessage());
		    //}
			e.setMessage(color.ColorfyString(e.getMessage(), e.getPlayer(), "chat", "&"));
		}
 }


