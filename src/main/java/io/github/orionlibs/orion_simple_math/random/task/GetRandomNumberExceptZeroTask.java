package io.github.orionlibs.orion_simple_math.random.task;

import io.github.orionlibs.orion_assert.Assert;
import java.util.stream.IntStream;

public class GetRandomNumberExceptZeroTask
{
    public static double run(double maximumNumber)
    {
        double randomNumber = 0;
        do
        {
            randomNumber = (Math.floor(Math.random() * maximumNumber));
        }
        while(randomNumber == 0);
        return randomNumber;
    }


    public static double run(double minimumNumber, double maximumNumber)
    {
        double randomNumber = 0;
        do
        {
            randomNumber = (Math.floor(Math.random() * maximumNumber));
        }
        while(randomNumber < minimumNumber);
        return randomNumber;
    }


    public static double[] run(int numberOfNumbersToGenerate, double minimumNumber, double maximumNumber)
    {
        Assert.isPositive(numberOfNumbersToGenerate, "it has to be a positive number");
        double[] numbers = new double[numberOfNumbersToGenerate];
        IntStream.range(0, 100).forEach(i -> numbers[i] = run(minimumNumber, maximumNumber));
        return numbers;
    }
}