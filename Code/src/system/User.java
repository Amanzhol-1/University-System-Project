package system;

import java.util.Objects;

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
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(name, surname, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname)
				&& Objects.equals(username, other.username);
	}
	

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", surname=" + surname + "]";
	}
	
	
}
