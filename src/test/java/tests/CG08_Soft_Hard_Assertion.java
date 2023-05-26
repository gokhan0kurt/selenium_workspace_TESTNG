package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CG08_Soft_Hard_Assertion {


    @Test
    public void hardAssertion(){

        int number = 44 ;

        Assert.assertTrue(number %2 == 0,"sayi 2 ile bolunebilmeli");
        Assert.assertTrue(number > 50 ,"sayi 50'den buyuk olmali");
        Assert.assertTrue(number < 100,"sayi 100'den kucuk olmali");
        Assert.assertFalse(number % 3 == 0,"sayi 3 ile bolunememeli");

    }

    @Test
    public void softAssertion(){
        int number = 42 ;

        SoftAssert softAssert =new SoftAssert();

        softAssert.assertTrue(number %2 == 0,"sayi 2 ile bolunebilmeli");
        softAssert.assertTrue(number > 50 ,"sayi 50'den buyuk olmali");
        softAssert.assertTrue(number < 100,"sayi 100'den kucuk olmali");
        softAssert.assertFalse(number % 3 == 0,"sayi 3 ile bolunememeli");

        softAssert.assertAll();


        /*
            SoftAssert class'i sayesinde
            assertAll()'nun calisacagi satira kadar
            failed olan olsa bile, tum assertion'lar calismaya devam eder.

            assertAll() calistiginda
            failed olan assertion'lara ait raporu verir
            ANCAK hangi satirda olduklarini vermez

            Selenium hata mesaji da assertAll()'un bulundugu satiri isaret eder.

            Failed olan assertion'lari kolaylikla bulabilmemiz icin

             softAssert objesi ile assertion'lari yaptiktan sonra
             assertAll() kullanmazsaniz, test direk PASSED olur,
             failed olan assertion'lar raporlanmaz

         */

    }

}
