package structural.bridge;

public class PreemptiveThreadScheduler extends ThreadScheduler {

	public PreemptiveThreadScheduler(ThreadScheduleImplementation osImplementation) {
		super(osImplementation);
		
	}

	@Override
	public void schedulingPlatform() {
		System.out.print("Preemptive Thread scheduling on ");
		osImplementation.schedulingPlatform();
	}

}
