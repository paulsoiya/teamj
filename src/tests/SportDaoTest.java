package tests;

import static org.junit.Assert.*;

import service.*;
import model.Sport;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SportDaoTest {
	private AbstractDaoFactory daoFact;
	private SportDao dao;
	private Sport sport1;
	private Sport sport2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		daoFact = DaoFactory.getDaoFactory();

		this.dao = daoFact.getSportDao();
		this.sport1 = new Sport(1, "Football", "", "");
		this.sport2 = new Sport(1, "Baseball", "", "");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUser() {
		assertTrue(dao.createSport(sport1));
		//give the wrong password to the connection so it can fail
		DaoFactory.conUrlInd = "jdbc:mysql://localhost:3306/individual?user=root&password=wrongpassword";

		assertFalse(dao.createSport(sport2));

	}
	
	@Test
	public void testDeleteUser(){
		assertFalse(dao.deleteSport(sport1.getName()));
		//set the right password so the connection will succeed and the delete will work
		DaoFactory.conUrlInd = "jdbc:mysql://localhost:3306/individual?user=root&password=password";
		assertTrue(dao.deleteSport(sport1.getName()));
	}

}
