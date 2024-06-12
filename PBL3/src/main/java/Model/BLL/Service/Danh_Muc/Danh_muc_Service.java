package Model.BLL.Service.Danh_Muc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import DataStructures.RandomID;
import Model.DAL.DAO.implemet.Danh_muc_DAO;
import Model.DTO.Don_Hang.Danh_gia_don_hang;
import Model.DTO.San_Pham.Danh_muc_san_pham;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Danh_muc_Service {
	
	private Danh_muc_DAO danh_muc_DAO;
	private Tree tree_danh_muc;
	
	public Danh_muc_Service(Danh_muc_DAO danh_muc_DAO) {
		this.danh_muc_DAO = danh_muc_DAO;
		tree_danh_muc = new Tree();
		LayTatCaDanhMuc();
	}
	
	public List<Danh_muc_san_pham> load_category_by_json(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id  = Integer.parseInt(req.getParameter("danh_muc"));
		
		return Lay_danh_muc_con(id);
		
	    
	}
	
	public void load_category_by_session(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.setAttribute("category", tree_danh_muc);
	}
	
	public void LayTatCaDanhMuc() {
		List<Danh_muc_san_pham> list = danh_muc_DAO.getALL();
		tree_danh_muc.add(list);
	}
	
	public List<Danh_muc_san_pham> Lay_danh_muc_con(){
		return tree_danh_muc.getChild();
	}
	
	public List<Danh_muc_san_pham> Lay_danh_muc_con(Danh_muc_san_pham danh_muc_san_pham){
		
		return tree_danh_muc.getChild(danh_muc_san_pham);
	}
	
	public List<Danh_muc_san_pham> Lay_danh_muc_con(int id){
		return tree_danh_muc.getChild(id);
	}
	
	public Danh_muc_san_pham getDanh_muc_Id(int id) {
		return tree_danh_muc.getDanhMucByID(id);
	}
	
	public void addDanhMucSanPham(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id_muc_san_pham = new RandomID().ran();
		int id_parent = -1;
		if(req.getParameter("id_parent") != null && req.getParameter("id_parent").length() != 0) {
			id_parent = Integer.parseInt(req.getParameter("id_parent"));
		}
		String ten_danh_muc = req.getParameter("ten");
		
		Danh_muc_san_pham danh_muc_san_pham = new Danh_muc_san_pham(id_muc_san_pham, id_parent, ten_danh_muc);
		System.out.println(danh_muc_san_pham.toString());
		danh_muc_DAO.add(danh_muc_san_pham);
		
		List<Danh_muc_san_pham> list_Danh_gia_don_hang = danh_muc_DAO.getDanhMucByID(id_parent);
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(list_Danh_gia_don_hang);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
	
	public List<TreeDanhMuc> getTree(){
		List<Danh_muc_san_pham> danh_muc = Lay_danh_muc_con();
		List<TreeDanhMuc> nodes = new ArrayList<>();
		for(Danh_muc_san_pham dm : danh_muc) {
			TreeDanhMuc tree = new TreeDanhMuc();
			tree.setDanh_muc_san_pham(dm);
			tree.setNode(getTree(tree.getDanh_muc_san_pham().getId()));
			nodes.add(tree);
		}
		return nodes;
	}
	
	public List<TreeDanhMuc> getTree(int id){
		List<Danh_muc_san_pham> danh_muc = Lay_danh_muc_con(id);
		List<TreeDanhMuc> nodes = new ArrayList<>();
		for(Danh_muc_san_pham dm : danh_muc) {
			TreeDanhMuc tree = new TreeDanhMuc();
			tree.setDanh_muc_san_pham(dm);
			tree.setNode(getTree(tree.getDanh_muc_san_pham().getId()));
			nodes.add(tree);
		}
		return nodes;
	}
}
