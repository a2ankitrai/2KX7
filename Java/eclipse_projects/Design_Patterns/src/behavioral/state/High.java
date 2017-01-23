package behavioral.state;

public class High implements State {

	@Override
	public void pull(CeilingFanPullChain wrapper) {
		wrapper.setM_current_state(new Off());
		System.out.println("  turning Off");
	}

}
