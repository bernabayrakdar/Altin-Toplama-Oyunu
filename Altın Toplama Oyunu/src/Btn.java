import javax.swing.JButton;

public class Btn extends JButton{
	
	private int BtnSatir,BtnSutun;
	private boolean AltinVarMi;
	private boolean GizliAltinn;	
	
	public Btn(int BtnSatir,int BtnSutun)
	{
		this.BtnSatir = BtnSatir;
		this.BtnSutun = BtnSutun;
		this.AltinVarMi =false;
		this.GizliAltinn =false;
	}
	
	public int getBtnSatir() {
		return BtnSatir;
	}

	public void setBtnSatir(int btnSatir) {
		BtnSatir = btnSatir;
	}

	public int getBtnSutun() {
		return BtnSutun;
	}

	public void setBtnSutun(int btnSutun) {
		BtnSutun = btnSutun;
	}

	public boolean isAltinVarMi() {
		return AltinVarMi;
	}

	public void setAltinVarMi(boolean altinVarMi) {
		AltinVarMi = altinVarMi;
	}

	public boolean isGizliAltinn() {
		return GizliAltinn;
	}

	public void setGizliAltinn(boolean gizliAltinn) {
		GizliAltinn = gizliAltinn;
	}
}