package gun3Odev2.entities;


public class Student extends User{
	private String studentNo;
	
	public Student(int id, String firstName, String lastName, String email, byte[] passwordSalt, byte[] passwordHash, boolean status, String studentNo) {
		super(id, firstName, lastName, email, passwordSalt, passwordHash, status);
		this.studentNo=studentNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	
}