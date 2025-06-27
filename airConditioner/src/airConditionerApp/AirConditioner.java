package airConditionerApp;

public class AirConditioner {
    private boolean isOn;
    private int temperature;

    public AirConditioner(int temperature) {
        this.temperature = temperature;
    }

    public void toggleSwitch() {
        isOn = !isOn;
    }

    public boolean isAcOn() {
        return isOn;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void increaseTemperature(int increment) {
        final int maxTemperature = 30;
        boolean temperatureIsValid = getTemperature() + increment <= maxTemperature;
        temperature = temperatureIsValid ? temperature + increment : maxTemperature;
    }

    public void decreaseTemperature(int decrement) {
        final int minTemperature = 16;
        boolean temperatureIsValid = getTemperature() - decrement  >= minTemperature;
        this.temperature = temperatureIsValid ? getTemperature() - decrement : minTemperature;
    }
}
