class InfixToPostfix {
	
	StackAsLinkedList sl = new StackAsLinkedList();
	String expression ;

	public InfixToPostfix(expression){
		this.expression = expression;
	}

	public boolean isOperand(String ch){
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}

}