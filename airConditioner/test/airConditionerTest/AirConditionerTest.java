package airConditionerTest;

import airConditionerApp.AirConditioner;
import airConditionerApp.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest {
    AirConditioner samsung;
    Person james;

    @BeforeEach
    public void setUp() {
        samsung = new AirConditioner();
        james = new Person(samsung);
    }

    @Test
    public void testAirConditioner_IsOn() {
        assertFalse(james.checkAcIsOn());

        james.toggleAcSwitch();
        assertTrue(james.checkAcIsOn());
    }

    @Test
    public void testAirConditioner_IsOff() {
        james.toggleAcSwitch();
        assertTrue(james.checkAcIsOn());

        james.toggleAcSwitch();
        assertFalse(james.checkAcIsOn());
    }

    @Test
    public void testTemperatureIncreases() {
        james.toggleAcSwitch();
        assertTrue(james.checkAcIsOn());
        assertEquals(24, james.checkAcTemperature());

        james.increaseAcTemperature(5);
        assertEquals(29, james.checkAcTemperature());
    }

    @Test
    public void testTemperatureDecreases() {
        james.toggleAcSwitch();
        assertTrue(james.checkAcIsOn());
        assertEquals(24, james.checkAcTemperature());

        james.decreaseAcTemperature(5);
        assertEquals(19, james.checkAcTemperature());
    }

    @Test
    public void testIncreaseTemperatureBeyond30_temperatureRemains30() {
        james.toggleAcSwitch();
        assertTrue(james.checkAcIsOn());
        james.increaseAcTemperature(6);
        assertEquals(30, james.checkAcTemperature());

        james.increaseAcTemperature(10);
        assertEquals(30, james.checkAcTemperature());
    }

    @Test
    public void testDecreaseTemperatureBelow16_temperatureRemains16() {
        james.toggleAcSwitch();
        assertTrue(james.checkAcIsOn());
        james.decreaseAcTemperature(4);
        assertEquals(20, james.checkAcTemperature());

        james.decreaseAcTemperature(10);
        assertEquals(16, james.checkAcTemperature());
    }
}
