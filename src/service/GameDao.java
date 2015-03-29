package service;

import model.Game;

public interface GameDao {

    /**
     * Creats a new game in the Game Table
     * @param UserID
     * @return true if successfully entered
     */
    public boolean addGame(Game game);
    
    /**
     * Creats a new game in the Game Table
     * @param gameD
     * @return true if successfully deleted
     */
    public boolean deleteGame(int gameId);
}
