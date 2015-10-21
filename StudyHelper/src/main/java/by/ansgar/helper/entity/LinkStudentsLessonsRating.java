package by.ansgar.helper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "link_stud_les_rat")
public class LinkStudentsLessonsRating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@ManyToOne
	@JoinColumn(name = "group_id", referencedColumnName = "id")
	private Group group;
	@ManyToOne
	@JoinColumn(name = "stud_id", referencedColumnName = "id")
	private Students students;
	@ManyToOne
	@JoinColumn(name = "less_id", referencedColumnName = "id")
	private Lessons lessons;
	@ManyToOne
	@JoinColumn(name = "rat_id", referencedColumnName = "id")
	private Ratings ratings;

	public LinkStudentsLessonsRating() {

	}

	public LinkStudentsLessonsRating(long id, Group group, Students students,
			Lessons lessons, Ratings rating) {
		this.id = id;
		this.group = group;
		this.students = students;
		this.lessons = lessons;
		this.ratings = rating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Students getStudents() {
		return students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Lessons getLessons() {
		return lessons;
	}

	public void setLessons(Lessons lessons) {
		this.lessons = lessons;
	}

	public Ratings getRating() {
		return ratings;
	}

	public void setRating(Ratings rating) {
		this.ratings = rating;
	}

}
