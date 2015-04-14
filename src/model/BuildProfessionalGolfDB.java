package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BuildProfessionalGolfDB {
	
	private static final String DB_URL = "jdbc:sqlite:professionalGolf.db";
	private static final String DRIVER = "org.sqlite.JDBC";
    
    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName(DRIVER);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL);
        }
        catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
        return connection;
    }
	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	
	public static JSONObject readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = null;
		URLConnection openConnection = new URL(url).openConnection();
		openConnection
				.addRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		try {
			is = openConnection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		}
		finally {
			if (is != null)
				is.close();
		}
	}
	
	public static void playersPrint() {
		JSONObject jsonPlayer;
		Connection c = null;
		PreparedStatement stmt = null;
		try {
			jsonPlayer = readJsonFromUrl("http://api.sportsdatallc.org/golf-t1/profiles/pga/2015/players/profiles.json?api_key=zdmmqpppj7kvaqhhzxguznnk");
			JSONArray playerArr = jsonPlayer.getJSONArray("players");
			for (int i = 0; i < playerArr.length(); i++) {
                JSONObject player = playerArr.getJSONObject(i);
                try {
                    c = getConnection();
                    c.setAutoCommit(false);
                    String sql = "INSERT INTO Player (PlayerID, PlayerName, Height, Weight, "
                    + "BirthDate, Country, BirthPlace) VALUES (?,?,?,?,?,?,?)";
                    stmt = c.prepareStatement(sql);
                    stmt.setString(1, player.get("id").toString());
                    stmt.setString(2, player.get("first_name").toString() + " " +
                                   player.get("last_name").toString());
                    System.out.println(player.get("first_name").toString());
                    stmt.setString(3, player.get("height").toString());
                    stmt.setString(4, player.get("weight").toString());
                    stmt.setString(5, player.get("birthdate").toString());
                    stmt.setString(6, player.get("country").toString());
                    stmt.setString(7, player.get("birth_place").toString());
                    stmt.executeUpdate();
                    } catch (Exception e1) {
                        System.err.println(e1.getClass().getName() + ": "
                            + e1.getMessage());
                    } finally {
                        try {
                            stmt.close();
                            c.commit();
                            c.close();
                        } catch (Exception e2) {
                            System.err.println(e2.getClass().getName() + ": "
                                + e2.getMessage());
                        }
                    }
            }
		}
		catch (JSONException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		catch (IOException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		playersPrint();
	}
}
