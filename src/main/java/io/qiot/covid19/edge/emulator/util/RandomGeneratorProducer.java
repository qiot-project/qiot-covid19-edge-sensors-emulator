package io.qiot.covid19.edge.emulator.util;


import java.util.PrimitiveIterator.OfDouble;
import java.util.PrimitiveIterator.OfInt;
import java.util.Random;


import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class RandomGeneratorProducer {

    /**
     * Initialize a new random number generator that generates random numbers in
     * the
     * range [avg-delta-2, avg+delta+3]
     * 
     * @param avg
     *            - the avg value (inclusive)
     * @param delta
     *            - the delta value (inclusive)
     * @return
     */
    public OfInt intRandomNumberGenerator(int avg, int delta) {
        return new Random().ints(avg - delta - 1, avg + delta + 2)
                .iterator();
    }

    /**
     * Initialize a new random number generator that generates random numbers in
     * the
     * range [avg-delta-2, avg+delta+3]
     * 
     * @param avg
     *            - the avg value (inclusive)
     * @param delta
     *            - the delta value (inclusive)
     * @return
     */
    public OfDouble doubleRandomNumberGenerator(double avg, double delta) {
        return new Random().doubles(avg - delta - 1, avg + delta + 2)
                .iterator();
    }
}
