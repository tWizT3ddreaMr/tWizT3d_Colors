package me.tWizT3d_dreaMr.colors;
import org.bukkit.ChatColor;
 import org.bukkit.entity.HumanEntity;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.EventPriority;
 import org.bukkit.event.inventory.InventoryClickEvent;
 import org.bukkit.inventory.AnvilInventory;
 import org.bukkit.inventory.Inventory;
 import org.bukkit.inventory.InventoryView;
 import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
 
 public class AnvilRoname implements org.bukkit.event.Listener
 {
   
   @EventHandler(priority=EventPriority.MONITOR)
   public void onInventoryClick(InventoryClickEvent e) { if (!e.isCancelled()) {
       HumanEntity ent = e.getWhoClicked();
       if ((ent instanceof Player)&&(((Player)ent).hasPermission("Colorme.h.Anvil")||((Player)ent).hasPermission("Colorme.H"))) {
         Inventory inv = e.getInventory();
         if ((inv instanceof AnvilInventory)) {
           InventoryView view = e.getView();
           int rawSlot = e.getRawSlot(); if (rawSlot == view.convertSlot(rawSlot))
           {
             if (rawSlot == 2)
             {
 				
 
 
               ItemStack item = inv.getItem(2);
               if ((item != null) && item.hasItemMeta() &&item.getItemMeta().hasDisplayName())
                  {
	
						ItemMeta im=item.getItemMeta();
	
							im.setDisplayName((checker((Player)e.getWhoClicked(), view.getItem(2).getItemMeta().getDisplayName())));
							item.setItemMeta(im);
							
               }
             }
           }
         }
       }
     }
   }

private String checker(Player p, String itemName) {
	itemName=colorFile.ColorfyAnvil(itemName,p);
	itemName=ChatColor.translateAlternateColorCodes('&', itemName);
	
	return itemName;
}
}
   
 