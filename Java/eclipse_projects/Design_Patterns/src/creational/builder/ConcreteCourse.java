package creational.builder;

public class ConcreteCourse implements CoursePlan {

	private String basic;
	private String intermediate;
	private String advanced;

	public String getBasic() {
		return basic;
	}

	public String getIntermediate() {
		return intermediate;
	}

	public String getAdvanced() {
		return advanced;
	}

	@Override
	public void setBasicTopics(String basic) {
		this.basic = basic;
	}
	
	@Override
	public void setIntermediateTopics(String intermediate) {
		this.intermediate = intermediate;
	}

	@Override
	public void setAdvancedTopics(String advanced) {
		this.advanced = advanced;
	}

}
