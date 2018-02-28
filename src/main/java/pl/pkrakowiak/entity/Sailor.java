package pl.pkrakowiak.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Sailor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String nameSurname;
	String email;
	@DateTimeFormat(pattern="dd-MM-yy")
	@Temporal(TemporalType.DATE)
	Date dateOfBirth;
	String placeOfBirth;
	String adress;
	boolean student = false;
	String studentCardNumber;

	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;

	public String getStudentCardNumber() {
		return studentCardNumber;
	}

	public void setStudentCardNumber(String studentCardNumber) {
		this.studentCardNumber = studentCardNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public boolean isStudent() {
		return student;
	}

	public void setStudent(boolean student) {
		this.student = student;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	

}

// many tweets to one user
// many sailors to one exam

// Sailor == tweet
// exam == User
