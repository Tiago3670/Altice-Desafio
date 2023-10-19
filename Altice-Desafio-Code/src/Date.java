import java.util.Calendar;

public class Date {

    public Date(long timeStamp) {
    }

    public static Boolean isWeekend(ChargingRequest request)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(request.getTimeStamp());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {

            return false;  //dia da semana
        } else {
            return true;  //fim de semana
        }
    }
    public static Boolean isNight(ChargingRequest request)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(request.getTimeStamp());

        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        System.out.println("hora:"+hour);

        if (hour >= 20 || hour < 6) {

            return true; //se for noite
        } else {
            return false;//se for dia
        }
    }

}
