import com.bezirk.middleware.messages.Event;

/**
 * Created by yazid on 22-Oct-16.
 */

public class Main {
    public static void main(String args[]){
        CentralHubZirk centralHub = new CentralHubZirk("CH");
        while(true) {
            if(isSomeoneAtHome(centralHub.houseState)) {
                System.out.println("Someone is at home");
                (BaseZirk)centralHub.bezirk
                (new HouseStateEvent("CH","",centralHub.houseState))
            }
        }
    }

    //Returns whether someone is at home or not
    private static boolean isSomeoneAtHome(HouseState state){
        for(Person person:state.People){
            if(person.status == PersonStatus.in || person.status == PersonStatus.asleep)
                return true;
        }
        return false;
    }
}
