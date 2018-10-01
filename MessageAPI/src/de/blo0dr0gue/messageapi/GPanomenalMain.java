package de.blo0dr0gue.messageapi;

import org.bukkit.plugin.java.JavaPlugin;

import de.blo0dr0gue.mysqlapi.MySQLAPI;

public class GPanomenalMain extends JavaPlugin{
		
	private MySQLAPI mysql;
	public MySQL_zusatz mysql_z;
	private MAPICacheManager cache;
	public static GPanomenalMain instance;
	
	@Override
	public void onEnable() {
		instance=this;
		mysql = new MySQLAPI();
		mysql_z = new MySQL_zusatz();
		mysql_z.con = mysql.connect("minecraft_server");
		cache = new MAPICacheManager();
		cache.startCheckerMessage(5);
		cache.startCheckerPlayer(5);
	}
	
	@Override
	public void onDisable() {
		mysql.disconnect();
	}

	/**
	 * Do not Use !!!!!!!!
	 * @return MessageMain instance
	 */
	public static GPanomenalMain getInstance() {
		return instance;
	}
	


	
}
