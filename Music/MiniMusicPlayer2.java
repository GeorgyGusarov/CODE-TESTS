package Music;

import javax.sound.midi.*;

public class MiniMusicPlayer2 implements ControllerEventListener {

    public static void main(String[] args) {
        MiniMusicPlayer2 miniMusicPlayer2 = new MiniMusicPlayer2();
        miniMusicPlayer2.go();
    }

    public void go() {

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsWeWant = {127};
            sequencer.addControllerEventListener(this, eventsWeWant);

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            for (int i = 5; i < 60; i += 4) {
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }

            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("ля " + event.getData1());
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage shortMessage = new ShortMessage();
            shortMessage.setMessage(comd, chan, one, two);
            event = new MidiEvent(shortMessage, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}
