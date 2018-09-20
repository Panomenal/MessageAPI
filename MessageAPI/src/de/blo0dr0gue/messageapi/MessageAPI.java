package de.blo0dr0gue.messageapi;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageAPI {

	private MessageMain main;
	private CacheManager cm;

	private boolean cache;

	public MessageAPI(boolean cache) {
		main = MessageMain.getInstance();
		this.cache = cache;
		cm = CacheManager.getInstance();
	}

	/**
	 * Returns the Message from the DB for dif. Langauges
	 * 
	 * @param p
	 * @param shorthandsymbol
	 * @return String message
	 */
	public String msg(Player p, String shorthandsymbol) {
		String message = null;
		String language = main.mysql_z.selectLanguage(p);

		if (this.cache == true) {
			if (cm.isCached(language, shorthandsymbol) == true) {
				message = cm.getCache(language, shorthandsymbol);
			} else {
				message = main.mysql_z.selectMessage(language, shorthandsymbol);
				message = ChatColor.translateAlternateColorCodes('&', message);
				cm.setCache(language, shorthandsymbol, message);
			}
		} else {
			message = main.mysql_z.selectMessage(language, shorthandsymbol);
			message = ChatColor.translateAlternateColorCodes('&', message);
		}

		return message;
	}

	/**
	 * Returns the Message from the DB for dif. Langauges and replace content
	 * 
	 * @param Player p
	 * @param String shorthandsymbol
	 * @param        String... replace
	 * @return String message
	 */
	public String msg(Player p, String shorthandsymbol, String... replace) {
		int count = 1;
		String message = null;
		String language = main.mysql_z.selectLanguage(p);

		if (this.cache == true) {
			if (cm.isCached(language, shorthandsymbol) == true) {
				message = cm.getCache(language, shorthandsymbol);
			} else {
				message = main.mysql_z.selectMessage(language, shorthandsymbol);
				message = ChatColor.translateAlternateColorCodes('&', message);
				cm.setCache(language, shorthandsymbol, message);
			}
		} else {
			message = main.mysql_z.selectMessage(language, shorthandsymbol);
			message = ChatColor.translateAlternateColorCodes('&', message);
		}

		for (String value : replace) {
			message = message.replace("%replace" + count + "%", value);
			count++;
		}

		return message;
	}
}
