package me.tWizT3d_dreaMr.colors.Listeners.Stations;

import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import me.tWizT3d_dreaMr.colors.colorFile;
import me.tWizT3d_dreaMr.colors.main;

public class Signs implements Listener {
@EventHandler
public void onShopCreation(SignChangeEvent e) {
	Bukkit.getServer().getScheduler().runTask(main.plugin, new Runnable() {
        @Override
        public void run() {
        	Sign sign = (Sign) e.getBlock().getState();
        	sign.setLine(0,colorFile.ColorfySign(sign.getLine(0), e.getPlayer()));
        	sign.setLine(1,colorFile.ColorfySign(sign.getLine(1), e.getPlayer()));
        	sign.setLine(2,colorFile.ColorfySign(sign.getLine(2), e.getPlayer()));
        	sign.setLine(3,colorFile.ColorfySign(sign.getLine(3), e.getPlayer()));

        	sign.update(true);
        }
    }
	);

}
    
}
