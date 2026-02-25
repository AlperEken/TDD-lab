public class Date {
    private int theYear = 2000;
    private int theMonth = 1;
    private int theDay = 1;


    protected String dateSet(int year, int month, int day) {
        if (year >= 2000 && year <= 2100) {
            theYear = year;
        } else {
            theYear = -1;
        }

        if (month >= 1 && month <= 12) {
            theMonth = month;
        } else {
            theMonth = -1;
        }

        if (day >= 1 && day <= 31) {
            theDay = day;
        } else {
            theDay = -1;
        }

        return showDate();
    }

    protected String showDate() {
        return theYear + "-" + theMonth + "-" + theDay;
    }
}