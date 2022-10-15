package charCounterTask;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;


@ExtendWith(MockitoExtension.class)
class CachedCounterTest {
    @Mock
    Counter defaultCounter;
    @InjectMocks
    CachedCounter cachedCounter;

    @Test
    void charStringCount_whenCachedCounterIsGotStrFor1StTime_shouldUseDefaultCounter() {
        Mockito.when(defaultCounter.charStringCount("cat")).thenReturn(new CharCounterBody ("cat",
                new LinkedHashMap<>()));

        CharCounterBody testBody = defaultCounter.charStringCount("cat");
        Assert.assertEquals(testBody, cachedCounter.charStringCount("cat"));
    }

    @Test
    void charStringCount_whenAlreadyContainedStringIsBeingProcessed_shouldNotUseDefaultCounter() {
        Mockito.when(defaultCounter.charStringCount("cat")).thenReturn(new CharCounterBody ("cat",
                new LinkedHashMap<>()));
        cachedCounter.charStringCount("cat");
        cachedCounter.charStringCount("cat");
        Mockito.verify(defaultCounter, Mockito.times(1)).charStringCount("cat");
    }
}

