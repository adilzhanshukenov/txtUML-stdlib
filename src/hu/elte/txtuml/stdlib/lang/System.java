package hu.elte.txtuml.stdlib.lang;

import hu.elte.txtuml.api.model.external.ExternalClass;

/**
 * The Interface System contains several useful methods from the original System class in order to use as External class in txtUML
 * 
 */
public interface System extends ExternalClass{

	/**
	 * Removes the system property indicated by the specified key.
	 * @param key the name of the system property to be removed.
	 * @return the previous string value of the system property, or null if there was no property with that key.
	 */
	public String clearProperty(String key);
	/**
	 * Returns the current time in milliseconds
	 * @return the difference, measured in milliseconds, between the current time and midnight, January 1, 1970 UTC.
	 */
	public String currentTimeMillis(); 
	/**
	 * Terminates the currently running Java Virtual Machine. The argument serves as a status code; by convention, a nonzero status code indicates abnormal termination.
	 * <p>
	 * This method calls the exit method in class Runtime. This method never returns normally.
	 * @param status  exit status
	 */
	public void exitVM(int status);
	/**
	 * Runs the garbage collector.
	 * <p>
	 * Calling the gc method suggests that the Java Virtual Machine expend effort toward recycling unused objects in order to make the memory they currently occupy available for quick reuse. When control returns from the method call, the Java Virtual Machine has made a best effort to reclaim space from all discarded objects.
	 */
	public void gc();
	/**
	 * Gets the value of the specified environment variable. An environment variable is a system-dependent external named value.
	 * @param name the name of the environment variable
	 * @return the string value of the variable, or null if the variable is not defined in the system environment
	 */
	public String getenv(String name);
	/**
	 * Gets the system property indicated by the specified key.
	 * @param key the name of the system property.
	 * @return the string value of the system property, or null if there is no property with that key.
	 */
	public String getProperty(String key);
	/**
	 * Gets the system property indicated by the specified key.
	 * @param key the name of the system property.
	 * @param def a default value.
	 * @return the string value of the system property, or the default value if there is no property with that key.
	 */
	public String getProperty(String key, String def);
	/**
	 * Returns the system-dependent line separator string. It always returns the same value - the initial value of the system property line.separator.
	 * <p>
	 * On UNIX systems, it returns "\n"; on Microsoft Windows systems it returns "\r\n".
	 * @return the system-dependent line separator string
	 */
	public String lineSeparator();
	/**
	 * Loads the native library specified by the filename argument. The filename argument must be an absolute path name. If the filename argument, when stripped of any platform-specific library prefix, path, and file extension, indicates a library whose name is, for example, L, and a native library called L is statically linked with the VM, then the JNI_OnLoad_L function exported by the library is invoked rather than attempting to load a dynamic library. A filename matching the argument does not have to exist in the file system. See the JNI Specification for more details. Otherwise, the filename argument is mapped to a native library image in an implementation-dependent manner.
	 * @param filename the file to load.
	 */
	public void load(String filename);
	/**
	 * Loads the native library specified by the libname argument. The libname argument must not contain any platform specific prefix, file extension or path. If a native library called libname is statically linked with the VM, then the JNI_OnLoad_libname function exported by the library is invoked. See the JNI Specification for more details. Otherwise, the libname argument is loaded from a system library location and mapped to a native library image in an implementation- dependent manner.
	 * @param libname the name of the library
	 */
	public void loadLibrary(String libname);
	/**
	 * Maps a library name into a platform-specific string representing a native library.
	 * @param libname the name of the library.
	 * @return a platform-dependent native library name.
	 */
	public String mapLibraryName(String libname);
	/**
	 *Returns the current value of the running Java Virtual Machine's high-resolution time source, in nanoseconds.
	 *<p>
	 *This method can only be used to measure elapsed time and is not related to any other notion of system or wall-clock time. The value returned represents nanoseconds since some fixed but arbitrary origin time (perhaps in the future, so values may be negative). The same origin is used by all invocations of this method in an instance of a Java virtual machine; other virtual machine instances are likely to use a different origin.
	 *<p>
	 *This method provides nanosecond precision, but not necessarily nanosecond resolution (that is, how frequently the value changes) - no guarantees are made except that the resolution is at least as good as that of currentTimeMillis().
	 *Differences in successive calls that span greater than approximately 292 years (2^63 nanoseconds) will not correctly compute elapsed time due to numerical overflow.
	 *<p>
	 *The values returned by this method become meaningful only when the difference between two such values, obtained within the same instance of a Java virtual machine, is computed.
	 *<p> 
	 *For example, to measure how long some code takes to execute:
	 *<p>
	 *  long startTime = System.nanoTime();
 		// ... the code being measured ...
 		long estimatedTime = System.nanoTime() - startTime;
 	 * <p>
 	 * To compare two nanoTime values
 	 * <p>
 	 *  long t0 = System.nanoTime();
 		...
 		long t1 = System.nanoTime();
 	 * <p>
 	 * one should use t1 - t0 < 0, not t1 < t0, because of the possibility of numerical overflow.
	 * @return the current value of the running Java Virtual Machine's high-resolution time source, in nanoseconds
	 */
	public String nanoTime(); 
	/**
	 * Runs the finalization methods of any objects pending finalization.
	 * <p>
	 * Calling this method suggests that the Java Virtual Machine expend effort toward running the finalize methods of objects that have been found to be discarded but whose finalize methods have not yet been run. When control returns from the method call, the Java Virtual Machine has made a best effort to complete all outstanding finalizations.
	 */
	public void runFinalization();
	/**
	 * Sets the system property indicated by the specified key.
	 * @param key the name of the system property.
	 * @param value the value of the system property.
	 * @return the previous value of the system property, or null if it did not have one.
	 */
	public String setProperty(String key, String value);

}
