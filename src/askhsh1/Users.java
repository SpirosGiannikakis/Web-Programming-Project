package askhsh1;

public class Users {
	private String username, name, surname, password;
	private static int usersCounter = 0;
	public Users(String username, String name, String surname, String password) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static int getUsersCounter() {
		return usersCounter;
	}
	public static void setUsersCounter(int usersCounter) {
		Users.usersCounter = usersCounter;
	}
	
	
}
