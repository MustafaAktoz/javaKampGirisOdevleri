package gun3Odev2.entities;


public class Instructor extends User {

	public Instructor(int id, String firstName, String lastName, String email, byte[] passwordSalt, byte[] passwordHash, boolean status) {
		super(id, firstName, lastName, email, passwordSalt, passwordHash, status);
	}
}
