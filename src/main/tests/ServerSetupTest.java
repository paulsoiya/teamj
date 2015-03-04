package main.tests;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

public class ServerSetupTest {
    
    @Test
    public void DatabaseCreationTest() {
        File proDB = new File("professional.db");
        File indDB = new File("individual.db");
        assertTrue(proDB.exists());
        assertTrue(indDB.exists());
    }
}
