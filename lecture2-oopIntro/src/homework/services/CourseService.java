package homework.services;

import java.util.ArrayList;
import java.util.List;

import homework.constants.Messages;
import homework.models.Course;

public class CourseService {
	
	List<Course> _courses = new ArrayList<Course>();
	
	public void add(Course course) {
		if(!this.checkStartAndEndDate(course)) {
			System.out.println("Course start date and end date are cannot be null.");
			return;
		}
		
		this._courses.add(course);
		System.out.println(course.name + " "  + Messages.Added);
	}
	public void update(Course course) {
		
		int courseIndex = this._courses.indexOf(course);
		
		this._courses.set(courseIndex, course);
		System.out.println(course.name + " " + Messages.Updated);
	}
	public void delete(Course course) {
		
		int courseIndex = this._courses.indexOf(course);
		
		this._courses.remove(courseIndex);
		System.out.println(course.name + " " + Messages.Deleted);
	}
	public List<Course> getAll() {
		return _courses;
	}
	
	private boolean checkStartAndEndDate(Course course) {
		
		if(course.startDate == null || course.endDate == null) {
			return false;
		}
		
		return true;
	}
}
