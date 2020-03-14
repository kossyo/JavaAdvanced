package observer_pattern;

public abstract class Display {

    public void becomeNotified(String newData){
        System.out.println(newData);
    }
}
