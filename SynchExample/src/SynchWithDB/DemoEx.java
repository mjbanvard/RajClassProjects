package SynchWithDB;

public class DemoEx {

	public static DemoEx instance = null;

	private DemoEx() {}

	// Synchronized keeps the one at a time happening
	// Not good for performance
	public static DemoEx getInstance() {

		synchronized (instance) {
			if (instance == null) {
				instance = new DemoEx();
			}
		}

		return instance;
	}

}
