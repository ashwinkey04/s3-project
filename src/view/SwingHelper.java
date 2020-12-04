package view;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;


public class SwingHelper {
	
	public static Image getImageFromUrl(String urlString) throws MalformedURLException {
	    URL url = new URL(urlString);
	    return Toolkit.getDefaultToolkit().createImage(url);
	  }

	public static Font customFont(int size) {
		return new Font("Tahoma", Font.PLAIN, size);
	}
	
	
}
