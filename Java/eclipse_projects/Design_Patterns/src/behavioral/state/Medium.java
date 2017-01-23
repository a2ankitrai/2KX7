package behavioral.state;

public class Medium implements State {

	@Override
	public void pull(CeilingFanPullChain wrapper) {
		wrapper.setM_current_state(new High());
		System.out.println("  High speed");
	}

}
