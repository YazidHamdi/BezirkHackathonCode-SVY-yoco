/**
 * Created by yazid on 22-Oct-16.
 */

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.core.proxy.Config;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;

public class AsthmaAssistantZirk {

    public AsthmaAssistantZirk() {
        Config config = new Config.ConfigBuilder().setGroupName("SVY-yoco").create();
        BezirkMiddleware.initialize(config);
        final Bezirk bezirk = BezirkMiddleware.registerZirk("Asthma Assistant Zirk");

        EventSet airQualityEvents = new EventSet(AirQualityUpdateEvent.class);

        airQualityEvents.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                //Check if this event is of interest
                if (event instanceof AirQualityUpdateEvent) {
                    final AirQualityUpdateEvent aqUpdate = (AirQualityUpdateEvent) event;
                    System.out.println("\nReceived air quality update: " + aqUpdate.toString());
                    //do something in response to this event
                    if (aqUpdate.getHumidity() > 0.7) {
                        System.out.println("Humidity is high - recommend turning on the dehumidifier.");
                    }
                    if (aqUpdate.getDustLevel() > 20) {
                        System.out.println("Dust level is high - recommend running the vacuum.");
                    }
                    if (aqUpdate.getPollenLevel() > 500) {
                        System.out.println("Pollen level is high - recommend closing the windows and running the air filter.");
                    }
                }
            }
        });

        bezirk.subscribe(airQualityEvents);

    }

    public static void main (String args[]) {
        AsthmaAssistantZirk asthmaAssistantZirk = new AsthmaAssistantZirk();
        System.out.println("Listening for air quality update events...");
    }
}
