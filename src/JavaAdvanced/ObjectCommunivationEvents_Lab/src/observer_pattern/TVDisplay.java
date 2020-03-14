package observer_pattern;

public class TVDisplay extends Display {

    @Override
    public void becomeNotified(String newData) {

        System.out.print("TV: ");
        super.becomeNotified(newData);
    }
}
