package observer_pattern;

public class SmartPhoneDisplay extends Display {

    @Override
    public void becomeNotified(String newData) {

        System.out.print("Smart Phone: ");
        super.becomeNotified(newData);
    }
}
