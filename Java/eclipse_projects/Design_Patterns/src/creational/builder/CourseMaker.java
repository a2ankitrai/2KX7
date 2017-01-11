package creational.builder;

public class CourseMaker {

	private CourseBuilder courseBuilder;
	
	public CourseMaker(CourseBuilder courseBuilder){
		this.courseBuilder = courseBuilder;
	}
	
	public ConcreteCourse getCourse(){
		return this.courseBuilder.getCourse();
	}
	
	public void makeCourse(){
		this.courseBuilder.buildCourseBasics();
		this.courseBuilder.buildCourseIntermediates();
		this.courseBuilder.buildCourseAdvances();
	}
}
