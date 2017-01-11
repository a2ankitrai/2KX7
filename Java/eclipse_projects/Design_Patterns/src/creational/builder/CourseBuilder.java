package creational.builder;

public interface CourseBuilder {

	public void buildCourseBasics();
	
	public void buildCourseIntermediates();
	
	public void buildCourseAdvances();
	
	public ConcreteCourse getCourse();
}
