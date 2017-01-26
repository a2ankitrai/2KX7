package structural.decorator;

public class BaseWeapon implements Weapon {

	@Override
	public void aimAndFire() {
		System.out.println("Firing with Base weapon");
	}

}
