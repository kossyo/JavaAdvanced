package observer_pattern;

public class Main {
    public static void main(String[] args) {

        Display tvDisplay = new TVDisplay();
        Display iPhoneDisplay = new SmartPhoneDisplay();

        WeatherStation station = new WeatherStation();
        station.register(tvDisplay);
        station.register(iPhoneDisplay);
        station.next("Sudski spor");

        Display samsungDisplay = new SmartPhoneDisplay();
        station.register(samsungDisplay);
        station.next("Vsi4ki da stanat, vliza sydiq Ivan Sotirov");

    }
}
