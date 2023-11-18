import java.util.ArrayList;

interface ImageViewerInterface {
	String getName();

	void show(String fileName);

	String getExtension();
}

class ImageViewer {
	private static final int MAX_PLUGINS = 5;
	ArrayList<ImageViewerInterface> plugin;
	ImageViewer() {
		plugin = new ArrayList<ImageViewerInterface>();
	}

	void addPlugIn(ImageViewerInterface ivi) {
		plugin.add(ivi);
	}

	void show(String fileName, String ext) {
		for(ImageViewerInterface i : plugin)
		{
			if(i.getExtension().equals(ext))
			{
				i.show(fileName);
				return;
			}
		}
		
		System.out.println("Image viewr plugin for the extension, " + ext + ", is not registered");
	}

}

class PNGModule implements ImageViewerInterface {
	public PNGModule() {

	}
	@Override
	public String getName() {
		return null;
	}
	@Override
	public String getExtension() {
		return "PNG";
	}
	@Override
	public void show(String fileName) {
		System.out.println("Using PNG Module");
		System.out.println("PNG Imahe loading:" + fileName);
		
	}
	
}

class JPGModule implements ImageViewerInterface {
	public JPGModule() {

	}
	@Override
	public String getName() {
		return null;
	}
	@Override
	public String getExtension() {
		return "JPG";
	}
	@Override
	public void show(String fileName) {
		System.out.println("Using JPG Module");
		System.out.println("JPG Imahe loading:" + fileName);
	}
}

public class TestImageViewer {
	public static void main(String[] args) {
		ImageViewer v = new ImageViewer();
		v.addPlugIn(new PNGModule());
		v.addPlugIn(new JPGModule());
		v.show("a.jpg", "JPG");
		v.show("b.png", "PNG");
		v.show("c.tif", "TIF");
	}
}
