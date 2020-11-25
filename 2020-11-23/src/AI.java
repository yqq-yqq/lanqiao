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
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
	Thread thread;
	int heroX,heroY,bossX,bossY;
	int flag;
	Image heroImg[][]=new Image[4][3];
	Image bossImg;//0��ʾ��1��ʾ�ң�2��ʾ�ϣ�3��ʾ�¡�
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
	�ڶ��߳���дһ����ѭ������ͣ�ıȽ�boss��hero������
	*/
	public void run(){
		while(true){
			try
			{
				Thread.sleep(200);//FPS����Ļˢ����
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