package Service.Danh_Muc;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.implemet.Danh_muc_DAO;
import Entity.San_Pham.Danh_muc_san_pham;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Danh_muc_Service {
	
	private Danh_muc_DAO danh_muc_DAO;
	private Tree tree_danh_muc;
	
	public Danh_muc_Service() {
		danh_muc_DAO = new Danh_muc_DAO();
		tree_danh_muc = new Tree();
		LayTatCaDanhMuc();
	}
	
	public void load_category_by_json(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id  = Integer.parseInt(req.getParameter("danh_muc"));
		
		List<Danh_muc_san_pham> list = new Danh_muc_Service().Lay_danh_muc_con(id);
		
	    ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(list);
	    
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
	
	public void load_category_by_session(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.setAttribute("category", tree_danh_muc);
	}
	
	public void LayTatCaDanhMuc() {
		List<Danh_muc_san_pham> list = danh_muc_DAO.LayTatCaDanhMuc();
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
}
