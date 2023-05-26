package tests.test02;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class CG05_AmazonPageFirstTest {

    @Test
    public void amazonTest01(){
        // amazon anasayfaya gidelim
        Driver.getDriver().get("https://amazon.com");

        // Nutella icin arama yapalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys("Nutella"+ Keys.ENTER);
        ReusableMethods.waitSeconds(1);
        // sonuclarin Nutella icerdigini test edelim

        String expectedContent ="Nutella";
        String actualContent = amazonPage.searchResultsText.getText();

        Assert.assertTrue(actualContent.contains(expectedContent));

        Driver.closeDriver();

    }

}
