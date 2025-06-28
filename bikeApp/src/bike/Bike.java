package bike;

public class Bike {
    private boolean isBikeTurnedOn;
    private float bikeSpeed;
    private int gear = 1;

    public boolean getPowerStatus() {
        return isBikeTurnedOn;
    }

    public void togglePower() {
        isBikeTurnedOn = !isBikeTurnedOn;
    }

    public float getSpeed() {
        return bikeSpeed;
    }

    public int getCurrentGear() {
        boolean speedExceeds20 = bikeSpeed > 20;
        boolean speedExceeds30 = bikeSpeed > 30;
        boolean speedExceeds40 = bikeSpeed > 40;

        if (speedExceeds40) gear = 4;
        else if (speedExceeds30) gear = 3;
        else if (speedExceeds20) gear = 2;
        else gear = 1;
        return gear;
    }

    public void accelerate(int currentGear) {
        bikeSpeed += currentGear;
    }

    public void decelerate(int currentGear) {
        bikeSpeed -= currentGear;
    }
}