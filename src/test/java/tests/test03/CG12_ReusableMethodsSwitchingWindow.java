package tests.test03;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HerokuappPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class CG12_ReusableMethodsSwitchingWindow {



    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri dönun

    @Test
    public void switchWindowTest() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("herokuUrl"));

        String firstPageWHD = Driver.getDriver().getWindowHandle();

        HerokuappPage herokuappPage = new HerokuappPage();
        SoftAssert softAssert = new SoftAssert();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedContent = ConfigReader.getProperty("openingWindowText");
        String actualContent = herokuappPage.openingWindowText.getText();

        softAssert.assertEquals(actualContent, expectedContent, "Sayfadaki text Opening a new window,degil");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = ConfigReader.getProperty("herokuExpectedTitle");

        softAssert.assertEquals(actualTitle,expectedTitle,"Bekelenen baslik The Internet,degil");


        //● Click Here butonuna basın.
        herokuappPage.clickHereButton.click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        ReusableMethods.switchToWindow("New Window"); // Driver yeni pencereye gecti

        String expectedNewWindowTitle = ConfigReader.getProperty("herokuNewWindowTitle");
        String actualNewWindowTitle = Driver.getDriver().getTitle();

        softAssert.assertEquals(actualNewWindowTitle,expectedNewWindowTitle,"Yeni sayfa title New Window, degil");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedText = "New Window";
        String actualText = herokuappPage.newWindowText.getText();

        softAssert.assertEquals(actualText,expectedText,"Yeni sayfada gorunen metin New Window, degil");


        //● Bir önceki pencereye geri donun
        Driver.getDriver().switchTo().window(firstPageWHD);


        ReusableMethods.waitSeconds(1);
        Driver.quitDriver();


        softAssert.assertAll();

    }
















}
