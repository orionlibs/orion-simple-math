package io.github.orionlibs.orion_simple_math.probability.distribution;

import java.util.random.RandomGenerator;

public class NormalDistribution
{
    public static float getRandomNumber()
    {
        RandomGenerator randomGenerator = RandomGenerator.of("Random");
        return (float)randomGenerator.nextGaussian();
    }
}
