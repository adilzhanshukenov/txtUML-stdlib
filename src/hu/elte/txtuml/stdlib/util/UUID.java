package hu.elte.txtuml.stdlib.util;

import hu.elte.txtuml.api.model.external.ExternalClass;

/**
 * This class provides the functionality of the an immutable Universally Unique
 * Identifier (UUID) Java class for txtUML models.
 * 
 * @see UUIDImplementation
 * 
 * @author Salhi Fadhel (fadhelsalhif@gmail.com)
 */
public interface UUID extends ExternalClass {

	/**
	 * 
	 * The clock sequence value associated with this UUID.</br>
	 * The 14 bit clock sequence value is constructed from the clock sequence
	 * field of this UUID. The clock sequence field is used to guarantee
	 * temporal uniqueness in a time-based UUID. The clockSequence value is only
	 * meaningful in a time-based UUID, which has version type 1. If this UUID
	 * is not a time-based UUID then this method throws
	 * UnsupportedOperationException.
	 *
	 * @return The clock sequence (int) of this UUID
	 * 
	 * @throws UnsupportedOperationException
	 *             - If this UUID is not a version 1 UUID
	 */
	public int clockSequence();

	/**
	 * Compares this UUID with the specified UUID. The first of two UUIDs is
	 * greater than the second if the most significant field in which the UUIDs
	 * differ is greater for the first UUID.
	 *
	 * @Specified by: compareTo in interface Comparable<UUID>
	 * 
	 * @param val
	 *            - UUID to which this UUID is to be compared
	 * 
	 * @return -1, 0 or 1 as this UUID is less than, equal to, or greater than
	 *         val (int)
	 */
	public int compareTo(UUID val);

	/**
	 * Compares this object to the specified object. The result is true if and
	 * only if the argument is not null, is a UUID object, has the same variant,
	 * and contains the same value, bit for bit, as this UUID.
	 *
	 * @param obj
	 *            - The object to be compared
	 * 
	 * @return true if the objects are the same; false otherwise
	 * 
	 */
	public boolean equals(Object obj);

	/**
	 * Creates a UUID from the string standard representation as described in
	 * the toString() method.
	 *
	 * @param str
	 *            - A string that specifies a UUID
	 * 
	 * @return A UUID with the specified value
	 * 
	 * @throws IllegalArgumentException
	 *             - If name does not conform to the string representation as
	 *             described in toString()
	 */
	public static UUID fromString(String str) {
		return new UUIDImplementation(java.util.UUID.fromString(str));
	}

	/**
	 * Returns the least significant 64 bits of this UUID's 128 bit value.
	 *
	 * @return The least significant 64 bits of this UUID's 128 bit value
	 */
	public long getLeastSignificantBits();

	/**
	 * Returns the most significant 64 bits of this UUID's 128 bit value.
	 *
	 * @return The most significant 64 bits of this UUID's 128 bit value
	 */
	public long getMostSignificantBits();

	/**
	 * Returns a hash code for this UUID.
	 *
	 * @return A hash code value for this UUID
	 */
	public int hashCode();

	/**
	 * Static factory to retrieve a type 3 (name based) UUID based on the
	 * specified byte array..
	 *
	 * @param name
	 *            - A byte array to be used to construct a UUID
	 * 
	 * @return A UUID generated from the specified array
	 */
	/*
	 * public static UUID nameUUIDFromBytes(Collection<Byte> name) {
	 * 
	 * return new UUIDImplementation(java.util.UUID.nameUUIDFromBytes(name)); }
	 */

	/**
	 * The node value associated with this UUID. The 48 bit node value is
	 * constructed from the node field of this UUID. This field is intended to
	 * hold the IEEE 802 address of the machine that generated this UUID to
	 * guarantee spatial uniqueness. The node value is only meaningful in a
	 * time-based UUID, which has version type 1. If this UUID is not a
	 * time-based UUID then this method throws UnsupportedOperationException.
	 *
	 * @return The node value of this UUID
	 */
	public long node();

	/**
	 * Static factory to retrieve a type 4 (pseudo randomly generated) UUID. The
	 * UUID is generated using a cryptographically strong pseudo random number
	 * generator.
	 *
	 * @return A randomly generated UUID
	 */
	public static UUID randomUUID() {
		return new UUIDImplementation(java.util.UUID.randomUUID());
	}

	/**
	 * The timestamp value associated with this UUID. The 60 bit timestamp value
	 * is constructed from the time_low, time_mid, and time_hi fields of this
	 * UUID. The resulting timestamp is measured in 100-nanosecond units since
	 * midnight, October 15, 1582 UTC. The timestamp value is only meaningful in
	 * a time-based UUID, which has version type 1. If this UUID is not a
	 * time-based UUID then this method throws UnsupportedOperationException.
	 *
	 * @return The timestamp of this UUID.
	 */
	public long timestamp();

	/**
	 * Returns a String object representing this UUID.
	 *
	 * @return A string representation of this UUID
	 */
	public String toString();

	/**
	 * The variant number associated with this UUID. The variant number
	 * describes the layout of the UUID. The variant number has the following
	 * meaning: </br>
	 * 0 Reserved for NCS backward compatibility </br>
	 * 2 IETF RFC 4122 (Leach-Salz), used by this class </br>
	 * 6 Reserved, Microsoft Corporation backward compatibility </br>
	 * 7 Reserved for future definition </br>
	 *
	 * @return The variant number of this UUID
	 */
	public int variant();

	/**
	 * The version number associated with this UUID. The version number
	 * describes how this UUID was generated. The version number has the
	 * following meaning: </br>
	 * 1 Time-based UUID </br>
	 * 2 DCE security UUID </br>
	 * 3 Name-based UUID </br>
	 * 4 Randomly generated UUID
	 *
	 * @return The version number of this UUID
	 */
	public int version();
}
