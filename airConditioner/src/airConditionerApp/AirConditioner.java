package airConditionerApp;

public class AirConditioner {
    private boolean isOn;
    private int temperature;

    public AirConditioner() {
        int DEFAULT_TEMPERATURE = 24;
        temperature = DEFAULT_TEMPERATURE;
    }

    public void toggleSwitch() {
        isOn = !isOn;
    }

    public boolean isAcOn() {
        return isOn;
    }

    public int getTemperature() {
        return temperature;
    }

    public void increaseTemperature(int increment) {
        final int maxTemperature = 30;
        boolean temperatureIsValid = temperature + increment <= maxTemperature;
        temperature = temperatureIsValid ? temperature + increment : maxTemperature;
    }

    public void decreaseTemperature(int decrement) {
        final int minTemperature = 16;
        boolean temperatureIsValid = temperature - decrement  >= minTemperature;
        temperature = temperatureIsValid ? getTemperature() - decrement : minTemperature;
    }
}
