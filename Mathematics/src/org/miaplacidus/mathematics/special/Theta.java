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
 * @author Miaplacidus d'Orléans <miaplacidus.d.orleans@gmail.com>
 */
public class Theta {
    
    private static final Logger LOG = Logger.getLogger(Theta.class.getName());
    
    
    
    
    public static Complex theta1(Complex z, Complex tau, long fourierSeriesPrecision) {
        final Complex q=Complex.I.multiply(Math.PI).multiply(tau);
        Complex result = Complex.ZERO;
        
        for (long n = 0; n < fourierSeriesPrecision; n++) {
            Complex addend = Complex.ONE.negate().exponentiate(n)
                    .multiply(q.exponentiate(new Complex(n + 1 / 2).exponentiate(2)))
                    .multiply(z.multiply(2 * n + 1).sin());
            result = result.add(addend);
        }
        return result;        
    }
}
