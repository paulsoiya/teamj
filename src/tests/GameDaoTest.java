package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import service.*;
import model.Game;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameDaoTest {
	private AbstractDaoFactory daoFact;
	private GameDao dao;
    private UserDao usrDao;
	private Game game1;
	private Game game2;
    private User user;
     private User currentUser;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		daoFact = DaoFactory.getDaoFactory();
        
        Date now = new Date();
        LocalDate date = now.toInstant().atZone(ZoneId.systemDefault())
        .toLocalDate();
        
        this.user = new User("testemail5@asu.edu", "password", "TestFname",
                              "TestLname", date);
        
		this.dao = daoFact.getGameDao();
        this.usrDao = daoFact.getUserDao();
        usrDao.createUser(user);
        currentUser = usrDao.findUser(user.getEmail());
		this.game1 = new Game(1, currentUser.getId(), 1, "Pittsford", "20-7", date);
		this.game2 = new Game(2, currentUser.getId(), 2, "Rush", "28-7", date);
        
        
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateGame() {
		assertTrue(dao.addGame(game1));
		//give the wrong password to the connection so it can fail
		DaoFactory.conUrlInd = "jdbc:mysql://localhost:3306/individual?user=root&password=wrongpassword";
		assertFalse(dao.addGame(game2));

	}
	
	@Test
	public void testDeleteGame(){
		assertFalse(dao.deleteGame(game1.getGameID()));
		//set the right password so the connection will succeed and the delete will work
		DaoFactory.conUrlInd = "jdbc:mysql://localhost:3306/individual?user=root&password=password";
		assertTrue(dao.deleteGame(game1.getGameID()));
        usrDao.deleteUser(currentUser.getEmail());
	}

}
