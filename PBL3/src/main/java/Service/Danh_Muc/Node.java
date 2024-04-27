package Service.Danh_Muc;

import java.util.HashMap;
import java.util.Map;

import Entity.San_Pham.Danh_muc_san_pham;

public class Node {
	private Node front;
	private Danh_muc_san_pham danh_muc;
	private Map<Integer, Node> next;
	
	public Node() {
		next = new HashMap<Integer, Node>();
	}
	
	public Node(Danh_muc_san_pham danh_muc) {
		next = new HashMap<Integer, Node>();
		this.danh_muc = danh_muc;
	}

	public void put(Node node) {
		next.put(node.getDanh_muc().getId(), node);
		node.front = this;
	}
	
	public void put(Danh_muc_san_pham danh_muc) {
		Node node = new Node(danh_muc);
		put(node);
	}
	
	public Node getFront() {
		return front;
	}

	public void setFront(Node front) {
		this.front = front;
	}

	public Danh_muc_san_pham getDanh_muc() {
		return danh_muc;
	}

	public void setDanh_muc(Danh_muc_san_pham danh_muc) {
		this.danh_muc = danh_muc;
	}

	public Map<Integer, Node> getNext() {
		return next;
	}

	public void setNext(Map<Integer, Node> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		String s = danh_muc.getCategory() + "\n";
		for(int key : next.keySet())
		{
			Node node = (Node)next.get(key) ;
			s += node.toString();
		}
		return s;
	}
	
	
}
