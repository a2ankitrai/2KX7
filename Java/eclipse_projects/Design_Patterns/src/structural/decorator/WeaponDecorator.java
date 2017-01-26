package structural.decorator;

public abstract class WeaponDecorator implements Weapon {

	protected Weapon weapon;

	public WeaponDecorator(Weapon weapon) {
		super();
		this.weapon = weapon;
	}

	@Override
	public void aimAndFire() {
		weapon.aimAndFire();
	}
	
	
}
