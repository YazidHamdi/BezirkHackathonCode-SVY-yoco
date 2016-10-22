/**
 * Created by yazid on 22-Oct-16.
 */

/**
 * Broadcast the status of the house to all phones
 */
public class HouseStateEvent extends BaseEvent {
    public HouseStateEvent(String senderId, String receiverId, HouseState houseState) {
        super(senderId, receiverId);
        this.houseState = houseState;
    }

    public HouseStateEvent() {
    }

    public HouseState houseState;
}