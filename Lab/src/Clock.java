public class Clock {

    private Time theTime;
    private Date theDate;
    private States state;


    public Clock(){
        state = States.Display_Time;
        theTime = new Time();
        theDate = new Date();
    }

    public String changeMode()
    {
        if (state.equals(States.Display_Time)){
            state = States.Display_Date;
        } else if (state.equals(States.Display_Date)){
            state = States.Display_Time;
        } else {
            return "Invalid state";
        }

        return state.toString();
    }

    public String ready()
    {
        if (state.equals(States.Display_Time)){
            state = States.Change_Time;
            return state.toString();
        } else if (state.equals(States.Display_Date)){
            state = States.Change_Date;
            return state.toString();
        } else {
            return "Invalid state";
        }
    }

    public String set(int p1, int p2, int p3) //Beroende på vilken man står på, antingen tid eller datum
    {
        if (state.equals(States.Change_Time)){
            return theTime.timeSet(p1, p2, p3);
        } else if (state.equals(States.Change_Date)){
            return theDate.dateSet(p1, p2, p3);
        } else {
            return "Invalid state";
        }
    }



}

