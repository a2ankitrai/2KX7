package structural.proxy;

public class ProxyPatternTest {

	public static void main(String[] args) {
		
		// consider using the high resolution image object directly		
		Image highRes = new HighResolutionImage();
		System.out.println("Object created image loaded");
		highRes.showImage();
	
		System.out.println("\n\n");
		
		Image proxy = new ImageProxy();
		System.out.println("Proxy object created: Image not loaded");
		//in this case image will be loaded into memory now
		proxy.showImage();
		
		
	}
}
