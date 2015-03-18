package tests;

import static org.junit.Assert.*;
import view.ScreensController;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScreensControllerTest {
	private ScreensController sc;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sc = new ScreensController();
		sc.loadScreen("register", "register.fxml");
		sc.loadScreen("login", "login.fxml");
		sc.setScreen("login");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetScreen() {
		assertTrue(sc.setScreen("register"));
	}

}
