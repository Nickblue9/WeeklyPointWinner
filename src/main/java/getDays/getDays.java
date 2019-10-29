package getDays;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.util.List;
public class getDays {
    public List<List<Object>> getSunday(Sheets service, String spreadsheetId)throws IOException {
        final String range = "Example!A4:N13";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId,range).execute();
        List<List<Object>> list = response.getValues();
        for(int k = 0; k<list.size(); k++)
            if(list.get(k).get(0)=="") {
                list.remove(k);
                k--;
            }
        return list;
    }
    public List<List<Object>> getMonday(Sheets service, String spreadsheetId)throws IOException{
        final String range = "Example!A15:N24";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId,range).execute();
        List<List<Object>> list = response.getValues();
        for(int k = 0; k<list.size(); k++)
            if(list.get(k).get(0)=="") {
                list.remove(k);
                k--;
            }
        return list;
    }
    public List<List<Object>> getTuesday(Sheets service, String spreadsheetId)throws IOException{
        final String range = "Example!A26:N35";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId,range).execute();
        List<List<Object>> list = response.getValues();
        for(int k = 0; k<list.size(); k++)
            if(list.get(k).get(0)=="") {
                list.remove(k);
                k--;
            }
        return list;
    }
    public List<List<Object>> getWednesday(Sheets service, String spreadsheetId)throws IOException{
        final String range = "Example!A37:N46";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId,range).execute();
        List<List<Object>> list = response.getValues();
        for(int k = 0; k<list.size(); k++)
            if(list.get(k).get(0)=="") {
                list.remove(k);
                k--;
            }
        return list;
    }
    public List<List<Object>> getThursday(Sheets service, String spreadsheetId)throws IOException{
        final String range = "Example!A48:N57";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId,range).execute();
        List<List<Object>> list = response.getValues();
        for(int k = 0; k<list.size(); k++)
            if(list.get(k).get(0)=="") {
                list.remove(k);
                k--;
            }
        return list;
    }
}
