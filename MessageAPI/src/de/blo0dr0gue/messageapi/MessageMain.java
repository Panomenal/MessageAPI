package de.blo0dr0gue.messageapi;

import org.bukkit.plugin.java.JavaPlugin;

import de.blo0dr0gue.mysqlapi.MySQLAPI;

public class MessageMain extends JavaPlugin{
		
	public MySQLAPI mysql;
	public MySQL_zusatz mysql_z;
	public CacheManager cache;
	public static MessageMain instance;
	
	@Override
	public void onEnable() {
		instance=this;
		mysql = new MySQLAPI();
		mysql_z = new MySQL_zusatz();
		mysql_z.con = mysql.connect("minecraft_server");
		cache = new CacheManager();
	}
	
	@Override
	public void onDisable() {
		mysql.disconnect();
	}

	public static MessageMain getInstance() {
		return instance;
	}
	


	
}
