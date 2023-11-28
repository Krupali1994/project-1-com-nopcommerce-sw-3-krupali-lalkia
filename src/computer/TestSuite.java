package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Create the package name computer
 * 1. Create class “TestSuite”
 */
public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    /**
     * Write the following Test:
     * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
     * 1.1 Click on Computer Menu.
     * 1.2 Click on Desktop
     * 1.3 Select Sort By position "Name: Z to A"
     * 1.4 Verify the Product will arrange in Descending order.
     */

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        String menu = "Computers";
        clickOnElement(By.xpath("//a[text()='Computers ']"));
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        selectByVisibleText(By.id("products-orderby"), "Name: Z to A");
        String expected = "Name: Z to A";
        String actual = getTextFromElement(By.xpath("//option[normalize-space()='Name: Z to A']"));
        assertEqualsMethod("Not in descending order", expected, actual);
    }

    /**
     * Test name verifyProductAddedToShoppingCartSuccessFully()
     * 2.1 Click on Computer Menu.
     * 2.2 Click on Desktop
     * 2.3 Select Sort By position "Name: A to Z"
     * 2.4 Click on "Add To Cart"
     * 2.5 Verify the Text "Build your own computer"
     */

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        String menu = "Computers";
        clickOnElement(By.xpath("//a[text()='Computers ']"));
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        selectByVisibleText(By.id("products-orderby"), "Name: Z to A");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text() = 'Build your own computer']"));
        String expected = "Build your own computer";
        String actual = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        assertEqualsMethod("Element not correct", expected, actual);

        /**
         * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
         * 2.7.Select "8GB [+$60.00]" using Select class.
         * 2.8 Select HDD radio "400 GB [+$100.00]"
         * 2.9 Select OS radio "Vista Premium [+$60.00]"
         * 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
         * [+$5.00]"
         * 2.11 Verify the price "$1,475.00"
         * Verify the Message "The product has been added to your shopping cart" on Top
         * green Bar
         */
        clickOnElement(By.id("product_attribute_1"));
        selectByVisibleText(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        clickOnElement(By.id("product_attribute_2"));
        selectByVisibleText(By.id("product_attribute_2"), "8GB [+$60.00]");
        clickOnElement(By.id("product_attribute_3_7"));
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(2000);
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(2000);
        String expected1 = "$1,475.00";
        String actual1 = getTextFromElement(By.id("price-value-1"));
        assertEqualsMethod("Error", expected1, actual1);
        Thread.sleep(2000);
        clickOnElement(By.id("add-to-cart-button-1"));
        String expectedMessage2 = "The product has been added to your shopping cart";
        String actualMessage2 = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        assertEqualsMethod("The product has been added to your shopping cart", expectedMessage2, actualMessage2);

        /**
         * After that close the bar clicking on the cross button.
         * 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
         * 2.15 Verify the message "Shopping cart"
         * 2.16 Change the Qty to "2" and Click on "Update shopping cart"
         * 2.17 Verify the Total"$2,950.00"
         * 2.18 click on checkbox “I agree with the terms of service”
         * 2.19 Click on “CHECKOUT”
         * 2.20 Verify the Text “Welcome, Please Sign In!”
         * 2.21Click on “CHECKOUT AS GUEST” Tab
         */
        clickOnElement(By.xpath("//span[@class = 'close']"));
        mouseHoverToElement(By.xpath("//a[@class='ico-cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[@class='cart-label']"));
        String expectedText = "Shopping cart";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        assertEqualsMethod("Incorrect message displayed!", expectedText, actualText);
        Thread.sleep(2000);
        clearTextField(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        Thread.sleep(2000);
        String expectedTotalPrice = "$2,950.00";
        String actualTotalPrice = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(2000);
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        assertEqualsMethod("Incorrect message displayed!", expectedMessage, actualMessage);
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        Thread.sleep(2000);

        /**
         * 2.22 Fill the all mandatory field
         * 2.23 Click on “CONTINUE”
         * 2.24 Click on Radio Button “Next Day Air($0.00)”
         * 2.25 Click on “CONTINUE”
         * 2.26 Select Radio Button “Credit Card”
         * 2.27 Select “Master card” From Select credit card dropdown
         * 2.28 Fill all the details
         * 2.29 Click on “CONTINUE”
         */
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Krupali");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Lalkia");
        sendTextToElement(By.id("BillingNewAddress_Email"), "kruapali@gmail.com");
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "10");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "10 Windsor Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "SW1 2FD");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07089456123");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[text()='Continue']"));
        Thread.sleep(2000);
        clickOnElement(By.id("shippingoption_1"));
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleText(By.id("CreditCardType"), "Master card");
        sendTextToElement(By.id("CardholderName"), "Krupali Lalkia");
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        Thread.sleep(2000);
        clickOnElement(By.id("ExpireMonth"));
        selectByValueFromDropDown(By.id("ExpireMonth"), "12");
        selectByValueFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "123");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        /**
         * 2.30 Verify “Payment Method” is “Credit Card”
         * 2.32 Verify “Shipping Method” is “Next Day Air”
         * 2.33 Verify Total is “$2,950.00”
         * 2.34 Click on “CONFIRM”
         * 2.35 Verify the Text “Thank You”
         * 2.36 Verify the message “Your order has been successfully processed!”
         * 2.37 Click on “CONTINUE”
         * 2.37 Verify the text “Welcome to our store”
         */
        String expectedPayment = "Payment Method: Credit Card";
        String actualPayment = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        assertEqualsMethod("Incorrect payment method", expectedPayment, actualPayment);

        String expectedShipping = "Shipping Method: Next Day Air";
        String actualShipping = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        assertEqualsMethod("Incorrect Shipping method", expectedShipping, actualShipping);

        String eTotal1 = "$2,950.00";
        String aTotal1 = driver.findElement(By.xpath("//span[text()='$2,950.00'][@class = 'product-subtotal']")).getText();
        assertEqualsMethod("Incorrect total value", eTotal1, aTotal1);

        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        String etext = "Thank you";
        String atext = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        assertEqualsMethod("Incorrect message", etext, atext);
        String expectedOrder1 = "Your order has been successfully processed!";
        String actualOrder1 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        assertEqualsMethod("Error in ordering", expectedOrder1, actualOrder1);

        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        String expectedWelcome = "Welcome to our store";
        String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        assertEqualsMethod("Error message", expectedWelcome, actualWelcome);
    }

    //closing the browser
    @After
    public void setDown() {
        closeBrowser();
    }
}
