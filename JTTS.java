package jtts;

/**
 *
 * @author Slam
 */

public class JTTS {

    public static void main(String[] args) {
        String[] words = {"el", "veloz", "murcielago"};
        SimpleTTS stts = new SimpleTTS();
        for (String text : words) {
            stts.speak(text);
        }
    }
}
