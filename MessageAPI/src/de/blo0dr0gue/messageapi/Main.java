package de.blo0dr0gue.messageapi;

import org.bukkit.plugin.java.JavaPlugin;

import de.blo0dr0gue.mysqlapi.MySQLAPI;

public class Main extends JavaPlugin{
		
	public MySQLAPI mysql;
	public MySQL_zusatz mysql_z;
	
	@Override
	public void onEnable() {
		mysql = new MySQLAPI();
		mysql_z = new MySQL_zusatz();
		mysql_z.con = mysql.connect("minecraft_server");
	}
	
	@Override
	public void onDisable() {
		mysql.disconnect();
	}
	
}
