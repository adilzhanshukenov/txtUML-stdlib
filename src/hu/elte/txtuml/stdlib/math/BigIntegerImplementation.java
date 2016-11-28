package hu.elte.txtuml.stdlib.math;

import java.util.Random;

import hu.elte.txtuml.api.model.Collection;

/**
 * Implementation class for BigInteger interface for txtUML models.
 * @see 	BigInteger
 * @author	Andrey Khasanov
 *
 */

public class BigIntegerImplementation implements BigInteger {

	/*
	 * Protected constructor to make conversion faster
	 */
	protected BigIntegerImplementation(java.math.BigInteger val) {
		this.num = val;
	}

	/*
	 * Extract java.math.BigInteger from BigInteger
	 */
	protected static java.math.BigInteger getOrigBigInteger(Object val) {
		if (val instanceof BigIntegerImplementation) {
			return ((BigIntegerImplementation) val).num;
		}
		else if (val instanceof BigInteger) {
			return ((BigIntegerImplementation)(BigInteger) val).num;
		}
		// Otherwise it's an error
		else return null;
	}

	//Constructors

	/**
	 * Translates a byte array containing the two's-complement binary
	 * representation of a BigInteger into a BigInteger.  The input array is
	 * assumed to be in <i>big-endian</i> byte-order: the most significant
	 * byte is in the zeroth element.
	 *
	 * @param  val big-endian two's-complement binary representation of
	 *         BigInteger.
	 * @throws NumberFormatException {@code val} is zero bytes long.
	 */
	public BigIntegerImplementation(byte[] val) {
		this.num = new java.math.BigInteger(val);
	}

	/**
	 * Translates the sign-magnitude representation of a BigInteger into a
	 * BigInteger.  The sign is represented as an integer signum value: -1 for
	 * negative, 0 for zero, or 1 for positive.  The magnitude is a byte array
	 * in <i>big-endian</i> byte-order: the most significant byte is in the
	 * zeroth element.  A zero-length magnitude array is permissible, and will
	 * result in a BigInteger value of 0, whether signum is -1, 0 or 1.
	 *
	 * @param  signum signum of the number (-1 for negative, 0 for zero, 1
	 *         for positive).
	 * @param  magnitude big-endian binary representation of the magnitude of
	 *         the number.
	 * @throws NumberFormatException {@code signum} is not one of the three
	 *         legal values (-1, 0, and 1), or {@code signum} is 0 and
	 *         {@code magnitude} contains one or more non-zero bytes.
	 */
	public BigIntegerImplementation(int signum, byte[] magnitude) {
		this.num = new java.math.BigInteger(signum, magnitude);
	}

	/**
	 * Constructs a randomly generated positive BigInteger that is probably
	 * prime, with the specified bitLength.
	 *
	 * <p>It is recommended that the {@link #probablePrime probablePrime}
	 * method be used in preference to this constructor unless there
	 * is a compelling need to specify a certainty.
	 *
	 * @param  bitLength bitLength of the returned BigInteger.
	 * @param  certainty a measure of the uncertainty that the caller is
	 *         willing to tolerate.  The probability that the new BigInteger
	 *         represents a prime number will exceed
	 *         (1 - 1/2<sup>{@code certainty}</sup>).  The execution time of
	 *         this constructor is proportional to the value of this parameter.
	 * @param  rnd source of random bits used to select candidates to be
	 *         tested for primality.
	 * @throws ArithmeticException {@code bitLength < 2} or {@code bitLength} is too large.
	 * @see    #bitLength()
	 */
	public BigIntegerImplementation(int bitLength, int certainty, Random rnd) {
		this.num = new java.math.BigInteger(bitLength, certainty, rnd);
	}

	/**
	 * Constructs a randomly generated BigInteger, uniformly distributed over
	 * the range 0 to (2<sup>{@code numBits}</sup> - 1), inclusive.
	 * The uniformity of the distribution assumes that a fair source of random
	 * bits is provided in {@code rnd}.  Note that this constructor always
	 * constructs a non-negative BigInteger.
	 *
	 * @param  numBits maximum bitLength of the new BigInteger.
	 * @param  rnd source of randomness to be used in computing the new
	 *         BigInteger.
	 * @throws IllegalArgumentException {@code numBits} is negative.
	 * @see #bitLength()
	 */
	public BigIntegerImplementation(int numBits, Random rnd) {
		this.num = new java.math.BigInteger(numBits, rnd);
	}

	/**
	 * Translates the decimal String representation of a BigInteger into a
	 * BigInteger.  The String representation consists of an optional minus
	 * sign followed by a sequence of one or more decimal digits.  The
	 * character-to-digit mapping is provided by {@code Character.digit}.
	 * The String may not contain any extraneous characters (whitespace, for
	 * example).
	 *
	 * @param val decimal String representation of BigInteger.
	 * @throws NumberFormatException {@code val} is not a valid representation
	 *         of a BigInteger.
	 * @see    Character#digit
	 */
	public BigIntegerImplementation(String val) {
		this.num = new java.math.BigInteger(val);
	}

	/**
	 * Translates the String representation of a BigInteger in the
	 * specified radix into a BigInteger.  The String representation
	 * consists of an optional minus or plus sign followed by a
	 * sequence of one or more digits in the specified radix.  The
	 * character-to-digit mapping is provided by {@code
	 * Character.digit}.  The String may not contain any extraneous
	 * characters (whitespace, for example).
	 *
	 * @param val String representation of BigInteger.
	 * @param radix radix to be used in interpreting {@code val}.
	 * @throws NumberFormatException {@code val} is not a valid representation
	 *         of a BigInteger in the specified radix, or {@code radix} is
	 *         outside the range from {@link Character#MIN_RADIX} to
	 *         {@link Character#MAX_RADIX}, inclusive.
	 * @see    Character#digit
	 */
	public BigIntegerImplementation(String val, int radix) {
		this.num = new java.math.BigInteger(val, radix);
	}

	private java.math.BigInteger num;

	@Override
	public BigInteger abs() {
		return new BigIntegerImplementation(num.abs());
	}

	@Override
	public BigInteger add(BigInteger val) {
		return new BigIntegerImplementation(num.add(getOrigBigInteger(val)));
	}

	@Override
	public BigInteger and(BigInteger val) {
		return new BigIntegerImplementation(num.and(getOrigBigInteger(val)));
	}

	@Override
	public BigInteger andNot(BigInteger val) {
		return new BigIntegerImplementation(num.andNot(getOrigBigInteger(val)));
	}

	@Override
	public int bitCount() {
		return num.bitCount();
	}

	@Override
	public int bitLength() {
		return num.bitLength();
	}

	@Override
	public byte byteValue() {
		return num.byteValue();
	}

	@Override
	public byte byteValueExact() {
		return num.byteValueExact();
	}

	@Override
	public BigInteger clearBit(int n) {
		return new BigIntegerImplementation(num.clearBit(n));
	}

	@Override
	public int compareTo(BigInteger val) {
		return num.compareTo(getOrigBigInteger(val));
	}

	@Override
	public BigInteger divide(BigInteger val) {
		return new BigIntegerImplementation(num.divide(getOrigBigInteger(val)));
	}

	@Override
	public Collection<BigInteger> divideAndRemainder(BigInteger val) {
		java.math.BigInteger[] arr = num.divideAndRemainder(getOrigBigInteger(val));
		Collection<BigInteger> result = new Collection.Empty<>();
		for (java.math.BigInteger temp : arr) result = result.add(new BigIntegerImplementation(temp));
		return result;
	}

	@Override
	public double doubleValue() {
		return num.doubleValue();
	}

	@Override
	public boolean equals(Object x) {
		return num.equals(getOrigBigInteger(x));
	}

	@Override
	public BigInteger flipBit(int n) {
		return new BigIntegerImplementation(num.flipBit(n));
	}

	@Override
	public float floatValue() {
		return num.floatValue();
	}

	@Override
	public BigInteger gcd(BigInteger val) {
		return new BigIntegerImplementation(num.gcd(getOrigBigInteger(val)));
	}

	@Override
	public int getLowestSetBit() {
		return num.getLowestSetBit();
	}

	@Override
	public int hashCode() {
		return num.hashCode();
	}

	@Override
	public int intValue() {
		return num.intValue();
	}

	@Override
	public int intValueExact() {
		return num.intValueExact();
	}

	@Override
	public boolean isProbablePrime(int certainty) {
		return num.isProbablePrime(certainty);
	}

	@Override
	public long longValue() {
		return num.longValue();
	}

	@Override
	public long longValueExact() {
		return num.longValueExact();
	}

	@Override
	public BigInteger max(BigInteger val) {
		return new BigIntegerImplementation(num.max(getOrigBigInteger(val)));
	}

	@Override
	public BigInteger min(BigInteger val) {
		return new BigIntegerImplementation(num.min(getOrigBigInteger(val)));
	}

	@Override
	public BigInteger mod(BigInteger m) {
		return new BigIntegerImplementation(num.mod(getOrigBigInteger(m)));
	}

	@Override
	public BigInteger modInverse(BigInteger m) {
		return new BigIntegerImplementation(num.modInverse(getOrigBigInteger(m)));
	}

	@Override
	public BigInteger modPow(BigInteger exponent, BigInteger m) {
		return new BigIntegerImplementation(num.modPow(getOrigBigInteger(exponent), getOrigBigInteger(m)));
	}

	@Override
	public BigInteger multiply(BigInteger val) {
		return new BigIntegerImplementation(num.multiply(getOrigBigInteger(val)));
	}

	@Override
	public BigInteger negate() {
		return new BigIntegerImplementation(num.negate());
	}

	@Override
	public BigInteger nextProbablePrime() {
		return new BigIntegerImplementation(num.nextProbablePrime());
	}

	@Override
	public BigInteger not() {
		return new BigIntegerImplementation(num.not());
	}

	@Override
	public BigInteger or(BigInteger val) {
		return new BigIntegerImplementation(num.or(getOrigBigInteger(val)));
	}

	@Override
	public BigInteger pow(int exponent) {
		return new BigIntegerImplementation(num.pow(exponent));
	}

	@Override
	public BigInteger remainder(BigInteger val) {
		return new BigIntegerImplementation(num.remainder(getOrigBigInteger(val)));
	}

	@Override
	public BigInteger setBit(int n) {
		return new BigIntegerImplementation(num.setBit(n));
	}

	@Override
	public BigInteger shiftLeft(int n) {
		return new BigIntegerImplementation(num.shiftLeft(n));
	}

	@Override
	public BigInteger shiftRight(int n) {
		return new BigIntegerImplementation(num.shiftRight(n));
	}

	@Override
	public short shortValue() {
		return num.shortValue();
	}

	@Override
	public short shortValueExact() {
		return num.shortValueExact();
	}

	@Override
	public int signum() {
		return num.signum();
	}

	@Override
	public BigInteger subtract(BigInteger val) {
		return new BigIntegerImplementation(num.subtract(getOrigBigInteger(val)));
	}

	@Override
	public boolean testBit(int n) {
		return num.testBit(n);
	}

	@Override
	public Collection<Byte> toByteArray() {
		byte[] arr = num.toByteArray();
		Collection<Byte> result = new Collection.Empty<>();
		for (byte b : arr) result = result.add(b);
		return result;
	}

	@Override
	public String toString() {
		return num.toString();
	}

	@Override
	public String toString(int radix) {
		return num.toString(radix);
	}

	@Override
	public BigInteger xor(BigInteger val) {
		return new BigIntegerImplementation(num.xor(getOrigBigInteger(val)));
	}
}
