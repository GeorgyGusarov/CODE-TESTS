package Net_and_Streams;

import java.io.*;
import java.net.*;

public class DailyAdviceClient {

    public void go() {

        try {
            Socket socket = new Socket("192.168.0.1", 4242);

            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("Сегодня ты должен: " + advice);

            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
