package observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {

    private List<Display> displays;
    private String newData;

    public WeatherStation() {
        this.displays = new ArrayList<>();
        this.newData = "";
    }

    public void register(Display display){
        this.displays.add(display);
    }

    public void unregister(Display display){
        this.displays.remove(display);
    }

    private void notifyObservers(){
        this.displays.forEach(display -> display.becomeNotified(newData));
    }

    public void next(String newData){
        this.newData = newData;
        this.notifyObservers();
    }
}
