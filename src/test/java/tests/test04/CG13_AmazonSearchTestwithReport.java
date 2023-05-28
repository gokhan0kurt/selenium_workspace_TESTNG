package tests.test04;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class CG13_AmazonSearchTestwithReport extends TestBaseReport {

    @Test
    public void amazonTestReport(){

        extentTest = extentReports.createTest("Amazon search test," +
                "Kullanici istedigi kelimeyi aratabilmeli");


        // amazon'a gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Kullanici amazon anasayfaya gider");


        // Nutella icin arama yapin
        AmazonPage amazonPage =new AmazonPage();
        amazonPage.searchBox.sendKeys(ConfigReader.getProperty("amazonSearchWord")+ Keys.ENTER);
        extentTest.info("Arama cubuguna aratmak istedigi kelimeyi yazar ve aratir");

        // arama sonuclarinin Nutella icerdigini test edin
        String expectedResultText = ConfigReader.getProperty("amazonExpectedContent");
        String actualResultText = amazonPage.searchResultsText.getText();

        Assert.assertTrue(actualResultText.contains(expectedResultText));
        extentTest.pass("Belirlenen aratma kelimesi olarak "+ConfigReader.getProperty("amazonSearchWord")+
                " aratildiginda, arama sonuclarinda beklenen icerik oldugu test edildi " )   ;

        Driver.closeDriver();
    }

}
