/**
 * Created by yazid on 22-Oct-16.
 */

import java.util.List;

/**
 * Updates tasks in the house
 */
public class UpdateTasksEvent extends BaseEvent {
    public UpdateTasksEvent(List<Task> tasks) {
        this.tasks = tasks;
    }

    public UpdateTasksEvent() {
    }

    public UpdateTasksEvent(String senderId, String receiverId, List<Task> tasks) {
        super(senderId, receiverId);
        this.tasks = tasks;
    }

    public List<Task> tasks;
}
