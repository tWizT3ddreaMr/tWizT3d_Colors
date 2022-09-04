 package me.tWizT3d_dreaMr.colors.Listeners;
 
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.EventPriority;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.clip.placeholderapi.PlaceholderAPI;
import me.tWizT3d_dreaMr.colors.color;
import mineverse.Aust1n46.chat.api.MineverseChatAPI;
import mineverse.Aust1n46.chat.api.MineverseChatPlayer;
import mineverse.Aust1n46.chat.channel.ChatChannel;

public class Chat2 implements Listener
 {
	   @EventHandler(ignoreCancelled=true, priority=EventPriority.LOWEST)
	   public void chat(AsyncPlayerChatEvent e) {
			/*
		   MineverseChatPlayer mcp = MineverseChatAPI.getOnlineMineverseChatPlayer(e.getPlayer());
		   ChatChannel eventChannel = mcp.getCurrentChannel();
		    if(eventChannel.getName().equalsIgnoreCase("global") &&  color.isGrad(PlaceholderAPI.setPlaceholders(e.getPlayer(), "%vault_suffix%"))&&!e.getMessage().startsWith("#")&&!e.getMessage().startsWith("!")) {
		    	e.setMessage(color.replaceAllGrad(e.getMessage()));
		     	e.setMessage(PlaceholderAPI.setPlaceholders(e.getPlayer(), "%vault_suffix%").replace("!", "&")+e.getMessage());
		    }
			 */
			e.setMessage(color.ColorfyString(e.getMessage(), e.getPlayer(), "chat", "&"));
		}
 }


