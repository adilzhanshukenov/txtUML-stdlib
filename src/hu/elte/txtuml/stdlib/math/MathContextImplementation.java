package hu.elte.txtuml.stdlib.math;

import java.math.RoundingMode;

/**
 * Implementation class for MathContext interface for txtUML models.
 * @see 	MathContext
 * @author	Andrey Khasanov
 *
 */
public class MathContextImplementation implements MathContext {

	/*
	 * Protected constructor to make conversion faster
	 */
	protected MathContextImplementation(java.math.MathContext mc) {
		this.mc = mc;
	}

	/*
	 * Extract java.math.MathContext from MathContext
	 */
	protected static java.math.MathContext getOrigMathContext(Object val) {
		if (val instanceof MathContextImplementation) {
			return ((MathContextImplementation) val).mc;
		}
		else if (val instanceof MathContext) {
			return ((MathContextImplementation)(MathContext) val).mc;
		}
		// Otherwise it's an error
		else return null;
	}

	/**
	 * Constructs a new {@code MathContext} with the specified
	 * precision and the {@link RoundingMode#HALF_UP HALF_UP} rounding
	 * mode.
	 *
	 * @param setPrecision The non-negative {@code int} precision setting.
	 * @throws IllegalArgumentException if the {@code setPrecision} parameter is less
	 *         than zero.
	 */
	public MathContextImplementation(int setPrecision) {
		this.mc = new java.math.MathContext(setPrecision);
	}

	/**
	 * Constructs a new {@code MathContext} with a specified
	 * precision and rounding mode.
	 *
	 * @param setPrecision The non-negative {@code int} precision setting.
	 * @param setRoundingMode The rounding mode to use.
	 * @throws IllegalArgumentException if the {@code setPrecision} parameter is less
	 *         than zero.
	 * @throws NullPointerException if the rounding mode argument is {@code null}
	 */
	public MathContextImplementation(int setPrecision, RoundingMode setRoundingMode) {
		this.mc = new java.math.MathContext(setPrecision, setRoundingMode);
	}

	/**
	 * Constructs a new {@code MathContext} from a string.
	 *
	 * The string must be in the same format as that produced by the
	 * {@link #toString} method.
	 *
	 * <p>An {@code IllegalArgumentException} is thrown if the precision
	 * section of the string is out of range ({@code < 0}) or the string is
	 * not in the format created by the {@link #toString} method.
	 *
	 * @param val The string to be parsed
	 * @throws IllegalArgumentException if the precision section is out of range
	 * or of incorrect format
	 * @throws NullPointerException if the argument is {@code null}
	 */
	public MathContextImplementation(String val) {
		this.mc = new java.math.MathContext(val);
	}

	private java.math.MathContext mc;

	@Override
	public boolean equals(Object x) {
		return mc.equals(getOrigMathContext(x));
	}

	@Override
	public int getPrecision() {
		return mc.getPrecision();
	}

	@Override
	public RoundingMode getRoundingMode() {
		return mc.getRoundingMode();
	}

	@Override
	public int hashCode() {
		return mc.hashCode();
	}

	@Override
	public String toString() {
		return mc.toString();
	}
}