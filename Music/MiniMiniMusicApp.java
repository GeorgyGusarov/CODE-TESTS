package Music;

import javax.sound.midi.*;

public class MiniMiniMusicApp {

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer(); // получаем синтезатор и открываем его
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4); // конструктор синтезатора
            Track track = seq.createTrack(); // запрашиваем трэк у последовательности

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100); // "начать проигрывать ноту № 44"
            MidiEvent noteOn = new MidiEvent(a, 1); // noteOn - в какой момент нота начинает играть
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16); // noteOff - в какой момент нота перестает играть
            track.add(noteOff);

            player.setSequence(seq); // передаем последовательность синтезатору
            player.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
