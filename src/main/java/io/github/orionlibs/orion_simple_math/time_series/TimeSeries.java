package io.github.orionlibs.orion_simple_math.time_series;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class TimeSeries<T> implements Iterable<TimeSeriesEntry>
{
    private final Map<Long, T> map = new TreeMap();


    public void add(long time, T event)
    {
        map.put(time, event);
        try
        {
            TimeUnit.MICROSECONDS.sleep(1);  // 0.000001 sec delay
        }
        catch(InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }


    public T get(long time)
    {
        return map.get(time);
    }


    public ArrayList getList()
    {
        ArrayList<TimeSeriesEntry> list = new ArrayList();
        for(TimeSeriesEntry entry : this)
        {
            list.add(entry);
        }
        return list;
    }


    public int size()
    {
        return map.size();
    }


    @Override
    public Iterator iterator()
    {
        return new Iterator()
        {
            private final Iterator it = map.keySet().iterator();


            @Override
            public boolean hasNext()
            {
                return it.hasNext();
            }


            @Override
            public TimeSeriesEntry<T> next()
            {
                long time = (Long)it.next();
                T event = map.get(time);
                return new TimeSeriesEntry(time, event);
            }
        };
    }
}
