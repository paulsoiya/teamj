package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;
import service.*;

public class CompareTest {
    private float min = 0.0f;
    private float max = 65.0f;
    AbstractDaoFactory daoFact = new DaoFactory();
    CompareDao dao = daoFact.getCompareDao();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void CompareTest() {
        Random rand = new Random();
        
        for(int i=0; i < 50; i++) {
            assertTrue(dao.playerComparison((rand.nextFloat() * (max - min) + min), "RB", "New York Jets") > 0);
        }
	}
    
    @Test
    public void InsertTest() {
        assertTrue(dao.insertStat(1,1));
    }
    
    @Test
    public void findStatTest() {
        assertTrue(dao.findStatsId(1) > 0);
    }
    
    @Test
    public void userPositionTeamTest() {
        assertTrue(dao.userPositionTeam(1) != null);
    }
}
