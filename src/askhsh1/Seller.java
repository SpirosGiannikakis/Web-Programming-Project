package askhsh1;
import java.util.Scanner;

public class Seller extends Users {
	public Seller(String username, String name, String surname, String password) {
		super(username, name, surname, password);
		// TODO Auto-generated constructor stub
	}
	Program program;
	//String salary, store;
	public void registerNewClient(){
		//NA VALOUME PRAGMATA
		System.out.println("The client was registered successfully!");
	}
	public void createAccount() {
		System.out.println("The account was created successfully!");
	}
	public void changeProgram() {
		System.out.println("Program changed successfully!");
	}
}
