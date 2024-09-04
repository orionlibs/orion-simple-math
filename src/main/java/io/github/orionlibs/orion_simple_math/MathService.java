package io.github.orionlibs.orion_simple_math;

public class MathService
{
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