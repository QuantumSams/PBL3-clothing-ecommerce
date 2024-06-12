package Model.BLL.Service.Danh_Muc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.DTO.San_Pham.Danh_muc_san_pham;

public class Tree {
	private Map<Integer, Node> root;
	private Map<Integer, Node> list;
	
	public Tree() {
		root = new HashMap<Integer, Node>();
		list = new HashMap<Integer, Node>();
	}
	
	private void add(Node node) {
		if(node.getDanh_muc().getParent_id() == 0) {
			root.put(node.getDanh_muc().getId(), node);
		}
		else {
			((Node)list.get(node.getDanh_muc().getParent_id())).put(node);
		}
	}
	
	public void add(List<Danh_muc_san_pham> list_category) {
		for(Danh_muc_san_pham dm : list_category) {
			Node node = new Node(dm);
			list.put(node.getDanh_muc().getId(), node);
		}
		for(Danh_muc_san_pham dm : list_category) {
			Node node = new Node(dm);
			add(node);
		}
	}

	// Lay cac phan tu con cua mot danh muc
	public List<Danh_muc_san_pham> getChild(Danh_muc_san_pham danh_muc){
		Node node = list.get(danh_muc.getId());
		return getChild(node.getNext());
	}
	
	// Lay cac phan tu con cua mot danh muc
	public List<Danh_muc_san_pham> getChild(int id){
		Node node = list.get(id);
		return getChild(node.getNext());
	}
	
	public Danh_muc_san_pham getDanhMucByID(int id){
		Node node = list.get(id);
		return node.getDanh_muc();
	}
	
	// lay cac phan tu con mot root
	public List<Danh_muc_san_pham> getChild(){
		return getChild(root);
	}
	
	public List<Danh_muc_san_pham> getChild(Map<Integer, Node> node){
		List<Danh_muc_san_pham> list_danh_muc = new ArrayList<>();
		for(int key : node.keySet()) {
			list_danh_muc.add(node.get(key).getDanh_muc());
		}
		return list_danh_muc;
	}

	@Override
	public String toString() {
		String str = "";
		for(int key : root.keySet())
		{
			Node node = (Node)root.get(key);
			str += node.toString();
 		}
		return str;
	}
	
	
}
