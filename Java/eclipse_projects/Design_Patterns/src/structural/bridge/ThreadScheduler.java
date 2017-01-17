package structural.bridge;

public abstract class ThreadScheduler {

	protected ThreadScheduleImplementation osImplementation;
	
	public ThreadScheduler(ThreadScheduleImplementation osImplementation){
		this.osImplementation = osImplementation;
	}
	
	public abstract void schedulingPlatform();
	
}
