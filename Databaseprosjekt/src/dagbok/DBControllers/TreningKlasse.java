package src.dagbok.DBControllers;

public class TreningKlasse {
	public String navn;
	public String type;

	TreningKlasse(String type,String navn){
		this.navn=navn;
		this.type=type;
	}
	public String getNavn() {
		return this.navn;
	}
	public String getType() {
		return this.type;
	}
}
