package bikeTest;

import bike.Bike;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeTest {
    Bike myBike;

    @BeforeEach
    public void setUp() {
        myBike = new Bike();
    }

    @Test
    public void testBikeTurnsOn() {
        assertFalse(myBike.getPowerStatus());

        myBike.togglePower();
        assertTrue(myBike.getPowerStatus());
    }

    @Test
    public void testBikeTurnsOff() {
        assertFalse(myBike.getPowerStatus());
        myBike.togglePower();
        assertTrue(myBike.getPowerStatus());

        myBike.togglePower();
        assertFalse(myBike.getPowerStatus());
    }

    @Test
    public void testBikeAcceleratesAccordingToGear() {
        myBike.togglePower();
        assertTrue(myBike.getPowerStatus());
        int currentGear = 1;

        myBike.accelerate(currentGear);
        assertEquals(1, myBike.getSpeed());

        for(int accelerate = 0; accelerate < 20; accelerate++) myBike.accelerate(currentGear);
        assertEquals(21, myBike.getSpeed());

        currentGear = 2;
        for(int accelerate = 0; accelerate < 5; accelerate++) myBike.accelerate(currentGear);
        assertEquals(31, myBike.getSpeed());

        currentGear = 3;
        for(int accelerate = 0; accelerate < 4; accelerate++) myBike.accelerate(currentGear);
        assertEquals(43, myBike.getSpeed());

        currentGear = 4;
        myBike.accelerate(currentGear);
        assertEquals(47, myBike.getSpeed());
    }

    @Test
    public void testBikeDeceleratesAccordingToGear() {
        myBike.togglePower();
        assertTrue(myBike.getPowerStatus());
        int currentGear = 4;
        for(int acceleration = 0; acceleration < 10; acceleration++) myBike.accelerate(currentGear);
        assertEquals(40, myBike.getSpeed());

        myBike.decelerate(currentGear);
        assertEquals(36, myBike.getSpeed());

        currentGear = 3;
        for(int deceleration = 0; deceleration < 2; deceleration++) myBike.decelerate(currentGear);
        assertEquals(30,  myBike.getSpeed());

        currentGear = 2;
        for(int deceleration = 0; deceleration < 5; deceleration++) myBike.decelerate(currentGear);
        assertEquals(20, myBike.getSpeed());

        currentGear = 1;
        for(int deceleration = 0; deceleration < 5; deceleration++) myBike.decelerate(currentGear);
        assertEquals(15, myBike.getSpeed());
    }

    @Test
    public void testGearSpeedRanges() {
        myBike.togglePower();
        assertTrue(myBike.getPowerStatus());


        assertEquals(1, myBike.getCurrentGear());
        for(int acceleration = 0; acceleration < 20; acceleration++) myBike.accelerate(myBike.getCurrentGear());
        assertEquals(20, myBike.getSpeed());

        myBike.accelerate(myBike.getCurrentGear());
        assertEquals(21, myBike.getSpeed());
        assertEquals(2, myBike.getCurrentGear());

        for(int acceleration = 0; acceleration < 5; acceleration++) myBike.accelerate(myBike.getCurrentGear());
        assertEquals(31, myBike.getSpeed());
        assertEquals(3, myBike.getCurrentGear());

        for(int acceleration = 0; acceleration < 4; acceleration++) myBike.accelerate(myBike.getCurrentGear());
        assertEquals(43, myBike.getSpeed());
        assertEquals(4, myBike.getCurrentGear());

        myBike.decelerate(myBike.getCurrentGear());
        assertEquals(39, myBike.getSpeed());
        assertEquals(3, myBike.getCurrentGear());

        for(int deceleration = 0; deceleration < 3; deceleration++) myBike.decelerate(myBike.getCurrentGear());
        assertEquals(30, myBike.getSpeed());
        assertEquals(2, myBike.getCurrentGear());

        for(int deceleration = 0; deceleration < 5; deceleration++) myBike.decelerate(myBike.getCurrentGear());
        assertEquals(20, myBike.getSpeed());
        assertEquals(1, myBike.getCurrentGear());
    }
}
