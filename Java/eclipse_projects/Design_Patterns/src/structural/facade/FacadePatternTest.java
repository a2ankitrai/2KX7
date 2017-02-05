package structural.facade;

public class FacadePatternTest {

	public static void main(String[] args) {
		
		System.out.println("General client accessing the system: ");
		
		GeneralClient.performCompilation();
		
		System.out.println("\n--------------------------------------\n");
		
		
		System.out.println("Facade client accessing the system through facade");
		
		FacadeClient.performCompilation();
		
	}
}
