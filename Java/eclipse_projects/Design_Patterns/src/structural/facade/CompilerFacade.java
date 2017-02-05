package structural.facade;

public class CompilerFacade {

	public static void compile(){
		
		System.out.println("Starting code compilation");
		Scanner.scan();
		Tokernizer.tokenize();
		Parser.parse();
		ByteCodeConverter.convertToByteCode();
		System.out.println("Finished code compilation");
	}
}
