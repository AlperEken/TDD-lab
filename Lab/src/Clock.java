public class Clock {

    private Time theTime;
    private Date theDate;
    private States state;

    public Clock() {
        state = States.Display_Time;
        theTime = new Time();
        theDate = new Date();
    }

    public String changeMode() {
        switch (state) {
            case Display_Time:
                state = States.Display_Date;
                return state.toString();
            case Display_Date:
                state = States.Display_Time;
                return state.toString();
            case Change_Time:
            case Change_Date:
                return "Invalid state";
            default:
                return "Error";
        }
    }

    public String ready() {
        switch (state) {
            case Display_Time:
                state = States.Change_Time;
                return state.toString();
            case Display_Date:
                state = States.Change_Date;
                return state.toString();
            case Change_Time:
            case Change_Date:
                return "Invalid state";
            default:
                return "Error";
        }
    }

    public String set(int p1, int p2, int p3) {
        switch (state) {
            case Change_Time:
                String timeResult = theTime.timeSet(p1, p2, p3);
                state = States.Display_Time;
                return timeResult;
            case Change_Date:
                String dateResult = theDate.dateSet(p1, p2, p3);
                state = States.Display_Date;
                return dateResult;
            case Display_Time:
            case Display_Date:
                return "Invalid state";
            default:
                return "Error";
        }
    }
}