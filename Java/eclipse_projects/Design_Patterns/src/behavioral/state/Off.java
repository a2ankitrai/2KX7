package behavioral.state;

public class Off implements State {

	@Override
	public void pull(CeilingFanPullChain wrapper) {
		wrapper.setM_current_state(new Low());
		System.out.println("  low speed"); 
	}

}
