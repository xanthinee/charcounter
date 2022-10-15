package charCounterTask;

import java.util.*;
import java.util.Map;

@SuppressWarnings("java:S106")
public class CharCounter implements Counter {

    @Override
    public CharCounterBody charStringCount(String str) {

        char[] strInChar = str.toCharArray();
        Map <Character, Integer> charsMap = new LinkedHashMap<>();
        for (char symbolArray: strInChar) {
                charsMap.merge(symbolArray, 1, (oldValue, newValue) -> oldValue + newValue);
        }
        return new CharCounterBody(str, charsMap);
    }
}
