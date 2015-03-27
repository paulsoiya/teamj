package service;

import model.Game;

public interface GameDao {

    /**
     * Creats a new game in the Game Table
     * @param UserID
     * @return true if successfully entered
     */
    public boolean addGame(Game game);
}
