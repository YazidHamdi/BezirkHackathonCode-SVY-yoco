import java.util.List;

/**
 * Created by yazid on 22-Oct-16.
 */

public class HouseState {
    //People
    public List<Person> People;

    //Tasks
    public  List<Task> Tasks;

    /**
     *
     * @param people People
     * @param tasks Tasks
     */
    public HouseState(List<Person> people, List<Task> tasks) {
        People = people;
        Tasks = tasks;
    }
}