package me.tWizT3d_dreaMr.colors.Listeners.Stations;

import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import me.tWizT3d_dreaMr.colors.color;
import me.tWizT3d_dreaMr.colors.main;

public class Signs implements Listener {
@EventHandler
public void onShopCreation(SignChangeEvent e) {
	Bukkit.getServer().getScheduler().runTask(main.plugin, new Runnable() {
        @Override
        public void run() {
        	Sign sign = (Sign) e.getBlock().getState();
        	sign.setLine(0,color.ColorfyString(sign.getLine(0), e.getPlayer(),"sign","&"));
        	sign.setLine(1,color.ColorfyString(sign.getLine(1), e.getPlayer(),"sign","&"));
        	sign.setLine(2,color.ColorfyString(sign.getLine(2), e.getPlayer(),"sign","&"));
        	sign.setLine(3,color.ColorfyString(sign.getLine(3), e.getPlayer(),"sign","&"));

        	sign.update(true);
        }
    }
	);

}
    
}
