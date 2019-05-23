import data.LoginPerson;
import db.DBLoginAccess;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Tester-Klasse für Datenbank-Methode findPasswordByUsername(inputBenutzer).
 * 
 * @author Herbert Seewann
 * @version 7.0
 */
@RunWith(Parameterized.class)
public class PasswordFindTest {
    private String inputBenutzer, passwordExpected;
    
    private DBLoginAccess dba;
    public PasswordFindTest(String inputBenutzer,
            String passwordExpected) {
        this.inputBenutzer = inputBenutzer;
        this.passwordExpected = passwordExpected;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dba = DBLoginAccess.getInstance();
    }
    
    @After
    public void tearDown() {
        dba = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
            {"seewanne", "12345"},
            {"seehea16", "98765"}
        });
    }
    
    @Test
    public void PasswortChecker() throws Exception {
        System.out.println("Passwortchecker: " + inputBenutzer);
        dba.persistEntity(new LoginPerson("Spieler", inputBenutzer, passwordExpected));
        assertEquals(passwordExpected, dba.findPasswordByUsername(inputBenutzer));
    }
}