package de.blo0dr0gue.messageapi;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageAPI {

	private Main main = new Main();

	/**
	 * Returns the Message in the DB for dif. Langauges
	 * @param p
	 * @param shorthandsymbol
	 * @return String message
	 */
	public String msg(Player p, String shorthandsymbol) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		return message;
	}
	
	public String msg(Player p, String shorthandsymbol, String replace) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replace("%replace%", replace + "");
		return message;
	}
	
	public String msg(Player p, String shorthandsymbol, String replace, String replace2) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replace("%replace%", replace + "");
		message = message.replace("%replace2%", replace2 + "");
		return message;
	}
	
	public String msg(Player p, String shorthandsymbol, String replace, String replace2, String replace3) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replace("%replace%", replace + "");
		message = message.replace("%replace2%", replace2 + "");
		message = message.replace("%replace3%", replace3 + "");
		return message;
	}
	
	public String msg(Player p, String shorthandsymbol, String replace, String replace2, String replace3, String replace4) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replace("%replace%", replace + "");
		message = message.replace("%replace2%", replace2 + "");
		message = message.replace("%replace3%", replace3 + "");
		message = message.replace("%replace4%", replace4 + "");
		return message;
	}
	
	public String msg(Player p, String shorthandsymbol, String replace, String replace2, String replace3,
			String replace4 , String replace5) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replace("%replace%", replace + "");
		message = message.replace("%replace2%", replace2 + "");
		message = message.replace("%replace3%", replace3 + "");
		message = message.replace("%replace4%", replace4 + "");
		message = message.replace("%replace5%", replace5 + "");
		return message;
	}
	
	public String msg(Player p, String shorthandsymbol, String replace, String replace2, String replace3,
			String replace4 , String replace5, String replace6) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replace("%replace%", replace + "");
		message = message.replace("%replace2%", replace2 + "");
		message = message.replace("%replace3%", replace3 + "");
		message = message.replace("%replace4%", replace4 + "");
		message = message.replace("%replace5%", replace5 + "");
		message = message.replace("%replace6%", replace6 + "");
		return message;
	}
	
	public String msg(Player p, String shorthandsymbol, String replace, String replace2, String replace3,
			String replace4 , String replace5, String replace6, String replace7) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replace("%replace%", replace + "");
		message = message.replace("%replace2%", replace2 + "");
		message = message.replace("%replace3%", replace3 + "");
		message = message.replace("%replace4%", replace4 + "");
		message = message.replace("%replace5%", replace5 + "");
		message = message.replace("%replace6%", replace6 + "");
		message = message.replace("%replace7%", replace7 + "");
		return message;
	}
	
	public String msg(Player p, String shorthandsymbol, String replace, String replace2, String replace3,
			String replace4 , String replace5, String replace6, String replace7, String replace8) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replace("%replace%", replace + "");
		message = message.replace("%replace2%", replace2 + "");
		message = message.replace("%replace3%", replace3 + "");
		message = message.replace("%replace4%", replace4 + "");
		message = message.replace("%replace5%", replace5 + "");
		message = message.replace("%replace6%", replace6 + "");
		message = message.replace("%replace7%", replace7 + "");
		message = message.replace("%replace8%", replace8 + "");
		return message;
	}
	
	public String msg(Player p, String shorthandsymbol, String replace, String replace2, String replace3,
			String replace4 , String replace5, String replace6, String replace7, String replace8, String replace9) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replace("%replace%", replace + "");
		message = message.replace("%replace2%", replace2 + "");
		message = message.replace("%replace3%", replace3 + "");
		message = message.replace("%replace4%", replace4 + "");
		message = message.replace("%replace5%", replace5 + "");
		message = message.replace("%replace6%", replace6 + "");
		message = message.replace("%replace7%", replace7 + "");
		message = message.replace("%replace8%", replace8 + "");
		message = message.replace("%replace9%", replace9 + "");
		return message;
	}
	
	public String msg(Player p, String shorthandsymbol, String replace, String replace2, String replace3,
			String replace4 , String replace5, String replace6, String replace7, String replace8, String replace9 , String replace10) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);
		message = main.mysql_z.selectMessage(language, shorthandsymbol);
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replace("%replace%", replace + "");
		message = message.replace("%replace2%", replace2 + "");
		message = message.replace("%replace3%", replace3 + "");
		message = message.replace("%replace4%", replace4 + "");
		message = message.replace("%replace5%", replace5 + "");
		message = message.replace("%replace6%", replace6 + "");
		message = message.replace("%replace7%", replace7 + "");
		message = message.replace("%replace8%", replace8 + "");
		message = message.replace("%replace9%", replace9 + "");
		message = message.replace("%replace10%", replace10 + "");
		return message;
	}


}
