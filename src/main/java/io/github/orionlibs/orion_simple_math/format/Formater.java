package io.github.orionlibs.orion_simple_math.format;

import io.github.orionlibs.orion_simple_math.format.task.FormatNumberTask;
import io.github.orionlibs.orion_simple_math.format.task.FormatNumberWithLeftTrailingZerosTask;
import io.github.orionlibs.orion_simple_math.format.task.FormatNumberWithRightTrailingZerosTask;
import java.math.BigDecimal;

public class Formater
{
    public static String formatNumber(BigDecimal number, int numberOfDecimalDigits)
    {
        return FormatNumberTask.run(number, numberOfDecimalDigits);
    }


    public static String formatNumber(long number, String format)
    {
        return FormatNumberTask.run(number, format);
    }


    public static String formatNumber(long number)
    {
        return FormatNumberTask.run(number);
    }


    public static String formatNumberWithLeftTrailingZeros(long number, int numberOfTrailingZeros)
    {
        return FormatNumberWithLeftTrailingZerosTask.run(number, numberOfTrailingZeros);
    }


    public static String formatNumberWithRightTrailingZeros(long number, int numberOfTrailingZeros)
    {
        return FormatNumberWithRightTrailingZerosTask.run(number, numberOfTrailingZeros);
    }
}