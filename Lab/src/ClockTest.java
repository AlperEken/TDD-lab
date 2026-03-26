//By Alper Eken and Samuel Schulze
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClockTest {

    private Clock clock;

    @BeforeEach
    void setUp() {
        clock = new Clock();
    }

    @Test
    void testS1toS3Ready() {
        assertEquals(States.Change_Time.toString(), clock.ready());
    }

    @Test
    void testS2toS4Ready() {
        clock.changeMode();
        assertEquals(States.Change_Date.toString(), clock.ready());
    }

    @Test
    void testS1toS2ChangeMode() {
        assertEquals(States.Display_Date.toString(), clock.changeMode());
    }

    @Test
    void testS2toS1ChangeMode() {
        clock.changeMode();
        assertEquals(States.Display_Time.toString(), clock.changeMode());
    }

    @Test
    void testS3toS1SetValid() {
        clock.ready();
        assertEquals("10:15:30", clock.set(10, 15, 30));
    }

    @Test
    void testS4toS1SetValid() {
        clock.changeMode(); clock.ready();
        assertEquals("2025-12-24", clock.set(2025, 12, 24));
    }

    @Test
    void testS3toS3IllegalReady() {
        clock.ready();
        assertEquals("Already in setting mode", clock.ready());
    }

    @Test
    void testS4toS4IllegalReady() {
        clock.changeMode(); clock.ready();
        assertEquals("Already in setting mode", clock.ready());
    }

    @Test
    void testS3IllegalChangeMode() {
        clock.ready();
        assertEquals("Cannot change mode while in setting mode", clock.changeMode());
    }

    @Test
    void testS4IllegalChangeMode() {
        clock.changeMode(); clock.ready();
        assertEquals("Cannot change mode while in setting mode", clock.changeMode());
    }

    @Test
    void testS1IllegalSet() {
        assertEquals("Must be in a setting mode to set values", clock.set(12, 0, 0));
    }

    @Test
    void testS2IllegalSet() {
        clock.changeMode();
        assertEquals("Must be in a setting mode to set values", clock.set(2024, 1, 1));
    }

    @Test
    void testS3HourMinBoundary() {
        clock.ready();
        assertEquals("0:0:0", clock.set(0, 0, 0));
    }

    @Test
    void testS3HourUnderMinBoundary() {
        clock.ready();
        assertEquals("Invalid hour: -1. Must be 0-23", clock.set(-1, 0, 0));
    }

    @Test
    void testS3HourMaxBoundary() {
        clock.ready();
        assertEquals("23:0:0", clock.set(23, 0, 0));
    }

    @Test
    void testS3HourOverMaxBoundary() {
        clock.ready();
        assertEquals("Invalid hour: 25. Must be 0-23", clock.set(25, 0, 0));
    }

    @Test
    void testS3MinuteMinBoundary() {
        clock.ready();
        assertEquals("0:0:0", clock.set(0, 0, 0));
    }

    @Test
    void testS3MinuteUnderMinBoundary() {
        clock.ready();
        assertEquals("Invalid minute: -1. Must be 0-59", clock.set(0, -1, 0));
    }

    @Test
    void testS3MinuteMaxBoundary() {
        clock.ready();
        assertEquals("0:59:0", clock.set(0, 59, 0));
    }

    @Test
    void testS3MinuteOverMaxBoundary() {
        clock.ready();
        assertEquals("Invalid minute: 61. Must be 0-59", clock.set(0, 61, 0));
    }

    @Test
    void testS3SecondMinBoundary() {
        clock.ready();
        assertEquals("0:0:0", clock.set(0, 0, 0));
    }

    @Test
    void testS3SecondUnderMinBoundary() {
        clock.ready();
        assertEquals("Invalid second: -1. Must be 0-59", clock.set(0, 0, -1));
    }

    @Test
    void testS3SecondMaxBoundary() {
        clock.ready();
        assertEquals("0:0:59", clock.set(0, 0, 59));
    }

    @Test
    void testS3SecondOverMaxBoundary() {
        clock.ready();
        assertEquals("Invalid second: 61. Must be 0-59", clock.set(0, 0, 61));
    }

    @Test
    void testS4YearMinBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("2000-1-1", clock.set(2000, 1, 1));
    }

    @Test
    void testS4YearUnderMinBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("Invalid year: 1999. Must be 2000-2100", clock.set(1999, 1, 1));
    }

    @Test
    void testS4YearMaxBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("2100-1-1", clock.set(2100, 1, 1));
    }

    @Test
    void testS4YearOverMaxBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("Invalid year: 2101. Must be 2000-2100", clock.set(2101, 1, 1));
    }

    @Test
    void testS4MonthMinBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("2000-1-1", clock.set(2000, 1, 1));
    }

    @Test
    void testS4MonthUnderMinBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("Invalid month: 0. Must be 1-12", clock.set(2000, 0, 1));
    }

    @Test
    void testS4MonthMaxBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("2000-12-1", clock.set(2000, 12, 1));
    }

    @Test
    void testS4MonthOverMaxBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("Invalid month: 13. Must be 1-12", clock.set(2000, 13, 1));
    }

    @Test
    void testS4DayMinBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("2000-1-1", clock.set(2000, 1, 1));
    }

    @Test
    void testS4DayUnderMinBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("Invalid day: 0. Must be 1-31", clock.set(2000, 1, 0));
    }

    @Test
    void testS4DayMaxBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("2000-1-31", clock.set(2000, 1, 31));
    }

    @Test
    void testS4DayOverMaxBoundary() {
        clock.changeMode(); clock.ready();
        assertEquals("Invalid day: 32. Must be 1-31", clock.set(2000, 1, 32));
    }

    @Test
    void testS3Exactly24Hour() {
        clock.ready();
        assertEquals("0:0:0", clock.set(24, 0, 0));
    }

    @Test
    void testS3Exactly60Minute() {
        clock.ready();
        assertEquals("0:0:0", clock.set(0, 60, 0));
    }

    @Test
    void testS3Exactly60Second() {
        clock.ready();
        assertEquals("0:0:0", clock.set(0, 0, 60));
    }
}