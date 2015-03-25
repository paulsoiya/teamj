package model;

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

public class BuildProfessionalDB {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/individual?user=root&password=password";  
	private static final String DRIVER = "com.mysql.jdbc.Driver";

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
									System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
								} finally {
									try{
										stmt.close();
										c.commit();
										c.close();
										} catch (Exception e2) {
											System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
										}
								}
							}
						}
					}
				} catch (JSONException e) {
					System.err.println(e.getClass().getName() + ": " + e.getMessage());
				} catch (IOException e) {
					System.err.println(e.getClass().getName() + ": " + e.getMessage());
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
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            System.err.println(e.getClass().getName() + ": " + e.getMessage());
                        }
                        jsonPlayer = readJsonFromUrl("http://api.sportsdatallc.org/nfl-t1/teams/" +
                                                     team.get("id").toString() +
                                                     "/roster.json?api_key=vdgd4t2d9vbfsum3rwxfaqu4");
                        JSONArray players = jsonPlayer.getJSONArray("players");
                        for(int l=0; l<players.length(); l++){
                            JSONObject player = players.getJSONObject(l);
                            try {
                                c = getConnection();
                                c.setAutoCommit(false);
                                String sql = "INSERT INTO Player (PlayerID, PlayerName, Team, Height, Weight, BirthDate, College, Number) " +
                                "VALUES (?,?,?,?,?,?,?,?)";
                                stmt = c.prepareStatement(sql);
                                stmt.setString(1, player.get("id").toString());
                                stmt.setString(2, player.get("name_full").toString());
                                stmt.setString(3, team.get("id").toString());
                                stmt.setString(4, player.get("height").toString());
                                stmt.setString(5, player.get("weight").toString());
                                stmt.setString(6, player.get("birthdate").toString());
                                stmt.setString(7, player.get("college").toString());
                                stmt.setString(8, player.get("jersey_number").toString());
                                stmt.executeUpdate();
                            } catch ( Exception e1 ) {
                                System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
                            } finally {
                                try{
                                    stmt.close();
                                    c.commit();
                                    c.close();
                                } catch (Exception e2) {
                                    System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void statsPrint() {
        JSONObject jsonSeason;
        JSONObject jsonStats;
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            jsonSeason = readJsonFromUrl("http://api.sportsdatallc.org/nfl-t1/2014/REG/schedule.json?api_key=vdgd4t2d9vbfsum3rwxfaqu4");
            JSONArray weekArr = jsonSeason.getJSONArray("weeks");
            for (int i=0; i< weekArr.length(); i++) {
                JSONObject week = weekArr.getJSONObject(i);
                JSONArray gameArr = week.getJSONArray("games");
                for(int j=0; j<gameArr.length(); j++) {
                    JSONObject game = gameArr.getJSONObject(j);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    jsonStats = readJsonFromUrl("http://api.sportsdatallc.org/nfl-t1/2014/REG/"
                                                + week.get("number").toString() + "/"
                                                + game.get("away").toString() + "/"
                                                + game.get("home").toString()
                                                + "/statistics.json?api_key=vdgd4t2d9vbfsum3rwxfaqu4");
                    //Home Team Rushing Stats
                    JSONObject homeTeam = jsonStats.getJSONObject("home_team");
                    JSONObject statsHome = homeTeam.getJSONObject("statistics");
                    JSONObject rushHome = statsHome.getJSONObject("rushing");
                    JSONArray homeRushArr = rushHome.getJSONArray("players");
                    for(int k=0; k<homeRushArr.length(); k++) {
                        JSONObject player = homeRushArr.getJSONObject(k);
                        try {
                            c = getConnection();
                            c.setAutoCommit(false);
                            
                            String sql = "INSERT INTO Stats(GameID, PlayerID, RushYDs, RushTDs, RushAtt) " +
                            "VALUES (?,?,?,?,?)";
                            
                            stmt = c.prepareStatement(sql);
                            stmt.setString(1, game.get("id").toString());
                            stmt.setString(2, player.get("id").toString());
                            stmt.setString(3, player.get("yds").toString());
                            stmt.setString(4, player.get("td").toString());
                            stmt.setString(5, player.getString("att").toString());
                            stmt.executeUpdate();
                            
                        } catch (Exception e1) {
                            System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
                        } finally {
                            try {
                                stmt.close();
                                c.commit();
                                c.close();
                            } catch (Exception e2) {
                                System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
                            }
                        }
                    }
                    //Home Team Passing Stats
                    JSONObject passHome = statsHome.getJSONObject("passing");
                    JSONArray homePassArr = passHome.getJSONArray("players");
                    for(int k=0; k<homePassArr.length(); k++) {
                        JSONObject player = homePassArr.getJSONObject(k);
                        try {
                            c = getConnection();
                            c.setAutoCommit(false);
                            
                            String sql = "INSERT INTO Stats(GameID, PlayerID, PassYDs, PassTDs, PassAtt) " +
                            "VALUES (?,?,?,?,?)";
                            
                            stmt = c.prepareStatement(sql);
                            stmt.setString(1, game.get("id").toString());
                            stmt.setString(2, player.get("id").toString());
                            stmt.setString(3, player.get("yds").toString());
                            stmt.setString(4, player.get("td").toString());
                            stmt.setString(5, player.getString("att").toString());
                            stmt.executeUpdate();
                            
                        } catch (Exception e1) {
                            System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
                        } finally {
                            try {
                                stmt.close();
                                c.commit();
                                c.close();
                            } catch (Exception e2) {
                                System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
                            }
                        }
                    }
                    
                    //Home Team Receiving Stats
                    JSONObject recHome = statsHome.getJSONObject("passing");
                    JSONArray homeRecArr = recHome.getJSONArray("players");
                    for(int k=0; k<homeRecArr.length(); k++) {
                        JSONObject player = homeRecArr.getJSONObject(k);
                        try {
                            c = getConnection();
                            c.setAutoCommit(false);
                            
                            String sql = "INSERT INTO Stats(GameID, PlayerID, RecYDs, RecTDs, RecAtt) " +
                            "VALUES (?,?,?,?,?)";
                            
                            stmt = c.prepareStatement(sql);
                            stmt.setString(1, game.get("id").toString());
                            stmt.setString(2, player.get("id").toString());
                            stmt.setString(3, player.get("yds").toString());
                            stmt.setString(4, player.get("td").toString());
                            stmt.setString(5, player.getString("att").toString());
                            stmt.executeUpdate();
                            
                        } catch (Exception e1) {
                            System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
                        } finally {
                            try {
                                stmt.close();
                                c.commit();
                                c.close();
                            } catch (Exception e2) {
                                System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
                            }
                        }
                    }
                    
                    //Away Team Rushing Stats
                    JSONObject awayTeam = jsonStats.getJSONObject("away_team");
                    JSONObject statsAway = awayTeam.getJSONObject("statistics");
                    JSONObject rushAway = statsAway.getJSONObject("rushing");
                    JSONArray awayRushArr = rushAway.getJSONArray("players");
                    for(int k=0; k<awayRushArr.length(); k++) {
                        JSONObject player = awayRushArr.getJSONObject(k);
                        try {
                            c = getConnection();
                            c.setAutoCommit(false);
                            
                            String sql = "INSERT INTO Stats(GameID, PlayerID, RushYDs, RushTDs, RushAtt) " +
                            "VALUES (?,?,?,?,?)";
                            
                            stmt = c.prepareStatement(sql);
                            stmt.setString(1, game.get("id").toString());
                            stmt.setString(2, player.get("id").toString());
                            stmt.setString(3, player.get("yds").toString());
                            stmt.setString(4, player.get("td").toString());
                            stmt.setString(5, player.getString("att").toString());
                            stmt.executeUpdate();
                            
                        } catch (Exception e1) {
                            System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
                        } finally {
                            try {
                                stmt.close();
                                c.commit();
                                c.close();
                            } catch (Exception e2) {
                                System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
                            }
                        }
                    }
                    
                    //Away Team Passing Stats
                    JSONObject passAway = statsHome.getJSONObject("passing");
                    JSONArray awayPassArr = passAway.getJSONArray("players");
                    for(int k=0; k<awayPassArr.length(); k++) {
                        JSONObject player = awayPassArr.getJSONObject(k);
                        try {
                            c = getConnection();
                            c.setAutoCommit(false);
                            
                            String sql = "INSERT INTO Stats(GameID, PlayerID, PassYDs, PassTDs, PassAtt) " +
                            "VALUES (?,?,?,?,?)";
                            
                            stmt = c.prepareStatement(sql);
                            stmt.setString(1, game.get("id").toString());
                            stmt.setString(2, player.get("id").toString());
                            stmt.setString(3, player.get("yds").toString());
                            stmt.setString(4, player.get("td").toString());
                            stmt.setString(5, player.getString("att").toString());
                            stmt.executeUpdate();
                            
                        } catch (Exception e1) {
                            System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
                        } finally {
                            try {
                                stmt.close();
                                c.commit();
                                c.close();
                            } catch (Exception e2) {
                                System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
                            }
                        }
                    }
                    
                    //Away Team Receiving Stats
                    JSONObject recAway = statsHome.getJSONObject("passing");
                    JSONArray awayRecArr = recAway.getJSONArray("players");
                    for(int k=0; k<awayRecArr.length(); k++) {
                        JSONObject player = awayRecArr.getJSONObject(k);
                        try {
                            c = getConnection();
                            c.setAutoCommit(false);
                            
                            String sql = "INSERT INTO Stats(GameID, PlayerID, RecYDs, RecTDs, RecAtt) " +
                            "VALUES (?,?,?,?,?)";
                            
                            stmt = c.prepareStatement(sql);
                            stmt.setString(1, game.get("id").toString());
                            stmt.setString(2, player.get("id").toString());
                            stmt.setString(3, player.get("yds").toString());
                            stmt.setString(4, player.get("td").toString());
                            stmt.setString(5, player.getString("att").toString());
                            stmt.executeUpdate();
                            
                        } catch (Exception e1) {
                            System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
                        } finally {
                            try {
                                stmt.close();
                                c.commit();
                                c.close();
                            } catch (Exception e2) {
                                System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
                            }
                        }
                    }
                    
                    try {
                        c = getConnection();
                        c.setAutoCommit(false);
                        
                        String sql = "INSERT INTO GameLog (GameID, Date, Team, Oppenent, Score) " +
                        "VALUES (?,?,?,?,?)";
                        stmt = c.prepareStatement(sql);
                        stmt.setString(1, game.get("id").toString());
                        stmt.setString(2, game.get("scheduled").toString());
                        stmt.setString(3, game.get("home").toString());
                        stmt.setString(4, game.get("away").toString());
                        stmt.setString(5,  homeTeam.get("points").toString() + "-" + awayTeam.get("points").toString());
                        stmt.executeUpdate();
                    } catch (Exception e1) {
                        System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
                    } finally {
                        try {
                            stmt.close();
                            c.commit();
                            c.close();
                        } catch (Exception e2) {
                            System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
		public static Connection getConnection() throws ClassNotFoundException {  
			Class.forName(DRIVER);  
			Connection connection = null;  
			try {
			    connection = DriverManager.getConnection(DB_URL);
			} catch (SQLException ex) {
                System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            }
			return connection;  
		}

	  public static void main(String[] args) {
		  teamPrint();
          try {
              TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
              System.err.println(e.getClass().getName() + ": " + e.getMessage());
          }
          playersPrint();
          try {
              TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
              System.err.println(e.getClass().getName() + ": " + e.getMessage());
          }
          statsPrint();
	  }
}