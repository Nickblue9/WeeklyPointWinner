import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import getDays.getDays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class getDaysTest {

    getDays SUT = new getDays();
    List<List<Object>> Sunday = new ArrayList<>();
    List<List<Object>> Monday = null;
    List<List<Object>> Tuesday = null;
    List<List<Object>> Wednesday = null;
    List<List<Object>> Thursday = null;

    Sheets service;
    private static final String APPLICATION_NAME = "setup.WeeklyPointWinner";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private final String id = "1i1fFjYdsmMy0frZzL0WGF5f4vWcsuVESSzc1Ecsoc_E";

    @Before
    public void setup() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, Credentials.getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        List<Object> r = new ArrayList<>();
        r.add("Sean Shields");
        r.add(5);r.add(5);r.add(3);r.add(0);r.add(3);
        r.add(5);r.add(2);r.add(5);r.add(5);r.add(5);
        r.add(2);r.add(0);
        r.add(40);
        Sunday.add(0,r);

        List<Object> r2 = new ArrayList<>();
        r2.add("Nick Edwards");
        r2.add(5);r2.add(4);r2.add(5);r2.add(5);r2.add(3);
        r2.add(5);r2.add(4);r2.add(5);r2.add(5);r2.add(3);
        r2.add(5);r2.add(0);
        r2.add(49);
        Sunday.add(1,r2);

        List<Object> r3 = new ArrayList<>();
        r3.add("Greg Gladfelter");
        r3.add(5);r3.add(5);r3.add(5);r3.add(3);r3.add(5);
        r3.add(5);r3.add(5);r3.add(5);r3.add(5);r3.add(5);
        r3.add(5);r3.add(0);
        r3.add(53);
        Sunday.add(2,r3);

        List<Object> r4 = new ArrayList<>();
        r4.add("Makenna Hugi (sc)");
        r4.add(5);r4.add(5);r4.add(5);r4.add(0);r4.add(3);
        r4.add(5);r4.add(0);r4.add(5);r4.add(5);r4.add(5);
        r4.add(4);r4.add(5);
        r4.add(47);
        Sunday.add(3,r4);

        List<Object> r5 = new ArrayList<>();
        r5.add("David Althouse");
        r5.add(5);r5.add(3);r5.add(5);r5.add(3);r5.add(3);
        r5.add(5);r5.add(4);r5.add(5);r5.add(5);r5.add(5);
        r5.add(3);r5.add(0);
        r5.add(46);
        Sunday.add(4,r5);

        List<Object> r6 = new ArrayList<>();
        r6.add("Trey Povanda");
        r6.add(5);r6.add(5);r6.add(5);r6.add(5);r6.add(5);
        r6.add(5);r6.add(4);r6.add(5);r6.add(5);r6.add(2);
        r6.add(5);r6.add(0);
        r6.add(51);
        Sunday.add(5,r6);

        List<Object> r7 = new ArrayList<>();
        r7.add("Jimmy Forsythe");
        r7.add(5);r7.add(5);r7.add(5);r7.add(3);r7.add(5);
        r7.add(5);r7.add(5);r7.add(5);r7.add(5);r7.add(5);
        r7.add(5);r7.add(0);
        r7.add(53);
        Sunday.add(6,r7);

        List<Object> r8 = new ArrayList<>();
        r8.add("Kristina Westervelt (sc)");
        r8.add(5);r8.add(5);r8.add(5);r8.add(0);r8.add(3);
        r8.add(5);r8.add(0);r8.add(5);r8.add(5);r8.add(5);
        r8.add(5);r8.add(4);
        r8.add(47);
        Sunday.add(7,r8);

        Monday = Sunday;
        Tuesday = Sunday;
        Wednesday = Sunday;
        Thursday = Sunday;
    }



    @Test
    public void getSunday_Returns_Sunday(){
        try{
            List<List<Object>> expected = Sunday;
            List<List<Object>> got = SUT.getSunday(service,id);
            for(int k = 0; k<expected.size();k++){
                assertEquals(expected.get(k).toString(),got.get(k).toString());
            }
        }catch(IOException e){e.printStackTrace();}
    }


    @Test
    public void getMonday_Returns_Monday(){
        try{
            List<List<Object>> expected = Sunday;
            List<List<Object>> got = SUT.getSunday(service,id);
            for(int k = 0; k<expected.size();k++){
                assertEquals(expected.get(k).toString(),got.get(k).toString());
            }
        }catch(IOException e){e.printStackTrace();}
    }


    @Test
    public void getTuesday_Returns_Tuesday(){
        try{
            List<List<Object>> expected = Sunday;
            List<List<Object>> got = SUT.getSunday(service,id);
            for(int k = 0; k<expected.size();k++){
                assertEquals(expected.get(k).toString(),got.get(k).toString());
            }
        }catch(IOException e){e.printStackTrace();}
    }


    @Test
    public void getWednesday_Returns_Wednesday(){
        try{
            List<List<Object>> expected = Sunday;
            List<List<Object>> got = SUT.getSunday(service,id);
            for(int k = 0; k<expected.size();k++){
                assertEquals(expected.get(k).toString(),got.get(k).toString());
            }
        }catch(IOException e){e.printStackTrace();}
    }


    @Test
    public void getThursday_Returns_Thursday(){
        try{
            List<List<Object>> expected = Sunday;
            List<List<Object>> got = SUT.getSunday(service,id);
            for(int k = 0; k<expected.size();k++){
                assertEquals(expected.get(k).toString(),got.get(k).toString());
            }
        }catch(IOException e){e.printStackTrace();}
    }
}
