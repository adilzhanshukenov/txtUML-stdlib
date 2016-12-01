package hu.elte.txtuml.stdlib.math;

import java.math.RoundingMode;

import hu.elte.txtuml.api.model.Collection;

/**
 * Implementation class for BigDecimal interface for txtUML models.
 * @see 	BigDecimal
 * @author	Andrey Khasanov
 *
 */
public class BigDecimalImplementation implements BigDecimal {

	/**
	 * Protected constructor to make conversion faster
	 */
	protected BigDecimalImplementation(java.math.BigDecimal val) {
		this.num = val;
	}

	/**
	 * Extracts java.math.BigDecimal from BigDecimal. Usually used
	 * in cases, when there is an instance method that takes another
	 * BigDecimal as a parameter and we want to extract an original
	 * Java object to send it as a parameter to an original object
	 * method.
	 * The reason why this method is static is because an Interface
	 * object doesn't contain an original object, as it is contained
	 * in an Implementation object.
	 * This method is NOT private because some other External Classes
	 * can and do use such methods (such as BigDecimal's constructors
	 * use BigInteger's extract methods)
	 * 
	 * @see #add(BigDecimal)
	 * @see #equals(BigDecimal)
	 * @see BigDecimalImplementation#BigDecimalImplementation(BigInteger, MathContext)
	 */
	protected static java.math.BigDecimal getOrigBigDecimal(Object val) {
		if (val instanceof BigDecimal) {
			return ((BigDecimalImplementation)(BigDecimal) val).num;
		}
		else if (val instanceof BigDecimalImplementation) {
			return ((BigDecimalImplementation) val).num;
		}
		// Otherwise it's an error
		else return null;
	}

	/**
	 * Translates a {@code BigInteger} into a {@code BigDecimal}.
	 * The scale of the {@code BigDecimal} is zero.
	 *
	 * @param val {@code BigInteger} value to be converted to
	 *            {@code BigDecimal}.
	 */
	public BigDecimalImplementation(BigInteger val) {
		this.num = new java.math.BigDecimal(BigIntegerImplementation.getOrigBigInteger(val));
	}

	/**
	 * Translates a {@code BigInteger} unscaled value and an
	 * {@code int} scale into a {@code BigDecimal}.  The value of
	 * the {@code BigDecimal} is
	 * <tt>(unscaledVal &times; 10<sup>-scale</sup>)</tt>.
	 *
	 * @param unscaledVal unscaled value of the {@code BigDecimal}.
	 * @param scale scale of the {@code BigDecimal}.
	 */
	public BigDecimalImplementation(BigInteger unscaledVal, int scale) {
		this.num = new java.math.BigDecimal(BigIntegerImplementation.getOrigBigInteger(unscaledVal), scale);
	}

	/**
	 * Translates a {@code BigInteger} unscaled value and an
	 * {@code int} scale into a {@code BigDecimal}, with rounding
	 * according to the context settings.  The value of the
	 * {@code BigDecimal} is <tt>(unscaledVal &times;
	 * 10<sup>-scale</sup>)</tt>, rounded according to the
	 * {@code precision} and rounding mode settings.
	 *
	 * @param  unscaledVal unscaled value of the {@code BigDecimal}.
	 * @param  scale scale of the {@code BigDecimal}.
	 * @param  mc the context to use.
	 * @throws ArithmeticException if the result is inexact but the
	 *         rounding mode is {@code UNNECESSARY}.
	 * @since  1.5
	 */
	public BigDecimalImplementation(BigInteger unscaledVal, int scale, MathContext mc) {
		this.num = new java.math.BigDecimal(BigIntegerImplementation.getOrigBigInteger(unscaledVal), scale, MathContextImplementation.getOrigMathContext(mc));
	}

	/**
	 * Translates a {@code BigInteger} into a {@code BigDecimal}
	 * rounding according to the context settings.  The scale of the
	 * {@code BigDecimal} is zero.
	 *
	 * @param val {@code BigInteger} value to be converted to
	 *            {@code BigDecimal}.
	 * @param  mc the context to use.
	 * @throws ArithmeticException if the result is inexact but the
	 *         rounding mode is {@code UNNECESSARY}.
	 * @since  1.5
	 */
	public BigDecimalImplementation(BigInteger val, MathContext mc) {
		this.num = new java.math.BigDecimal(BigIntegerImplementation.getOrigBigInteger(val), MathContextImplementation.getOrigMathContext(mc));
	}

	/**
	 * Translates a character array representation of a
	 * {@code BigDecimal} into a {@code BigDecimal}, accepting the
	 * same sequence of characters as the {@link #BigDecimalImplementation(String)}
	 * constructor.
	 *
	 * <p>Note that if the sequence of characters is already available
	 * as a character array, using this constructor is faster than
	 * converting the {@code char} array to string and using the
	 * {@code BigDecimalImplementation(String)} constructor .
	 *
	 * @param in {@code char} array that is the source of characters.
	 * @throws NumberFormatException if {@code in} is not a valid
	 *         representation of a {@code BigDecimal}.
	 * @since  1.5
	 */
	public BigDecimalImplementation(char[] in) {
		this.num = new java.math.BigDecimal(in);
	}

	/**
	 * Translates a character array representation of a
	 * {@code BigDecimal} into a {@code BigDecimal}, accepting the
	 * same sequence of characters as the {@link #BigDecimalImplementation(String)}
	 * constructor, while allowing a sub-array to be specified.
	 *
	 * <p>Note that if the sequence of characters is already available
	 * within a character array, using this constructor is faster than
	 * converting the {@code char} array to string and using the
	 * {@code BigDecimalImplementation(String)} constructor .
	 *
	 * @param  in {@code char} array that is the source of characters.
	 * @param  offset first character in the array to inspect.
	 * @param  len number of characters to consider.
	 * @throws NumberFormatException if {@code in} is not a valid
	 *         representation of a {@code BigDecimal} or the defined subarray
	 *         is not wholly within {@code in}.
	 * @since  1.5
	 */
	public BigDecimalImplementation(char[] in, int offset, int len) {
		this.num = new java.math.BigDecimal(in, offset, len);
	}

	/**
	 * Translates a character array representation of a
	 * {@code BigDecimal} into a {@code BigDecimal}, accepting the
	 * same sequence of characters as the {@link #BigDecimalImplementation(String)}
	 * constructor, while allowing a sub-array to be specified and
	 * with rounding according to the context settings.
	 *
	 * <p>Note that if the sequence of characters is already available
	 * within a character array, using this constructor is faster than
	 * converting the {@code char} array to string and using the
	 * {@code BigDecimalImplementation(String)} constructor .
	 *
	 * @param  in {@code char} array that is the source of characters.
	 * @param  offset first character in the array to inspect.
	 * @param  len number of characters to consider..
	 * @param  mc the context to use.
	 * @throws ArithmeticException if the result is inexact but the
	 *         rounding mode is {@code UNNECESSARY}.
	 * @throws NumberFormatException if {@code in} is not a valid
	 *         representation of a {@code BigDecimal} or the defined subarray
	 *         is not wholly within {@code in}.
	 * @since  1.5
	 */
	public BigDecimalImplementation(char[] in, int offset, int len, MathContext mc) {
		this.num = new java.math.BigDecimal(in, offset, len, MathContextImplementation.getOrigMathContext(mc));
	}

	/**
	 * Translates a character array representation of a
	 * {@code BigDecimal} into a {@code BigDecimal}, accepting the
	 * same sequence of characters as the {@link #BigDecimalImplementation(String)}
	 * constructor and with rounding according to the context
	 * settings.
	 *
	 * <p>Note that if the sequence of characters is already available
	 * as a character array, using this constructor is faster than
	 * converting the {@code char} array to string and using the
	 * {@code BigDecimalImplementation(String)} constructor .
	 *
	 * @param  in {@code char} array that is the source of characters.
	 * @param  mc the context to use.
	 * @throws ArithmeticException if the result is inexact but the
	 *         rounding mode is {@code UNNECESSARY}.
	 * @throws NumberFormatException if {@code in} is not a valid
	 *         representation of a {@code BigDecimal}.
	 * @since  1.5
	 */
	public BigDecimalImplementation(char[] in, MathContext mc) {
		this.num = new java.math.BigDecimal(in, MathContextImplementation.getOrigMathContext(mc));
	}

	/**
	 * Translates a {@code double} into a {@code BigDecimal} which
	 * is the exact decimal representation of the {@code double}'s
	 * binary floating-point value.  The scale of the returned
	 * {@code BigDecimal} is the smallest value such that
	 * <tt>(10<sup>scale</sup> &times; val)</tt> is an integer.
	 * <p>
	 * <b>Notes:</b>
	 * <ol>
	 * <li>
	 * The results of this constructor can be somewhat unpredictable.
	 * One might assume that writing {@code new BigDecimal(0.1)} in
	 * Java creates a {@code BigDecimal} which is exactly equal to
	 * 0.1 (an unscaled value of 1, with a scale of 1), but it is
	 * actually equal to
	 * 0.1000000000000000055511151231257827021181583404541015625.
	 * This is because 0.1 cannot be represented exactly as a
	 * {@code double} (or, for that matter, as a binary fraction of
	 * any finite length).  Thus, the value that is being passed
	 * <i>in</i> to the constructor is not exactly equal to 0.1,
	 * appearances notwithstanding.
	 *
	 * <li>
	 * The {@code String} constructor, on the other hand, is
	 * perfectly predictable: writing {@code new BigDecimal("0.1")}
	 * creates a {@code BigDecimal} which is <i>exactly</i> equal to
	 * 0.1, as one would expect.  Therefore, it is generally
	 * recommended that the {@linkplain #BigDecimalImplementation(String)
	 * <tt>String</tt> constructor} be used in preference to this one.
	 *
	 * <li>
	 * When a {@code double} must be used as a source for a
	 * {@code BigDecimal}, note that this constructor provides an
	 * exact conversion; it does not give the same result as
	 * converting the {@code double} to a {@code String} using the
	 * {@link Double#toString(double)} method and then using the
	 * {@link #BigDecimalImplementation(String)} constructor.  To get that result,
	 * use the {@code static} {@link #valueOf(double)} method.
	 * </ol>
	 *
	 * @param val {@code double} value to be converted to
	 *        {@code BigDecimal}.
	 * @throws NumberFormatException if {@code val} is infinite or NaN.
	 */
	public BigDecimalImplementation(double val) {
		this.num = new java.math.BigDecimal(val);
	}

	/**
	 * Translates a {@code double} into a {@code BigDecimal}, with
	 * rounding according to the context settings.  The scale of the
	 * {@code BigDecimal} is the smallest value such that
	 * <tt>(10<sup>scale</sup> &times; val)</tt> is an integer.
	 *
	 * <p>The results of this constructor can be somewhat unpredictable
	 * and its use is generally not recommended; see the notes under
	 * the {@link #BigDecimalImplementation(double)} constructor.
	 *
	 * @param  val {@code double} value to be converted to
	 *         {@code BigDecimal}.
	 * @param  mc the context to use.
	 * @throws ArithmeticException if the result is inexact but the
	 *         RoundingMode is UNNECESSARY.
	 * @throws NumberFormatException if {@code val} is infinite or NaN.
	 * @since  1.5
	 */
	public BigDecimalImplementation(double val, MathContext mc) {
		this.num = new java.math.BigDecimal(val, MathContextImplementation.getOrigMathContext(mc));
	}

	/**
	 * Translates an {@code int} into a {@code BigDecimal}.  The
	 * scale of the {@code BigDecimal} is zero.
	 *
	 * @param val {@code int} value to be converted to
	 *            {@code BigDecimal}.
	 * @since  1.5
	 */
	public BigDecimalImplementation(int val) {
		this.num = new java.math.BigDecimal(val);
	}

	/**
	 * Translates an {@code int} into a {@code BigDecimal}, with
	 * rounding according to the context settings.  The scale of the
	 * {@code BigDecimal}, before any rounding, is zero.
	 *
	 * @param  val {@code int} value to be converted to {@code BigDecimal}.
	 * @param  mc the context to use.
	 * @throws ArithmeticException if the result is inexact but the
	 *         rounding mode is {@code UNNECESSARY}.
	 * @since  1.5
	 */
	public BigDecimalImplementation(int val, MathContext mc) {
		this.num = new java.math.BigDecimal(val, MathContextImplementation.getOrigMathContext(mc));
	}

	/**
	 * Translates a {@code long} into a {@code BigDecimal}.  The
	 * scale of the {@code BigDecimal} is zero.
	 *
	 * @param val {@code long} value to be converted to {@code BigDecimal}.
	 * @since  1.5
	 */
	public BigDecimalImplementation(long val) {
		this.num = new java.math.BigDecimal(val);
	}

	/**
	 * Translates a {@code long} into a {@code BigDecimal}, with
	 * rounding according to the context settings.  The scale of the
	 * {@code BigDecimal}, before any rounding, is zero.
	 *
	 * @param  val {@code long} value to be converted to {@code BigDecimal}.
	 * @param  mc the context to use.
	 * @throws ArithmeticException if the result is inexact but the
	 *         rounding mode is {@code UNNECESSARY}.
	 * @since  1.5
	 */
	public BigDecimalImplementation(long val, MathContext mc) {
		this.num = new java.math.BigDecimal(val, MathContextImplementation.getOrigMathContext(mc));
	}

	/**
	 * Translates the string representation of a {@code BigDecimal}
	 * into a {@code BigDecimal}.  The string representation consists
	 * of an optional sign, {@code '+'} (<tt> '&#92;u002B'</tt>) or
	 * {@code '-'} (<tt>'&#92;u002D'</tt>), followed by a sequence of
	 * zero or more decimal digits ("the integer"), optionally
	 * followed by a fraction, optionally followed by an exponent.
	 *
	 * <p>The fraction consists of a decimal point followed by zero
	 * or more decimal digits.  The string must contain at least one
	 * digit in either the integer or the fraction.  The number formed
	 * by the sign, the integer and the fraction is referred to as the
	 * <i>significand</i>.
	 *
	 * <p>The exponent consists of the character {@code 'e'}
	 * (<tt>'&#92;u0065'</tt>) or {@code 'E'} (<tt>'&#92;u0045'</tt>)
	 * followed by one or more decimal digits.  The value of the
	 * exponent must lie between -{@link Integer#MAX_VALUE} ({@link
	 * Integer#MIN_VALUE}+1) and {@link Integer#MAX_VALUE}, inclusive.
	 *
	 * <p>More formally, the strings this constructor accepts are
	 * described by the following grammar:
	 * <blockquote>
	 * <dl>
	 * <dt><i>BigDecimalString:</i>
	 * <dd><i>Sign<sub>opt</sub> Significand Exponent<sub>opt</sub></i>
	 * <dt><i>Sign:</i>
	 * <dd>{@code +}
	 * <dd>{@code -}
	 * <dt><i>Significand:</i>
	 * <dd><i>IntegerPart</i> {@code .} <i>FractionPart<sub>opt</sub></i>
	 * <dd>{@code .} <i>FractionPart</i>
	 * <dd><i>IntegerPart</i>
	 * <dt><i>IntegerPart:</i>
	 * <dd><i>Digits</i>
	 * <dt><i>FractionPart:</i>
	 * <dd><i>Digits</i>
	 * <dt><i>Exponent:</i>
	 * <dd><i>ExponentIndicator SignedInteger</i>
	 * <dt><i>ExponentIndicator:</i>
	 * <dd>{@code e}
	 * <dd>{@code E}
	 * <dt><i>SignedInteger:</i>
	 * <dd><i>Sign<sub>opt</sub> Digits</i>
	 * <dt><i>Digits:</i>
	 * <dd><i>Digit</i>
	 * <dd><i>Digits Digit</i>
	 * <dt><i>Digit:</i>
	 * <dd>any character for which {@link Character#isDigit}
	 * returns {@code true}, including 0, 1, 2 ...
	 * </dl>
	 * </blockquote>
	 *
	 * <p>The scale of the returned {@code BigDecimal} will be the
	 * number of digits in the fraction, or zero if the string
	 * contains no decimal point, subject to adjustment for any
	 * exponent; if the string contains an exponent, the exponent is
	 * subtracted from the scale.  The value of the resulting scale
	 * must lie between {@code Integer.MIN_VALUE} and
	 * {@code Integer.MAX_VALUE}, inclusive.
	 *
	 * <p>The character-to-digit mapping is provided by {@link
	 * java.lang.Character#digit} set to convert to radix 10.  The
	 * String may not contain any extraneous characters (whitespace,
	 * for example).
	 *
	 * <p><b>Examples:</b><br>
	 * The value of the returned {@code BigDecimal} is equal to
	 * <i>significand</i> &times; 10<sup>&nbsp;<i>exponent</i></sup>.
	 * For each string on the left, the resulting representation
	 * [{@code BigInteger}, {@code scale}] is shown on the right.
	 * <pre>
	 * "0"            [0,0]
	 * "0.00"         [0,2]
	 * "123"          [123,0]
	 * "-123"         [-123,0]
	 * "1.23E3"       [123,-1]
	 * "1.23E+3"      [123,-1]
	 * "12.3E+7"      [123,-6]
	 * "12.0"         [120,1]
	 * "12.3"         [123,1]
	 * "0.00123"      [123,5]
	 * "-1.23E-12"    [-123,14]
	 * "1234.5E-4"    [12345,5]
	 * "0E+7"         [0,-7]
	 * "-0"           [0,0]
	 * </pre>
	 *
	 * <p>Note: For values other than {@code float} and
	 * {@code double} NaN and &plusmn;Infinity, this constructor is
	 * compatible with the values returned by {@link Float#toString}
	 * and {@link Double#toString}.  This is generally the preferred
	 * way to convert a {@code float} or {@code double} into a
	 * BigDecimal, as it doesn't suffer from the unpredictability of
	 * the {@link #BigDecimalImplementation(double)} constructor.
	 *
	 * @param val String representation of {@code BigDecimal}.
	 *
	 * @throws NumberFormatException if {@code val} is not a valid
	 *         representation of a {@code BigDecimal}.
	 */
	public BigDecimalImplementation(String val) {
		this.num = new java.math.BigDecimal(val);
	}

	/**
	 * Translates the string representation of a {@code BigDecimal}
	 * into a {@code BigDecimal}, accepting the same strings as the
	 * {@link #BigDecimalImplementation(String)} constructor, with rounding
	 * according to the context settings.
	 *
	 * @param  val string representation of a {@code BigDecimal}.
	 * @param  mc the context to use.
	 * @throws ArithmeticException if the result is inexact but the
	 *         rounding mode is {@code UNNECESSARY}.
	 * @throws NumberFormatException if {@code val} is not a valid
	 *         representation of a BigDecimal.
	 * @since  1.5
	 */
	public BigDecimalImplementation(String val, MathContext mc) {
		this.num = new java.math.BigDecimal(val, MathContextImplementation.getOrigMathContext(mc));
	}

	private java.math.BigDecimal num; /* = java.math.BigDecimal.ZERO;*/

	@Override
	public BigDecimal abs() {
		return new BigDecimalImplementation(num.abs());
	}

	@Override
	public BigDecimal abs(MathContext mc) {
		return new BigDecimalImplementation(num.abs(MathContextImplementation.getOrigMathContext(mc)));
	}

	@Override
	public BigDecimal add(BigDecimal augend) {
		return new BigDecimalImplementation(num.add(getOrigBigDecimal(augend)));
	}

	@Override
	public BigDecimal add(BigDecimal augend, MathContext mc) {
		return new BigDecimalImplementation(num.add(getOrigBigDecimal(augend), MathContextImplementation.getOrigMathContext(mc)));
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
	public int compareTo(BigDecimal val) {
		return num.compareTo(getOrigBigDecimal(val));
	}

	@Override
	public BigDecimal divide(BigDecimal divisor) {
		return new BigDecimalImplementation(num.divide(getOrigBigDecimal(divisor)));
	}

	@Override
	public BigDecimal divide(BigDecimal divisor, int roundingMode) {
		return new BigDecimalImplementation(num.divide(getOrigBigDecimal(divisor), roundingMode));
	}

	@Override
	public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {
		return new BigDecimalImplementation(num.divide(getOrigBigDecimal(divisor), scale, roundingMode));
	}

	@Override
	public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
		return new BigDecimalImplementation(num.divide(getOrigBigDecimal(divisor), scale, roundingMode));
	}

	@Override
	public BigDecimal divide(BigDecimal divisor, MathContext mc) {
		return new BigDecimalImplementation(num.divide(getOrigBigDecimal(divisor), MathContextImplementation.getOrigMathContext(mc)));
	}

	@Override
	public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
		return new BigDecimalImplementation(num.divide(getOrigBigDecimal(divisor), roundingMode));
	}

	@Override
	public Collection<BigDecimal> divideAndRemainder(BigDecimal divisor) {
		java.math.BigDecimal[] arr = num.divideAndRemainder(getOrigBigDecimal(divisor));
		Collection<BigDecimal> result = new Collection.Empty<>();
		for (java.math.BigDecimal temp : arr) result = result.add(new BigDecimalImplementation(temp));
		return result;
	}

	@Override
	public Collection<BigDecimal> divideAndRemainder(BigDecimal divisor, MathContext mc) {
		java.math.BigDecimal[] arr = num.divideAndRemainder(getOrigBigDecimal(divisor), MathContextImplementation.getOrigMathContext(mc));
		Collection<BigDecimal> result = new Collection.Empty<>();
		for (java.math.BigDecimal temp : arr) result = result.add(new BigDecimalImplementation(temp));
		return result;
	}

	@Override
	public BigDecimal divideToIntegralValue(BigDecimal divisor) {
		return new BigDecimalImplementation(num.divideToIntegralValue(getOrigBigDecimal(divisor)));
	}

	@Override
	public BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc) {
		return new BigDecimalImplementation(num.divideToIntegralValue(getOrigBigDecimal(divisor), MathContextImplementation.getOrigMathContext(mc)));
	}

	@Override
	public double doubleValue() {
		return num.doubleValue();
	}

	@Override
	public boolean equals(BigDecimal x) {
		return num.equals(getOrigBigDecimal(x));
	}

	@Override
	public float floatValue() {
		return num.floatValue();
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
	public long longValue() {
		return num.longValue();
	}

	@Override
	public long longValueExact() {
		return num.longValueExact();
	}

	@Override
	public BigDecimal max(BigDecimal val) {
		return new BigDecimalImplementation(num.max(getOrigBigDecimal(val)));
	}

	@Override
	public BigDecimal min(BigDecimal val) {
		return new BigDecimalImplementation(num.min(getOrigBigDecimal(val)));
	}

	@Override
	public BigDecimal movePointLeft(int n) {
		return new BigDecimalImplementation(num.movePointLeft(n));
	}

	@Override
	public BigDecimal movePointRight(int n) {
		return new BigDecimalImplementation(num.movePointRight(n));
	}

	@Override
	public BigDecimal multiply(BigDecimal multiplicand) {
		return new BigDecimalImplementation(num.multiply(getOrigBigDecimal(multiplicand)));
	}

	@Override
	public BigDecimal multiply(BigDecimal multiplicand, MathContext mc) {
		return new BigDecimalImplementation(num.multiply(getOrigBigDecimal(multiplicand), MathContextImplementation.getOrigMathContext(mc)));
	}

	@Override
	public BigDecimal negate() {
		return new BigDecimalImplementation(num.negate());
	}

	@Override
	public BigDecimal negate(MathContext mc) {
		return new BigDecimalImplementation(num.negate(MathContextImplementation.getOrigMathContext(mc)));
	}

	@Override
	public BigDecimal plus() {
		return new BigDecimalImplementation(num.plus());
	}

	@Override
	public BigDecimal plus(MathContext mc) {
		return new BigDecimalImplementation(num.plus(MathContextImplementation.getOrigMathContext(mc)));
	}

	@Override
	public BigDecimal pow(int n) {
		return new BigDecimalImplementation(num.pow(n));
	}

	@Override
	public BigDecimal pow(int n, MathContext mc) {
		return new BigDecimalImplementation(num.pow(n, MathContextImplementation.getOrigMathContext(mc)));
	}

	@Override
	public int precision() {
		return num.precision();
	}

	@Override
	public BigDecimal remainder(BigDecimal divisor) {
		return new BigDecimalImplementation(num.remainder(getOrigBigDecimal(divisor)));
	}

	@Override
	public BigDecimal remainder(BigDecimal divisor, MathContext mc) {
		return new BigDecimalImplementation(num.remainder(getOrigBigDecimal(divisor), MathContextImplementation.getOrigMathContext(mc)));
	}

	@Override
	public BigDecimal round(MathContext mc) {
		return new BigDecimalImplementation(num.round(MathContextImplementation.getOrigMathContext(mc)));
	}

	@Override
	public int scale() {
		return num.scale();
	}

	@Override
	public BigDecimal scaleByPowerOfTen(int n) {
		return new BigDecimalImplementation(num.scaleByPowerOfTen(n));
	}

	@Override
	public BigDecimal setScale(int newScale) {
		return new BigDecimalImplementation(num.setScale(newScale));
	}

	@Override
	public BigDecimal setScale(int newScale, int roundingMode) {
		return new BigDecimalImplementation(num.setScale(newScale, roundingMode));
	}

	@Override
	public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
		return new BigDecimalImplementation(num.setScale(newScale, roundingMode));
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
	public BigDecimal stripTrailingZeros() {
		return new BigDecimalImplementation(num.stripTrailingZeros());
	}

	@Override
	public BigDecimal subtract(BigDecimal subtrahend) {
		return new BigDecimalImplementation(num.subtract(getOrigBigDecimal(subtrahend)));
	}

	@Override
	public BigDecimal subtract(BigDecimal subtrahend, MathContext mc) {
		return new BigDecimalImplementation(num.subtract(getOrigBigDecimal(subtrahend), MathContextImplementation.getOrigMathContext(mc)));
	}

	@Override
	public BigInteger toBigInteger() {
		return new BigIntegerImplementation(num.toBigInteger());
	}

	@Override
	public BigInteger toBigIntegerExact() {
		return new BigIntegerImplementation(num.toBigIntegerExact());
	}

	@Override
	public String toEngineeringString() {
		return num.toEngineeringString();
	}

	@Override
	public String toPlainString() {
		return num.toPlainString();
	}

	@Override
	public String toString() {
		return num.toString();
	}

	@Override
	public BigDecimal ulp() {
		return new BigDecimalImplementation(num.ulp());
	}

	@Override
	public BigInteger unscaledValue() {
		return new BigIntegerImplementation(num.unscaledValue());
	}
}
