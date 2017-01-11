package creational.builder;

public class TestCourseBuilder {

	public static void main(String[] args) {
		
		CourseBuilder javaCB = new JavaCourseBuilder();
		
		CourseBuilder jsCB = new JavaScriptCourseBuilder();
		
		CourseMaker cm = new CourseMaker(javaCB);
		CourseMaker cm2 = new CourseMaker(jsCB);
		
		cm.makeCourse();
		cm2.makeCourse();
		
		ConcreteCourse javaCourse = cm.getCourse();
		
		System.out.println("Java Course Made");
		
		System.out.println("Basics: "+ javaCourse.getBasic());
		System.out.println("Intermediates: "+ javaCourse.getIntermediate());
		System.out.println("Advanced: "+ javaCourse.getAdvanced());
		
		ConcreteCourse javaScriptCourse = cm2.getCourse();
		
		System.out.println("JavaScript Course Made");
		
		System.out.println("Basics: "+ javaScriptCourse.getBasic());
		System.out.println("Intermediates: "+ javaScriptCourse.getIntermediate());
		System.out.println("Advanced: "+ javaScriptCourse.getAdvanced());
		
	}
}
