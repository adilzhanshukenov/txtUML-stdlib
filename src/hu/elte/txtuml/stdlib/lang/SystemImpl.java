package hu.elte.txtuml.stdlib.lang;

/**
 * Implementation class for System interface for txtUML models.
 * @see System
 *
 */
public class SystemImpl implements System {

	@Override
	public String clearProperty(String key) {
		return java.lang.System.clearProperty(key);
	}

	@Override
	public String currentTimeMillis() {
		return String.valueOf(java.lang.System.currentTimeMillis());
	}

	@Override
	public void exitVM(int status) {
		java.lang.System.exit(status);
	}

	@Override
	public void gc() {
		java.lang.System.gc();
	}

	@Override
	public String getenv(String name) {
		return java.lang.System.getenv(name);
	}

	@Override
	public String getProperty(String key) {
		return java.lang.System.getProperty(key);
	}

	@Override
	public String getProperty(String key, String def) {
		return java.lang.System.getProperty(key, def);
	}

	@Override
	public String lineSeparator() {
		return java.lang.System.lineSeparator();
	}

	@Override
	public void load(String filename) {
		java.lang.System.load(filename);
	}

	@Override
	public void loadLibrary(String libname) {
		java.lang.System.loadLibrary(libname);
	}

	@Override
	public String mapLibraryName(String libname) {
		return java.lang.System.mapLibraryName(libname);
	}

	@Override
	public String nanoTime() {
		return String.valueOf(java.lang.System.nanoTime());
	}

	@Override
	public void runFinalization() {
		java.lang.System.runFinalization();
	}

	@Override
	public String setProperty(String key, String value) {
		return java.lang.System.setProperty(key, value);
	}

}
