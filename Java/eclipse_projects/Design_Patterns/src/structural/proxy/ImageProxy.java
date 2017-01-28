package structural.proxy;

public class ImageProxy implements Image {

	/**
	 * Private Proxy data
	 */
	private String imageFilePath;

	/**
	 * Reference to RealSubject
	 */
	private Image proxifiedImage;

	@Override
	public void showImage() {
		// create the Image Object only when the image is required to be shown

		proxifiedImage = new HighResolutionImage();
		proxifiedImage.showImage();
	}

}
