package de.blo0dr0gue.messageapi;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageAPI {

	private GPanomenalMain main;
	private MAPICacheManager cm;

	public static boolean cache;

	public MessageAPI(boolean pCache) {
		main = GPanomenalMain.getInstance();
		cache = pCache;
		cm = MAPICacheManager.getInstance();
	}
	
	/**
	 * Get the Language of an Player
	 * @param Player p
	 * @return String language
	 */
	public String getLanguage(Player p) {
		String back = null;
		if(cache == true) {
			if(cm.isCached(p)==true){
				back = cm.getCache(p);
			}else {
				back = main.mysql_z.selectLanguage(p);
				cm.setCache(p, back);
			}
		}else {
			back = main.mysql_z.selectLanguage(p);
		}
		return back;
	}
	
	/**
	 * Set the Language of an Player
	 * @param Player p
	 * @param String language
	 */
	public void setLanguage(Player p, String language) {
		main.mysql_z.setLanguage(p, language);
	}
	
	/**
	 * Force an update of the Cached items | The Cached get updated all 5min manually
	 * Only if Cache is enabled
	 */
	public void forceUpdateCache() {
		try {
			if(cache==true) {
				cm.updateCacheAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		String language = getLanguage(p);

		if (cache == true) {
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
	 * @param String... replace
	 * @return String message
	 */
	public String msg(Player p, String shorthandsymbol, String... replace) {
		int count = 1;
		String message = null;
		String language = getLanguage(p);

		if (cache == true) {
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
