import fan.Fan;
import org.junit.jupiter.api.Test;

import static fan.Speed.*;
import static org.junit.jupiter.api.Assertions.*;

class FanTest {
    @Test
    public void testThatIsOffWhenCreated(){
        Fan fan = new Fan();
        assertFalse(fan.isOn());
    }@Test
    public void testThatFanIsOnWhenTurnedOn(){
        Fan myFan = new Fan();
        myFan.on();
        assertTrue(myFan.isOn());
    }@Test
    public void testThatFanHasASpeedWhichByDefaultIsSlowValue(){
        Fan myFan = new Fan();
        assertSame(myFan.getSpeed(), SLOW.valueSpeed);
    }@Test
    public void testThatFanCanBeSetToAValueInSpeed(){
        Fan myFan = new Fan();
        myFan.setSpeed(MEDIUM.valueSpeed);
        assertSame(myFan.getSpeed(), MEDIUM.valueSpeed);
    }@Test
    public void thatTheDefaultRadiusOfAFanIs5_SetValueTo7(){
        Fan myFan = new Fan();
        assertEquals(myFan.getRadius(), 5);
        myFan.setRadius(7);
        assertEquals(7, myFan.getRadius());
    }@Test
    public void testThatFanHasAColorWhichIsDefaultBlueCanBeSetAndGet(){
        Fan myFan = new Fan();
        assertEquals("blue", myFan.getColor());
        myFan.setColor("red");
        assertEquals("red", myFan.getColor());
    }@Test
    public void testForThePrintingOfFanWhenItIsOn(){
        Fan myFan = new Fan();
        myFan.setSpeed(MAXIMUM.valueSpeed);
        myFan.setRadius(10);
        myFan.setColor("yellow");
        myFan.on();
        System.out.println(myFan.toString());
    }@Test
    public void testForThePrintingOfFanWhenItsNotON(){
        Fan myFan = new Fan();
        myFan.setSpeed(MAXIMUM.valueSpeed);
        myFan.setRadius(10);
        myFan.setColor("yellow");
        System.out.println(myFan);
    }

}