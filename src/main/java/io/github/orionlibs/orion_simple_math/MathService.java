package io.github.orionlibs.orion_simple_math;

import io.github.orionlibs.orion_simple_math.tasks.FormatNumberTask;
import io.github.orionlibs.orion_simple_math.tasks.FormatNumberWithLeftTrailingZerosTask;
import io.github.orionlibs.orion_simple_math.tasks.FormatNumberWithRightTrailingZerosTask;
import java.math.BigDecimal;

public class MathService
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


    public static float round(float number, int numberOfDecimalDigits)
    {
        int scale = (int)Math.pow(10, numberOfDecimalDigits);
        return (float)Math.round(number * scale) / scale;
    }


    public static double round(double number, int numberOfDecimalDigits)
    {
        int scale = (int)Math.pow(10, numberOfDecimalDigits);
        return (double)Math.round(number * scale) / scale;
    }


    public static long removeDecimalPart(double number)
    {
        String ceilingString = Double.toString(number);
        ceilingString = ceilingString.substring(0, ceilingString.indexOf("."));
        return Long.parseLong(ceilingString);
    }


    public static Long parseLongOrNull(String x)
    {
        if(x != null && !x.isEmpty())
        {
            return Long.parseLong(x);
        }
        else
        {
            return null;
        }
    }


    public static Boolean parseBooleanOrNull(String x)
    {
        if(x != null && !x.isEmpty())
        {
            return Boolean.parseBoolean(x);
        }
        else
        {
            return null;
        }
    }


    public static Float parseFloatOrNull(String x)
    {
        if(x != null && !x.isEmpty())
        {
            return Float.parseFloat(x);
        }
        else
        {
            return null;
        }
    }


    public static Integer parseIntegerOrNull(String x)
    {
        if(x != null && !x.isEmpty())
        {
            return Integer.parseInt(x);
        }
        else
        {
            return null;
        }
    }
}