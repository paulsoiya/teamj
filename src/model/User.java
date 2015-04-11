package model;

public class User {
	public static final User NULL_USER = new User();
	
	private int id;
	private String email;
	private String password;
	private String passwordConfirm;
	private String firstName;
	private String lastName;
	private String dob;
	
	public User() {
	}
	
	public User(int id, String email, String password, String firstName, String lastName,
			String dob) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	public User(String email, String password, String firstName, String lastName,
			String dob) {
		
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	public User(String email, String password, String passwordConfirm, String firstName,
			String lastName, String dob) {
		
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public ValidateResult validate() {
		ValidateResult result = new ValidateResult(false, "");
		String emailRegex = ".+@.+\\.[a-z]+";
		boolean validEmail = email.matches(emailRegex);
		boolean validName = !firstName.isEmpty() && !lastName.isEmpty();
		boolean validPassword = !password.isEmpty() && password.equals(passwordConfirm);
		
		if (!validName) {
			result.setMessage("You must enter your first and last name.");
		}
		else if (!validEmail) {
			result.setMessage("The email you entered is invalid.");
		}
		else if (!validPassword) {
			result.setMessage("The passwords you entered do not mach.");
		}
		else {
			result.setValid(true);
		}
		
		return result;
		
	}
	
}
