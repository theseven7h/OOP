package airConditionerApp;

public class Person {
    private final AirConditioner airConditioner;

    public Person(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    public boolean checkAcIsOn() {
        return airConditioner.isAcOn();
    }

    public void toggleAcSwitch() {
        airConditioner.toggleSwitch();
    }

    public int checkAcTemperature() {
        return airConditioner.getTemperature();
    }

    public void increaseAcTemperature(int increment) {
        airConditioner.increaseTemperature(increment);
    }

    public void decreaseAcTemperature(int decrement) {
        airConditioner.decreaseTemperature(decrement);
    }
}
