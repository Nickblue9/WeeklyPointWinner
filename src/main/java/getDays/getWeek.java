package getDays;

import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.util.List;

import Sort.sort;
public class getWeek {
    getDays days = new getDays();
    sort sort = new sort();

    public List<List<Object>> getWeek(Sheets service, String id)throws IOException {
        List<List<Object>> Sunday = days.getSunday(service,id);
        List<List<Object>> Monday = days.getMonday(service,id);
        List<List<Object>> Tuesday = days.getTuesday(service,id);
        List<List<Object>> Wednesday = days.getWednesday(service,id);
        List<List<Object>> Thursday = days.getThursday(service,id);

        List<List<Object>> allDays = null;
        assert false;
        allDays.addAll(Sunday);
        allDays.addAll(Monday);
        allDays.addAll(Tuesday);
        allDays.addAll(Wednesday);
        allDays.addAll(Thursday);

        return allDays;
    }

    public List<List<Object>> getWeek(Sheets service, String id, Boolean sorted)throws IOException{
        if (!sorted)
            return getWeek(service, id);
        else{
            List<List<Object>> allDays = getWeek(service,id);
            sort.sort(allDays);
            return allDays;
        }
    }
}
