package me.tWizT3d_dreaMr.colors;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;

public class ChatGui {
public static void Command(Player p) {
	if(p.hasPermission("tc2.can")) {p.spigot().sendMessage(fin());}
	p.sendMessage(ChatColor.DARK_AQUA+"Click on a color below to set your chat color.");
	p.sendMessage(ChatColor.DARK_GRAY+"--------------------------------");

	if(!p.hasPermission("tc2.can")) {
		p.spigot().sendMessage(fin());
		p.sendMessage(ChatColor.DARK_GRAY+"--------------------------------");
		return;
		}
		TextComponent Builder=new TextComponent("");
		int i=0;
		List<String> color=new ArrayList<String>();
		color.add("a");color.add("b");color.add("c");
		color.add("d");color.add("e");color.add("f");
		color.add("1");color.add("2");color.add("3");
		color.add("4");color.add("5");color.add("6");
		color.add("7");color.add("8");color.add("9");color.add("0");
		for(String col:color) {
			if(i>=7) {
				p.spigot().sendMessage(Builder);
				Builder=new TextComponent("");
				i=0;
			}
			if(p.hasPermission("tc2.chat."+col)) {
				if(i!=0) {
					Builder.addExtra(new TextComponent(ChatColor.GRAY+", "));
				}
				Builder.addExtra(MessageBuilder2(ChatColor.translateAlternateColorCodes('&', "&"+col)+col,col));
				i++;
			}
		}
		if(i!=0) {
			p.spigot().sendMessage(Builder);
		}
		Builder=new TextComponent("");
		i=0;
		p.sendMessage(ChatColor.DARK_GRAY+"--------------------------------");
		ArrayList<String[]> colol=colorFile.getColorList();
		for(String col[]:colol) {
			if(i>=7) {
				p.spigot().sendMessage(Builder);
				Builder=new TextComponent("");
				i=0;
			}
			if(p.hasPermission("tc2.chat."+col[0])) {
				if(i!=0)
				Builder.addExtra(new TextComponent(ChatColor.GRAY+", "));
				if(col[1].equalsIgnoreCase("random")) {
					Builder.addExtra(MessageBuilder("random",colorFile.rh(),col[0]));
				}
				else Builder.addExtra(MessageBuilder("&"+col[0],col[1],col[0]));
				i++;
			}
		}
		if(i!=0) {
			p.spigot().sendMessage(Builder);
		}
		p.sendMessage(ChatColor.DARK_GRAY+"--------------------------------");	
		p.spigot().sendMessage(fin());
		p.sendMessage(ChatColor.DARK_GRAY+"--------------------------------");
}
public static TextComponent MessageBuilder(String Message,String hex,String color) {
	TextComponent message = new TextComponent(Message);
	if(!hex.isEmpty())
		message.setColor(ChatColor.of("#"+hex));
	message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/setcolor set "+color ) );
	message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new Text( colorFile.Colorfyexclamation("!b")+"Set your chat to this color" ) ) );
	return message;
	}
public static TextComponent MessageBuilder2(String Message,String color) {
	TextComponent message = new TextComponent(Message);
	message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/setcolor set "+color ) );
	message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new Text( colorFile.Colorfyexclamation("!"+color)+"Set your chat to this color" ) ) );
	return message;
}public static TextComponent fin() {
	TextComponent message = new TextComponent(ChatColor.RED+"Remove");
	message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/setcolor remove") );
	message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new Text( "Remove your chat color" ) ) );
	return message;
}
}
