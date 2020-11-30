import java.awt.*;
import java.net.MalformedURLException;

import javax.swing.JFrame;

public class TempCanvas extends Canvas{

	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {  
	        Image i=null;
			try {
				i = SwingHelper.getImageFromUrl("https://upload.wikimedia.org/wikipedia/commons/0/07/A._R._Rahman.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if(i!=null) g.drawImage(i, 120,100,this);  
	        else System.out.print("It's null looser");
	          
	}  

	public static void main(String[] args) {
		TempCanvas m=new TempCanvas();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(400,400);  
        f.setVisible(true);  

	}

}
