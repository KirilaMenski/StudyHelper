package by.ansgar.helper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lessons")
public class Lessons {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "lesson")
	private String lesson;
	@Column(name = "lesson_eng")
	private String lesson_eng;

	public Lessons() {

	}

	public Lessons(long id, String lesson, String lesson_eng) {
		super();
		this.id = id;
		this.lesson = lesson;
		this.lesson_eng = lesson_eng;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public String getLesson_eng() {
		return lesson_eng;
	}

	public void setLesson_eng(String lesson_eng) {
		this.lesson_eng = lesson_eng;
	}

}
