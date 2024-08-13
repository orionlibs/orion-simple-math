package io.github.orionlibs.orion_simple_math.tasks;

import org.apache.commons.lang3.StringUtils;

public class FormatNumberWithRightTrailingZerosTask
{
    public static String run(long number, int numberOfTrailingZeros)
    {
        String numberString = Long.toString(number);
        if(numberString.length() < numberOfTrailingZeros)
        {
            return StringUtils.rightPad(numberString, numberOfTrailingZeros, "0");
        }
        else
        {
            return numberString;
        }
    }
}