package charCounterTask;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleOutputBuildIT {

    CharCounter cc = new CharCounter();
    ConsoleOutputBuild co = new ConsoleOutputBuild();

    @Test
    void outputBuild_whenStringIsOneSpace() {
        CharCounterBody testBody = cc.charStringCount(" ");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add(" ")
                .add("' ' - 1");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringIsSeveralSpace() {
        CharCounterBody testBody = cc.charStringCount("   ");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("   ")
                .add("' ' - 3");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringHasLeadingSpaces() {
        CharCounterBody testBody = cc.charStringCount("   a");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("   a")
                .add("' ' - 3")
                .add("'a' - 1");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringHasLeadingAndTrailingSpaces() {
        CharCounterBody testBody = cc.charStringCount("   a  ");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("   a  ")
                .add("' ' - 5")
                .add("'a' - 1");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringContainOneLetter() {
        CharCounterBody testBody = cc.charStringCount("a");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("a")
                .add("'a' - 1");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringContainOneLetterSeveralTimes() {
        CharCounterBody testBody = cc.charStringCount("aaa");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("aaa")
                .add("'a' - 3");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringContainOneLetterSeveralTimesDividedBySpaces() {
        CharCounterBody testBody = cc.charStringCount("a  a");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("a  a")
                .add("'a' - 2")
                .add("' ' - 2");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringContainLetterSpaceAndSymbol() {
        CharCounterBody testBody = cc.charStringCount("a &");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("a &")
                .add("'a' - 1")
                .add("' ' - 1")
                .add("'&' - 1");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringContainsOnlySymbols() {
        CharCounterBody testBody = cc.charStringCount("*%&");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("*%&")
                .add("'*' - 1")
                .add("'%' - 1")
                .add("'&' - 1");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringContainLetterSpaceAndSymbolMixed() {
        CharCounterBody testBody = cc.charStringCount("aa&   a & &&a  &&  aa");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("aa&   a & &&a  &&  aa")
                .add("'a' - 6")
                .add("'&' - 6")
                .add("' ' - 9");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringContainOneLetterInDifferentCases() {
        CharCounterBody testBody = cc.charStringCount("aAAa");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("aAAa")
                .add("'a' - 2")
                .add("'A' - 2");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringContainsOnlyNumbers() {
        CharCounterBody testBody = cc.charStringCount("12332132132");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("12332132132")
                .add("'1' - 3")
                .add("'2' - 4")
                .add("'3' - 4");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringContainsAllPossibleTypesOfSymbolsInMixedForm() {
        CharCounterBody testBody = cc.charStringCount("2, sg1** 23 a*3,A");
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
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }

    @Test
    void outputBuild_whenStringContainsSameWordSeveralTimes() {
        CharCounterBody testBody = cc.charStringCount("cat cat cat");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("cat cat cat")
                .add("'c' - 3")
                .add("'a' - 3")
                .add("'t' - 3")
                .add("' ' - 2");
        assertEquals(sj.toString(), co.outputBuild(testBody));
    }
}
