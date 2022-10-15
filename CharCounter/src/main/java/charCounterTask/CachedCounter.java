package charCounterTask;

public class CachedCounter extends CounterDecorator {

    public CachedCounter(Counter counter) {
        super(counter);
    }

    private Cache <String, CharCounterBody> cache = new Cache<>();

    public CharCounterBody charStringCount(String str) {

        CharCounterBody cachedBody = cache.getElementFromCache(str);
        if (cachedBody == null) {
            cache.putElementInCache(str, super.charStringCount(str));
        }
        return cache.getElementFromCache(str);
    }
}
