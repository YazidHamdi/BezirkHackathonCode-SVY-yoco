/**
 * Created by yazid on 21-Oct-16.
 */

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

public class HelloWorld {
    public static void main(String args[]){
        BezirkMiddleware.initialize();
        Bezirk bezirk = BezirkMiddleware.registerZirk("Hello World Zirk");
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        HelloWorldEvent helloWorldEvent = new HelloWorldEvent();
        helloWorldEvent.helloText = "Hi world, how are you!";
        bezirk.sendEvent(helloWorldEvent);
        System.out.println("Published Hello World Message: " + helloWorldEvent.helloText);
    }
}
