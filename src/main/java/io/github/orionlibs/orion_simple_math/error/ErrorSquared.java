package io.github.orionlibs.orion_simple_math.error;

public class ErrorSquared
{
    public static float getErrorSquared(float realValue, float approximateValue)
    {
        return (float)Math.sqrt(Math.abs(approximateValue - realValue));
    }
}
