package system;

public abstract class User {
	public String username;
	public String name;
	public String surname;
	
	public User(String username, String name, String surname)
	{
		this.name = name;
		this.surname = surname;
		this.username = username;
		logIn();
	}
	
	public User() {};
	
	public abstract void logIn();
}
