package de.blo0dr0gue.messageapi;

import java.util.HashMap;

public class CacheManager {

	private static CacheManager cache;

	public CacheManager() {
		cache = this;
	}

	public static CacheManager getInstance() {
		return cache;
	}

	private HashMap<String, String> messages = new HashMap<>();

	public boolean isCached(String language, String shorthandsymbol) {
		if (messages.containsKey(language+"-"+shorthandsymbol) == true) {
			return true;
		} else
			return false;
	}

	public void setCache(String language, String shorthandsymbol, String message) {
		try {
			messages.put(language+"-"+shorthandsymbol, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCache(String language, String shorthandsymbol) {
		return messages.get(language+"-"+shorthandsymbol);
	}

	public void removeCache(String language, String shorthandsymbol) {
			messages.remove(language+"-"+shorthandsymbol);
	}

	public void updateCache(String language, String shorthandsymbol, String message) {
			removeCache(language, shorthandsymbol);
			setCache(language, shorthandsymbol, message);
	}

}
