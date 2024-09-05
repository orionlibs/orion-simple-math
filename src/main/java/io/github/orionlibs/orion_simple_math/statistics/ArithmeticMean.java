package io.github.orionlibs.orion_simple_math.statistics;

import io.github.orionlibs.orion_assert.Assert;
import java.util.List;

public class ArithmeticMean
{
    public float getMean(List<Float> numbers)
    {
        Assert.notEmpty(numbers, "input cannot be empty");
        float sum = 0.0f;
        for(float x : numbers)
        {
            sum += x;
        }
        return sum / numbers.size();
    }
}
