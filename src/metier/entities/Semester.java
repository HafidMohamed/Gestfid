package metier.entities;

public class Semester {
	private String semester;

	public Semester() {
		super();
	}

	public Semester(String semester) {
		super();
		this.semester = semester;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Semester [Semester=" + semester + "]";
	}
	

}
