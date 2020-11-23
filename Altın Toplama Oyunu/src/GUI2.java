import java.awt.Color;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class GUI2 extends Main {

	int i=0;	
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	int [] SayiTut = new int[8];
	
public GUI2(Btn[][] board) {

	Guncel_Konum.add(0);
	Guncel_Konum.add(0);
	Guncel_Konum.add(0);
	Guncel_Konum.add(19);
	Guncel_Konum.add(19);
	Guncel_Konum.add(19);
	Guncel_Konum.add(19);
	Guncel_Konum.add(0);
}

public void rastgele()
{
	AltinDeger[0] = 5;
	AltinDeger[1] = 10;
	AltinDeger[2] = 15;
	AltinDeger[3] = 20;
		
	int satir,sutun,sayac=0;

while(sayac != 80)
{ 
	satir = rand.nextInt(20);		
	sutun = rand.nextInt(20);
	
	while((satir==0 && sutun==0)  || (satir==0 && sutun==19) ||  (satir==19 && sutun==0) || (satir==19 && sutun==19) )
	{
		satir = rand.nextInt(20);
		sutun = rand.nextInt(20);
	}
		
	while(board[satir][sutun].isAltinVarMi())
	{
		satir = rand.nextInt(20);
		sutun = rand.nextInt(20);		
	}
	
	board[0][0].setText("A");
	board[0][19].setText("B");
	board[19][0].setText("D");
	board[19][19].setText("C");
	
	int index = rand.nextInt(4);
	Altin[sayac][0] = satir;
	Altin[sayac][1] =sutun;
	Altin[sayac][2]= AltinDeger[index];	  
	
	board[satir][sutun].setAltinVarMi(true);
	sayac++;		
}

	int sayi;
	int num;
	
	for(int i=0;i<8;i++)
	{
		num =0;
		sayi = rand.nextInt(80);
		
		for(int j=0;j<i ; j++)
		{
			if(sayi == SayiTut[j])
			{
				num--;
			}
		}
		
		if(num <= -1)
			{
				i--;
			}
		else
			{
			SayiTut[i] = sayi;
			}		
	}	
	
	for(int i=0;i<8;i++)
	{
		GizliAltin[i][0] = Altin[SayiTut[i]][0];	
		GizliAltin[i][1]  = Altin[SayiTut[i]][1];		
			
	}		
	
	for(int  i=0;i<20;i++)
	{
		for(int j=0 ; j<20 ; j++)
		{			
			 for(int z=0;z<8;z++)
	    	 {    		 
	    			 if( i == GizliAltin[z][0] && j == GizliAltin[z][1] )
		    		 {
	    				board[i][j].setGizliAltinn(true);		    	       
		    	        board[i][j].setAltinVarMi(false);  
		    	        board[i][j].setBackground(Color.RED);
		    		 }	    			 
	    	 }
		}
	}
}

public void print()
{
	for(int  i=0;i<20;i++)
	{
		for(int j=0 ; j<20 ; j++)
		{						
		     if(board[i][j].isAltinVarMi() == true)		    	 
			{   	
		    	 board[i][j].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));			
			}				
		}
	}	
}
}