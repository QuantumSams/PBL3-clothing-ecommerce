package Control;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import DAO.AbstractDao;
import DAO.implemet.Danh_muc_DAO;
import DAO.implemet.Thuoc_tinh_DAO;
import Entity.San_Pham.Danh_muc_san_pham;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;
import Mapper.Thuoc_tinh_san_pham.Mau_sac_Mapper;
import Mapper.Thuoc_tinh_san_pham.Size_Mapper;
import Service.Danh_Muc.Danh_muc_Service;
import Service.Thuoc_Tinh.Thuoc_tinh_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/load_product"})
public class Load_Category_Properties extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Danh_muc_Service danhmuc = new Danh_muc_Service();
		Thuoc_tinh_Service thuoc_tinh_Service = new Thuoc_tinh_Service();
		
		String sql ;
		List<Mau_sac> list_mau_sac = thuoc_tinh_Service.getMau_sac();
		List<Size> list_size = thuoc_tinh_Service.getSize(); 

		danhmuc.LayTatCaDanhMuc();
		List<Danh_muc_san_pham> list_dtkh = danhmuc.Lay_danh_muc_con();
		List<Danh_muc_san_pham> list_ten_loai_san_pham = danhmuc.Lay_danh_muc_con(list_dtkh.get(0));
		List<Danh_muc_san_pham> list_danh_muc_san_pham = danhmuc.Lay_danh_muc_con(list_ten_loai_san_pham.get(0));
		
		req.setAttribute("mau_sac", list_mau_sac);
		req.setAttribute("size", list_size);
		req.setAttribute("doi_tuong_khach_hang", list_dtkh);
		req.setAttribute("ten_loai_san_pham", list_ten_loai_san_pham);
		req.setAttribute("ten_danh_muc_san_pham", list_danh_muc_san_pham);
		req.getRequestDispatcher("/Crud.jsp").forward(req, resp);
	}

}
