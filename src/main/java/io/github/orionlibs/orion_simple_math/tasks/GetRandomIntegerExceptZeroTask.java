package io.github.orionlibs.orion_simple_math.tasks;

public class GetRandomIntegerExceptZeroTask
{
    public static int run(int maximumNumber)
    {
        int randomNumber = 0;

        do
        {
            randomNumber = (int)(Math.floor(Math.random() * maximumNumber));
        }
        while(randomNumber == 0);

        return randomNumber;
    }


    public static int run(int minimumNumber, int maximumNumber)
    {
        int randomNumber = 0;

        do
        {
            randomNumber = (int)(Math.floor(Math.random() * maximumNumber));
        }
        while(randomNumber < minimumNumber);

        return randomNumber;
    }
}