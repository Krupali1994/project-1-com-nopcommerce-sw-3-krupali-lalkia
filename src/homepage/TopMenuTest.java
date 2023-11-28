package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation
 */
public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space() = '" + menu + "']"));
        String expected = menu;
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'" + menu + "')]"));
        assertEqualsMethod("Incorrect top menu", expected, actual);
    }

    @Test
    public void verifyPageNavigation() throws InterruptedException {
        selectMenu("Computers");
        Thread.sleep(2000);
        selectMenu("Electronics");
        selectMenu("Apparel");
        selectMenu("Digital downloads");
        Thread.sleep(2000);
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");
    }

    @After
    public void setDown() {
        closeBrowser();
    }
}
