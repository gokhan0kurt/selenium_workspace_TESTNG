package utilities;

public class Reusable {

    public static void waitSeconds(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {

        }
    }


}
