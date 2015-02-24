package main.tests;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

public class ServerSetupTest {

   @Test
   public void DatabaseCreationTest() {
       File proDB = new File("teamj/professional.db");
       assertTrue(proDB.exists());
       File indDB = new File("teamj/individual.db");
       assertTrue(indDB.exists());
   } 
}
