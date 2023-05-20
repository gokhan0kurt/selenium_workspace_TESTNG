package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.Reusable;

public class CG06_QualitydemyPageTest {

    @Test
    public void qdTest01(){
        // Qualitydemy sayfasina gidin
        Driver.getDriver().get("https://qualitydemy.com");

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.upLoginButton.click();

        // gecerli username ve sifre yi ilgili kutulara yazin  (anevzatcelik@gmail.com  pass: Nevzat152032)
        qualitydemyPage.emailBox.sendKeys("anevzatcelik@gmail.com");
        qualitydemyPage.passwordBox.sendKeys("Nevzat152032");
        Reusable.waitSeconds(1);

        // login butonuna basin
        qualitydemyPage.downLoginButton.click();
        Reusable.waitSeconds(1);
        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.successLogin.isDisplayed());

        // sayfayi kapatin
        Driver.closeDriver();


    }






}
