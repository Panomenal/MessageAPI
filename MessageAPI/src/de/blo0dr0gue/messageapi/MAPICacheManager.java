package de.blo0dr0gue.messageapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.entity.Player;

public class MAPICacheManager {

	private static MAPICacheManager cache;
	private HashMap<String, String> messages = new HashMap<>();
	private HashMap<Player, String> players = new HashMap<>();

	public MAPICacheManager() {
		cache = this;
	}

	public static MAPICacheManager getInstance() {
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

	public String getCache(String shorthandsymbolandlanguage) {
		return messages.get(shorthandsymbolandlanguage);
	}

	public void removeCache(String language, String shorthandsymbol) {
		messages.remove(language + "-" + shorthandsymbol);
	}

	public void updateCache(String language, String shorthandsymbol, String message) {
		removeCache(language, shorthandsymbol);
		setCache(language, shorthandsymbol, message);
	}
	
	public void updateCacheAll() {
		List<String> l = new ArrayList<String>(messages.keySet());
		if (l.size() > 0) {
			for (int i = 0; i < l.size(); i++) {
				String check = l.get(i);
				String[] parts = check.split("-");
				String language = parts[0];
				String shorthandsymbol = parts[1];
				String messageDB = GPanomenalMain.getInstance().mysql_z.selectMessage(language, shorthandsymbol);
				if (getCache(language, shorthandsymbol).equals(messageDB)) {
				} else {
					if (isCached(language, shorthandsymbol) == true) {
						updateCache(language, shorthandsymbol, messageDB);
					}
				}
			}
		}
		
		
		List<Player> lp = new ArrayList<Player>(players.keySet());
		if(lp.size()>0) {
			for (int i = 0; i < lp.size(); i++) {
				Player check = lp.get(i);
				String languageDB = GPanomenalMain.getInstance().mysql_z.selectLanguage(check);
				if (getCache(check).equals(languageDB)) {
				} else {
					if (isCached(check) == true) {
						updateCache(check, languageDB);
					}
				}
			}
		}
		
	}

	public void startCheckerMessage(Integer min) {
		TimerTask meinTimerTask = new TimerTask() {
			public void run() {

				List<String> l = new ArrayList<String>(messages.keySet());
				if (l.size() > 0) {
					for (int i = 0; i < l.size(); i++) {
						String check = l.get(i);
						String[] parts = check.split("-");
						String language = parts[0];
						String shorthandsymbol = parts[1];
						String messageDB = GPanomenalMain.getInstance().mysql_z.selectMessage(language, shorthandsymbol);
						if (getCache(language, shorthandsymbol).equals(messageDB)) {
						} else {
							if (isCached(language, shorthandsymbol) == true) {
								updateCache(language, shorthandsymbol, messageDB);
							}
						}
					}
				}
			}
		};
		long delay = 1000 * 60 * min;
		Timer timer = new Timer();
		timer.schedule(meinTimerTask, 0, delay);
	}

	public void startCheckerPlayer(Integer min) {
		TimerTask playerTimerTask = new TimerTask() {
			public void run() {

				List<Player> l = new ArrayList<Player>(players.keySet());
				if(l.size()>0) {
					for (int i = 0; i < l.size(); i++) {
						Player check = l.get(i);
						String languageDB = GPanomenalMain.getInstance().mysql_z.selectLanguage(check);
						if (getCache(check).equals(languageDB)) {
						} else {
							if (isCached(check) == true) {
								updateCache(check, languageDB);
							}
						}
					}
				}
			}
		};
		long delay = 1000 * 60 * min;
		Timer playerTimer = new Timer();
		playerTimer.schedule(playerTimerTask, 0, delay);
	}

}
