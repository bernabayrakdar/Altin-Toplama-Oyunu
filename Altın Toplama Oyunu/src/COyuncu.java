import java.util.ArrayList;

import javax.swing.ImageIcon;

public class COyuncu extends GUI2{

	int C_kaldigi_yerX =  Guncel_Konum.get(4);
	int C_kaldigi_yerY = Guncel_Konum.get(5);
	int CAltin = 200;

	ArrayList <Integer> GizliUzaklik = new ArrayList<Integer>();

	int [][] CKonum = new int[80][3];
	int [][] CMaliyet = new int[80][3];	
	int Uzaklik = 0,a=0,b=0,c=0,d=0,m=1,Cx,Cy,sayac=0;
	int AltinDegeri;
	int EnBuyuk;
	int uzaklik = 0;
	int [][] gizli_uzaklik = new int[8][3];
	
public COyuncu(Btn[][] board) {
	super(board);
}
	
public void CHedefBelirleme()
{
	C=0;
	a=0;
	b=0;
	for(int i=19; i>-1; i--)
		{
			for(int j=19; j>-1; j--)			
			{
				if(board[i][j].isAltinVarMi())
				{		
					Uzaklik = Math.abs(C_kaldigi_yerX-i) + Math.abs(C_kaldigi_yerY-j);	
					CKonum[a][b] = i;
					b++;
					CKonum[a][b] = j;
					b++;
					CKonum[a][b] = Uzaklik;
					b=0;
					a++;			
				}				
			}
		}
}

public void CHedefTut()
{
	
	Cx = Guncel_Konum.get(4);	
	Cy = Guncel_Konum.get(5);
	
 if(C_HedefTut.get(2) > 3)	 
 { 
	 C = 1;
	 AltinDegeri =0;
		while(Cx != C_HedefTut.get(0))
		{		
			if(Cx < C_HedefTut.get(0))
			{
				Cx++;			
				sayac++;
				if(sayac == 3)
				{
					C_kaldigi_yerX = Cx;
					C_kaldigi_yerY = Cy;
					C_HedefTut.add(2,C_HedefTut.get(2) - sayac);					
				}															
			}
			else 
			{
				 Cx--;
				 sayac++;				 
				 if(sayac ==3)
				 { 
					C_kaldigi_yerX = Cx;
					C_kaldigi_yerY = Cy;		
					C_HedefTut.add(2,C_HedefTut.get(2) - sayac);
				 }				
			}
		}
		
		if(sayac <3)
		{			
			while( Cy != C_HedefTut.get(1))
			{
				if(Cy < C_HedefTut.get(1))
				{
					Cy++;
					sayac++;					
					if(sayac == 3)
					{
						C_kaldigi_yerX = Cx;
						C_kaldigi_yerY = Cy;		
						C_HedefTut.add(2,C_HedefTut.get(2) - sayac);
					}															
				}				
				else
				{
					Cy--;
					sayac++;
										
					 if(sayac == 3)
						{
						 C_kaldigi_yerX = Cx;
						 C_kaldigi_yerY = Cy;
						 C_HedefTut.add(2,C_HedefTut.get(2) - sayac);
						}					
				}
			}
		}
	EnBuyuk = C_HedefTut.get(2);
	
	for(int i=0;i<80;i++)
	{
		if( Altin[i][0] == C_kaldigi_yerX  && Altin[i][1] == C_kaldigi_yerY)
		{
			AltinDegeri = Altin[i][2];
		}
	}
 }
sayac = 0;	
}

public void Cmaliyet()
{	
	for(int i=0; i<a; i++)
	{	
		AltinDegeri = Altin[i][2];
		CMaliyet[i][0] = CKonum[i][0];
		CMaliyet[i][1] = CKonum[i][1];
		CMaliyet[i][2] = CAltin - (CKonum[i][2]*2)+ AltinDegeri-15;	
	}
	
	EnBuyuk  = CMaliyet[0][2];
	C_kaldigi_yerX = CMaliyet[0][0];	
	C_kaldigi_yerY = CMaliyet[0][1];	
	uzaklik = CKonum[0][2];  


	for(int i=1; i<a; i++)
	{	
		if(EnBuyuk < CMaliyet[i][2])
		{
			EnBuyuk = CMaliyet[i][2];			
			C_kaldigi_yerX = CMaliyet[i][0];
			C_kaldigi_yerY = CMaliyet[i][1];
			uzaklik = CKonum[i][2];  

		}
	}	
	
	CAltin = EnBuyuk;	
	
	for(int i=0;i<80;i++)
	{
		if( Altin[i][0] == C_kaldigi_yerX  && Altin[i][1] == C_kaldigi_yerY)
		{
			AltinDegeri = Altin[i][2];
		}
	}	
	
		D_Konum_Bilgisi.add(6,C_kaldigi_yerX);
		D_Konum_Bilgisi.add(7,C_kaldigi_yerY);
        D_Konum_Bilgisi.add(8,uzaklik);
        	
        C_HedefTut.add(0,C_kaldigi_yerX);
        C_HedefTut.add(1,C_kaldigi_yerY);
        C_HedefTut.add(2,uzaklik);
	  
        CHedefTut(); 
        
  	  if(board[B_HedefTut.get(0)][B_HedefTut.get(1)].isAltinVarMi() == false)
	    {
	    	
	    	C_kaldigi_yerX = Guncel_Konum.get(4);
	    	C_kaldigi_yerY = Guncel_Konum.get(5);
	    	
	    	CHedefBelirleme();
	    
	    	for(int i=0; i<a; i++)
	    	{	
	    		AltinDegeri = Altin[i][2];
	    		CMaliyet[i][0] = CKonum[i][0];
	    		CMaliyet[i][1] = CKonum[i][1];
	    		CMaliyet[i][2] = CAltin - (CKonum[i][2]*2)+ AltinDegeri-15;	
	    	}
	    	
	    	EnBuyuk  = CMaliyet[0][2];
	    	C_kaldigi_yerX = CMaliyet[0][0];	
	    	C_kaldigi_yerY = CMaliyet[0][1];	
	    	uzaklik = CKonum[0][2];  


	    	for(int i=1; i<a; i++)
	    	{	
	    		if(EnBuyuk < CMaliyet[i][2])
	    		{
	    			EnBuyuk = CMaliyet[i][2];			
	    			C_kaldigi_yerX = CMaliyet[i][0];
	    			C_kaldigi_yerY = CMaliyet[i][1];
	    			uzaklik = CKonum[i][2];  

	    		}
	    	}	
	    	
	    	CAltin = EnBuyuk;	
	    	
	    	D_Konum_Bilgisi.add(6,C_kaldigi_yerX);
	    	D_Konum_Bilgisi.add(7,C_kaldigi_yerY);
	    	D_Konum_Bilgisi.add(8,uzaklik);
	    	
	    	C_HedefTut.add(0,C_kaldigi_yerX);
	    	C_HedefTut.add(1,C_kaldigi_yerY);
	    	C_HedefTut.add(2,uzaklik);
	    	  
	    	CHedefTut(); 
	    }		
     board[C_kaldigi_yerX][C_kaldigi_yerY].setAltinVarMi(false);
}

public void CAltinAc() {
	c=0;
	d=0;
	int x = Guncel_Konum.get(4);
	int y = Guncel_Konum.get(5);
	
	for(int i=0; i<8; i++)
	{
		if(board[GizliAltin[i][0]][GizliAltin[i][1]].isGizliAltinn() == true)
		{		
			gizli_uzaklik[c][d] = Math.abs(GizliAltin[i][0] - x) + Math.abs(GizliAltin[i][1]-y);
			d++;
			gizli_uzaklik[c][d] = GizliAltin[i][0];
			d++;
			gizli_uzaklik[c][d] = GizliAltin[i][1];	
			d=0;
			c++;
		}	
	}
	
	int temp=0,temp1=0,temp2=0;
	
	for(int i=0; i<c; i++)
	{
		for(int j=1; j<c-i; j++)
			{
				if(gizli_uzaklik[j-1][0] > gizli_uzaklik[j][0])
				{
					temp = gizli_uzaklik[j-1][0];
					temp1 = gizli_uzaklik[j-1][1];
					temp2 = gizli_uzaklik[j-1][2];
					
					gizli_uzaklik[j-1][0] = gizli_uzaklik[j][0];
					gizli_uzaklik[j-1][1] = gizli_uzaklik[j][1];
					gizli_uzaklik[j-1][2] = gizli_uzaklik[j][2];
					
					gizli_uzaklik[j][0] = temp;
				    gizli_uzaklik[j][1] = temp1;
					gizli_uzaklik[j][2] = temp2;					
					
				}
			}	
	}
	
	for(int i =0; i<c; i++)
	{
		GizliUzaklik.add(gizli_uzaklik[i][0]);
		GizliUzaklik.add(gizli_uzaklik[i][1]);
		GizliUzaklik.add(gizli_uzaklik[i][2]);
	} 	
	
	if(board[gizli_uzaklik[0][1]][gizli_uzaklik[0][2]].isGizliAltinn())
	{
		board[gizli_uzaklik[0][1]][gizli_uzaklik[0][2]].setGizliAltinn(false);
		board[gizli_uzaklik[0][1]][gizli_uzaklik[0][2]].setAltinVarMi(true);
		board[gizli_uzaklik[0][1]][gizli_uzaklik[0][2]].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));			
	}
	
	if(board[gizli_uzaklik[1][1]][gizli_uzaklik[1][2]].isGizliAltinn())
	{
		board[gizli_uzaklik[1][1]][gizli_uzaklik[1][2]].setGizliAltinn(false);
		board[gizli_uzaklik[1][1]][gizli_uzaklik[1][2]].setAltinVarMi(true);
		board[gizli_uzaklik[1][1]][gizli_uzaklik[1][2]].setIcon(new ImageIcon(this.getClass().getResource("/flag.png")));	
		
	}		
}

public void CKonum_Guncelle(){
	
	Guncel_Konum.remove(4);
	Guncel_Konum.add(4,C_kaldigi_yerX);
	Guncel_Konum.remove(5);
	Guncel_Konum.add(5,C_kaldigi_yerY);	
	System.out.println("C Konum X: "+Guncel_Konum.get(4)+" "+"C Kounm Y: "+Guncel_Konum.get(5));

}
}