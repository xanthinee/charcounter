package charCounterTask;

import java.util.Map;
import java.util.Objects;

public class CharCounterBody {

    private String mainStr;

    private Map<Character, Integer> strCharsMap;


    public CharCounterBody(String mainStr, Map<Character, Integer> strCharsMap ) {
        this.mainStr = mainStr;
        this.strCharsMap = strCharsMap;
    }

    public Map<Character, Integer> getStrCharsMap() {
        return strCharsMap;
    }

    public String getMainStr() {
        return mainStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharCounterBody that = (CharCounterBody) o;
        return mainStr.equals(that.mainStr) && strCharsMap.equals(that.strCharsMap);
    }
    @Override
    public int hashCode() {
        return Objects.hash(mainStr, strCharsMap);
    }
}
