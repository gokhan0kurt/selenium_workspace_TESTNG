import org.testng.annotations.Test;

public class CG04_DependsOnMethod {


    /*
    DependsOnmethods oncelik sirasina karismaz

    dependsOnMethods bir test method'un calismasini
    baska bir method'un calisip passed olmasina baglar

    baglanilan method calismaz veya calisir ama failed olursa
    baglanan method hic calismaz


  */



    @Test(priority = -4)
    public void testYoutube(){
        System.out.println("youtube");
    }


    @Test(dependsOnMethods = "testAmazon")
    public void testShopify(){
        System.out.println("shopify");


        // Normal priority deger 0 oldugu icin ilk bi test calismali
        // Ancak dependson methodu ile bunun calismasi Amazontestine baglandi
        // o test calismadan bu test calismayacaktir
    }

    @Test(dependsOnMethods = "testYoutube")
    public void testAmazon(){
        System.out.println("amazon");
        // Assert.assertTrue(8==3);  // failed olma durumunda bu teste bagli testler hic calistirilmaz
    }

    /*
    @Test sayesinde her test bagimsiz olarak calistirilabilir

        Ancak bir test dependsOnMethods ile baska bir method'a baglanmis ise
        tek basina calismasi istendiginde, once bagli oldugu test method'unu calistirir
        o method calisip passed olursa asil calistirmak istedigimiz method'da calisir

        bu baglanti 3 veya daha fazla method arasinda olursa
        yani calistirmak istedigimiz method baska bir method'a,
        o da baska bir method'a bagli ise
        3'u birden calismaz
        "No tests were found" yazar ve hic bir test method'u calismaz
     */

}
