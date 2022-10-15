package charCounterTask;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    CharCounter cc = new CharCounter();

    @Test
    void charStringCount_whenStringIsEOneSpace() {
        Map<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',1);
        CharCounterBody testChCountB = new CharCounterBody("a", testMap);
        assertEquals(testChCountB, cc.charStringCount("a"));
    }

    @Test
    void charStringCount_whenStringIsSeveralSpace() {
        Map<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put(' ',3);
        CharCounterBody testChCountB = new CharCounterBody("   ", testMap);
        assertEquals(testChCountB, cc.charStringCount("   "));
    }

    @Test
    void charStringCount_whenStringHasLeadingSpaces() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put(' ',3);
        testMap.put('a',1);
        CharCounterBody testChCountB = new CharCounterBody("   a", testMap);
        assertEquals(testChCountB, cc.charStringCount("   a"));
    }

    @Test
    void charStringCount_whenStringHasLeadingAndTrailingSpaces() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put(' ',5);
        testMap.put('a',1);
        CharCounterBody testChCountB = new CharCounterBody("   a  ", testMap);
        assertEquals(testChCountB, cc.charStringCount("   a  "));
    }

    @Test
    void charStringCount_whenStringContainOneLetter() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',1);
        CharCounterBody testChCountB = new CharCounterBody("a", testMap);
        assertEquals(testChCountB, cc.charStringCount("a"));
    }

    @Test
    void charStringCount_whenStringContainOneLetterSeveralTimes() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',3);
        CharCounterBody testChCountB = new CharCounterBody("aaa", testMap);
        assertEquals(testChCountB, cc.charStringCount("aaa"));
    }

    @Test
    void charStringCount_whenStringContainOneLetterSeveralTimesDividedBySpaces() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',2);
        testMap.put(' ',2);
        CharCounterBody testChCountB = new CharCounterBody("a  a", testMap);
        assertEquals(testChCountB, cc.charStringCount("a  a"));
    }

    @Test
    void charStringCount_whenStringContainLetterSpaceAndSymbol() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',1);
        testMap.put(' ',1);
        testMap.put('&',1);
        CharCounterBody testChCountB = new CharCounterBody("a &", testMap);
        assertEquals(testChCountB, cc.charStringCount("a &"));
    }

    @Test
    void charStringCount_whenStringContainsOnlySymbols() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('*',1);
        testMap.put('%',1);
        testMap.put('&',1);
        CharCounterBody testChCountB = new CharCounterBody("*%&", testMap);
        assertEquals(testChCountB, cc.charStringCount("*%&"));
    }

    @Test
    void charStringCount_whenStringContainLetterSpaceAndSymbolMixed() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',6);
        testMap.put('&',6);
        testMap.put(' ',9);
        CharCounterBody testChCountB = new CharCounterBody("aa&   a & &&a  &&  aa", testMap);
        assertEquals(testChCountB, cc.charStringCount("aa&   a & &&a  &&  aa"));
    }

    @Test
    void charStringCount_whenStringContainOneLetterInDifferentCases() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',2);
        testMap.put('A',2);
        CharCounterBody testChCountB = new CharCounterBody("aAAa", testMap);
        assertEquals(testChCountB, cc.charStringCount("aAAa"));
    }

    @Test
    void charStringCount_whenStringContainsOnlyNumbers() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('1',3);
        testMap.put('2',4);
        testMap.put('3',4);
        CharCounterBody testChCountB = new CharCounterBody("12332132132", testMap);
        assertEquals(testChCountB, cc.charStringCount("12332132132"));
    }

    @Test
    void charStringCount_whenStringContainsAllPossibleTypesOfSymbolsInMixedForm() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('2',2);
        testMap.put(',',2);
        testMap.put(' ',3);
        testMap.put('s',1);
        testMap.put('g',1);
        testMap.put('1',1);
        testMap.put('*',3);
        testMap.put('3',2);
        testMap.put('a',1);
        testMap.put('A',1);
        CharCounterBody testChCountB = new CharCounterBody("2, sg1** 23 a*3,A", testMap);
        assertEquals(testChCountB, cc.charStringCount("2, sg1** 23 a*3,A"));
    }

    @Test
    void charStringCount_whenStringContainsSameWordSeveralTimes() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('c',3);
        testMap.put('a',3);
        testMap.put('t',3);
        testMap.put(' ',2);
        CharCounterBody testChCountB = new CharCounterBody("cat cat cat", testMap);
        assertEquals(testChCountB, cc.charStringCount("cat cat cat"));
    }
}