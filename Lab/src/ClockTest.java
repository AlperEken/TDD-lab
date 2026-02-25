import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ClockTest {


    @Test
    void readyTestTime()
    {
        Clock clock = new Clock();

        assertEquals(States.Change_Time.toString(), clock.ready());
    }

    @Test
    void readyTestDateInvalid(){
        Clock clock = new Clock();

        clock.ready();

        assertEquals("Invalid Mode", clock.ready());
    }

    @Test
    void readyTestDate()
    {
        Clock clock = new Clock();

        clock.changeMode();

        assertEquals(States.Change_Date.toString(), clock.ready());

    }


    @Test
    void changeModeS1toS2(){
        Clock clock = new Clock();

        assertEquals(States.Display_Date.toString(), clock.changeMode());
    }

    @Test
    void changeModeS2toS1(){
        Clock clock = new Clock();

        clock.changeMode();

        assertEquals(States.Display_Time.toString(), clock.changeMode());
    }

    @Test
    void changeModeInvalid(){
        Clock clock = new Clock();

        clock.ready();

        assertEquals("Invalid Mode", clock.changeMode());
    }

}