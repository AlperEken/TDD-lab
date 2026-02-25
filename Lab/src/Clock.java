public class Clock {

    private Time theTime;
    private Date theDate;
    private States state;


    public Clock(){
        state = States.Display_Time;
    }

    public String changeMode()
    {
        if (state.equals(States.Display_Time)){
            state = States.Display_Date;
        } else if (state.equals(States.Display_Date)){
            state = States.Display_Time;
        } else {
            return "Invalid Mode";
        }

        return state.toString();
    }

    public String ready()
    {
        state = States.Change_Time;

        return state.toString();
    }

    //public set(int p1, int p2, int p3)
    //{}



}

