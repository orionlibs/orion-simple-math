package io.github.orionlibs.orion_simple_math;

/**
 * Decompose a floating-point value into its parts according to the IEEE 754
 * standard.
 */
public class IEEE754
{
    private static final int DOUBLE_SIGN_INDEX = 0;
    private static final int DOUBLE_SIGN_SIZE = 1;
    private static final int DOUBLE_EXPONENT_INDEX = 1;
    private static final int DOUBLE_EXPONENT_SIZE = 11;
    private static final int DOUBLE_EXPONENT_RESERVED = 2047;
    private static final int DOUBLE_EXPONENT_BIAS = 1023;
    private static final int DOUBLE_FRACTION_INDEX = 12;
    private static final int DOUBLE_FRACTION_SIZE = 52;
    /** sign bit as a string */
    private String signBit;
    /** exponent bits as a string */
    private String exponentBits;
    /** fraction bits as a string */
    private String fractionBits;
    /** implied bit as a string */
    private String impliedBit;
    /** biased exponent value */
    private int biased;
    /** fraction value */
    private long fraction;
    /** exponent bias */
    private int bias;
    /** double number value */
    private double doubleValue;
    /**
     * true if number value is zero
     */
    private boolean isZero;
    /**
     * true if reserved exponent value
     */
    private boolean isReserved;
    /**
     * true if denormalized number value
     */
    private boolean isDenormalized;


    public IEEE754(double value)
    {
        // Convert the value to a character array of '0' and '1'.
        char[] bits = toCharBitArray(Double.doubleToLongBits(value), 64);
        doubleValue = value;
        decompose(bits, DOUBLE_EXPONENT_BIAS, DOUBLE_EXPONENT_RESERVED, DOUBLE_SIGN_INDEX, DOUBLE_SIGN_SIZE, DOUBLE_EXPONENT_INDEX, DOUBLE_EXPONENT_SIZE, DOUBLE_FRACTION_INDEX, DOUBLE_FRACTION_SIZE);
    }


    public double doubleValue()
    {
        return doubleValue;
    }


    /**
     * Return the biased value of the exponent.
     * @return the unbiased exponent value
     */
    public int biasedExponent()
    {
        return biased;
    }


    /**
     * Return the unbiased value of the exponent.
     * @return the unbiased exponent value
     */
    public int unbiasedExponent()
    {
        return isDenormalized ? (-bias + 1) : biased - bias;
    }


    /**
     * Return the sign as a string of '0' and '1'.
     * @return the string
     */
    public String signBit()
    {
        return signBit;
    }


    /**
     * Return the exponent as a string of '0' and '1'.
     * @return the string
     */
    public String exponentBits()
    {
        return exponentBits;
    }


    /**
     * Return the fraction as a string of '0' and '1'.
     * @return the string
     */
    public String fractionBits()
    {
        return fractionBits;
    }


    /**
     * Return the significand as a string of '0', '1' and '.'.
     * @return the string
     */
    public String significandBits()
    {
        return impliedBit + "." + fractionBits;
    }


    /**
     * Return whether or not the value is zero.
     * @return true if zero, else false
     */
    public boolean isZero()
    {
        return isZero;
    }


    /**
     * Return whether or not the value is denormalized.
     * @return true if denormalized, else false
     */
    public boolean isDenormalized()
    {
        return isDenormalized;
    }


    /**
     * Return whether or not the exponent value is reserved.
     * @return true if reserved, else false
     */
    public boolean isExponentReserved()
    {
        return isReserved;
    }


    private static char[] toCharBitArray(long value, int size)
    {
        char[] bits = new char[size];
        // Convert each bit from right to left.
        for(int i = size - 1; i >= 0; --i)
        {
            bits[i] = (value & 1) == 0 ? '0' : '1';
            value >>>= 1;
        }
        return bits;
    }


    private void decompose(char[] bits, int bias, int reserved, int signIndex, int signSize, int exponentIndex, int exponentSize, int fractionIndex, int fractionSize)
    {
        this.bias = bias;
        // Extract the individual parts as strings of '0' and '1'.
        signBit = new String(bits, signIndex, signSize);
        exponentBits = new String(bits, exponentIndex, exponentSize);
        fractionBits = new String(bits, fractionIndex, fractionSize);
        try
        {
            biased = Integer.parseInt(exponentBits, 2);
            fraction = Long.parseLong(fractionBits, 2);
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
        }
        isZero = (biased == 0) && (fraction == 0);
        isDenormalized = (biased == 0) && (fraction != 0);
        isReserved = (biased == reserved);
        impliedBit = isDenormalized || isZero || isReserved ? "0" : "1";
    }


    /**
     * Print the decomposed parts of the value.
     */
    public void print()
    {
        System.out.println("------------------------------");
        System.out.println("double value = " + doubleValue());
        // Print the sign.
        System.out.print("sign=" + signBit());
        // Print the bit representation of the exponent and its
        // biased and unbiased values. Indicate whether the value
        // is denormalized, or whether the exponent is reserved.
        System.out.print(", exponent=" + exponentBits() + " (biased=" + biasedExponent());
        if(isZero())
        {
            System.out.println(", zero)");
        }
        else if(isExponentReserved())
        {
            System.out.println(", reserved)");
        }
        else if(isDenormalized())
        {
            System.out.println(", denormalized, use " + unbiasedExponent() + ")");
        }
        else
        {
            System.out.println(", normalized, unbiased=" + unbiasedExponent() + ")");
        }
        // Print the significand.
        System.out.println("significand=" + significandBits());
    }


    /**
     * Compute the value of the double biased exponent given the unbiased value.
     * @param unbiased the unbiased exponent value
     * @return the biased exponent value
     */
    public static int toDoubleBiasedExponent(int unbiased)
    {
        return unbiased + DOUBLE_EXPONENT_BIAS;
    }


    /**
     * Compute the value of the double unbiased exponent given the biased value.
     * @param biased the biased exponent value
     * @return the unbiased exponent value
     */
    public static int toDoubleUnbiasedExponent(int biased)
    {
        return biased == 0 ? (-DOUBLE_EXPONENT_BIAS + 1) : biased - DOUBLE_EXPONENT_BIAS;
    }


    /**
     * Validate the value of the double biased exponent value.
     * @param biased the biased exponent value
     * @throws Exception
     */
    public static void validateDoubleBiasedExponent(int biased) throws Exception
    {
        if((biased < 0) || (biased > DOUBLE_EXPONENT_RESERVED))
        {
            throw new Exception("The biased exponent value should be " + "0 through " + DOUBLE_EXPONENT_RESERVED + ".");
        }
    }


    /**
     * Validate the value of the double unbiased exponent value.
     * @param unbiased the unbiased exponent value
     * @throws Exception
     */
    public static void validateDoubleUnbiasedExponent(int unbiased) throws Exception
    {
        if((unbiased < -DOUBLE_EXPONENT_BIAS + 1) || (unbiased > DOUBLE_EXPONENT_BIAS))
        {
            throw new Exception("The unbiased exponent value should be " + -(DOUBLE_EXPONENT_BIAS - 1) + " through " + DOUBLE_EXPONENT_BIAS + ".");
        }
    }
}