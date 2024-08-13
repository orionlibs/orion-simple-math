package io.github.orionlibs.orion_simple_math.tasks;

public class FormatNumberWithLeftTrailingZerosTask
{
    public static String run(long number, int numberOfTrailingZeros)
    {
        return String.format("%0" + numberOfTrailingZeros + "d", number);
    }
}