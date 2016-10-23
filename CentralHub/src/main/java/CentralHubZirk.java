import java.util.ArrayList;
import java.util.List;

/**
 * Created by yazid on 22-Oct-16.
 */

public class CentralHubZirk extends BaseZirk{
    public HouseState houseState;

    public CentralHubZirk(String zirkName) {
        super(zirkName);
        List<Person> people = new ArrayList<Person>();
        for(String name:new String[]{"Vignesh", "Yazid"}){
            people.add(new Person(name.toLowerCase()+"phone",name,PersonStatus.out));
        }
        List<Task> tasks = new ArrayList<Task>();
        houseState = new HouseState(people,tasks);
    }
}