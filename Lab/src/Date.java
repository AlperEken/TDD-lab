public class Date {
    private int theYear;
    private int theMonth;
    private int theDay;
    public Date() {
        this.theYear = 2000;
        this.theMonth = 1;
        this.theDay = 1;
    }

    protected String dateSet(int year, int month, int day) {
        theYear = year;
        theMonth = month;
        theDay = day;

        return showDate();
    }

    protected String showDate() {
        return theYear + "-" + theMonth + "-" + theDay;
    }
}