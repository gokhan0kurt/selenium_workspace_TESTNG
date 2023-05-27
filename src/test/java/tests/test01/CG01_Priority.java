package tests.test01;

import org.testng.annotations.Test;

public class CG01_Priority {

    //  TestNG testleri harf sirasina gore calistirir (ONGORULEBILIR)

    //  priority sayisal olarak kucukten buyuge dogru testleri calistirir
    //  eger priority degeri ayni olan birden fazla test varsa, yine harf sirasina bakar



    @Test(priority = -3,groups = "smoke")
    public void testYoutube(){
        System.out.println("youtube");
    }


    @Test(groups = "minireg01")                       // priority yazilmazsa 0 degeri alir
    public void testShopify(){
        System.out.println("shopify");
    }

    @Test(groups = {"smoke","minireg01"})
    public void testAmazon(){
        System.out.println("amazon");
    }
}
