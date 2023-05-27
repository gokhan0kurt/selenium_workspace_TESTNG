package tests.test03;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class CG10_QdConfReaderNegativeTest {


    @Test
    public void invalidUsernamePassTest(){
        // Qualitydemy sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.upLoginButton.click();

        // gecersiz username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdInvalidUsername"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdInvalidPass"));
        ReusableMethods.waitSeconds(1);

        // login butonuna basin
        qualitydemyPage.downLoginButton.click();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailBox.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();

    }


    @Test
    public void invalidUsernameTest(){
        // Qualitydemy sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.upLoginButton.click();

        // gecersiz username ve gecerli sifre yi ilgili kutulara yazin
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdInvalidUsername"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdValidPass"));
        ReusableMethods.waitSeconds(1);

        // login butonuna basin
        qualitydemyPage.downLoginButton.click();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailBox.isEnabled());

        ReusableMethods.waitSeconds(1);
        // sayfayi kapatin
        Driver.closeDriver();

    }

    @Test
    public void invalidPasswordTest(){
        // Qualitydemy sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.upLoginButton.click();

        // gecerli username ve gecersiz sifre yi ilgili kutulara yazin
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdValidUsername"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdInvalidPass"));
        ReusableMethods.waitSeconds(1);

        // login butonuna basin
        qualitydemyPage.downLoginButton.click();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailBox.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();

    }

}
