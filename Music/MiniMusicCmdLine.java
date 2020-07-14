package Music;

import javax.sound.midi.*;
import java.util.Scanner;

public class MiniMusicCmdLine {

    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        System.out.println("Введите аргументы через пробел. Например: 102 30");
        Scanner userInput = new Scanner(System.in);

        int instrument = userInput.nextInt();
        int note = userInput.nextInt();
        mini.play(instrument, note);
    }

    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 9, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 9, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 9, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
