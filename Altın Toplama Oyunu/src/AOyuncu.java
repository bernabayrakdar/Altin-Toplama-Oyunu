import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class AOyuncu extends GUI2{
	
		int A_kaldigi_yerX = Guncel_Konum.get(0);
		int A_kaldigi_yerY = Guncel_Konum.get(1);
		int AAltin = 200;
		int EnKucuk =0;  
		int Amaliyet,Ax,Ay;
		int [][] AKonum = new int[80][3];
		int Uzaklik=0,a=0,b=0,sayac=0; 
		int AltinDegeri = 0;
				
	public AOyuncu(Btn[][] board) {
		super(board);    
}	

public void AHedefBelirleme()
{
	A=0;
	a=0;
	b=0;
	
	for(int i=0; i<20; i++)
	{
		for(int j=0; j<20; j++)			
		{
			if(board[i][j].isAltinVarMi())		    	 
			{			
				Uzaklik = Math.abs(A_kaldigi_yerX-i) + Math.abs(A_kaldigi_yerY-j);				
				AKonum[a][b] = i;
				b++;
				AKonum[a][b] = j;	
				b++;
				AKonum[a][b] = Uzaklik;	
				b=0;
				a++;			
			}		   	
		}
	}
}

public void AHedefTut()
{
	Ax = Guncel_Konum.get(0);	
	Ay = Guncel_Konum.get(1);
	
 if(A_HedefTut.get(2) > 3)	 
 { 
	 AltinDegeri  = 0;
	 A = 1;	 
	 while(Ax != A_HedefTut.get(0))
		{		
			if(Ax < A_HedefTut.get(0))
			{
				Ax++;			
				sayac++;
				
				if(sayac == 3)
				{
					A_kaldigi_yerX = Ax;
					A_kaldigi_yerY = Ay;
					A_HedefTut.add(2,A_HedefTut.get(2) - sayac);					
				}															
			}
			else 
			{
				 Ax--;
				 sayac++;				
				 
				 if(sayac ==3)
				 { 
					A_kaldigi_yerX = Ax;
					A_kaldigi_yerY = Ay;		
					A_HedefTut.add(2,A_HedefTut.get(2) - sayac);
				 }				
			}
		}
		
		if(sayac <3)
		{			
			while(Ay != A_HedefTut.get(1))
			{
				if(Ay < A_HedefTut.get(1))
				{
					Ay++;
					sayac++;
					
					if(sayac == 3)
					{
						A_kaldigi_yerX = Ax;
						A_kaldigi_yerY = Ay;		
						A_HedefTut.add(2,A_HedefTut.get(2) - sayac);
					}															
				}				
				else
				{
					Ay--;
					sayac++;
					
					 if(sayac == 3)
						{
						 A_kaldigi_yerX = Ax;
						 A_kaldigi_yerY = Ay;
						 A_HedefTut.add(2,A_HedefTut.get(2) - sayac);
						}					
				}
			}
		}	
		EnKucuk = A_HedefTut.get(2);
	   
		for(int i=0; i<80; i++) 
	    {
	    	if(Altin[i][0] == A_kaldigi_yerX  && Altin[i][1] == A_kaldigi_yerY)
	    	{
	    		AltinDegeri = Altin[i][2];
			}
		}	    
 }
sayac = 0;	
}

public void AMaliyet() {
	
	EnKucuk = AKonum[0][2];
	A_kaldigi_yerX = AKonum[0][0];
	A_kaldigi_yerY = AKonum[0][1];
	
	for(int i=1;i<a;i++)
	{		
			if(EnKucuk > AKonum[i][2])
			{
				EnKucuk = AKonum[i][2];	
				A_kaldigi_yerX = AKonum[i][0];
				A_kaldigi_yerY = AKonum[i][1];	
			}				
	}
	
    for(int i=0; i<80; i++) 
    {
    	if(Altin[i][0] == A_kaldigi_yerX  && Altin[i][1] == A_kaldigi_yerY)
    	{
    		AltinDegeri = Altin[i][2];
		}
	}
	
	D_Konum_Bilgisi.add(0,A_kaldigi_yerX);
	D_Konum_Bilgisi.add(1,A_kaldigi_yerY);
	D_Konum_Bilgisi.add(2,EnKucuk);
	
    A_HedefTut.add(0,A_kaldigi_yerX);
    A_HedefTut.add(1,A_kaldigi_yerY);
    A_HedefTut.add(2,EnKucuk);
  
    AHedefTut(); 
   
    if(board[A_HedefTut.get(0)][A_HedefTut.get(1)].isAltinVarMi() == false)
    {
    	
    	A_kaldigi_yerX = Guncel_Konum.get(0);
    	A_kaldigi_yerY = Guncel_Konum.get(1);
    	
    	AHedefBelirleme();
    
    	EnKucuk = AKonum[0][2];
    	A_kaldigi_yerX = AKonum[0][0];
    	A_kaldigi_yerY = AKonum[0][1];
    	
    	for(int i=1;i<a;i++)
    	{		
    			if(EnKucuk > AKonum[i][2])
    			{
    				EnKucuk = AKonum[i][2];	
    				A_kaldigi_yerX = AKonum[i][0];
    				A_kaldigi_yerY = AKonum[i][1];	
    			}				
    	}
    	
    	D_Konum_Bilgisi.add(0,A_kaldigi_yerX);
    	D_Konum_Bilgisi.add(1,A_kaldigi_yerY);
    	D_Konum_Bilgisi.add(2,EnKucuk);
    	
        A_HedefTut.add(0,A_kaldigi_yerX);
        A_HedefTut.add(1,A_kaldigi_yerY);
        A_HedefTut.add(2,EnKucuk);
      
        AHedefTut(); 
    	
    }	
    

    int x = Guncel_Konum.get(0);
    int y = Guncel_Konum.get(1);
    
    while(x != A_kaldigi_yerX || y != A_kaldigi_yerY)
    {
    	if(x < A_kaldigi_yerX && x < 19)
    	{
    		x++;				
    		if(board[x][y].isGizliAltinn())
    		{
    			board[x][y].setGizliAltinn(false);
    			board[x][y].setAltinVarMi(true);
    			board[x][y].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
    		}
    	}
    	else if(x > A_kaldigi_yerX && x > 0)
    	{
    		x--;
    		if(board[x][y].isGizliAltinn())
    		{
    			board[x][y].setGizliAltinn(false);
    			board[x][y].setAltinVarMi(true);
    			board[x][y].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
			}
		}
    	else if(y < A_kaldigi_yerY && y < 19)
    	{
    		y++;
    		if(board[x][y].isGizliAltinn())
    		{
    			board[x][y].setGizliAltinn(false);
    			board[x][y].setAltinVarMi(true);
    			board[x][y].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
			}
    	}
    	else if(y > A_kaldigi_yerY && y>0)
    	{
    		y--;				
    		if(board[x][y].isGizliAltinn())
    		{
    			board[x][y].setGizliAltinn(false);
    			board[x][y].setAltinVarMi(true);
    			board[x][y].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
			}
		}			
	}	

    board[A_kaldigi_yerX][A_kaldigi_yerY].setAltinVarMi(false);				
    Amaliyet = AAltin - EnKucuk*2 + AltinDegeri-5;	
    AAltin = Amaliyet;	
}

public void AKonum_Guncelle(){	
	
	Guncel_Konum.remove(0);
	Guncel_Konum.add(0,A_kaldigi_yerX);
	Guncel_Konum.remove(1);
	Guncel_Konum.add(1,A_kaldigi_yerY);
    System.out.println("A Konum X: "+Guncel_Konum.get(0)+" "+"A Kounm Y: "+Guncel_Konum.get(1));	
}
}