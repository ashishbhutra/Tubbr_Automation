package components;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class StepLogger {
    // public //String stepIdVar ;
    // Initialize Log4j logs
    private static Logger Log = Logger.getLogger(StepLogger.class.getName());

    public void commonLogger(String operation, String step){
        String message = operation + "-" + step;
        Log.info(message);
    }

    public void step(String stepName) {
        this.commonLogger("Step", stepName);
    }

    public StepLogger() {
        DOMConfigurator.configure("log4j.xml");
    }
}
