/*
 * The MIT License
 *
 * Copyright 2020 Miaplacidus.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.miaplacidus.mathematics.prime;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Miaplacidus
 */
public class Prime extends Object {
    private static final Logger LOG = Logger.getLogger(Prime.class.getName());   
    
    private static final long[] STRONG_PSEUDOPRIMES = new long[]{
        2047, 1373653, 25326001, 3215031751L, 2152302898747L, 3474749660383L,
        341550071728321L, 3825123056546413051L
    };
    
    private static final int[] NTH_PRIMES_FOR_PSEUDOPRIMALITY = {
        1, 2, 3, 4, 5, 6, 7, 9, 12
    };
    
    private static final short[] PRIMALITY_TEST_BASES = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37
    };
    
    /**
     * The method utilises the deterministic variants of the Miller–Rabin primality test
     * to substantiate if the provided number is a prime number.
     * @param number that its primality is tested.
     * @return true if the number is prime; false if it is composite.
     */
    public static boolean prime(final long number) {
        if (number < 2) {
            return false;
        } else {
            for (short i = 0; i < PRIMALITY_TEST_BASES.length; i++) {
                if (number % PRIMALITY_TEST_BASES[i] == 0) {
                    return number == PRIMALITY_TEST_BASES[i];
                }
            }
            
            final short bases[] = primalityTestBase(number);
            
            final BigInteger n = BigInteger.valueOf(number);
            
            final long d = number - 1;
            final int s = Long.numberOfTrailingZeros(d);
            final long r = d >> s;
            
            for (short a : bases) {
                
            }
            
            throw new UnsupportedOperationException();
        }
    }
    
    private static short[] primalityTestBase(final long oddNumber) {
        for (short i = 0; i < STRONG_PSEUDOPRIMES.length; i++) {
            if (oddNumber < STRONG_PSEUDOPRIMES[i]) {
                return Arrays.copyOf(PRIMALITY_TEST_BASES,NTH_PRIMES_FOR_PSEUDOPRIMALITY[i]);
            }
        }
        return Arrays.copyOf(PRIMALITY_TEST_BASES,PRIMALITY_TEST_BASES.length);
    }
    
    public static long nextPrime(long number) {
        throw new UnsupportedOperationException();
    }
    
    public static List<Long> primeFactorise(long number) throws IllegalArgumentException {
        if (number < 2) {
            throw new IllegalArgumentException();
        } else {
            throw new UnsupportedOperationException();
        }
    }
    
    private Prime() {
        throw new AssertionError();
    }
    
    
}
