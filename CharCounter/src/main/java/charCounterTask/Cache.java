package charCounterTask;

import java.util.*;

public class Cache <T1,T2> {

    private Map<T1, T2> map = new LinkedHashMap<>() {
        protected boolean removeEldestEntry(Map.Entry<T1, T2> eldest) {
            return size() > MAX_ENTRIES;
        }
    };
    private static final int MAX_ENTRIES = 3;
    public void putElementInCache(T1 key, T2 value) {
        map.put(key, value);
    }
    public T2 getElementFromCache(T1 key) {
        return map.get(key);
    }

    public Map<T1, T2> getMap() {
        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cache<?, ?> cache = (Cache<?, ?>) o;
        return map.equals(cache.map);
    }
    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
