import java.util.*;


// incomplete to do...
class LFU_Cache {

	class Node {
		int key, value, frequency;
		Node prev, next;
		Node(int key, int value) {
			this.value = value;
		}
	}

	int capacity;
	HashMap<Integer, Node> map = new HashMap<>();
	Deque<Node> queue = new LinkedList<>();

	LFU_Cache(int capacity) {
		this.capacity = capacity;
	}

	public void put(int key, int value) {
		if (map.size() == capacity) {
			Node last = queue.pollLast();
			map.remove(last.key);
		}
		Node newNode = new Node(key, value);
		map.put(key, newNode);
		queue.offer(newNode);
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {return -1;}
	}


}