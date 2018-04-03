package src.dagbok.DBControllers;

public class TreningKlasse {
	public String dato;
	public String notat;

	public TreningKlasse(String dato,String notat){
		this.dato=dato;
		this.notat=notat;
	}
	public String getDato() {
		return this.dato;
	}
	public String getNotat() {
		return this.notat;
	}
}
