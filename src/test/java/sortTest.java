import Sort.sort;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class sortTest {
    sort SUT = new sort();
    List<List<Object>> list = new ArrayList<>();
    List<List<Object>> unsorted = new ArrayList<>();

    Sheets service;
    private static final String APPLICATION_NAME = "setup.WeeklyPointWinner";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private final String id = "1i1fFjYdsmMy0frZzL0WGF5f4vWcsuVESSzc1Ecsoc_E";

    @Before
    @Test
    public void setup() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, Credentials.getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        for(int k = 0; k<=7; k++)
            list.add(null);

        List<Object> r = new ArrayList<>();
        r.add("Sean Shields");
        r.add(5);r.add(5);r.add(3);r.add(0);r.add(3);
        r.add(5);r.add(2);r.add(5);r.add(5);r.add(5);
        r.add(2);r.add(0);
        r.add(40);
        list.set(7,r);
        unsorted.add(r);

        List<Object> r2 = new ArrayList<>();
        r2.add("Nick Edwards");
        r2.add(5);r2.add(4);r2.add(5);r2.add(5);r2.add(3);
        r2.add(5);r2.add(4);r2.add(5);r2.add(5);r2.add(3);
        r2.add(5);r2.add(0);
        r2.add(49);
        list.set(3,r2);
        unsorted.add(r2);

        List<Object> r3 = new ArrayList<>();
        r3.add("Greg Gladfelter");
        r3.add(5);r3.add(5);r3.add(5);r3.add(3);r3.add(5);
        r3.add(5);r3.add(5);r3.add(5);r3.add(5);r3.add(5);
        r3.add(5);r3.add(0);
        r3.add(53);
        list.set(1,r3);
        unsorted.add(r3);

        List<Object> r4 = new ArrayList<>();
        r4.add("Makenna Hugi (sc)");
        r4.add(5);r4.add(5);r4.add(5);r4.add(0);r4.add(3);
        r4.add(5);r4.add(0);r4.add(5);r4.add(5);r4.add(5);
        r4.add(4);r4.add(5);
        r4.add(47);
        list.add(5,r4);
        unsorted.add(r4);

        List<Object> r5 = new ArrayList<>();
        r5.add("David Althouse");
        r5.add(5);r5.add(3);r5.add(5);r5.add(3);r5.add(3);
        r5.add(5);r5.add(4);r5.add(5);r5.add(5);r5.add(5);
        r5.add(3);r5.add(0);
        r5.add(46);
        list.add(5,r5);
        unsorted.add(r5);

        List<Object> r6 = new ArrayList<>();
        r6.add("Trey Povanda");
        r6.add(5);r6.add(5);r6.add(5);r6.add(5);r6.add(5);
        r6.add(5);r6.add(4);r6.add(5);r6.add(5);r6.add(2);
        r6.add(5);r6.add(0);
        r6.add(51);
        list.set(2,r6);
        unsorted.add(r6);

        List<Object> r7 = new ArrayList<>();
        r7.add("Jimmy Forsythe");
        r7.add(5);r7.add(5);r7.add(5);r7.add(3);r7.add(5);
        r7.add(5);r7.add(5);r7.add(5);r7.add(5);r7.add(5);
        r7.add(5);r7.add(0);
        r7.add(53);
        list.set(0,r7);
        unsorted.add(r7);

        List<Object> r8 = new ArrayList<>();
        r8.add("Kristina Westervelt (sc)");
        r8.add(5);r8.add(5);r8.add(5);r8.add(0);r8.add(3);
        r8.add(5);r8.add(0);r8.add(5);r8.add(5);r8.add(5);
        r8.add(5);r8.add(4);
        r8.add(47);
        list.set(4,r8);
        unsorted.add(r8);


    }

    @Test
    public void Sort_Puts_Names_In_Order_From_Highest_Score(){
        List<List<Object>> expected = list;
        SUT.sort(unsorted);
        for(int k = 0; k<list.size(); k++)
            assertEquals(expected.get(k),unsorted.get(k));

    }
}
