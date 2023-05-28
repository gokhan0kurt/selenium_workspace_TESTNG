package tests.test04;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HerokuappPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class CG14_JSAlertTestwithReport extends TestBaseReport {

    @Test
    public void alertTest(){
        extentTest = extentReports.createTest("Alert test",
                "Kullanici JS alert'leri calistirabilmeli ve kapatabilmeli");


        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        extentTest.info("Kullanici herokuapp alerts sayfasina gider");

        //1.alert'e tiklayin
        ReusableMethods.waitSeconds(2);

        HerokuappPage herokuappPage = new HerokuappPage();
        herokuappPage.jsAlert.click();
        extentTest.info("Ilk alert butonuna click yapar");

        //Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        ReusableMethods.waitSeconds(2);

        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();

        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals(actualAlertYazisi,expectedAlertYazisi,"alertteki yazi belirlenenden farkli");
        extentTest.info("softassert ile alert yazisinin beklenen degere sahip oldugunu test eder");

        //OK tusuna basip alert'i kapatin

        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("alert'i kapatir");

        // alert'in kapatildigini test edin


        softAssert.assertTrue(herokuappPage.jsAlert.isEnabled(),"alert kapatilamadi");
        extentTest.info("soft assert ile alert'in kapatildigini test eder");

        softAssert.assertAll();
        extentTest.pass("soft assert ile yapilan tum testlerin sonucunu raporlar");
        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");


    }


}
