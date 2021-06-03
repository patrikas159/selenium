
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    @BeforeTest
    public void setup() {
        Selenium.setup();
    }


    @Test(priority=1, groups="searchTests")
    public void searchByWordTest() {
        Selenium.searchByWord("Baranauskas");
        compareResultsTest();
    }
    public void compareResultsTest(){
        int results = Selenium.compareResults();
        Assert.assertEquals(159000, results);
    }
    @AfterTest
    public void close(){
     Selenium.close();
    }
}
