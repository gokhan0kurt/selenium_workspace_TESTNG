package tests.test04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class CG16_DataProvider {


    @DataProvider
    public static Object[][] userInfos() {

        String [][] userNamePassArr= {{"Thomas Anderson","123456"},{"Ajan Smith","0829391"},
                                      {"The Architect","92039103"},{"Merovingian","85943341"}};

        return userNamePassArr;
    }



    @Test(dataProvider = "userInfos")
    public void invalidUsernameTest01(String username ,String password){
        // Qualitydemy sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.upLoginButton.click();

        // gecersiz username ve gecerli sifre yi ilgili kutulara yazin
        qualitydemyPage.emailBox.sendKeys(username);
        qualitydemyPage.passwordBox.sendKeys(password);
        ReusableMethods.waitSeconds(1);

        // login butonuna basin
        qualitydemyPage.downLoginButton.click();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailBox.isEnabled());

        ReusableMethods.waitSeconds(1);
        // sayfayi kapatin
        Driver.closeDriver();

    }




}
