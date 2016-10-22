/**
 * Created by yazid on 22-Oct-16.
 */

/**
 * Sets a person's asleep status (on/off)
 */
public class SetAsleepEvent extends BaseEvent {
    public boolean asleep;

    public SetAsleepEvent(boolean asleep) {
        this.asleep = asleep;
    }

    public SetAsleepEvent() {
    }

    public SetAsleepEvent(String senderId, String receiverId, boolean asleep) {
        super(senderId, receiverId);
        this.asleep = asleep;
    }
}
