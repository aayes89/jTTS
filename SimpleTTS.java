package jtts;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Slam
 */
public class SimpleTTS {

    private FonemaMap fonemaMap = new FonemaMap();

    public void speak(String text) {
            String paths = fonemaMap.getAudioPath(text);
            playSound(paths);
        

        /*for (char c : text.toCharArray()) {
                String path = fonemaMap.getAudioPath(String.valueOf(c));
                if (path != null) {
                    playSound(path);
                }
            }*/
    }

    private void playSound(String path) {
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path))) {
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            try (SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info)) {
                audioLine.open(format);
                audioLine.start();
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
                    audioLine.write(buffer, 0, bytesRead);
                }
                audioLine.drain();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
