import java.util.Date;

public class Sub extends Super {
	
	private final Date date;

	Sub(){
		date = new Date();
	}

	@Override 
	public void overrideMe(){
		System.out.println(date);
		System.out.println("inside subclass overrideMe");
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}

}