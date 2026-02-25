public class Clock {

    private Time theTime;
    private Date theDate;
    private States state;

    public Clock() {
        state = States.Display_Time; // Standardtillstånd enligt specifikation [cite: 68]
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
                // Illegal transition: Man bör inte kunna byta mode när man håller på att sätta tid/datum
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
                // Illegal transition: Redan i ett "Change"-läge
                return "Invalid state";
            default:
                return "Error";
        }
    }

    public String set(int p1, int p2, int p3) {
        switch (state) {
            case Change_Time:
                String timeResult = theTime.timeSet(p1, p2, p3);
                state = States.Display_Time; // Återgå till visningsläge efter lyckad "set"
                return timeResult;
            case Change_Date:
                String dateResult = theDate.dateSet(p1, p2, p3);
                state = States.Display_Date; // Återgå till visningsläge efter lyckad "set"
                return dateResult;
            case Display_Time:
            case Display_Date:
                // Illegal transition: Kan inte anropa set() utan att ha tryckt på ready() först
                return "Invalid state";
            default:
                return "Error";
        }
    }
}