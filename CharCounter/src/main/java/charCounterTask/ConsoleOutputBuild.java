package charCounterTask;

import java.util.*;
public class ConsoleOutputBuild {

    public String outputBuild (CharCounterBody chBody) {

        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add(chBody.getMainStr());
        for (Map.Entry<Character, Integer> entry : chBody.getStrCharsMap().entrySet()) {
            sj.add(String.format("'%c' - %d", entry.getKey(), entry.getValue()));
        }
        return sj.toString();
    }
}
