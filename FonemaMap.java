package jtts;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Slam
 */
public class FonemaMap {

    private String path = FonemaMap.class.getResource("").getPath();

    private Map<String, String> fonemaMap;

    public FonemaMap() {
        fonemaMap = new HashMap<>();
        fonemaMap.put("a", path + "/a.wav");
        fonemaMap.put("e", path + "/e.wav");
        fonemaMap.put("i", path + "/i.wav");
        fonemaMap.put("o", path + "/o.wav");
        fonemaMap.put("u", path + "/u.wav");
        fonemaMap.put("n", path + "/n.wav");
        fonemaMap.put("una", path + "/una.wav");
        fonemaMap.put("el", path + "/el.wav");
        fonemaMap.put("la", path + "/la.wav");
        fonemaMap.put("fui", path + "/fui.wav");
        fonemaMap.put("pero", path + "/pero.wav");
        fonemaMap.put("si", path + "/si.wav");
        fonemaMap.put("no", path + "/no.wav");
        fonemaMap.put("veloz", path + "/veloz.wav");
        fonemaMap.put("murcielago", path + "/murcielago.wav");
        fonemaMap.put("vez", path + "/vez.wav");
        fonemaMap.put("estubistes", path + "/estubisteis.wav");

        // Agrega aquí las rutas a los demás fonemas.
    }

    public String getAudioPath(String fonema) {
        return fonemaMap.getOrDefault(fonema, null);
    }
}
