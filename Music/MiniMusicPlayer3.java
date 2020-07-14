package Music;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {
    static JFrame frame = new JFrame("My first music clip");
    static MyDrawPanel3 myDrawPanel3;

    public static void main(String[] args) {
        MiniMusicPlayer3 miniMusicPlayer3 = new MiniMusicPlayer3();
        miniMusicPlayer3.go();
    }

    public void setUpGui() {
        myDrawPanel3 = new MyDrawPanel3();
        frame.setContentPane(myDrawPanel3);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(myDrawPanel3, new int[] {127});

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            int r = 0;

            for (int i = 0; i < 60; i+= 4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100 ,i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }
            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    class MyDrawPanel3 extends JPanel implements ControllerEventListener {
        boolean message = false;

        @Override
        public void controlChange(ShortMessage event) {
            message = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (message) {
                Graphics2D graphics2D = (Graphics2D) g;

                int red = (int) (Math.random() * 250);
                int green = (int) (Math.random() * 250);
                int blue = (int) (Math.random() * 250);

                g.setColor(new Color(red, green, blue));

                int ht = (int) ((Math.random() * 120) + 10);
                int wt = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.fillRect(x, y, ht, wt);
                message = false;
            }
        }
    }
}
