package creational.factory;

public abstract class Car {
	
	private CarType model;
	
	public CarType getModel() {
		return model;
	}

	public void setModel(CarType model) {
		this.model = model;
	}

	public Car(CarType model){
		this.setModel(model);
	}
	
	private void arrangeParts(){
		
	};
	
	protected abstract void construct();
	
	
}
