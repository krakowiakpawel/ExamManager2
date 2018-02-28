package pl.pkrakowiak.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class ComMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	String nameSurname;
	String sailingLicence;
	String instructorLicence;

	@ManyToMany(mappedBy = "comMemberList"
			//, fetch = FetchType.EAGER
			)
	private List<Exam> examList = new ArrayList<>();

	@OneToMany(mappedBy = "chairman"
			//, fetch = FetchType.EAGER
			)
	private List<Exam> examChairmanList = new ArrayList<>();

	@OneToMany(mappedBy = "secretary"
		//	, fetch = FetchType.EAGER
			)
	private List<Exam> examSecretaryList = new ArrayList<>();

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

	public String getSailingLicence() {
		return sailingLicence;
	}

	public void setSailingLicence(String sailingLicence) {
		this.sailingLicence = sailingLicence;
	}

	public String getInstructorLicence() {
		return instructorLicence;
	}

	public void setInstructorLicence(String instructorLicence) {
		this.instructorLicence = instructorLicence;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public void setExamList(List<Exam> examList) {
		this.examList = examList;
	}

	public List<Exam> getExamChairmanList() {
		return examChairmanList;
	}

	public void setExamChairmanList(List<Exam> examChairmanList) {
		this.examChairmanList = examChairmanList;
	}

	public List<Exam> getExamSecretaryList() {
		return examSecretaryList;
	}

	public void setExamSecretaryList(List<Exam> examSecretaryList) {
		this.examSecretaryList = examSecretaryList;
	}

}
