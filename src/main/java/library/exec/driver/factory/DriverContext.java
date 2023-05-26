package library.exec.driver.factory;

import java.util.ArrayList;
import java.util.List;

public class DriverContext {

    private static List<DriverContext> threads = new ArrayList<DriverContext>();
    private long threadToEnvID;
    private boolean	keepBrowserOpen=false;

    private DriverContext() {

    }

    private DriverContext(long threadID){
        this.threadToEnvID = threadID;
    }

    public static synchronized DriverContext getInstance(){
        long currentRunningThreadID = Thread.currentThread().getId();
        for(DriverContext thread : threads){
            if (thread.threadToEnvID == currentRunningThreadID){
                return thread;
            }
        }
        DriverContext temp = new DriverContext(currentRunningThreadID);
        threads.add(temp);
        return temp;
    }
}
