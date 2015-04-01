package tests;

import static org.junit.Assert.*;

import service.*;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoTest {
	private UserDao dao;
	private User user1;
	private User user2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		AbstractDaoFactory daoFact = DaoFactory.getDaoFactory();

		this.dao = daoFact.getUserDao();

		this.user1 = new User("testemail1@asu.edu", "password", "TestFname",
				"TestLname", "");
		this.user2 = new User("testemail2@asu.edu", "password", "TestFname",
				"TestLname", "");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createUserTest() {
        assertTrue(dao.createUser(user1));
        DaoFactory.conUrlInd = "jdbc:mysql://localhost:3306/individual?user=root&password=wrongpassword";
        assertFalse(dao.createUser(user2));
	}
    
    @Test
    public void passwordMatchTest() {
        assertTrue(dao.passwordMatch("password", "password"));
        assertFalse(dao.passwordMatch("null", null));
        assertFalse(dao.passwordMatch("password", "pass"));
        assertFalse(dao.passwordMatch(null, "password"));
    }
    
    @Test
    public void loginUserTest(){
        assertFalse(dao.loginUser(user1.getEmail(), "passord"));
        DaoFactory.conUrlInd = "jdbc:mysql://localhost:3306/individual?user=root&password=password";
        assertTrue(dao.loginUser(user1.getEmail(), "password"));
        assertFalse(dao.loginUser(user1.getEmail(), "incorrect"));
    }
    
    @Test
    public void updateUserTest() {
        assertTrue(dao.updateUser(user2));
        DaoFactory.conUrlInd = "jdbc:mysql://localhost:3306/individual?user=root&password=wrongpassword";
        assertFalse(dao.updateUser(user1));
    }
    
    @Test
    public void deleteUserTest(){
        assertFalse(dao.deleteUser(user1.getEmail()));
        DaoFactory.conUrlInd = "jdbc:mysql://localhost:3306/individual?user=root&password=password";
        assertTrue(dao.deleteUser(user1.getEmail()));
    }

}
