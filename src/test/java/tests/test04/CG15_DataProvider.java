package tests.test04;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;


 /*
        dataProvider testNG'nin test method'u disindan
        test'e data saglamak icin olusturdugu ozel bir yapidir

        bu yapi iki katli bir array dondurur
*/

public class CG15_DataProvider {

    @DataProvider
    public static Object[][] searchWordArr() {

        String[][] searchWordList = {{"CCNA"},{"Comptia"},{"Selenium"},{"Security Tools"}};

        return searchWordList;
    }


    // amazon anasayfaya gidin

    // bize test method'u disindan list olarak verilen urunlerin hepsi icin
    // arama kutusuna yazip arama yapin
    // ve sonuc yazisinin arattiginiz element'i icerdigini test edin

    @Test(dataProvider = "searchWordArr")
    public void amazonDataProviderTest(String givenSearchWord) {

        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // bize test method'u disindan list olarak verilen urunlerin hepsi icin
        // arama kutusuna yazip arama yapin

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys(givenSearchWord + Keys.ENTER);


        // ve sonuc yazisinin arattiginiz element'i icerdigini test edin
        String actualResultText = amazonPage.searchResultsText.getText();
        String expectedResultText = givenSearchWord;
        Assert.assertTrue(actualResultText.contains(expectedResultText));

        Driver.closeDriver();

    }

}
