package charCounterTask;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    //convertStringToCharList
    @Test
    void convertStringToCharList_whenStringIsEOneSpace() {
        List<Character> testList = new ArrayList<>();
        testList.add(' ');
        assertEquals(testList, Utils.convertStringToCharList(" "));
    }

    @Test
    void convertStringToCharList_whenStringIsSeveralSpace() {
        List<Character> testList = new ArrayList<>();
        testList.add(' ');
        testList.add(' ');
        testList.add(' ');
        assertEquals(testList, Utils.convertStringToCharList("   "));
    }

    @Test
    void convertStringToCharList_whenStringIsOneLetter() {
        List<Character> testList = new ArrayList<>();
        testList.add('a');
        assertEquals(testList, Utils.convertStringToCharList("a"));
    }

    @Test
    void convertStringToCharList_whenStringIsSeveralLetters() {
        List<Character> testList = new ArrayList<>();
        testList.add('a');
        testList.add('b');
        testList.add('c');
        assertEquals(testList, Utils.convertStringToCharList("abc"));
    }

    @Test
    void convertStringToCharList_whenStringIsOneSymbol() {
        List<Character> testList = new ArrayList<>();
        testList.add('*');
        assertEquals(testList, Utils.convertStringToCharList("*"));
    }

    @Test
    void convertStringToCharList_whenStringIsSeveralSymbols() {
        List<Character> testList = new ArrayList<>();
        testList.add('@');
        testList.add('&');
        testList.add('(');
        assertEquals(testList, Utils.convertStringToCharList("@&("));
    }

    @Test
    void convertStringToCharList_whenStringIsOneNumber() {
        List<Character> testList = new ArrayList<>();
        testList.add('9');
        assertEquals(testList, Utils.convertStringToCharList("9"));
    }

    @Test
    void convertStringToCharList_whenStringIsSeveralNumbers() {
        List<Character> testList = new ArrayList<>();
        testList.add('7');
        testList.add('4');
        testList.add('1');
        assertEquals(testList, Utils.convertStringToCharList("741"));
    }

    @Test
    void convertStringToCharList_whenStringIsMixOfEverything() {
        List<Character> testList = new ArrayList<>();
        testList.add('7');
        testList.add('a');
        testList.add('A');
        testList.add('*');
        testList.add(' ');
        testList.add(',');
        testList.add(',');
        testList.add(' ');
        testList.add('*');
        testList.add('3');
        testList.add('1');
        testList.add('j');
        testList.add('j');
        assertEquals(testList, Utils.convertStringToCharList("7aA* ,, *31jj"));
    }
}