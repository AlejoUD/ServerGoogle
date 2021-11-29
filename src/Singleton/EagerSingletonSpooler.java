package Singleton;

public class EagerSingletonSpooler extends PrintSpooler {
	
	private static EagerSingletonSpooler INSTANCE = new EagerSingletonSpooler();

	private EagerSingletonSpooler() {
		super.resetJobs();
		System.out.println("  # EAGER: Execute the constructor.");
	}

	public static EagerSingletonSpooler getInstance() {
		System.out.println("  - EGAER: getting the unique instance ...");
		
		return INSTANCE;
	}

	public synchronized void resetPrintSpooler() {
		System.out.println("  - EAGER: reset print spooler.");
		INSTANCE = new EagerSingletonSpooler();
		super.resetJobs();
	}
}