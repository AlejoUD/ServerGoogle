package Singleton;

public class LazySingletonSpooler extends PrintSpooler {
	private static LazySingletonSpooler INSTANCE;

	private LazySingletonSpooler() {
		super.resetJobs();
		System.out.println("  # LAZY: Execute the constructor.");
	}

	public static LazySingletonSpooler getInstance() {
		synchronized(LazySingletonSpooler.class) {
			System.out.println("  - LAZY: getting the unique instance ...");
		
			if (INSTANCE == null) {
				INSTANCE = new LazySingletonSpooler();
			}
		}
		
		return INSTANCE;
	}

	public synchronized void resetPrintSpooler() {
		System.out.println("  - LAZY: reset print spooler.");
		INSTANCE = new LazySingletonSpooler();
	}
}