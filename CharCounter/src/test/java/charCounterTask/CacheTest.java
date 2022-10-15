package charCounterTask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    CharCounter chCounter = new CharCounter();

    @Test
    void putElementInCache_whenTryingPutElementInCache_shouldIncreaseSizeOfCacheByOne() {
        Cache<String, String> testCache = new Cache<>();
        testCache.putElementInCache("artem", "artem");
        assertSame(testCache.getElementFromCache("artem"), "artem");
    }

    @Test
    void putElementInCache_whenAlreadyCreatedObjectProcessing_shouldReturnNewestValue() {
        Cache<String, String> testCache = new Cache<>();
        testCache.putElementInCache("car", "Audi");
        testCache.putElementInCache("car", "BMW");
        assertSame("BMW", testCache.getElementFromCache("car"));
    }

    @Test
    void putElementInCache_whenCacheIsFull_shouldDeleteEldestValue() {
        Cache<Integer, String> testCache = new Cache<>();
        testCache.putElementInCache(1, "cat");
        testCache.putElementInCache(2, "car");
        testCache.putElementInCache(3, "dog");
        testCache.putElementInCache(4, "book");
        assertEquals(null, testCache.getElementFromCache(1));
    }

    @Test
    void getElementFromCache_whenTakingElementIsNotInCache_shouldReturnNull() {
        Cache<String, CharCounterBody> testCache = new Cache<>();
        assertEquals(null, testCache.getElementFromCache("car"));
    }

    @Test
    void getElementFromCache_whenTakingElementIsInCache_shouldReturnValueOfElement() {
        Cache<String, String> testCache = new Cache<>();
        CharCounterBody testBody = chCounter.charStringCount("car");
        testCache.putElementInCache("Audi", "A8");
        assertEquals("A8", testCache.getElementFromCache("Audi"));
    }
}