package GenericsAndCollections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class JukeBox4 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new JukeBox4().go();
    }

    void go() {
        getSongs(); // не меняли getSongs, так как он всё еще добавляет песни в ArrayList
        System.out.println("До вызова .sort()\n" + songList + "\n");

        Collections.sort(songList);
        System.out.println("После вызова .sort(). Сортировка по названию\n" + songList + "\n");

        HashSet<Song> songSet = new HashSet<Song>();    // множество HashSet, предназначенное для хранения объектов Song
        songSet.addAll(songList);
        System.out.println("После HashSet: \n" + songSet);
    }

    public void getSongs() {

        try {
            File file = new File("SongListMore.txt");
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

        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}
