package de.blo0dr0gue.messageapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;

public class MySQL_zusatz {

	public Connection con;

	/**
	 * select the Language of an Player
	 * 
	 * @param Player p
	 * @return String Language
	 */
	public String selectLanguage(Player p) {
		String language = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = null;
			rs = st.executeQuery(
					"SELECT language FROM player_settings WHERE uuid='" + p.getUniqueId().toString() + "'");
			while (rs.next()) {
				language = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return language;
	}

	/**
	 * returns the message from the DB(Language; e.g. de_DE)
	 * 
	 * @param String language
	 * @param String shorthandsymbol
	 * @return String messageInDB
	 */
	public String selectMessage(String language, String shorthandsymbol) {
		String messageInDB = null;

		if (ifExistsMessage(language, shorthandsymbol)) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = null;
				rs = st.executeQuery(
						"SELECT message FROM " + language + " WHERE shorthandsymbol='" + shorthandsymbol + "'");
				while (rs.next()) {
					messageInDB = rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				Statement st = con.createStatement();
				ResultSet rs = null;
				rs = st.executeQuery("SELECT message FROM " + language + " WHERE shorthandsymbol='default'");
				while (rs.next()) {
					messageInDB = rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return messageInDB;
	}

	/**
	 * Check if the message exists who u are watching for
	 * 
	 * @param String language
	 * @param String shorthandsymbol
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean ifExistsMessage(String language, String shorthandsymbol) {
		boolean back = false;

		try {
			Statement st = con.createStatement();
			ResultSet rs = null;
			rs = st.executeQuery("SELECT * FROM " + language + " WHERE shorthandsymbol='" + shorthandsymbol + "'");
			while (rs.next()) {
				if (rs != null) {
					back = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return back;
	}

	/**
	 * Check if the UUID exists in DB
	 * 
	 * @param Player p
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean ifExistsLangauge(Player p) throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs = null;
		rs = st.executeQuery("SELECT * FROM player_settings WHERE uuid='" + p.getUniqueId().toString() + "'");
		while (rs.next()) {
			if (rs != null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Set the language of an Player
	 * 
	 * @param Player p
	 * @param String language
	 */
	public void setLanguage(Player p, String language) {
		try {
			Statement st = con.createStatement();
			if (ifExistsLangauge(p)) {
				st.executeUpdate("UPDATE player_settings SET language='" + language + "' WHERE uuid='"
						+ p.getUniqueId().toString() + "';");
			} else {
				st.executeQuery("INSERT INTO `player_settings`(`uuid`, `language`) VALUES ("+p.getUniqueId().toString()+","+language+");");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
