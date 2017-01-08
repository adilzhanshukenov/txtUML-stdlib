package hu.elte.txtuml.stdlib.math;

import hu.elte.txtuml.api.model.external.ExternalClass;

/*	An instance of this class is used to generate a stream of pseudorandom numbers. 
 *  The class uses a 48-bit seed, which is modified using a linear congruential formula. 
 *  (See Donald Knuth, The Art of Computer Programming, Volume 2, Section 3.2.1.)
 *	If two instances of Random are created with the same seed, and the same sequence of method calls is made 
 *	for each, they will generate and return identical sequences of numbers. In order to guarantee this property, 
 *	particular algorithms are specified for the class Random. Java implementations must use all the algorithms 
 *	shown here for the class Random, for the sake of absolute portability of Java code. However, subclasses of 
 *	class Random are permitted to use other algorithms, so long as they adhere to the general contracts for all 
 *	the methods.
 *	The algorithms implemented by class Random use a protected utility method that on each invocation can supply 
 *	up to 32 pseudorandomly generated bits.
*/
public interface RandomInterface extends ExternalClass {
	
	
	public int nextInt();
	/*
	 * Returns the next pseudorandom, uniformly distributed int value from this random number generator's sequence. 
	 * The general contract of nextInt is that one int value is pseudorandomly generated and returned. All 232 
	 * possible int values are produced with (approximately) equal probability.
	 */
	public int nextLong();
	/*
	 * Returns the next pseudorandom, uniformly distributed long value from this random number generator's sequence. 
	 * The general contract of nextLong is that one long value is pseudorandomly generated and returned.
	 */
	public int nextInt(int bound);
	/*
	 * Returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and 
	 * the specified value (exclusive), drawn from this random number generator's sequence. 
	 * The general contract of nextInt is that one int value in the specified range is 
	 * pseudorandomly generated and returned. All bound possible int values are produced 
	 * with (approximately) equal probability.
	 * 
	 * Parameters:
	 * bound - the upper bound (exclusive). Must be positive.
	 * 
	 * Returns:
	 * the next pseudorandom, uniformly distributed int value between zero (inclusive) and bound 
	 * (exclusive) from this random number generator's sequence
	 * 
	 * Throws:
	 * IllegalArgumentException - if bound is not positive
	 * 
	 * Since:
	 * 1.2
	 */
	public boolean nextBoolean();
	/*
	 * Returns the next pseudorandom, uniformly distributed boolean value from 
	 * this random number generator's sequence. The general contract of nextBoolean is 
	 * that one boolean value is pseudorandomly generated and returned. 
	 * The values true and false are produced with (approximately) equal probability.
	 */
	
	
	public void nextBytes(int[] bytes);
	/*
	 * Generates random bytes and places them into a user-supplied byte array. 
	 * The number of random bytes produced is equal to the length of the byte array.
	 * 
	 * Parameters:
	 * bytes - the byte array to fill with random bytes
	 * 
	 * Throws:
	 * NullPointerException - if the byte array is null
	 * 
	 * Since:
	 * 1.1
	 */
	
}
