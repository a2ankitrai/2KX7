package creational.abstract_factory;

public class TestAbstractFactory {

	public static void main(String[] args) {
		
		Computer pc = ComputerFactory.getComputer(new PCFactory("16GB", "2TB", "3.66GHZ"));
		
		Computer laptop = ComputerFactory.getComputer(new LaptopFactory("32GB", "4TB", "5.3GHZ"));
		
		System.out.println("PC config: "+pc);

		System.out.println("Laptop config: "+laptop);
		
	}
}
