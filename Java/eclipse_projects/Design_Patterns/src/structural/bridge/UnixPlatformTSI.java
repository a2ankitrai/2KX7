package structural.bridge;

public class UnixPlatformTSI implements ThreadScheduleImplementation{

	@Override
	public void schedulingPlatform() {
		System.out.println("Unix platform");		
	}
	
}
