package structural.bridge;

public class WindowsPlatformTSI implements ThreadScheduleImplementation {

	@Override
	public void schedulingPlatform() {
		System.out.println("Windows platform");		
	}

}
