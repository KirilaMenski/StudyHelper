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
	@JoinColumn(name = "stud_id", referencedColumnName = "id")
	private Students students;
	@ManyToOne
	@JoinColumn(name = "less_id", referencedColumnName = "id")
	private Lessons lessons;
	@ManyToOne
	@JoinColumn(name = "rat_id", referencedColumnName = "id")
	private Rating ratings;

	public LinkStudentsLessonsRating() {

	}

	public LinkStudentsLessonsRating(long id, Students students,
			Lessons lessons, Rating rating) {
		this.id = id;
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

	public Rating getRating() {
		return ratings;
	}

	public void setRating(Rating rating) {
		this.ratings = rating;
	}

}
