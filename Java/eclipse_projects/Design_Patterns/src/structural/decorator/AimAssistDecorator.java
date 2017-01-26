package structural.decorator;

public class AimAssistDecorator extends WeaponDecorator {

	public AimAssistDecorator(Weapon weapon) {
		super(weapon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aimAndFire() {
		super.aimAndFire();
		System.out.println("Firing with Aim assist");
	}

}
