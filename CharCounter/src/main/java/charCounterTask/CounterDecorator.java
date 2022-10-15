package charCounterTask;

public abstract class CounterDecorator implements Counter {

    private final Counter counter;

    protected CounterDecorator(Counter counter) {
        this.counter = counter;
    }

    @Override
    public CharCounterBody charStringCount(String str) {
        return counter.charStringCount(str);
    }
}
