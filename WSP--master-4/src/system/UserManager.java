package system;

import admin.Admin;
import student.Student;
import teacher.Teacher;


public class UserManager {
	
	public static class NotExistingUserClassException extends Exception {
		public NotExistingUserClassException(String message) {
	        super(message);
	    }
	}
	
	UserManager(){};
	
	public static void login(String username, String name, String surname, String type) throws NotExistingUserClassException
	{
		switch(type)
		{
			case("admin"):
				Admin admin = new Admin(username, name, surname);
				break;
				
			case("student"):
				Student student = new Student(username, name, surname);
				break;
				
			case("teacher"):
				Teacher teacher = new Teacher(username, name, surname);
				break; 
				
			default:
				throw new NotExistingUserClassException("User Manager failed to found any matching classes");
		}
	} 
}


