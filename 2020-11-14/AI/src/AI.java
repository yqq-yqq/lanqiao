import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
      Image img,img1,img2,img3,currentimg;
	  public MainCanvas(){
	  try
	  {
		img=Image.createImage("/sayo10.png");
		img1=Image.createImage("/sayo12.png");
		img2=Image.createImage("/sayo14.png");
		img3=Image.createImage("/sayo16.png");

		currentimg=img;
	  }
	  catch (IOException e)
	  {
		  e.printStackTrace();
	  }
} 
		public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
	    g.drawImage(currentimg,120,120,0);
	}
	public void keyPressed(int keyCode){
	     
		 int action=getGameAction(keyCode);

			if(action==LEFT)
	     {
	        currentimg=img1;
	        repaint();
	     }
		 if(action==DOWN)
         {
	        currentimg=img;
	        repaint();
	     }
		 if(action==RIGHT){
	        currentimg=img3;
	        repaint();
	     }
	      else if(action==UP){
	      currentimg=img2;
	      repaint();
         }
}
}