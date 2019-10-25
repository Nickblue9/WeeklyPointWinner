import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class WeeklyPointWinner {
    private static final String APPLICATION_NAME = "WeeklyPointWinner";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = SheetsQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }


    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        WeeklyPointWinner wpw = new WeeklyPointWinner();
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1i1fFjYdsmMy0frZzL0WGF5f4vWcsuVESSzc1Ecsoc_E";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        List<List<Object>> Sunday = wpw.getSunday(service,spreadsheetId);
        List<List<Object>> Monday = wpw.getMonday(service,spreadsheetId);
        List<List<Object>> Tuesday = wpw.getTuesday(service,spreadsheetId);
        List<List<Object>> Wednesday = wpw.getWednesday(service,spreadsheetId);
        List<List<Object>> Thursday = wpw.getThursday(service,spreadsheetId);

        for(List<Object> row: Sunday){
            if(row.get(0)=="")
                Sunday.remove(row);

            row.subList(1, 13).clear();
        }

        for(List<Object> row: Monday){
            if(row.get(0)=="")
                Monday.remove(row);

            row.subList(1, 13).clear();
        }

        for(List<Object> row: Tuesday){
            if(row.get(0)=="")
                Tuesday.remove(row);

            row.subList(1, 13).clear();
        }

        for(List<Object> row: Wednesday){
            if(row.get(0)=="")
                Wednesday.remove(row);

            row.subList(1, 13).clear();
        }
        for(List<Object> row: Thursday){
            if(row.get(0)=="")
                Thursday.remove(row);

            row.subList(1, 13).clear();
        }

        Sunday.remove(Sunday.size()-1);

        for(List<Object> row: Sunday){
            for(List<Object>row2: Monday){
                String i = row.get(0).toString();
                String k = row2.get(0).toString();
                if(i.equals(k))
                    row.add(row2.get(1));
            }
            for(List<Object>row2: Tuesday){
                String i = row.get(0).toString();
                String k = row2.get(0).toString();
                if(i.equals(k))
                    row.add(row2.get(1));
            }
            for(List<Object>row2: Wednesday){
                String i = row.get(0).toString();
                String k = row2.get(0).toString();
                if(i.equals(k))
                    row.add(row2.get(1));
            }
            for(List<Object>row2: Thursday){
                String i = row.get(0).toString();
                String k = row2.get(0).toString();
                if(i.equals(k))
                    row.add(row2.get(1));
            }
        }

        for(List<Object>row: Sunday){
            int total=0;
            for(int i=1; i<row.size(); i++){
                total+=Integer.parseInt(row.get(i).toString());
            }
            row.subList(1,row.size()).clear();
            row.add(total);
        }
        wpw.sort(Sunday);

        for(List row:Sunday){
            System.out.println(row.toString());
        }


    }
    private List<List<Object>> getSunday(Sheets service, String spreadsheetId)throws IOException{
        final String range = "Example!A4:N13";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId,range).execute();
        return response.getValues();
    }
    private List<List<Object>> getMonday(Sheets service, String spreadsheetId)throws IOException{
        final String range = "Example!A15:N24";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId,range).execute();
        return response.getValues();
    }
    private List<List<Object>> getTuesday(Sheets service, String spreadsheetId)throws IOException{
        final String range = "Example!A26:N35";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId,range).execute();
        return response.getValues();
    }
    private List<List<Object>> getWednesday(Sheets service, String spreadsheetId)throws IOException{
        final String range = "Example!A37:N46";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId,range).execute();
        return response.getValues();
    }
    private List<List<Object>> getThursday(Sheets service, String spreadsheetId)throws IOException{
        final String range = "Example!A48:N57";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId,range).execute();
        return response.getValues();
    }
    private void sort(List<List<Object>> list){
        int[] array = new int[list.size()];
        for(int i = 0; i<list.size(); i++)
            array[i] = Integer.parseInt(list.get(i).get(1).toString());
        quickSort(array,0,array.length-1);

        for(int i = 0; i<list.size(); i++){
            int k=0;
            while(true){
                if(array[i] == Integer.parseInt(list.get(k).get(1).toString())) {
                    swap(list, i, k);
                    break;
                }
                else
                    k++;
            }
        }

    }
    private void quickSort(int[] A, int left, int right){
        if(right<=left)
            return;
        int lp = left, rp = right;
        int v = A[left];
        int i = left +1;
        while(i<=rp){
            if(v<A[i])
                swap(A,lp++,i++);
            else if (v>A[i])
                swap(A,i,rp--);
            else
                i++;
        }
        quickSort(A,left,lp-1);
        quickSort(A,rp+1,right);

    }
    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    private void swap(List<List<Object>> list, int i, int j){
        List<Object> tmp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,tmp);
    }
}