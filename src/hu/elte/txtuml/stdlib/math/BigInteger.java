package hu.elte.txtuml.stdlib.math;

import java.util.Random;

import hu.elte.txtuml.api.model.Collection;
import hu.elte.txtuml.api.model.external.ExternalClass;

/**
 * This class provides the functionality of the BigInteger Java class for txtUML models.
 *
 * @see		BigDecimal
 * @see		BigIntegerImplementation
 */

public interface BigInteger extends ExternalClass {

	/**
	 * The BigInteger constant zero.
	 *
	 * @since   1.2
	 */
	public static final BigInteger ZERO = new BigIntegerImplementation(java.math.BigInteger.ZERO);

	/**
	 * The BigInteger constant one.
	 *
	 * @since   1.2
	 */
	public static final BigInteger ONE  = new BigIntegerImplementation(java.math.BigInteger.ONE);

	/**
	 * The BigInteger constant ten.
	 *
	 * @since   1.5
	 */
	public static final BigInteger TEN  = new BigIntegerImplementation(java.math.BigInteger.TEN);

	/**
	 * Returns a positive BigInteger that is probably prime, with the
	 * specified bitLength. The probability that a BigInteger returned
	 * by this method is composite does not exceed 2<sup>-100</sup>.
	 *
	 * @param  bitLength bitLength of the returned BigInteger.
	 * @param  rnd source of random bits used to select candidates to be
	 *         tested for primality.
	 * @return a BigInteger of {@code bitLength} bits that is probably prime
	 * @throws ArithmeticException {@code bitLength < 2} or {@code bitLength} is too large.
	 * @see    #bitLength()
	 * @since 1.4
	 */
	public static BigInteger probablePrime(int bitLength, Random rnd) {
		return new BigIntegerImplementation(java.math.BigInteger.probablePrime(bitLength, rnd));
	}

	/**
	 * Returns a BigInteger whose value is equal to that of the
	 * specified {@code long}.  This "static factory method" is
	 * provided in preference to a ({@code long}) constructor
	 * because it allows for reuse of frequently used BigIntegers.
	 *
	 * @param  val value of the BigInteger to return.
	 * @return a BigInteger with the specified value.
	 */
	public static BigInteger valueOf(long val) {
		return new BigIntegerImplementation(java.math.BigInteger.valueOf(val));
	}


	/**
	 * Returns a BigInteger whose value is the absolute value of this
	 * BigInteger.
	 *
	 * @return {@code abs(this)}
	 */
	public BigInteger abs();

	/**
	 * Returns a BigInteger whose value is {@code (this + val)}.
	 *
	 * @param  val value to be added to this BigInteger.
	 * @return {@code this + val}
	 */
	public BigInteger add(BigInteger val);

	/**
	 * Returns a BigInteger whose value is {@code (this & val)}.  (This
	 * method returns a negative BigInteger if and only if this and val are
	 * both negative.)
	 *
	 * @param val value to be AND'ed with this BigInteger.
	 * @return {@code this & val}
	 */
	public BigInteger and(BigInteger val);

	/**
	 * Returns a BigInteger whose value is {@code (this & ~val)}.  This
	 * method, which is equivalent to {@code and(val.not())}, is provided as
	 * a convenience for masking operations.  (This method returns a negative
	 * BigInteger if and only if {@code this} is negative and {@code val} is
	 * positive.)
	 *
	 * @param val value to be complemented and AND'ed with this BigInteger.
	 * @return {@code this & ~val}
	 */
	public BigInteger andNot(BigInteger val);

	/**
	 * Returns the number of bits in the two's complement representation
	 * of this BigInteger that differ from its sign bit.  This method is
	 * useful when implementing bit-vector style sets atop BigIntegers.
	 *
	 * @return number of bits in the two's complement representation
	 *         of this BigInteger that differ from its sign bit.
	 */
	public int bitCount();

	/**
	 * Returns the number of bits in the minimal two's-complement
	 * representation of this BigInteger, <i>excluding</i> a sign bit.
	 * For positive BigIntegers, this is equivalent to the number of bits in
	 * the ordinary binary representation.  (Computes
	 * {@code (ceil(log2(this < 0 ? -this : this+1)))}.)
	 *
	 * @return number of bits in the minimal two's-complement
	 *         representation of this BigInteger, <i>excluding</i> a sign bit.
	 */
	public int bitLength();

	/**
	 * Returns the value of the specified number as a {@code byte},
	 * which may involve rounding or truncation.
	 *
	 * <p>This implementation returns the result of {@link #intValue} cast
	 * to a {@code byte}.
	 *
	 * @return  the numeric value represented by this object after conversion
	 *          to type {@code byte}.
	 * @since   JDK1.1
	 */
	public byte byteValue();

	/**
	 * Converts this {@code BigInteger} to a {@code byte}, checking
	 * for lost information.  If the value of this {@code BigInteger}
	 * is out of the range of the {@code byte} type, then an
	 * {@code ArithmeticException} is thrown.
	 *
	 * @return this {@code BigInteger} converted to a {@code byte}.
	 * @throws ArithmeticException if the value of {@code this} will
	 * not exactly fit in a {@code byte}.
	 * @see BigInteger#byteValue
	 * @since  1.8
	 */
	public byte byteValueExact();

	/**
	 * Returns a BigInteger whose value is equivalent to this BigInteger
	 * with the designated bit cleared.
	 * (Computes {@code (this & ~(1<<n))}.)
	 *
	 * @param  n index of bit to clear.
	 * @return {@code this & ~(1<<n)}
	 * @throws ArithmeticException {@code n} is negative.
	 */
	public BigInteger clearBit(int n);

	/**
	 * Compares this BigInteger with the specified BigInteger.  This
	 * method is provided in preference to individual methods for each
	 * of the six boolean comparison operators ({@literal <}, ==,
	 * {@literal >}, {@literal >=}, !=, {@literal <=}).  The suggested
	 * idiom for performing these comparisons is: {@code
	 * (x.compareTo(y)} &lt;<i>op</i>&gt; {@code 0)}, where
	 * &lt;<i>op</i>&gt; is one of the six comparison operators.
	 *
	 * @param  val BigInteger to which this BigInteger is to be compared.
	 * @return -1, 0 or 1 as this BigInteger is numerically less than, equal
	 *         to, or greater than {@code val}.
	 */
	public int compareTo(BigInteger val);

	/**
	 * Returns a BigInteger whose value is {@code (this / val)}.
	 *
	 * @param  val value by which this BigInteger is to be divided.
	 * @return {@code this / val}
	 * @throws ArithmeticException if {@code val} is zero.
	 */
	public BigInteger divide(BigInteger val);

	/**
	 * Returns a collection of two BigIntegers containing {@code (this / val)}
	 * followed by {@code (this % val)}.
	 *
	 * @param  val value by which this BigInteger is to be divided, and the
	 *         remainder computed.
	 * @return a collection of two BigIntegers: the quotient {@code (this / val)}
	 *         is the initial element, and the remainder {@code (this % val)}
	 *         is the final element.
	 * @throws ArithmeticException if {@code val} is zero.
	 */
	public Collection<BigInteger> divideAndRemainder(BigInteger val);

	/**
	 * Converts this BigInteger to a {@code double}.  This
	 * conversion is similar to the
	 * <i>narrowing primitive conversion</i> from {@code double} to
	 * {@code float} as defined in section 5.1.3 of
	 * <cite>The Java&trade; Language Specification</cite>:
	 * if this BigInteger has too great a magnitude
	 * to represent as a {@code double}, it will be converted to
	 * {@link Double#NEGATIVE_INFINITY} or {@link
	 * Double#POSITIVE_INFINITY} as appropriate.  Note that even when
	 * the return value is finite, this conversion can lose
	 * information about the precision of the BigInteger value.
	 *
	 * @return this BigInteger converted to a {@code double}.
	 */
	public double doubleValue();

	/**
	 * Compares this BigInteger with the specified Object for equality.
	 *
	 * @param  x Object to which this BigInteger is to be compared.
	 * @return {@code true} if and only if the specified Object is a
	 *         BigInteger whose value is numerically equal to this BigInteger.
	 */
	public boolean equals(Object x);

	/**
	 * Returns a BigInteger whose value is equivalent to this BigInteger
	 * with the designated bit flipped.
	 * (Computes {@code (this ^ (1<<n))}.)
	 *
	 * @param  n index of bit to flip.
	 * @return {@code this ^ (1<<n)}
	 * @throws ArithmeticException {@code n} is negative.
	 */
	public BigInteger flipBit(int n);

	/**
	 * Converts this BigInteger to a {@code float}.  This
	 * conversion is similar to the
	 * <i>narrowing primitive conversion</i> from {@code double} to
	 * {@code float} as defined in section 5.1.3 of
	 * <cite>The Java&trade; Language Specification</cite>:
	 * if this BigInteger has too great a magnitude
	 * to represent as a {@code float}, it will be converted to
	 * {@link Float#NEGATIVE_INFINITY} or {@link
	 * Float#POSITIVE_INFINITY} as appropriate.  Note that even when
	 * the return value is finite, this conversion can lose
	 * information about the precision of the BigInteger value.
	 *
	 * @return this BigInteger converted to a {@code float}.
	 */
	public float floatValue();

	/**
	 * Returns a BigInteger whose value is the greatest common divisor of
	 * {@code abs(this)} and {@code abs(val)}.  Returns 0 if
	 * {@code this == 0 && val == 0}.
	 *
	 * @param  val value with which the GCD is to be computed.
	 * @return {@code GCD(abs(this), abs(val))}
	 */
	public BigInteger gcd(BigInteger val);

	/**
	 * Returns the index of the rightmost (lowest-order) one bit in this
	 * BigInteger (the number of zero bits to the right of the rightmost
	 * one bit).  Returns -1 if this BigInteger contains no one bits.
	 * (Computes {@code (this == 0? -1 : log2(this & -this))}.)
	 *
	 * @return index of the rightmost one bit in this BigInteger.
	 */
	public int getLowestSetBit();

	/**
	 * Returns the hash code for this BigInteger.
	 *
	 * @return hash code for this BigInteger.
	 */
	public int hashCode();

	/**
	 * Converts this BigInteger to an {@code int}.  This
	 * conversion is analogous to a
	 * <i>narrowing primitive conversion</i> from {@code long} to
	 * {@code int} as defined in section 5.1.3 of
	 * <cite>The Java&trade; Language Specification</cite>:
	 * if this BigInteger is too big to fit in an
	 * {@code int}, only the low-order 32 bits are returned.
	 * Note that this conversion can lose information about the
	 * overall magnitude of the BigInteger value as well as return a
	 * result with the opposite sign.
	 *
	 * @return this BigInteger converted to an {@code int}.
	 * @see #intValueExact()
	 */
	public int intValue();

	/**
	 * Converts this {@code BigInteger} to an {@code int}, checking
	 * for lost information.  If the value of this {@code BigInteger}
	 * is out of the range of the {@code int} type, then an
	 * {@code ArithmeticException} is thrown.
	 *
	 * @return this {@code BigInteger} converted to an {@code int}.
	 * @throws ArithmeticException if the value of {@code this} will
	 * not exactly fit in a {@code int}.
	 * @see BigInteger#intValue
	 * @since  1.8
	 */
	public int intValueExact();

	/**
	 * Returns {@code true} if this BigInteger is probably prime,
	 * {@code false} if it's definitely composite.  If
	 * {@code certainty} is &le; 0, {@code true} is
	 * returned.
	 *
	 * @param  certainty a measure of the uncertainty that the caller is
	 *         willing to tolerate: if the call returns {@code true}
	 *         the probability that this BigInteger is prime exceeds
	 *         (1 - 1/2<sup>{@code certainty}</sup>).  The execution time of
	 *         this method is proportional to the value of this parameter.
	 * @return {@code true} if this BigInteger is probably prime,
	 *         {@code false} if it's definitely composite.
	 */
	public boolean isProbablePrime(int certainty);

	/**
	 * Converts this BigInteger to a {@code long}.  This
	 * conversion is analogous to a
	 * <i>narrowing primitive conversion</i> from {@code long} to
	 * {@code int} as defined in section 5.1.3 of
	 * <cite>The Java&trade; Language Specification</cite>:
	 * if this BigInteger is too big to fit in a
	 * {@code long}, only the low-order 64 bits are returned.
	 * Note that this conversion can lose information about the
	 * overall magnitude of the BigInteger value as well as return a
	 * result with the opposite sign.
	 *
	 * @return this BigInteger converted to a {@code long}.
	 * @see #longValueExact()
	 */
	public long longValue();

	/**
	 * Converts this {@code BigInteger} to a {@code long}, checking
	 * for lost information.  If the value of this {@code BigInteger}
	 * is out of the range of the {@code long} type, then an
	 * {@code ArithmeticException} is thrown.
	 *
	 * @return this {@code BigInteger} converted to a {@code long}.
	 * @throws ArithmeticException if the value of {@code this} will
	 * not exactly fit in a {@code long}.
	 * @see BigInteger#longValue
	 * @since  1.8
	 */
	public long longValueExact();

	/**
	 * Returns the maximum of this BigInteger and {@code val}.
	 *
	 * @param  val value with which the maximum is to be computed.
	 * @return the BigInteger whose value is the greater of this and
	 *         {@code val}.  If they are equal, either may be returned.
	 */
	public BigInteger max(BigInteger val);

	/**
	 * Returns the minimum of this BigInteger and {@code val}.
	 *
	 * @param  val value with which the minimum is to be computed.
	 * @return the BigInteger whose value is the lesser of this BigInteger and
	 *         {@code val}.  If they are equal, either may be returned.
	 */
	public BigInteger min(BigInteger val);

	/**
	 * Returns a BigInteger whose value is {@code (this mod m}).  This method
	 * differs from {@code remainder} in that it always returns a
	 * <i>non-negative</i> BigInteger.
	 *
	 * @param  m the modulus.
	 * @return {@code this mod m}
	 * @throws ArithmeticException {@code m} &le; 0
	 * @see    #remainder
	 */
	public BigInteger mod(BigInteger m);

	/**
	 * Returns a BigInteger whose value is {@code (this}<sup>-1</sup> {@code mod m)}.
	 *
	 * @param  m the modulus.
	 * @return {@code this}<sup>-1</sup> {@code mod m}.
	 * @throws ArithmeticException {@code  m} &le; 0, or this BigInteger
	 *         has no multiplicative inverse mod m (that is, this BigInteger
	 *         is not <i>relatively prime</i> to m).
	 */
	public BigInteger modInverse(BigInteger m);

	/**
	 * Returns a BigInteger whose value is
	 * <tt>(this<sup>exponent</sup> mod m)</tt>.  (Unlike {@code pow}, this
	 * method permits negative exponents.)
	 *
	 * @param  exponent the exponent.
	 * @param  m the modulus.
	 * @return <tt>this<sup>exponent</sup> mod m</tt>
	 * @throws ArithmeticException {@code m} &le; 0 or the exponent is
	 *         negative and this BigInteger is not <i>relatively
	 *         prime</i> to {@code m}.
	 * @see    #modInverse
	 */
	public BigInteger modPow(BigInteger exponent, BigInteger m);

	/**
	 * Returns a BigInteger whose value is {@code (this * val)}.
	 *
	 * @param  val value to be multiplied by this BigInteger.
	 * @return {@code this * val}
	 */
	public BigInteger multiply(BigInteger val);

	/**
	 * Returns a BigInteger whose value is {@code (-this)}.
	 *
	 * @return {@code -this}
	 */
	public BigInteger negate();

	/**
	 * Returns the first integer greater than this {@code BigInteger} that
	 * is probably prime.  The probability that the number returned by this
	 * method is composite does not exceed 2<sup>-100</sup>. This method will
	 * never skip over a prime when searching: if it returns {@code p}, there
	 * is no prime {@code q} such that {@code this < q < p}.
	 *
	 * @return the first integer greater than this {@code BigInteger} that
	 *         is probably prime.
	 * @throws ArithmeticException {@code this < 0} or {@code this} is too large.
	 * @since 1.5
	 */
	public BigInteger nextProbablePrime();

	/**
	 * Returns a BigInteger whose value is {@code (~this)}.  (This method
	 * returns a negative value if and only if this BigInteger is
	 * non-negative.)
	 *
	 * @return {@code ~this}
	 */
	public BigInteger not();

	/**
	 * Returns a BigInteger whose value is {@code (this | val)}.  (This method
	 * returns a negative BigInteger if and only if either this or val is
	 * negative.)
	 *
	 * @param val value to be OR'ed with this BigInteger.
	 * @return {@code this | val}
	 */
	public BigInteger or(BigInteger val);

	/**
	 * Returns a BigInteger whose value is <tt>(this<sup>exponent</sup>)</tt>.
	 * Note that {@code exponent} is an integer rather than a BigInteger.
	 *
	 * @param  exponent exponent to which this BigInteger is to be raised.
	 * @return <tt>this<sup>exponent</sup></tt>
	 * @throws ArithmeticException {@code exponent} is negative.  (This would
	 *         cause the operation to yield a non-integer value.)
	 */
	public BigInteger pow(int exponent);

	/**
	 * Returns a BigInteger whose value is {@code (this % val)}.
	 *
	 * @param  val value by which this BigInteger is to be divided, and the
	 *         remainder computed.
	 * @return {@code this % val}
	 * @throws ArithmeticException if {@code val} is zero.
	 */
	public BigInteger remainder(BigInteger val);

	/**
	 * Returns a BigInteger whose value is equivalent to this BigInteger
	 * with the designated bit set.  (Computes {@code (this | (1<<n))}.)
	 *
	 * @param  n index of bit to set.
	 * @return {@code this | (1<<n)}
	 * @throws ArithmeticException {@code n} is negative.
	 */
	public BigInteger setBit(int n);

	/**
	 * Returns a BigInteger whose value is {@code (this << n)}.
	 * The shift distance, {@code n}, may be negative, in which case
	 * this method performs a right shift.
	 * (Computes <tt>floor(this * 2<sup>n</sup>)</tt>.)
	 *
	 * @param  n shift distance, in bits.
	 * @return {@code this << n}
	 * @see #shiftRight
	 */
	public BigInteger shiftLeft(int n);

	/**
	 * Returns a BigInteger whose value is {@code (this >> n)}.  Sign
	 * extension is performed.  The shift distance, {@code n}, may be
	 * negative, in which case this method performs a left shift.
	 * (Computes <tt>floor(this / 2<sup>n</sup>)</tt>.)
	 *
	 * @param  n shift distance, in bits.
	 * @return {@code this >> n}
	 * @see #shiftLeft
	 */
	public BigInteger shiftRight(int n);

	/**
	 * Returns the value of the specified number as a {@code short},
	 * which may involve rounding or truncation.
	 *
	 * <p>This implementation returns the result of {@link #intValue} cast
	 * to a {@code short}.
	 *
	 * @return  the numeric value represented by this object after conversion
	 *          to type {@code short}.
	 * @since   JDK1.1
	 */
	public short shortValue();

	/**
	 * Converts this {@code BigInteger} to a {@code short}, checking
	 * for lost information.  If the value of this {@code BigInteger}
	 * is out of the range of the {@code short} type, then an
	 * {@code ArithmeticException} is thrown.
	 *
	 * @return this {@code BigInteger} converted to a {@code short}.
	 * @throws ArithmeticException if the value of {@code this} will
	 * not exactly fit in a {@code short}.
	 * @see BigInteger#shortValue
	 * @since  1.8
	 */
	public short shortValueExact();

	/**
	 * Returns the signum function of this BigInteger.
	 *
	 * @return -1, 0 or 1 as the value of this BigInteger is negative, zero or
	 *         positive.
	 */
	public int signum();

	/**
	 * Returns a BigInteger whose value is {@code (this - val)}.
	 *
	 * @param  val value to be subtracted from this BigInteger.
	 * @return {@code this - val}
	 */
	public BigInteger subtract(BigInteger val);

	/**
	 * Returns {@code true} if and only if the designated bit is set.
	 * (Computes {@code ((this & (1<<n)) != 0)}.)
	 *
	 * @param  n index of bit to test.
	 * @return {@code true} if and only if the designated bit is set.
	 * @throws ArithmeticException {@code n} is negative.
	 */
	public boolean testBit(int n);

	/**
	 * Returns a Byte collection containing the two's-complement
	 * representation of this BigInteger.  The Byte collection will be in
	 * <i>big-endian</i> byte-order: the most significant byte is in
	 * the zeroth element.  The collection will contain the minimum number
	 * of bytes required to represent this BigInteger, including at
	 * least one sign bit, which is {@code (ceil((this.bitLength() +
	 * 1)/8))}.  (This representation is compatible with the
	 * {@link BigIntegerImplementation#BigIntegerImplementation(byte[]) (byte[])} constructor.)
	 *
	 * @return a Byte collection containing the two's-complement representation of
	 *         this BigInteger.
	 * @see    BigIntegerImplementation#BigIntegerImplementation(byte[])
	 */
	public Collection<Byte> toByteArray();

	/**
	 * Returns the decimal String representation of this BigInteger.
	 * The digit-to-character mapping provided by
	 * {@code Character.forDigit} is used, and a minus sign is
	 * prepended if appropriate.  (This representation is compatible
	 * with the {@link BigIntegerImplementation#BigIntegerImplementation(String) (String)} constructor, and
	 * allows for String concatenation with Java's + operator.)
	 *
	 * @return decimal String representation of this BigInteger.
	 * @see    Character#forDigit
	 * @see    BigIntegerImplementation#BigIntegerImplementation(java.lang.String)
	 */
	public String toString();

	/**
	 * Returns the String representation of this BigInteger in the
	 * given radix.  If the radix is outside the range from {@link
	 * Character#MIN_RADIX} to {@link Character#MAX_RADIX} inclusive,
	 * it will default to 10 (as is the case for
	 * {@code Integer.toString}).  The digit-to-character mapping
	 * provided by {@code Character.forDigit} is used, and a minus
	 * sign is prepended if appropriate.  (This representation is
	 * compatible with the {@link BigIntegerImplementation#BigIntegerImplementation(String, int) (String,
	 * int)} constructor.)
	 *
	 * @param  radix  radix of the String representation.
	 * @return String representation of this BigInteger in the given radix.
	 * @see    Integer#toString
	 * @see    Character#forDigit
	 * @see    BigIntegerImplementation#BigIntegerImplementation(java.lang.String, int)
	 */
	public String toString(int radix);

	/**
	 * Returns a BigInteger whose value is {@code (this ^ val)}.  (This method
	 * returns a negative BigInteger if and only if exactly one of this and
	 * val are negative.)
	 *
	 * @param val value to be XOR'ed with this BigInteger.
	 * @return {@code this ^ val}
	 */
	public BigInteger xor(BigInteger val);
}
