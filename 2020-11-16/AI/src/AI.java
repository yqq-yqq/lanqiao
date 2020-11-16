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
      Image DownImg,LeftImg,UpImg,RightImg,currentimg;
	  public MainCanvas(){
	  try
	  {
		DownImg=Image.createImage("/sayo10.png");
		LeftImg=Image.createImage("/sayo12.png");
		UpImg=Image.createImage("/sayo14.png");
		RightImg=Image.createImage("/sayo16.png");

		currentimg=DownImg;
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
	        currentimg=LeftImg;
	     }
		 if(action==DOWN)
         {
	        currentimg=DownImg;
	     }
		 if(action==RIGHT){
	        currentimg=RightImg;
	     }
	      else if(action==UP){
	      currentimg=UpImg;
         }
		   repaint();
}
}