package Control;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import DAO.AbstractDao;
import DAO.implemet.Danh_muc_DAO;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;
import Mapper.Thuoc_tinh_san_pham.Mau_sac_Mapper;
import Mapper.Thuoc_tinh_san_pham.Size_Mapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/load_product"})
public class Load_product extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doHead(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(arg0, arg1);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql = "select * from mau_sac";
		List<Mau_sac> list_mau_sac = new Danh_muc_DAO().query(sql, new Mau_sac_Mapper());
		
		sql = "SELECT * FROM size";
		List<Size> list_size = new Danh_muc_DAO().query(sql, new Size_Mapper()); 
		
		sql = "SELECT DISTINCT ten_doi_tuong_khach_hang FROM thong_tin_danh_muc_san_pham";
		List<String> list_dtkh = new Danh_muc_DAO().GetItem(sql);
		
		sql = "SELECT DISTINCT ten_loai_san_pham FROM thong_tin_danh_muc_san_pham "
				+ "WHERE ten_doi_tuong_khach_hang = ?";
		List<String> list_ten_loai_san_pham = new Danh_muc_DAO().GetItem(sql, "Nam");
		
		sql = "SELECT DISTINCT ten_danh_muc_san_pham FROM thong_tin_danh_muc_san_pham "
				+ "WHERE ten_loai_san_pham = ?";
		List<String> list_danh_muc_san_pham = new Danh_muc_DAO().GetItem(sql, "Quần");
		
		req.setAttribute("mau_sac", list_mau_sac);
		req.setAttribute("size", list_size);
		req.setAttribute("doi_tuong_khach_hang", list_dtkh);
		req.setAttribute("ten_loai_san_pham", list_ten_loai_san_pham);
		req.setAttribute("ten_danh_muc_san_pham", list_danh_muc_san_pham);
		req.getRequestDispatcher("/Crud.jsp").forward(req, resp);
	}

}
