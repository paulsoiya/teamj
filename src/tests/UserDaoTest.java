package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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
		Date now = new Date();
		LocalDate dob = now.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		this.user1 = new User("testemail1@asu.edu", "password", "TestFname",
				"TestLname", dob);
		this.user2 = new User("testemail2@asu.edu", "password", "TestFname",
				"TestLname", dob);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUser() {
        assertTrue(dao.createUser(user1));
        assertFalse(dao.createUser(user1));
	}
	
	@Test
	public void testDeleteUser(){
		assertTrue(dao.deleteUser(user1.getEmail()));
		assertFalse(dao.deleteUser(user1.getEmail()));
	}

}
