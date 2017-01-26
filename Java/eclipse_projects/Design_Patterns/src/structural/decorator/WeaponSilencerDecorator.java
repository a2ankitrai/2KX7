package structural.decorator;

public class WeaponSilencerDecorator extends WeaponDecorator {

	public WeaponSilencerDecorator(Weapon weapon) {
		super(weapon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aimAndFire() {
		super.aimAndFire();
		System.out.println("Aiming and Firing Silently");
	}

}
