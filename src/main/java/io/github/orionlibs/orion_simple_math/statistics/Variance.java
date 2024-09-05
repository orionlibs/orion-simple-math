package io.github.orionlibs.orion_simple_math.statistics;

import io.github.orionlibs.orion_simple_math.error.ErrorSquared;
import java.util.List;

public class Variance
{
    public static float getPopulationVariance(List<Float> numbers)
    {
        float mean = new ArithmeticMean().getMean(numbers);
        float sum = numbers.stream().map(x -> ErrorSquared.getErrorSquared(x, mean)).reduce(0.0f, (a, b) -> a + b);
        return sum / numbers.size();
    }


    public static float getVarianceUsingStandardDeviation(float standardDeviation, float n)
    {
        return standardDeviation * standardDeviation / n;
    }
}
