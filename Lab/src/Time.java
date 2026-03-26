//By Alper Eken and Samuel Schulze
public class Time {

    private int theHour = 0;
    private int theMinute = 0;
    private int theSecond = 0;

    protected String timeSet(int hour, int minute, int second) {
        if (hour >= 0 && hour < 24) {
            theHour = hour;
        } else if (hour == 24) {
            theHour = 0;
        } else {
            return "Invalid hour: " + hour + ". Must be 0-23";
        }

        if (minute >= 0 && minute < 60) {
            theMinute = minute;
        } else if (minute == 60) {
            theMinute = 0;
        } else {
            return "Invalid minute: " + minute + ". Must be 0-59";
        }

        if (second >= 0 && second < 60) {
            theSecond = second;
        } else if (second == 60) {
            theSecond = 0;
        } else {
            return "Invalid second: " + second + ". Must be 0-59";
        }

        return showTime();
    }

    protected String showTime() {
        return theHour + ":" + theMinute + ":" + theSecond;
    }
}