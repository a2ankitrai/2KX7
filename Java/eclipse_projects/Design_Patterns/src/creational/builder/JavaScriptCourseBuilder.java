package creational.builder;

public class JavaScriptCourseBuilder implements CourseBuilder{

	private ConcreteCourse course;
	
	public JavaScriptCourseBuilder() {
		this.course = new ConcreteCourse();
	}
	
	@Override
	public void buildCourseBasics() {
		course.setBasicTopics("basic JS"); 
	}

	@Override
	public void buildCourseIntermediates() {
		course.setIntermediateTopics("Closures and Hoisting");	
	}

	@Override
	public void buildCourseAdvances() {
		course.setAdvancedTopics("Frameworks: AngularJS and Node JS");
	}

	@Override
	public ConcreteCourse getCourse() {
		// TODO Auto-generated method stub
		return this.course;
	}

}
