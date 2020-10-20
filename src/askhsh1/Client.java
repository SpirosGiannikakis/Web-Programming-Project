package askhsh1;

public class Client extends Users{
	
	final String afm;
	String phone;

	public Client(String username, String name, String surname, String password, String afm, String phone) {
		super(username, name, surname, password);
		this.afm = afm;
		this.phone = phone;
		// TODO Auto-generated constructor stub
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAfm() {
		return afm;
	}
	
	

}
