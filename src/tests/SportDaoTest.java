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
		AbstractDaoFactory daoFact = DaoFactory.getDaoFactory();

		this.dao = daoFact.getSportDao();
		this.sport1 = new Sport("Football", "");
		this.sport2 = new Sport("Baseball", "");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUser() {
        assertTrue(dao.createSport(sport1));
        assertTrue(dao.createSport(sport2));
	}
	
	@Test
	public void testDeleteUser(){
		assertTrue(dao.deleteSport(sport1.getName()));
		assertTrue(dao.deleteSport(sport2.getName()));
	}

}
