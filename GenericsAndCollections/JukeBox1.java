package GenericsAndCollections;

import java.io.*;
import java.util.*;

public class JukeBox1 {

    ArrayList<String> songList = new ArrayList<String>();

    public static void main(String[] args) {
        new JukeBox1().go();
    }

    public void go() {
        getSongs();
        System.out.println("До вызова .sort() " + songList);
        Collections.sort(songList);
        System.out.println("После вызова .sort() " + songList);
    }

    public void getSongs() {

        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        songList.add(tokens[0]);    // нам нужно только название, поэтому добавляем в songList только название
    }
}
