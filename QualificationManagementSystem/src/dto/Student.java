package dto;

public class Student {
	private String no;
	private String name;
	private int grade;
	private int clas;

	public Student(String no, String name, int grade, int clas) {
		this.no = no;
		this.name = name;
		this.grade = grade;
		this.clas = clas;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClas() {
		return clas;
	}

	public void setClas(int clas) {
		this.clas = clas;
	}
}