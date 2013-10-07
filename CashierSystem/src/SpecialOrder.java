import java.io.Serializable;
public class SpecialOrder implements Serializable {
	private static final long serialVersionUID = -3358923735860534296L;
private boolean isSpecial;
private String information;
public SpecialOrder(){
	
}
public SpecialOrder(boolean special, String inf){
	this.setSpecial(special);
	this.setInformation(inf);
}
public boolean isSpecial() {
	return isSpecial;
}
public void setSpecial(boolean isSpecial) {
	this.isSpecial = isSpecial;
}
public String getInformation() {
	return information;
}
public void setInformation(String information) {
	this.information = information;
}
}
