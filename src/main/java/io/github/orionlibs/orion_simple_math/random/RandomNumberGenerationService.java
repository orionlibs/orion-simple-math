package io.github.orionlibs.orion_simple_math.random;

import io.github.orionlibs.orion_simple_math.random.task.GetRandomFloatNumberExceptZeroTask;
import io.github.orionlibs.orion_simple_math.random.task.GetRandomIntegerExceptZeroTask;
import io.github.orionlibs.orion_simple_math.random.task.GetRandomNumberExceptZeroTask;

public class RandomNumberGenerationService
{
    public static double getRandomNumberFromZeroToOne()
    {
        return Math.random();
    }


    public static int getRandomInteger(int maximumNumber)
    {
        return (int)(Math.floor(Math.random() * maximumNumber));
    }


    public static double getRandomInteger(double maximumNumber)
    {
        return (int)(Math.floor(Math.random() * maximumNumber));
    }


    public static int getRandomIntegerExceptZero(int maximumNumber)
    {
        return GetRandomIntegerExceptZeroTask.run(maximumNumber);
    }


    public static double getRandomNumberExceptZero(double maximumNumber)
    {
        return GetRandomNumberExceptZeroTask.run(maximumNumber);
    }


    public static int getRandomIntegerExceptZero(int minimumNumber, int maximumNumber)
    {
        return GetRandomIntegerExceptZeroTask.run(minimumNumber, maximumNumber);
    }


    public static double getRandomNumberExceptZero(double minimumNumber, double maximumNumber)
    {
        return GetRandomNumberExceptZeroTask.run(minimumNumber, maximumNumber);
    }


    public static double[] getRandomNumbersExceptZero(int numberOfNumbersToGenerate, double minimumNumber, double maximumNumber)
    {
        return GetRandomNumberExceptZeroTask.run(numberOfNumbersToGenerate, minimumNumber, maximumNumber);
    }


    public static float getRandomFloatNumberExceptZero(float minimumNumber, float maximumNumber)
    {
        return GetRandomFloatNumberExceptZeroTask.run(minimumNumber, maximumNumber);
    }


    public static float[] getRandomFloatNumbersExceptZero(int numberOfNumbersToGenerate, float minimumNumber, float maximumNumber)
    {
        return GetRandomFloatNumberExceptZeroTask.run(numberOfNumbersToGenerate, minimumNumber, maximumNumber);
    }
}