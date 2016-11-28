package hu.elte.txtuml.stdlib.util;

/**
 * Implementation class for UUID interface for txtUML models.
 * 
 * @see UUID
 * @author Salhi Fadhel (fadhelsalhif@gmail.com)
 *
 */

public class UUIDImplementation implements UUID {

	/**
	 * Store UUID object and then do all other functions with it
	 */
	private java.util.UUID var;

	/**
	 * Instance method that returns val,
	 * 
	 * @param val
	 * @return
	 */
	protected java.util.UUID getOrigUUID(Object val) {
		if (val instanceof UUIDImplementation) {
			return ((UUIDImplementation) val).var;
		} else if (val instanceof UUID) {
			return var;
		} else
			return null;
	}

	/**
	 * Constructs a new UUID using the specified data. mostSigBits is used for
	 * the most significant 64 bits of the UUID and leastSigBits becomes the
	 * least significant 64 bits of the UUID.
	 * 
	 * @param mostSigBits
	 *            - The most significant bits of the UUID
	 * @param leastSigBits
	 *            - The least significant bits of the UUID
	 */
	public UUIDImplementation(long mostSigBits, long leastSigBits) {
		this.var = new java.util.UUID(mostSigBits, leastSigBits);
	}

	/**
	 * protected constructor
	 * 
	 * @param var
	 */
	protected UUIDImplementation(java.util.UUID var) {
		this.var = var;
	}

	@Override
	public int clockSequence() {

		return var.clockSequence();
	}

	@Override
	public int compareTo(UUID val) {
		return var.compareTo(getOrigUUID(val));
	}

	@Override
	public boolean equals(Object obj) {
		return var.equals(getOrigUUID(obj));
	}

	@Override
	public long getLeastSignificantBits() {
		return var.getLeastSignificantBits();
	}

	@Override
	public long getMostSignificantBits() {
		return var.getMostSignificantBits();
	}

	@Override
	public int hashCode() {
		return var.hashCode();
	}

	@Override
	public long node() {
		return var.node();
	}

	@Override
	public long timestamp() {
		return var.timestamp();
	}

	@Override
	public String toString() {
		return var.toString();
	}

	@Override
	public int variant() {
		return var.variant();
	}

	@Override
	public int version() {
		return var.version();
	}

}
