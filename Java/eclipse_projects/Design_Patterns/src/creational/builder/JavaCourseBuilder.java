package creational.builder;

public class JavaCourseBuilder implements CourseBuilder{

	private ConcreteCourse course;
	
	public JavaCourseBuilder() {
		course = new ConcreteCourse();
	}
	
	@Override
	public void buildCourseBasics() {
		course.setBasicTopics("Core Java");
	}

	@Override
	public void buildCourseIntermediates() {
		course.setIntermediateTopics("J2EE: Servlets and JSP");	
	}

	@Override
	public void buildCourseAdvances() {
		course.setAdvancedTopics("Frameworks: Spring and Hibernate");
	}

	@Override
	public ConcreteCourse getCourse() {
		// TODO Auto-generated method stub
		return this.course;
	}

}
