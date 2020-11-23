import javax.swing.ImageIcon;

public class BOyuncu extends GUI2{	

	int B_kaldigi_yerX = Guncel_Konum.get(2);
	int B_kaldigi_yerY = Guncel_Konum.get(3);	
	int BAltin = 200;
	int [][] BKonum = new int[80][3];	
	int [][] BMaliyet = new int[80][3];	 
	int Uzaklik =0,a=0,b=0,m,Bx,By,sayac=0; 
	int AltinDegeri;
	int EnBuyuk;
	int uzaklýk;
	
	public BOyuncu(Btn[][] board) {
		super(board);		
}	
			
public void BHedefBelirleme()
{
	B=0;
	a=0;
	b=0;

	for(int i=0; i<20; i++)
	{
		for(int j=19; j>-1; j--)			
		{
			if(board[i][j].isAltinVarMi())
			{			
				Uzaklik = Math.abs(B_kaldigi_yerX-i) + Math.abs(B_kaldigi_yerY-j);				
				BKonum[a][b] = i;
				b++;
				BKonum[a][b] = j;
				b++;
				BKonum[a][b] = Uzaklik;
				b=0;
				a++;			
			}			
		}
	}
}

public void BHedefTut()
{
	Bx = Guncel_Konum.get(2);	
	By  = Guncel_Konum.get(3);
	
 if(B_HedefTut.get(2) > 3)	 
 { 
	 B = 1;
	 AltinDegeri = 0;
	 while( Bx != B_HedefTut.get(0))
	 {		
		 if(Bx < B_HedefTut.get(0))
		 {
			 Bx++;			
			 sayac++;
				
			 if(sayac == 3)
			 {
				 B_kaldigi_yerX = Bx;
				 B_kaldigi_yerY = By;
				 B_HedefTut.add(2,B_HedefTut.get(2) - sayac);					
			 }															
		 }
		 else 
		 {
			 Bx--;
			 sayac++;

			 if(sayac ==3)
			 { 
				 B_kaldigi_yerX = Bx;
				 B_kaldigi_yerY = By;
				 B_HedefTut.add(2,B_HedefTut.get(2) - sayac);
			 }				
		 }
	 }
		
	 if(sayac <3)
	 {			
		 while( By != B_HedefTut.get(1))
		 {
			 if(By < B_HedefTut.get(1))
			 {
				 By++;
				 sayac++;
				 if(sayac == 3)
				 {
					 B_kaldigi_yerX = Bx;
					 B_kaldigi_yerY = By;
					 B_HedefTut.add(2,B_HedefTut.get(2) - sayac);
				 }															
			 }				
			 else
			 {
				 By--;
				 sayac++;
				 if(sayac == 3)
				 {
					 B_kaldigi_yerX = Bx;
					 B_kaldigi_yerY = By;
					 B_HedefTut.add(2,B_HedefTut.get(2) - sayac);
				}					
			}
		}
	}	
	 EnBuyuk = B_HedefTut.get(2);
	 
		for(int i=0;i<80;i++)
		{
			if( Altin[i][0] == B_kaldigi_yerX  && Altin[i][1] == B_kaldigi_yerY)
			{
				AltinDegeri = Altin[i][2];
			}
		}	
		
 }
sayac = 0;	
}

public void Bmaliyet()
{	
	for(int i=0; i<a; i++)
	{
		AltinDegeri = Altin[i][2];
		BMaliyet[i][0] = BKonum[i][0];
		BMaliyet[i][1] = BKonum[i][1];
		BMaliyet[i][2] = BAltin - (BKonum[i][2]*2)+ AltinDegeri-10;	
	}
	
	EnBuyuk  = BMaliyet[0][2];
	B_kaldigi_yerX = BMaliyet[0][0];
	B_kaldigi_yerY = BMaliyet[0][1];
	uzaklýk = BKonum[0][2];

	for(int i=1; i<a; i++)
	{	
		if(EnBuyuk < BMaliyet[i][2])
		{
			EnBuyuk = BMaliyet[i][2];			
			B_kaldigi_yerX = BMaliyet[i][0];
			B_kaldigi_yerY = BMaliyet[i][1];
			uzaklýk = BKonum[i][2];

		}
	}

	BAltin = EnBuyuk;
	
	for(int i=0;i<80;i++)
	{
		if( Altin[i][0] == B_kaldigi_yerX  && Altin[i][1] == B_kaldigi_yerY)
		{
			AltinDegeri = Altin[i][2];
		}
	}	
	
	
	D_Konum_Bilgisi.add(3,B_kaldigi_yerX);
	D_Konum_Bilgisi.add(4,B_kaldigi_yerY);
	D_Konum_Bilgisi.add(5,uzaklýk);
	
	  B_HedefTut.add(0,B_kaldigi_yerX);
	  B_HedefTut.add(1,B_kaldigi_yerY);
	  B_HedefTut.add(2,uzaklýk);
	  
	  BHedefTut();
	  
	  if(board[B_HedefTut.get(0)][B_HedefTut.get(1)].isAltinVarMi() == false)
	    {
	    	
	    	B_kaldigi_yerX = Guncel_Konum.get(2);
	    	B_kaldigi_yerY = Guncel_Konum.get(3);
	    	
	    	BHedefBelirleme();
	    
	    	for(int i=0; i<a; i++)
	    	{
	    		AltinDegeri = Altin[i][2];
	    		BMaliyet[i][0] = BKonum[i][0];
	    		BMaliyet[i][1] = BKonum[i][1];
	    		BMaliyet[i][2] = BAltin - (BKonum[i][2]*2)+ AltinDegeri-10;	
	    	}
	    	
	    	EnBuyuk  = BMaliyet[0][2];
	    	B_kaldigi_yerX = BMaliyet[0][0];
	    	B_kaldigi_yerY = BMaliyet[0][1];
	    	uzaklýk = BKonum[0][2];

	    	for(int i=1; i<a; i++)
	    	{	
	    		if(EnBuyuk < BMaliyet[i][2])
	    		{
	    			EnBuyuk = BMaliyet[i][2];			
	    			B_kaldigi_yerX = BMaliyet[i][0];
	    			B_kaldigi_yerY = BMaliyet[i][1];
	    			uzaklýk = BKonum[i][2];

	    		}
	    	}

	    	BAltin = EnBuyuk;
	    	
	    	D_Konum_Bilgisi.add(3,B_kaldigi_yerX);
	    	D_Konum_Bilgisi.add(4,B_kaldigi_yerY);
	    	D_Konum_Bilgisi.add(5,uzaklýk);
	    	
	    	  B_HedefTut.add(0,B_kaldigi_yerX);
	    	  B_HedefTut.add(1,B_kaldigi_yerY);
	    	  B_HedefTut.add(2,uzaklýk);
	    	  
	    	  BHedefTut();	    	
	    }

	int x = Guncel_Konum.get(2);
	int y = Guncel_Konum.get(3);
	
	while(x != B_kaldigi_yerX || y != B_kaldigi_yerY)
	{
		if(x < B_kaldigi_yerX && x < 19)
		{
			x++;
			if(board[x][y].isGizliAltinn())
			{
				board[x][y].setGizliAltinn(false);
				board[x][y].setAltinVarMi(true);
				board[x][y].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
			}	
		}
		 if(x > B_kaldigi_yerX && x > 0)
		{
			x--;
			if(board[x][y].isGizliAltinn())
			{
				board[x][y].setGizliAltinn(false);
				board[x][y].setAltinVarMi(true);
				board[x][y].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
			}
		}
		 if(y < B_kaldigi_yerY && y < 19)
		{
			y++;
			if(board[x][y].isGizliAltinn())
			{
				board[x][y].setGizliAltinn(false);
				board[x][y].setAltinVarMi(true);
				board[x][y].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));		
			}
		}
		 if(y > B_kaldigi_yerY && y > 0)
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
	
	board[B_kaldigi_yerX][B_kaldigi_yerY].setAltinVarMi(false);
}

public void BKonum_Guncelle(){	

	Guncel_Konum.remove(2);
	Guncel_Konum.add(2,B_kaldigi_yerX);
	Guncel_Konum.remove(3);
	Guncel_Konum.add(3,B_kaldigi_yerY);	
	System.out.println("B Konum X: "+Guncel_Konum.get(2)+" "+"B Kounm Y: "+Guncel_Konum.get(3));

}
}