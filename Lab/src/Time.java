public class Time {

    private int theHour;
    private int theMinute;
    private int theSecond;

    protected String timeSet(int hour, int minute, int second)
    {
        theHour = hour;
        theMinute = minute;
        theSecond = second;

        return showTime();
    }

    protected String showTime()
    {
        return theHour + ":" + theMinute + ":" + theSecond;
    }
}
