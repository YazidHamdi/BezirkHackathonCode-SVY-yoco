/**
 * Created by yazid on 22-Oct-16.
 */
import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.core.proxy.Config;

public class AirQualitySensorZirk {
    private Bezirk bezirk;
    public AirQualitySensorZirk () {
        Config config = new Config.ConfigBuilder().setGroupName("SVY-yoco").create();
        BezirkMiddleware.initialize(config);
        bezirk = BezirkMiddleware.registerZirk("Air Quality Sensor Zirk");
        System.out.println("Got Bezirk instance");
        try { Thread.sleep(2000); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void sendAirQualityUpdate() {
        final double humidity = 0.8;
        final int dustLevel = 30;
        final int pollenLevel = 1000;
        final AirQualityUpdateEvent airQualityUpdateEvent = new AirQualityUpdateEvent(humidity, dustLevel, pollenLevel);

        bezirk.sendEvent(airQualityUpdateEvent);

        System.out.println("Published air quality update: " + airQualityUpdateEvent.toString());
    }
}