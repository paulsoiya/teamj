package main.model;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sqlite.SQLiteConfig;

public class BuildProfessionalDB {
	
	private static final String DB_URL = "jdbc:sqlite:professional.db";  
	private static final String DRIVER = "org.sqlite.JDBC";

	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = null;
	    URLConnection openConnection = new URL(url).openConnection();
	    openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
	    try {
	    	is = openConnection.getInputStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	    	if(is != null)	
	    		is.close();
	    }
	  }
	  
	  public static void teamPrint() {
		    JSONObject jsonPlayer;
	        Connection c = null;
			PreparedStatement stmt = null;
				try {

					jsonPlayer = readJsonFromUrl("http://api.sportsdatallc.org/nfl-t1/teams/hierarchy.json?api_key=vdgd4t2d9vbfsum3rwxfaqu4");
					JSONArray confArr = jsonPlayer.getJSONArray("conferences");
					for (int i=0; i< confArr.length(); i++) {
						JSONObject conf = confArr.getJSONObject(i);
						JSONArray divArr = conf.getJSONArray("divisions");
						for(int j=0; j<divArr.length(); j++) {
							JSONObject div = divArr.getJSONObject(j);
							JSONArray teams = div.getJSONArray("teams");
							for(int k=0; k<teams.length(); k++) {
								JSONObject jsonOBject = teams.getJSONObject(k);
								try {
									c = getConnection();
									c.setAutoCommit(false);
									String sql = "INSERT INTO Team (TeamID, TeamName) " +
											"VALUES (?,?)";
									stmt = c.prepareStatement(sql);
									stmt.setString(1, jsonOBject.getString("id").toString());
									stmt.setString(2, jsonOBject.get("market").toString() + " " + jsonOBject.get("name").toString());
									stmt.executeUpdate();
								} catch ( Exception e1 ) {
									//TODO
								} finally {
									try{
										stmt.close();
										c.commit();
										c.close();
										} catch (Exception e2) {
											//TODO
										}
								}
							}
						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  }
	  
    public static void playersPrint() {
        JSONObject jsonTeam;
        JSONObject jsonPlayer;
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            jsonTeam = readJsonFromUrl("http://api.sportsdatallc.org/nfl-t1/teams/hierarchy.json?api_key=vdgd4t2d9vbfsum3rwxfaqu4");
            JSONArray confArr = jsonTeam.getJSONArray("conferences");
            for (int i=0; i< confArr.length(); i++) {
                JSONObject conf = confArr.getJSONObject(i);
                JSONArray divArr = conf.getJSONArray("divisions");
                for(int j=0; j<divArr.length(); j++) {
                    JSONObject div = divArr.getJSONObject(j);
                    JSONArray teams = div.getJSONArray("teams");
                    for(int k=0; k<teams.length(); k++) {
                        JSONObject team = teams.getJSONObject(k);
                        jsonPlayer = readJsonFromUrl("http://api.sportsdatallc.org/nfl-t1/teams/" +
                                                     team.get("id").toString() +
                                                     "/roster.json?api_key=vdgd4t2d9vbfsum3rwxfaqu4");
                        JSONArray players = jsonPlayer.getJSONArray("players");
                        for(int l=0; l<players.length(); l++){
                            JSONObject player = players.getJSONObject(l);
                            try {
                                c = getConnection();
                                c.setAutoCommit(false);
                                String sql = "INSERT INTO Player (PlayerID, PlayerName, Team, Height, Weight, BirthDate, Number) " +
                                "VALUES (?,?,?,?,?,?,?)";
                                stmt = c.prepareStatement(sql);
                                stmt.setString(1, player.get("id").toString());
                                stmt.setString(2, player.get("name_full").toString());
                                stmt.setString(3, team.get("id").toString());
                                stmt.setString(4, player.get("height").toString());
                                stmt.setString(5, player.get("weight").toString());
                                stmt.setString(6, player.get("birthdate").toString());
                                stmt.setString(7, player.get("jersey_number").toString());
                                stmt.executeUpdate();
                            } catch ( Exception e1 ) {
                                //TODO
                            } finally {
                                try{
                                    stmt.close();
                                    c.commit();
                                    c.close();
                                } catch (Exception e2) {
                                    //TODO
                                }
                            }
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                //TODO
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
		public static Connection getConnection() throws ClassNotFoundException {  
			Class.forName(DRIVER);  
			Connection connection = null;  
			try {  
				SQLiteConfig config = new SQLiteConfig();  
			    config.enforceForeignKeys(true);  
			    connection = DriverManager.getConnection(DB_URL,config.toProperties());  
			} catch (SQLException ex) {}  
			return connection;  
		}

	  public static void main(String[] args) {
		  teamPrint();
          try {
              TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
              //TODO
          }
          playersPrint();
	  }

}
