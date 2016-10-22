/**
 * Created by yazid on 22-Oct-16.
 */

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.core.proxy.Config;

public class BaseZirk {
    private Bezirk bezirk;
    public String zirkId;

    public BaseZirk() {
    }

    /**

     *
     * @param zirkName Name of this Zirk
     */
    public BaseZirk (String zirkName) {
        Config config = new Config.ConfigBuilder().setGroupName("SVY-yoco").create();
        BezirkMiddleware.initialize(config);
        bezirk = BezirkMiddleware.registerZirk(zirkName);

        //Give Bezirk 2 seconds to finish initializing
        try { Thread.sleep(2000); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
