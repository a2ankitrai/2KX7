package structural.decorator;

public class DecoratorTest {

	public static void main(String[] args) {
		
		Weapon weapon = new WeaponSilencerDecorator(new BaseWeapon());
		weapon.aimAndFire();
		
		System.out.println("\n**************\n");
		
		Weapon weapon2 = new AimAssistDecorator(new WeaponSilencerDecorator(new BaseWeapon()));
		weapon2.aimAndFire();
		
		
	}
}
