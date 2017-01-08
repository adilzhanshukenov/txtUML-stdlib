package hu.elte.txtuml.stdlib.math;

public class RandomImplementation implements RandomInterface {

	@Override
	public int nextInt() {
		return nextInt();
	}
	
	@Override
	public int nextLong() {
		return (int) nextLong();
	}

	@Override
	public int nextInt(int bound) {
		if (bound <= 0)
		     throw new IllegalArgumentException("bound must be positive");

		   if ((bound & -bound) == bound)  // i.e., bound is a power of 2
		     return (int)((bound * (long)nextInt(31)) >> 31);

		   int bits, val;
		   do {
		       bits = nextInt(31);
		       val = bits % bound;
		   } while (bits - val + (bound-1) < 0);
		   return val;
	}

	@Override
	public boolean nextBoolean() {
		return nextBoolean();
	}

	@Override
	public void nextBytes(int[] bytes) {
		for (int i = 0; i < bytes.length; )
		     for (int rnd = nextInt(), n = Math.min(bytes.length - i, 4);
		          n-- > 0; rnd >>= 8)
		       bytes[i++] = (int)rnd;		
	}
	
}
