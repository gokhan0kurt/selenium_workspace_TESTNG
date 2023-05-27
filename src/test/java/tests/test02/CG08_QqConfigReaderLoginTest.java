package tests.test02;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class CG08_QqConfigReaderLoginTest {

    // Qualitydemy sayfasina gidin
    // login linkine tiklayin
    // gecerli username ve sifre yi ilgili kutulara yazin
    // login butonuna basin
    // basarili olarak giris yapildigini test edin
    // sayfayi kapatin


    @Test
    public void qdConfigReaderTest(){

        // Qualitydemy sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));


        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.upLoginButton.click();

        // gecerli username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdValidUsername"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdValidPass"));
        ReusableMethods.waitSeconds(1);

        // login butonuna basin
        qualitydemyPage.downLoginButton.click();

        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.successLogin.isDisplayed());

        // sayfayi kapatin
        Driver.closeDriver();

    }


}
