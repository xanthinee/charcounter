package charCounterTask;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleOutputBuildTest {

    ConsoleOutputBuild co = new ConsoleOutputBuild();

    @Test
    void outputBuild_whenStringIsOneSpace() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put(' ',1);
        CharCounterBody testBody = new CharCounterBody(" ", testMap);

        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add(" ")
                .add("' ' - 1");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringIsSeveralSpace() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put(' ',3);
        CharCounterBody testChCountB = new CharCounterBody("   ", testMap);
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("   ")
                .add("' ' - 3");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringHasLeadingSpaces() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put(' ',3);
        testMap.put('a',1);
        CharCounterBody testChCountB = new CharCounterBody("   a", testMap);
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("   a")
                .add("' ' - 3")
                .add("'a' - 1");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringHasLeadingAndTrailingSpaces() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put(' ',5);
        testMap.put('a',1);
        CharCounterBody testChCountB = new CharCounterBody("   a  ", testMap);
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("   a  ")
                .add("' ' - 5")
                .add("'a' - 1");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringContainOneLetter() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',1);
        CharCounterBody testChCountB = new CharCounterBody("a", testMap);

        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("a")
                .add("'a' - 1");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringContainOneLetterSeveralTimes() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',3);
        CharCounterBody testChCountB = new CharCounterBody("aaa", testMap);
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("aaa")
                .add("'a' - 3");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringContainOneLetterSeveralTimesDividedBySpaces() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',2);
        testMap.put(' ',2);
        CharCounterBody testChCountB = new CharCounterBody("a  a", testMap);

        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("a  a")
                .add("'a' - 2")
                .add("' ' - 2");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringContainLetterSpaceAndSymbol() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',1);
        testMap.put(' ',1);
        testMap.put('&',1);
        CharCounterBody testChCountB = new CharCounterBody("a &", testMap);
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("a &")
                .add("'a' - 1")
                .add("' ' - 1")
                .add("'&' - 1");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringContainsOnlySymbols() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('*',1);
        testMap.put('%',1);
        testMap.put('&',1);
        CharCounterBody testChCountB = new CharCounterBody("*%&", testMap);
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("*%&")
                .add("'*' - 1")
                .add("'%' - 1")
                .add("'&' - 1");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringContainLetterSpaceAndSymbolMixed() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',6);
        testMap.put('&',6);
        testMap.put(' ',9);
        CharCounterBody testChCountB = new CharCounterBody("aa&   a & &&a  &&  aa", testMap);
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("aa&   a & &&a  &&  aa")
                .add("'a' - 6")
                .add("'&' - 6")
                .add("' ' - 9");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringContainOneLetterInDifferentCases() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('a',2);
        testMap.put('A',2);
        CharCounterBody testChCountB = new CharCounterBody("aAAa", testMap);
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("aAAa")
                .add("'a' - 2")
                .add("'A' - 2");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringContainsOnlyNumbers() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('1',3);
        testMap.put('2',4);
        testMap.put('3',4);
        CharCounterBody testChCountB = new CharCounterBody("12332132132", testMap);
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("12332132132")
                .add("'1' - 3")
                .add("'2' - 4")
                .add("'3' - 4");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringContainsAllPossibleTypesOfSymbolsInMixedForm() {
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

        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("2, sg1** 23 a*3,A")
                .add("'2' - 2")
                .add("',' - 2")
                .add("' ' - 3")
                .add("'s' - 1")
                .add("'g' - 1")
                .add("'1' - 1")
                .add("'*' - 3")
                .add("'3' - 2")
                .add("'a' - 1")
                .add("'A' - 1");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }

    @Test
    void outputBuild_whenStringContainsSameWordSeveralTimes() {
        LinkedHashMap<Character, Integer> testMap = new LinkedHashMap<>();
        testMap.put('c',3);
        testMap.put('a',3);
        testMap.put('t',3);
        testMap.put(' ',2);
        CharCounterBody testChCountB = new CharCounterBody("cat cat cat", testMap);

        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("cat cat cat")
                .add("'c' - 3")
                .add("'a' - 3")
                .add("'t' - 3")
                .add("' ' - 2");
        assertEquals(sj.toString(), co.outputBuild(testChCountB));
    }
}