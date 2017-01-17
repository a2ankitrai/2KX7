package structural.bridge;

public class TimeSlicedThreadScheduler extends ThreadScheduler {

	public TimeSlicedThreadScheduler(ThreadScheduleImplementation osImplementation) {
		super(osImplementation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void schedulingPlatform() {
		
		System.out.print("Timesliced Thread scheduling on ");
		
		osImplementation.schedulingPlatform();
	}
	
}
