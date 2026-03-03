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
    void testTimesetExaktMinHour(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("0:0:0", clock.set(0, 0, 0));
    }

    @Test
    void testTimesetUnderMinHour(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("-1:0:0", clock.set(-1, 0, 0));
    }

    @Test
    void testTimesetExaktMaxHour(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("23:0:0", clock.set(23, 0, 0));
    }

    @Test
    void testTimesetOverMaxHour(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("-1:0:0", clock.set(25, 0, 0));
    }

    @Test
    void testTimesetExaktMinMinute(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("0:0:0", clock.set(0, 0, 0));
    }

    @Test
    void testTimesetUnderMinMinute(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("0:-1:0", clock.set(0, -1, 0));
    }

    @Test
    void testTimesetExaktMaxMinute(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("0:59:0", clock.set(0, 59, 0));
    }

    @Test
    void testTimesetOverMaxMinute(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("0:-1:0", clock.set(0, 61, 0));
    }

    @Test
    void testTimesetExaktMinSecond(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("0:0:0", clock.set(0, 0, 0));
    }

    @Test
    void testTimesetUnderMinSecond(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("0:0:-1", clock.set(0, 0, -1));
    }

    @Test
    void testTimesetExaktMaxSecond(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("0:0:59", clock.set(0, 0, 59));
    }

    @Test
    void testTimesetOverMaxSecond(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals("0:0:-1", clock.set(0, 0, 61));
    }
// --- DATE BVA TESTS (12 st) ---

    @Test
    void testDatesetExaktMinYear(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("2000-1-1", clock.set(2000, 1, 1));
    }

    @Test
    void testDatesetUnderMinYear(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("-1-1-1", clock.set(1999, 1, 1));
    }

    @Test
    void testDatesetExaktMaxYear(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("2100-1-1", clock.set(2100, 1, 1));
    }

    @Test
    void testDatesetOverMaxYear(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("-1-1-1", clock.set(2101, 1, 1));
    }

    @Test
    void testDatesetExaktMinMonth(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("2000-1-1", clock.set(2000, 1, 1));
    }

    @Test
    void testDatesetUnderMinMonth(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("2000--1-1", clock.set(2000, 0, 1));
    }

    @Test
    void testDatesetExaktMaxMonth(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("2000-12-1", clock.set(2000, 12, 1));
    }

    @Test
    void testDatesetOverMaxMonth(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("2000--1-1", clock.set(2000, 13, 1));
    }

    @Test
    void testDatesetExaktMinDay(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("2000-1-1", clock.set(2000, 1, 1));
    }

    @Test
    void testDatesetUnderMinDay(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("2000-1--1", clock.set(2000, 1, 0));
    }

    @Test
    void testDatesetExaktMaxDay(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("2000-1-31", clock.set(2000, 1, 31));
    }

    @Test
    void testDatesetOverMaxDay(){
        Clock clock = new Clock();
        clock.changeMode(); clock.ready();
        assertEquals("2000-1--1", clock.set(2000, 1, 32));
    }
}