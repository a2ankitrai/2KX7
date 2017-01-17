package structural.bridge;

public class BridgePatternTest {

	public static void main(String[] args) {
		
		ThreadScheduler ts1 = new PreemptiveThreadScheduler(new WindowsPlatformTSI());
		
		ThreadScheduler ts2 = new PreemptiveThreadScheduler(new UnixPlatformTSI());
				
		ThreadScheduler ts3 = new TimeSlicedThreadScheduler(new SolarisPlatformTSI());
		
		ThreadScheduler ts4 = new TimeSlicedThreadScheduler(new UnixPlatformTSI());
		
		
		ts1.schedulingPlatform();
		
		ts2.schedulingPlatform();
		
		ts3.schedulingPlatform();
		
		ts4.schedulingPlatform();
		
	}
}
