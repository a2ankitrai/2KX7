package behavioral.state;

public class Low implements State {

	@Override
	public void pull(CeilingFanPullChain wrapper) {
		wrapper.setM_current_state(new Medium());
		System.out.println("  medium speed");
	}

}
