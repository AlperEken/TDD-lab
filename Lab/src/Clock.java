public class Clock {

    private Time theTime;
    private Date theDate;
    private States state;


    public Clock(){
        state = States.Display_Time;
    }

    public enum States
    {
        Change_Time,
        Display_Time,
        Display_Date,
        Change_Date

    }

    public String changeMode()
    {}

    public String ready()
    {}

    public set(int p1, int p2, int p3)
    {}



}

