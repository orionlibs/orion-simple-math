package io.github.orionlibs.orion_simple_math.statistics;

import java.util.List;

public class StandardDeviation
{
    public static float getPopulationStandardDeviation(List<Float> numbers)
    {
        return (float)Math.sqrt(Variance.getPopulationVariance(numbers));
    }
}
