import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.addressing.ZirkEndPoint;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yazid on 22-Oct-16.
 */

public class Main {
    public static final String CentralHubId = "CH";
    public static void main(String args[]) throws InterruptedException {
        //Creating central hub
        CentralHubZirk centralHub = new CentralHubZirk(CentralHubId);

        //Creating listeners
        EventSet aliveEvents = new EventSet(AliveEvent.class);

        aliveEvents.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                //Check if this event is of interest
                if (event instanceof AliveEvent) {
                    final AliveEvent aliveEvent = (AliveEvent) event;
                    //do something in response to this event
                    if(aliveEvent.ReceiverId() == CentralHubId)
                        System.out.println("Alive received from: "+aliveEvent.SenderId());
                    }
                }
            });

        centralHub.getBezirk().subscribe(aliveEvents);

        //Sending loop
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(isSomeoneAtHome(centralHub.houseState)) {
                    System.out.println("Someone is at home");
                    centralHub.getBezirk().sendEvent(new HouseStateEvent("CH","",centralHub.houseState));
                }
                System.out.println("Someone home test!");
            }
        },0,3000);
    }

    //Returns whether someone is at home or not
    private static boolean isSomeoneAtHome(HouseState state){
        for(Person person:state.People){
            if(person.status != PersonStatus.out)
                return true;
        }
        return false;
    }
}
