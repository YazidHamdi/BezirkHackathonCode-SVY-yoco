/**
 * Created by yazid on 22-Oct-16.
 */
import com.bezirk.middleware.messages.Event;

public class BaseEvent extends Event{
    //Sender
    private String senderId;
    public String SenderId()
    {
        return senderId;
    }

    //If receiver Id is empty then it's a broadcast event
    private String receiverId;
    public String ReceiverId()
    {
        return receiverId;
    }

    //Default constructor
    public BaseEvent() {
    }

    /**
     *
     * @param senderId Id of the sender
     * @param receiverId Id of the receiver
     */
    public BaseEvent(String senderId, String receiverId)
    {
        this.senderId = senderId;
        this.receiverId = receiverId;
    }
}
