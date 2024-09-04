package io.github.orionlibs.orion_simple_math.statistics;

import io.github.orionlibs.orion_simple_math.time_series.TimeSeries;
import io.github.orionlibs.orion_simple_math.time_series.TimeSeriesEntry;
import java.util.Iterator;

public class MovingAverage extends TimeSeries<Double>
{
    private final TimeSeries parent;
    private final int length;


    public MovingAverage(TimeSeries parent, int length)
    {
        this.parent = parent;
        this.length = length;
        if(length > parent.size())
        {
            throw new IllegalArgumentException("That's too long.");
        }
        double[] tmp = new double[length];  // temp array to compute averages
        double sum = 0;
        int i = 0;
        Iterator it = parent.iterator();
        for(int j = 0; j < length; j++)
        {
            sum += tmp[i++] = nextValue(it);
        }
        this.add(System.currentTimeMillis(), sum / length);
        while(it.hasNext())
        {
            sum -= tmp[i % length];
            sum += tmp[i++ % length] = nextValue(it);
            this.add(System.currentTimeMillis(), sum / length);
        }
    }


    /*  Returns the double value in the Entry currently located by it.
     */
    private static double nextValue(Iterator it)
    {
        TimeSeriesEntry<Double> entry = (TimeSeriesEntry)it.next();
        return entry.getEvent();
    }
}
