package io.github.orionlibs.orion_simple_math.time_series;

public class TimeSeriesEntry<T>
{
    private final Long time;
    private final T event;


    public TimeSeriesEntry(long time, T event)
    {
        this.time = time;
        this.event = event;
    }


    public long getTime()
    {
        return time;
    }


    public T getEvent()
    {
        return event;
    }


    @Override
    public String toString()
    {
        return String.format("(%d, %s)", time, event);
    }
}
