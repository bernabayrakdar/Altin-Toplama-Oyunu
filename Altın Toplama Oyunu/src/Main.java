import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class Main {
	
	static Btn[][] board =  new Btn[20][20];
	static int [][] Altin = new int [80][3]; 
	static int [][] GizliAltin = new int [8][2]; 
	static int [] AltinDeger = new int[4];
	static ArrayList <Integer> Guncel_Konum = new ArrayList<Integer>(); 
	static ArrayList <Integer> D_Konum_Bilgisi = new ArrayList<Integer>();
	static int B,C,A,D,say=0,aadýmsay=0, badýmsay=0,cadýmsay=0,dadýmsay=0;

	static ArrayList <Integer> A_HedefTut = new ArrayList<Integer>();
	static ArrayList <Integer> B_HedefTut = new ArrayList<Integer>();
	static ArrayList <Integer> C_HedefTut = new ArrayList<Integer>();
	static ArrayList <Integer> D_HedefTut = new ArrayList<Integer>();
	static ArrayList <Integer> Oyun_Sonu = new ArrayList<Integer>();
	static ArrayList <Integer> Altýn_Tut = new ArrayList<Integer>();
	static int q =0,sayac2=0,Aaltindegeri,Baltindegeri,Caltindegeri,Daltindegeri,A_Altin,B_Altin,C_Altin,D_Altin;
	static int k =0, Agidilecekx=0, Agidileceky=0, Bgidilecekx=0, Bgidileceky=19, Cgidilecekx=19, Cgidileceky=19, Dgidilecekx = 19, Dgidileceky=0;
	
public static void main(String [] args)
{		
	JFrame frame = new JFrame("ALTIN TOPLAMA OYUNU");
	frame.setSize(800,800);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new GridLayout(20,20));
		
	for(int  i=0;i<20;i++)
	{
		for(int j=0 ; j<20 ; j++)
		{
			Btn buton = new Btn(i,j);
			frame.add(buton);
			board[i][j] = buton;
			board[i][j].setBackground(Color.gray);
		}
	}		 

		GUI2 gui = new GUI2(board);
		gui.rastgele();
		gui.print();
		
		AOyuncu Aoyuncu = new AOyuncu(board);
		BOyuncu Boyuncu = new BOyuncu(board);
		COyuncu Coyuncu = new COyuncu(board);
		DOyuncu Doyuncu = new DOyuncu(board);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {		
				do {
					try {
						Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}	
						
						Aoyuncu.AHedefBelirleme();
						Aoyuncu.AMaliyet();	
		
						board[Guncel_Konum.get(0)][Guncel_Konum.get(1)].setText("A");
						board[Guncel_Konum.get(0)][Guncel_Konum.get(1)].setIcon(null);
													
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}		
						
						Boyuncu.BHedefBelirleme();
						Boyuncu.Bmaliyet();	
						
						board[Guncel_Konum.get(2)][Guncel_Konum.get(3)].setText("B");
						board[Guncel_Konum.get(2)][Guncel_Konum.get(3)].setIcon(null);	

						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						Coyuncu.CHedefBelirleme();
						Coyuncu.Cmaliyet();
						
						board[Guncel_Konum.get(4)][Guncel_Konum.get(5)].setText("C");
						board[Guncel_Konum.get(4)][Guncel_Konum.get(5)].setIcon(null);
						
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
						}	
						
						Doyuncu.DHedefBelirleme();
						Doyuncu.DMaliyetHesaplama();
						
						board[Guncel_Konum.get(6)][Guncel_Konum.get(7)].setText("D");
						board[Guncel_Konum.get(6)][Guncel_Konum.get(7)].setIcon(null);						

	    				q++;
					}while(q<1);
					
					while(true) {
						
						if(Aoyuncu.AAltin >0) 
						{	
					    board[Guncel_Konum.get(0)][Guncel_Konum.get(1)].setText(null);					   
						Aoyuncu.AKonum_Guncelle();	
						
						for(int  i=0;i<20;i++)
						{
							for(int j=0 ; j<20 ; j++)
							{						
							     if(board[i][j].isAltinVarMi() == true)		    	 
								{   	
							    		say++;
								}				
							}
						}	
						
						while(Agidilecekx != Guncel_Konum.get(0))
						{
							if(Agidilecekx < Guncel_Konum.get(0))
							{
								Agidilecekx ++;
								aadýmsay++;
								board[Agidilecekx][Agidileceky].setText("A");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Agidilecekx][Agidileceky].setText(" ");								
							}
							else {
								Agidilecekx--;
								aadýmsay++;
								board[Agidilecekx][Agidileceky].setText("A");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Agidilecekx][Agidileceky].setText(" ");
							}
						}
						
						while(Agidileceky != Guncel_Konum.get(1))
						{
							if(Agidileceky < Guncel_Konum.get(1))
							{
								Agidileceky ++;
								aadýmsay++;
								board[Agidilecekx][Agidileceky].setText("A");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Agidilecekx][Agidileceky].setText(" ");						
							}
							else {
								Agidileceky--;
								aadýmsay++;
								board[Agidilecekx][Agidileceky].setText("A");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Agidilecekx][Agidileceky].setText(" ");		
							}							
						}
						
						if(A_HedefTut.get(0) == Guncel_Konum.get(0) && A_HedefTut.get(1) == Guncel_Konum.get(1))
						{
							A=0;						
						}
					
						if(A == 0)
						{	
							Aoyuncu.AHedefBelirleme();						
						}
						
						Aoyuncu.AMaliyet();	
						Aaltindegeri = Aoyuncu.AltinDegeri;						
						board[Guncel_Konum.get(0)][Guncel_Konum.get(1)].setText("A");
						board[Guncel_Konum.get(0)][Guncel_Konum.get(1)].setIcon(null);					
						Oyun_Sonu.add(Aoyuncu.AAltin);
						A_Altin = Aoyuncu.AAltin;
						ADosyaYazma();
						
						}
						
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if(Boyuncu.BAltin > 0)
						{
						
					    board[Guncel_Konum.get(2)][Guncel_Konum.get(3)].setText(null);
						Boyuncu.BKonum_Guncelle();	
						
						for(int  i=0;i<20;i++)
						{
							for(int j=0 ; j<20 ; j++)
							{						
							     if(board[i][j].isAltinVarMi() == true)		    	 
								{   	
							    		say++;
								}				
							}
						}	
						
						while(Bgidilecekx != Guncel_Konum.get(2))
						{
							if(Bgidilecekx < Guncel_Konum.get(2))
							{
								Bgidilecekx ++;
								badýmsay++;
								board[Bgidilecekx][Bgidileceky].setText("B");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Bgidilecekx][Bgidileceky].setText(" ");								
							}
							else {
								Bgidilecekx--;
								badýmsay++;
								board[Bgidilecekx][Bgidileceky].setText("B");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Bgidilecekx][Bgidileceky].setText(" ");
							}	
						}
						
						while(Bgidileceky != Guncel_Konum.get(3))
						{
							if(Bgidileceky < Guncel_Konum.get(3))
							{
								Bgidileceky ++;
								badýmsay++;
								board[Bgidilecekx][Bgidileceky].setText("B");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Bgidilecekx][Bgidileceky].setText(" ");						
							}
							else {
								Bgidileceky--;
								badýmsay++;
								board[Bgidilecekx][Bgidileceky].setText("B");
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Bgidilecekx][Bgidileceky].setText(" ");		
							}							
						}	
						
						if(B_HedefTut.get(0) == Guncel_Konum.get(2) && B_HedefTut.get(1) == Guncel_Konum.get(3))
						{
							B=0;
						}
						
						if(B == 0)
						{
							Boyuncu.BHedefBelirleme();							
						}
					
						Boyuncu.Bmaliyet();
						Baltindegeri = Boyuncu.AltinDegeri;
						board[Guncel_Konum.get(2)][Guncel_Konum.get(3)].setText("B");	
					    board[Guncel_Konum.get(2)][Guncel_Konum.get(3)].setIcon(null);	
					    Oyun_Sonu.add(Boyuncu.BAltin);
					    B_Altin = Boyuncu.BAltin;
					    BDosyaYazma();
						
						}		
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}		
					
						if(Coyuncu.CAltin > 0)
						{						
							board[Guncel_Konum.get(4)][Guncel_Konum.get(5)].setText(null);
							Coyuncu.CAltinAc();
							Coyuncu.CKonum_Guncelle();	  
							
							for(int  i=0;i<20;i++)
							{
								for(int j=0 ; j<20 ; j++)
								{						
								     if(board[i][j].isAltinVarMi() == true)		    	 
									{   	
								    		say++;
									}				
								}
							}	
						
						while(Cgidilecekx != Guncel_Konum.get(4))
						{
							if(Cgidilecekx < Guncel_Konum.get(4))
							{
								Cgidilecekx ++;
								cadýmsay++;
								board[Cgidilecekx][Cgidileceky].setText("C");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Cgidilecekx][Cgidileceky].setText(" ");								
							}
							else {
								Cgidilecekx--;
								cadýmsay++;
								board[Cgidilecekx][Cgidileceky].setText("C");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Cgidilecekx][Cgidileceky].setText(" ");
							}	
						}
						
						while(Cgidileceky != Guncel_Konum.get(5))
						{
							if(Cgidileceky < Guncel_Konum.get(5))
							{
								Cgidileceky ++;
								cadýmsay++;
								board[Cgidilecekx][Cgidileceky].setText("C");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Cgidilecekx][Cgidileceky].setText(" ");						
							}
							else {
								Cgidileceky--;
								cadýmsay++;
								board[Cgidilecekx][Cgidileceky].setText("C");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Cgidilecekx][Cgidileceky].setText(" ");		
							}							
						}   
						
						if(C_HedefTut.get(0) == Guncel_Konum.get(4) && C_HedefTut.get(1) == Guncel_Konum.get(5))
						{
							C=0;
						}
					
						if(C == 0)
						{
							Coyuncu.CHedefBelirleme();	
						}					    
					   						
						Coyuncu.Cmaliyet();
						Caltindegeri = Coyuncu.AltinDegeri;
						board[Guncel_Konum.get(4)][Guncel_Konum.get(5)].setText("C");
						board[Guncel_Konum.get(4)][Guncel_Konum.get(5)].setIcon(null);	
						Oyun_Sonu.add(Coyuncu.CAltin);
						C_Altin = Coyuncu.CAltin;
						CDosyaYazma();
						}
						
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						if(Doyuncu.DAltin > 0)
						{						 
							board[Guncel_Konum.get(6)][Guncel_Konum.get(7)].setText(null);
							Doyuncu.DKonumGuncelleme();
							
							for(int  i=0;i<20;i++)
							{
								for(int j=0 ; j<20 ; j++)
								{						
								     if(board[i][j].isAltinVarMi() == true)		    	 
									{   	
								    		say++;
									}				
								}
							}	
						
						while(Dgidilecekx != Guncel_Konum.get(6))
						{
							if(Dgidilecekx < Guncel_Konum.get(6))
							{
								Dgidilecekx ++;
								dadýmsay++;
								board[Dgidilecekx][Dgidileceky].setText("D");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Dgidilecekx][Dgidileceky].setText(" ");								
							}
							else {
								Dgidilecekx--;
								dadýmsay++;
								board[Dgidilecekx][Dgidileceky].setText("D");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Dgidilecekx][Dgidileceky].setText(" ");
							}	
						}
						
						while(Dgidileceky != Guncel_Konum.get(7))
						{
							if(Dgidileceky < Guncel_Konum.get(7))
							{
								Dgidileceky ++;
								dadýmsay++;
								board[Dgidilecekx][Dgidileceky].setText("D");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Dgidilecekx][Dgidileceky].setText(" ");						
							}
							else {
								Dgidileceky--;
								dadýmsay++;
								board[Dgidilecekx][Dgidileceky].setText("D");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								board[Dgidilecekx][Dgidileceky].setText(" ");		
							}							
						}   
						
						if(D_HedefTut.get(0) == Guncel_Konum.get(6) && D_HedefTut.get(1) == Guncel_Konum.get(7))
						{
							D=0;
						}
					
						if(D == 0)
						{
							Doyuncu.DHedefBelirleme();	
						}	
					    					
						Doyuncu.DMaliyetHesaplama();
						Daltindegeri = Doyuncu.AltinDegeri;
						board[Guncel_Konum.get(6)][Guncel_Konum.get(7)].setText("D");
						board[Guncel_Konum.get(6)][Guncel_Konum.get(7)].setIcon(null);	
						Oyun_Sonu.add(Doyuncu.DAltin);
						D_Altin = Doyuncu.DAltin;
						DDosyaYazma();
						}					
					 
						try {
							Thread.sleep(300);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}	
						
						System.out.println("-----A: "+Aoyuncu.AAltin);
						System.out.println("-----B: "+Boyuncu.BAltin);
						System.out.println("-----C: "+Coyuncu.CAltin);
						System.out.println("-----D: "+Doyuncu.DAltin);		

						for(int f =0; f< Oyun_Sonu.size(); f++)
						{
							if(Oyun_Sonu.get(f) > 0)
							{ 
								sayac2++;						
							}
							
						}
						if(say == 0)
						{
							System.out.println("say: "+say);
							timer.cancel();
							System.exit(0);
						}
						
						if(sayac2 == 1)
						{
							timer.cancel();
							System.exit(0);
						}
						
						sayac2=0;
						say=0;
						Oyun_Sonu.clear();													
				}
			}
			}; timer.schedule(task, k, 500);
			k+=500;		
		frame.setVisible(true);	       
}
	
public static void ADosyaYazma()
{
	 File file = new File("A_OYUNCUSU.txt");		
     
	 if(!file.exists())
	 {
		 try {
             file.createNewFile();             
         } catch (Exception e) {
             e.printStackTrace();
         }		 
	 }        
	 
	 if(file.exists())
	 {
		 try {
			 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 bw.newLine();	

			 bw.write(String.valueOf("A Konum X: "+Guncel_Konum.get(0)+" "+"A Kounm Y: "+Guncel_Konum.get(1)));
			 bw.newLine();
			 bw.write(String.valueOf("A Hedef X: "+A_HedefTut.get(0)+" "+"A Hedef Y: "+A_HedefTut.get(1)));
			 bw.newLine();
			 bw.write(String.valueOf("A Altýn: "+A_Altin));
			 bw.newLine();
			 bw.write(String.valueOf("Geldiði Konumdaki ALtýn Deðeri: "+Aaltindegeri));
			 bw.newLine();
			 bw.write(String.valueOf("A Adým Sayýsý: "+aadýmsay));
			 bw.newLine();
			 
			 bw.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}               
	 }
}

public static void BDosyaYazma()
{
 File file = new File("B_OYUNCUSU.txt");		
     
	 if (!file.exists())
	 {
		 try {
             file.createNewFile();             
         } catch (Exception e) {
             e.printStackTrace();
         }		 
	 } 
	 if(file.exists())
	 {
		 try {
			 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 bw.newLine();	
			 
			 bw.write(String.valueOf("B Konum X: "+Guncel_Konum.get(2)+" "+"B Kounm Y: "+Guncel_Konum.get(3)));
			 bw.newLine();
			 bw.write(String.valueOf("B Hedef X: "+B_HedefTut.get(0)+" "+"B Hedef Y: "+B_HedefTut.get(1)));
			 bw.newLine();
			 bw.write(String.valueOf("B Altýn: "+B_Altin));
			 bw.newLine();
			 bw.write(String.valueOf("Geldiði Konumdaki ALtýn Deðeri: "+Baltindegeri));
			 bw.newLine();
			 bw.write(String.valueOf("B Adým Sayýsý: "+badýmsay));
			 bw.newLine();
			  
			 bw.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}               
	 }	
}
public static void CDosyaYazma()
{
 File file = new File("C_OYUNCUSU.txt");
		
	 if (!file.exists())
	 {
		 try {
             file.createNewFile();             
         } catch (Exception e) {
             e.printStackTrace();
         }		 
	 } 
	 if(file.exists())
	 {
		 try {
			 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 bw.newLine();	
			 
			 bw.write(String.valueOf("C Konum X: "+Guncel_Konum.get(4)+" "+"C Kounm Y: "+Guncel_Konum.get(5)));
			 bw.newLine();
			 bw.write(String.valueOf("C Hedef X: "+C_HedefTut.get(0)+" "+"C Hedef Y: "+C_HedefTut.get(1)));
			 bw.newLine();
			 bw.write(String.valueOf("C Altýn: "+C_Altin));
			 bw.newLine();
			 bw.write(String.valueOf("Geldiði Konumdaki ALtýn Deðeri: "+Caltindegeri));
			 bw.newLine();
			 bw.write(String.valueOf("C Adým Sayýsý: "+cadýmsay));
			 bw.newLine();
			  
			 bw.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}               
	 }	
}

public static void DDosyaYazma()
{
 File file = new File("D_OYUNCUSU.txt");
		    
	 if (!file.exists())
	 {
		 try {
             file.createNewFile();             
         } catch (Exception e) {
             e.printStackTrace();
         }		 
	 } 
	 if(file.exists())
	 {
		 try {
			 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 bw.newLine();	
			 
			 bw.write(String.valueOf("D Konum X: "+Guncel_Konum.get(6)+" "+"D Kounm Y: "+Guncel_Konum.get(7))); 
		 	 bw.newLine();
			 bw.write(String.valueOf("D Hedef X: "+D_HedefTut.get(0)+" "+"D Hedef Y: "+D_HedefTut.get(1)));
			 bw.newLine();
			 bw.write(String.valueOf("D Altýn: "+D_Altin));
			 bw.newLine(); 
			 bw.write(String.valueOf("Geldiði Konumdaki ALtýn Deðeri: "+Daltindegeri));
			 bw.newLine();
			 bw.write(String.valueOf("D Adým Sayýsý: "+dadýmsay));
			 bw.newLine();
			  
			 bw.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}               
	 }	
}
}