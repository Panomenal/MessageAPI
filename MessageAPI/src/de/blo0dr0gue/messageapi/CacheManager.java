package de.blo0dr0gue.messageapi;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.entity.Player;

public class CacheManager {

	private static CacheManager cache;
	private HashMap<String, String> messages = new HashMap<>();
	private String[] shorthandsymbol = new String[Integer.MAX_VALUE];
	private HashMap<Player, String> players = new HashMap<>();
	private String[] playerName = new String[Integer.MAX_VALUE];

	public CacheManager() {
		cache = this;
	}

	public static CacheManager getInstance() {
		return cache;
	}

	// -------------------------Player Teil-------------------------\\

	public boolean isCached(Player p) {
		if (players.containsKey(p) == true) {
			return true;
		} else
			return false;
	}

	public void setCache(Player p, String language) {
		try {
			players.put(p, language);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCache(Player p) {
		return players.get(p);
	}

	public void removeCache(Player p) {
		players.remove(p);
	}

	public void updateCache(Player p, String language) {
		removeCache(p);
		setCache(p, language);
	}

	// -------------------------Message Teil-------------------------\\

	public boolean isCached(String language, String shorthandsymbol) {
		if (messages.containsKey(language + "-" + shorthandsymbol) == true) {
			return true;
		} else
			return false;
	}

	public void setCache(String language, String shorthandsymbol, String message) {
		try {
			messages.put(language + "-" + shorthandsymbol, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCache(String language, String shorthandsymbol) {
		return messages.get(language + "-" + shorthandsymbol);
	}

	public void removeCache(String language, String shorthandsymbol) {
		messages.remove(language + "-" + shorthandsymbol);
	}

	public void updateCache(String language, String shorthandsymbol, String message) {
		removeCache(language, shorthandsymbol);
		setCache(language, shorthandsymbol, message);
	}

	public void startChecker() {
		TimerTask meinTimerTask = new TimerTask() {
			public void run() {
				
				for(int i=0; i<messages.size();i++) {
					
				}
				
			}
		};
		long delay = 1000 * 60 * 5; // 5 Minuten
		Timer timer = new Timer();
		timer.schedule(meinTimerTask, 0, delay);
	}

}
