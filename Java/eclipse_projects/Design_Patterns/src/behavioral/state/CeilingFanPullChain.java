package behavioral.state;

public class CeilingFanPullChain {
	
	private State m_current_state;

	public CeilingFanPullChain() {
		 m_current_state = new Off();
	}

	public void setM_current_state(State s) {
		this.m_current_state = s;
	}
	
	public void pull(){
		m_current_state.pull(this);
	}
	
}
