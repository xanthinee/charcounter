package charCounterTask;

import java.util.Map;

@SuppressWarnings("java:S106")
public class Main {

    public static void main(String[] args) {

        CharCounter chC = new CharCounter();
        ConsoleOutputBuild co = new ConsoleOutputBuild();
        System.out.println(co.outputBuild(chC.charStringCount("artem smirnov")));
        CachedCounter cached = new CachedCounter(chC);
        System.out.println("---------------");
        Cache<String, Map<Character, Integer>> cache = new Cache();
        System.out.println(cache.getElementFromCache("artemsmirnov"));

    }
}
