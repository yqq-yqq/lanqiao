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
class MainCanvas extends Canvas implements Runnable
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Thread thread;
	int heroX,heroY,bossX,bossY;
	int flag;
	Image heroImg[][]=new Image[4][3];
	Image bossImg;//0表示左，1表示右，2表示上，3表示下。
	Image currentImg;
	public MainCanvas(){
	    try
	    {
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++)
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				bossImg=Image.createImage("/zuzu000.png");
			}
			
			currentImg=heroImg[3][1];
			heroX=122;
			heroY=122;
			flag=1;

			thread=new Thread(this);
			thread.start();
	    }
	    catch (IOException e)
	    {
			e.printStackTrace();
	    }
	
   }
   /*
	在多线程里写一个死循环，不停的比较boss和hero的坐标
	*/
	public void run(){
		while(true){
			try
			{
				Thread.sleep(200);//FPS：屏幕刷新率
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(bossX<heroX){
				bossX++;
			}
			else{
				bossX--;
			}

			if(bossY<heroY){
				bossY++;
			}else{
				bossY--;
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(255,224,231);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}

    public void changeAndDirection(int direction)
	{

		if(flag==1){
			currentImg=heroImg[direction][0];
			flag++;
		}
		else if(flag==2){
			currentImg=heroImg[direction][2];
			flag=1;
		}
		repaint();
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			changeAndDirection(0);
			heroX=heroX-1;
		}
		if(action==RIGHT){
			changeAndDirection(1);
			heroX=heroX+1;
		}
		if(action==UP){
			changeAndDirection(2);
			heroY=heroY-1;
		}
		if(action==DOWN){
			changeAndDirection(3);
			heroY=heroY+1;
		}
	}
}