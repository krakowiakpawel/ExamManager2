package pl.pkrakowiak.entity;

import java.util.Date;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String place;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	Date date;
	String number;
	String type;

	@OneToMany(mappedBy = "exam")
	private List<Sailor> sailorList = new ArrayList<>();
	
	@ManyToOne
	ComMember chairman;
	
	@ManyToOne
	ComMember secretary;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	private List<ComMember> comMemberList = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Sailor> getSailorList() {
		return sailorList;
	}

	public void setSailorList(List<Sailor> sailorList) {
		this.sailorList = sailorList;
	}

	public ComMember getChairman() {
		return chairman;
	}

	public void setChairman(ComMember chairman) {
		this.chairman = chairman;
	}

	public ComMember getSecretary() {
		return secretary;
	}

	public void setSecretary(ComMember secretary) {
		this.secretary = secretary;
	}

	public List<ComMember> getComMemberList() {
		return comMemberList;
	}

	public void setComMemberList(List<ComMember> comMemberList) {
		this.comMemberList = comMemberList;
	}


}
