import java.util.Calendar;

public class Date {

    public static Boolean isWeekend(ChargingRequest request)
    {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.setTimeInMillis(request.getTimeStamp());
        if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {

            return false;  //dia da semana
        } else {
            return true;  //fim de semana
        }
    }

}
