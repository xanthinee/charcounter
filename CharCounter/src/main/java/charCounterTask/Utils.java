package charCounterTask;

import java.util.*;
import java.util.stream.Collectors;

public class Utils {

    public static List<Character> convertStringToCharList(String str) {
        return str.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
    }
}
