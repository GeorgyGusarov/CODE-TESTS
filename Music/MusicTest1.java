package Music;

import javax.sound.midi.*;

public class MusicTest1 {

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // берём sequencer из класса MidiSystem
            System.out.println("Успешно получили синтезатор");
        } catch (MidiUnavailableException midiEx) {
            System.out.println("Ошибка: " + midiEx);
        }

    }

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
}
