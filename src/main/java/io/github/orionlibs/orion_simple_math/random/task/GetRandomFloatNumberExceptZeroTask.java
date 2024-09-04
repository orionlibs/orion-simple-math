package io.github.orionlibs.orion_simple_math.random.task;

import io.github.orionlibs.orion_assert.Assert;
import java.util.stream.IntStream;

public class GetRandomFloatNumberExceptZeroTask
{
    public static float run(float minimumNumber, float maximumNumber)
    {
        float randomNumber = 0;
        do
        {
            randomNumber = (float)Math.floor(Math.random() * maximumNumber);
        }
        while(randomNumber < minimumNumber);
        return randomNumber;
    }


    public static float[] run(int numberOfNumbersToGenerate, float minimumNumber, float maximumNumber)
    {
        Assert.isPositive(numberOfNumbersToGenerate, "it has to be a positive number");
        float[] numbers = new float[numberOfNumbersToGenerate];
        IntStream.range(0, 100).forEach(i -> numbers[i] = run(minimumNumber, maximumNumber));
        return numbers;
    }
}