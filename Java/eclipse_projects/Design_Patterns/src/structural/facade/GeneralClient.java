package structural.facade;

public class GeneralClient {

	public static void performCompilation() {

		System.out.println("Scanning initiated by "
				+ GeneralClient.class.getName());
		Scanner.scan();
		
		System.out.println("Tokenizing initiated by "
				+ GeneralClient.class.getName());
		Tokernizer.tokenize();
		
		System.out.println("Parsing initiated by "
				+ GeneralClient.class.getName());
		Parser.parse();
		
		System.out.println("ByteConversion initiated by "
				+ GeneralClient.class.getName());
		ByteCodeConverter.convertToByteCode();
		
		System.out.println("Compilation process finished by "
				+ GeneralClient.class.getName());
	}

}
