import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class CG02_Ignore {

     /*
            @Ignore notasyonu
            basina yazdigi testin Ignore edilmesini saglar
     */


    @Test(priority = -4)
    public void testYoutube(){
        System.out.println("youtube");
    }


    @Test @Ignore
    public void testShopify(){
        System.out.println("shopify");
    }

    @Test(priority = 1)
    public void testAmazon(){
        System.out.println("amazon");
    }
}
