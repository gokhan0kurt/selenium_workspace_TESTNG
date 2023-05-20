package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.Reusable;

public class CG07_QdNegatifTest {
    @Test
    public void qdNegatifTest01(){
        // qualitydemy anasayfaya gidin
        Driver.getDriver().get("https://qualitydemy.com");

        // ilk login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.upLoginButton.click();

        // kullanici adi olarak selenium
        qualitydemyPage.emailBox.sendKeys("selenium");

        // password olarak test012305 yazin
        qualitydemyPage.passwordBox.sendKeys("test012305");
        Reusable.waitSeconds(1);

        // login butonuna tiklayin
        qualitydemyPage.downLoginButton.click();

        // giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailBox.isEnabled());
        // sayfayi kapatin
        Reusable.waitSeconds(2);
        Driver.closeDriver();






    }



}
