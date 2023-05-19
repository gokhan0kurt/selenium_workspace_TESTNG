import org.testng.annotations.Test;

public class CG01_Priority {

    //  TestNG testleri harf sirasina gore calistirir (ONGORULEBILIR)

    //  priority sayisal olarak kucukten buyuge dogru testleri calistirir
    //  eger priority degeri ayni olan birden fazla test varsa, yine harf sirasina bakar



    @Test(priority = -4)
    public void testYoutube(){
        System.out.println("youtube");
    }


    @Test                       // priority yazilmazsa 0 degeri alir
    public void testShopify(){
        System.out.println("shopify");
    }

    @Test(priority = 1)
    public void testAmazon(){
        System.out.println("amazon");
    }
}
