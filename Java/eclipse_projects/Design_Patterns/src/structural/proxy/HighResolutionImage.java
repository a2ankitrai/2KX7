package structural.proxy;

public class HighResolutionImage implements Image {

	public HighResolutionImage() {
		loadImage();
	}
	
	private void loadImage(){
		System.out.println("Loading image from disk into memory :  heavy and costly operation");
	}
	
	@Override
	public void showImage() {
		System.out.println("Showing High Resolution Image");
	}

}
