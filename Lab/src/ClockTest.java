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

        assertEquals("Invalid state", clock.ready());
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

        assertEquals("Invalid state", clock.changeMode());
    }

    @Test
    void testTimesetUnderMinTime(){
        Clock clock = new Clock();
        clock.ready();

        assertEquals("-1:-1:-1", clock.set(-1, -1, -1));
    }

    @Test
    void testTimesetExactMinTime(){
        Clock clock = new Clock();
        clock.ready();

        assertEquals("0:0:0", clock.set(0, 0, 0));
    }

    @Test
    void testTimesetExactMaxTime(){
        Clock clock = new Clock();
        clock.ready();

        assertEquals("23:59:59", clock.set(23, 59, 59));
    }

    @Test
    void testTimesetAtResetLimit(){
        Clock clock = new Clock();
        clock.ready();

        assertEquals("0:0:0", clock.set(24, 60, 60));
    }

    @Test
    void testTimesetOverMaxTime(){
        Clock clock = new Clock();
        clock.ready();

        assertEquals("-1:-1:-1", clock.set(25, 61, 61));
    }

    @Test
    void testDatesetExaktBelowYear(){
        Clock clock = new Clock();

        clock.changeMode();
        clock.ready();

        assertEquals("2000-1-1", clock.set(2000, 01, 01));
    }

    @Test
    void testDatesetBelowMaxYear(){
        Clock clock = new Clock();

        clock.changeMode();
        clock.ready();

        assertEquals("2099-11-30", clock.set(2099, 11, 30));
    }

    @Test
    void testDatesetExaktMaxYear(){
        Clock clock = new Clock();

        clock.changeMode();
        clock.ready();

        assertEquals("2100-12-31", clock.set(2100, 12, 31));
    }

    @Test
    void testDatesetOverMaxYear(){
        Clock clock = new Clock();

        clock.changeMode();
        clock.ready();

        assertEquals("-1--1--1", clock.set(2101, 13, 32));
    }

    @Test
    void testTimesetInvalid(){
        Clock clock = new Clock();

        assertEquals("Invalid state", clock.set(01, 02, 03));
    }

    @Test
    void testDatesetInvalid(){
        Clock clock = new Clock();

        clock.changeMode();

        assertEquals("Invalid state", clock.set(01, 02, 03));
    }
}