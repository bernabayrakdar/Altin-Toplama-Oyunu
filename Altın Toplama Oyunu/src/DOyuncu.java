
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class DOyuncu extends GUI2 {

	int D_kaldigi_yerX =  Guncel_Konum.get(6);
	int D_kaldigi_yerY = Guncel_Konum.get(7);


	int [][] DKonum = new int[80][3];
	int AltinDegeri;
	int DAltin = 200;
	int [][] CKonum = new int[80][3];
	int [][] DMaliyet = new int[80][3];	
	int Uzaklik = 0,a=0,b=0,c=0,d=0,Dx,Dy,sayac=0;
	int EnBuyuk;
	int uzaklik;
	
public DOyuncu(Btn[][] board) {
		super(board);
}
		
public void DHedefBelirleme()
{	
	D=0;
	a=0;
	b=0; 
	c=0;
	d=0;

for(int i=19; i>-1; i--)
{
	for(int j=0; j<20; j++)
	{
		if(board[i][j].isAltinVarMi())		    	 
		{			
			Uzaklik = Math.abs(D_kaldigi_yerX-i) + Math.abs(D_kaldigi_yerY-j);				
			DKonum[a][b] = i;
			b++;
			DKonum[a][b] = j;	
			b++;
			DKonum[a][b] = Uzaklik;				
			b=0;
			a++;			
		}		   	
	}
}			

for(int i=0; i<a; i++)
{
	for(int j=0;j<8 ; j=j+3)
	{
		if(DKonum[i][0] == D_Konum_Bilgisi.get(j)  && DKonum[i][1] == D_Konum_Bilgisi.get(j+1))
		{
			if(DKonum[i][2] > D_Konum_Bilgisi.get(j+2))
			{					
				for(int e=19; e>-1; e--)
				{
					for(int p=0; p<20; p++)			
					{							
						if(board[e][p].isAltinVarMi() &&  DKonum[i][0] != D_Konum_Bilgisi.get(j) && DKonum[i][1] != D_Konum_Bilgisi.get(j+1) )		    	 
						{			
							Uzaklik = Math.abs(D_kaldigi_yerX-e) + Math.abs(D_kaldigi_yerY-p);				
							DKonum[c][d] = e;
							d++;
							DKonum[c][d] = p;				
							d++;
							DKonum[c][d] = Uzaklik;				
							d=0;
							c++;			
						}		   	
					}
				}
		   }						
	   }			
	}
}	
}
public void DHedefTut()
{
	Dx = Guncel_Konum.get(6);	
	Dy = Guncel_Konum.get(7);
		
	 if(D_HedefTut.get(2) > 3)	 
	 { 
		 D = 1;
		 AltinDegeri =0;
			while(Dx != D_HedefTut.get(0))
			{		
				if(Dx < D_HedefTut.get(0))
				{
					Dx++;			
					sayac++;
					
					if(sayac == 3)
					{
						D_kaldigi_yerX = Dx;
						D_kaldigi_yerY = Dy;
						D_HedefTut.add(2,D_HedefTut.get(2) - sayac);
						
					}															
				}
				else 
				{
					 Dx--;
					 sayac++;

					if(sayac ==3)
						{ 
							D_kaldigi_yerX = Dx;
							D_kaldigi_yerY = Dy;
							D_HedefTut.add(2,D_HedefTut.get(2) - sayac);
						}				
				}
			}
			
			if(sayac <3)
			{			
				while(Dy != D_HedefTut.get(1))
				{
					if(Dy < D_HedefTut.get(1))
					{
						Dy++;
						sayac++;
						
						if(sayac == 3)
						{
							D_kaldigi_yerX = Dx;
							D_kaldigi_yerY = Dy;
							D_HedefTut.add(2,D_HedefTut.get(2) - sayac);
						}															
					}				
					else
					{
						Dy--;
						sayac++;
						
						 if(sayac == 3)
							{
								D_kaldigi_yerX = Dx;
								D_kaldigi_yerY = Dy;
								D_HedefTut.add(2,D_HedefTut.get(2) - sayac);
							}					
					}
				}
			}
		EnBuyuk = D_HedefTut.get(2);
		
		for(int i=0;i<80;i++)
		{
			if( Altin[i][0] == D_kaldigi_yerX  && Altin[i][1] == D_kaldigi_yerY)
			{
				AltinDegeri = Altin[i][2];
			}
		}
		
	}
 sayac = 0;	
}
	
public void DMaliyetHesaplama()
{	
	for(int i=0; i<a; i++)
	{	
		AltinDegeri = Altin[i][2];
		DMaliyet[i][0] = DKonum[i][0];
		DMaliyet[i][1] = DKonum[i][1];
		DMaliyet[i][2] = DAltin - (DKonum[i][2]*2)+ AltinDegeri-20;	
	}
	
	EnBuyuk  = DMaliyet[0][2];	
	D_kaldigi_yerX = DMaliyet[0][0];	
	D_kaldigi_yerY = DMaliyet[0][1];	
	uzaklik = DKonum[0][2];
  
	for(int i=1; i<a; i++)
	{	
		if(EnBuyuk < DMaliyet[i][2])
		{
			EnBuyuk = DMaliyet[i][2];			
			D_kaldigi_yerX = DMaliyet[i][0];
			D_kaldigi_yerY = DMaliyet[i][1];
			uzaklik = DKonum[i][2];
		}
	}
	DAltin = EnBuyuk;	
	 
	for(int i=0;i<80;i++)
	{
		if( Altin[i][0] == D_kaldigi_yerX  && Altin[i][1] == D_kaldigi_yerY)
		{
			AltinDegeri = Altin[i][2];
		}
	}
	
	D_HedefTut.add(0,D_kaldigi_yerX);	  
	D_HedefTut.add(1,D_kaldigi_yerY);
	D_HedefTut.add(2,uzaklik);
	
	DHedefTut();
	

	int dx = Guncel_Konum.get(6);
	int dy = Guncel_Konum.get(7);
	
	while(dx != D_kaldigi_yerX || dy != D_kaldigi_yerY)
	{
		if(dx < D_kaldigi_yerX && dx < 19)
		{
			dx++;
			if(board[dx][dy].isGizliAltinn())
			{
				board[dx][dy].setGizliAltinn(false);
				board[dx][dy].setAltinVarMi(true);
				board[dx][dy].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
			}	
		}
		 if(dx > D_kaldigi_yerX && dx > 0)
		{
			dx--;
			if(board[dx][dy].isGizliAltinn())
			{
				board[dx][dy].setGizliAltinn(false);
				board[dx][dy].setAltinVarMi(true);
				board[dx][dy].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
			}
		}
		 if(dy < D_kaldigi_yerY && dy < 19)
		{
			dy++;
			if(board[dx][dy].isGizliAltinn())
			{
				board[dx][dy].setGizliAltinn(false);
				board[dx][dy].setAltinVarMi(true);
				board[dx][dy].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
			}
		}
		 if(dy > D_kaldigi_yerY && dy > 0)
		{
			dy--;			
			if(board[dx][dy].isGizliAltinn())
			{
				board[dx][dy].setGizliAltinn(false);
				board[dx][dy].setAltinVarMi(true);
				board[dx][dy].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
			}
		}		
	}	
	board[D_kaldigi_yerX][D_kaldigi_yerY].setAltinVarMi(false);
}	

public void DKonumGuncelleme(){
	
	Guncel_Konum.remove(6);
	Guncel_Konum.add(6,D_kaldigi_yerX);
	Guncel_Konum.remove(7);
	Guncel_Konum.add(7,D_kaldigi_yerY);	
	System.out.println("D Konum X: "+Guncel_Konum.get(6)+" "+"D Kounm Y: "+Guncel_Konum.get(7));
	
}	
}