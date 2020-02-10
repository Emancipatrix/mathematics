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
package org.miaplacidus.mathematics.special;

import java.util.logging.Logger;
import org.miaplacidus.mathematics.number.complex.Complex;

/**
 *
 * @author Miaplacidus
 */
public class Hypergeometric {
    
    private static final Logger LOG = Logger.getLogger(Hypergeometric.class.getName());
    
    public static Complex hypergeometric(Complex a, Complex b, Complex c, Complex z, short precision) {
        Complex result = Gamma.gamma(c).divide(Gamma.gamma(a)).divide(Gamma.gamma(b));
        Complex tempMultiplier=Complex.ZERO;
        for (short s = 0; s < precision; s++) {
            Complex temp = Gamma.gamma(a.add(s)).multiply(Gamma.gamma(b.add(s))).divide(Gamma.gamma(c.add(s))).divide(factorial(s)).multiply(z.exponentiate(s));
            tempMultiplier = tempMultiplier.add(temp);
        }
        return result.multiply(tempMultiplier);
    }
    

    public static long factorial(long number) {
        long result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }
}
