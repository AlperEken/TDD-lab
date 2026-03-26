//By Alper Eken and Samuel Schulze
public class Date {
    private int theYear = 2000;
    private int theMonth = 1;
    private int theDay = 1;


    protected String dateSet(int year, int month, int day) {
        if (year >= 2000 && year <= 2100) {
            theYear = year;
        } else {
            return "Invalid year: " + year + ". Must be 2000-2100";
        }

        if (month >= 1 && month <= 12) {
            theMonth = month;
        } else {
            return "Invalid month: " + month + ". Must be 1-12";
        }

        if (day >= 1 && day <= 31) {
            theDay = day;
        } else {
            return "Invalid day: " + day + ". Must be 1-31";
        }

        return showDate();
    }

    protected String showDate() {
        return theYear + "-" + theMonth + "-" + theDay;
    }
}