public class Date {
    private int theYear;
    private int theMonth;
    private int theDay;

    protected String dateSet(int year, int month, int day)
    {
        theYear = year;
        theMonth = month;
        theDay = day;

        return showDate();
    }

    protected String showDate()
    {
        return theYear + "-" + theMonth + "-" + theDay;
    }
}
