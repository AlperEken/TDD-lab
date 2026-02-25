public class Time {

    private int theHour;
    private int theMinute;
    private int theSecond;

    public Time() {
        this.theHour = 0;
        this.theMinute = 0;
        this.theSecond = 0;
    }

    protected String timeSet(int hour, int minute, int second) {
        theHour = hour;
        theMinute = minute;
        theSecond = second;

        return showTime();
    }

    protected String showTime() {
        return theHour + ":" + theMinute + ":" + theSecond;
    }
}