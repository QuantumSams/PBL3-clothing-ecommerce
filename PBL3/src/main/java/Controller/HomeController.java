package Controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.Danh_Muc.Danh_muc_Service;
import Model.BLL.Service.Doanh_Thu.Doanh_thu_Service;
import Model.BLL.Service.Nguoi_Dung.Nguoi_dung_Service;
import Model.BLL.Service.Order.Order_Service;
import Model.BLL.Service.San_Pham.Muc_san_pham_Service;
import Model.BLL.Service.San_Pham.San_pham_Service;
import Model.DAL.DAO.implemet.Anh_san_pham_DAO;
import Model.DAL.DAO.implemet.Danh_muc_DAO;
import Model.DAL.DAO.implemet.Doanh_thu_DAO;
import Model.DAL.DAO.implemet.Don_hang_DAO;
import Model.DAL.DAO.implemet.Mau_sac_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.Nguoi_dung_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.DAO.implemet.Size_DAO;
import Model.DTO.Doanh_Thu.Doanh_thu;
import Model.DTO.Don_Hang.Don_hang;
import Model.DTO.Don_Hang.Xac_nhan_don_hang;
import Model.DTO.Don_Hang.Xem_don_hang;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import Model.DTO.Nguoi_Dung.Phan_quyen_nguoi_dung;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.San_pham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/trang_chu", "/trang_chu_cua_hang", "/nhan_vien", 
							"/login", "/logout", "/sign_up"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = -5225303616746645511L;

	Nguoi_dung_Service nguoi_dung_Service = new Nguoi_dung_Service(new Nguoi_dung_DAO());
	San_pham_Service san_pham_Service = new San_pham_Service(new San_pham_DAO(), new Muc_san_pham_DAO(), new Mau_sac_DAO(), new Size_DAO(), new Anh_san_pham_DAO());
	Danh_muc_Service danh_muc_Service = new Danh_muc_Service(new Danh_muc_DAO());
	Muc_san_pham_Service muc_san_pham_Service = new Muc_san_pham_Service(new Muc_san_pham_DAO(), new San_pham_DAO());
	Order_Service order_Service = new Order_Service();
	Doanh_thu_Service doanh_thu_Service = new Doanh_thu_Service(new Doanh_thu_DAO());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		HttpSession session = req.getSession();
		
		if(action != null && action.equals("/logout")) {
			resp.setContentType("text/html;charset=UTF-8");
			session = req.getSession();
			session.removeAttribute("acc");
			resp.sendRedirect("trang_chu");
		}
		
		else if(action != null && action.equals("/trang_chu")) {
			List<San_pham> list_san_pham = san_pham_Service.GetAllProducts(req, resp);
			session.setAttribute("san_pham", list_san_pham);
			
			danh_muc_Service.load_category_by_session(req, resp);
			session = req.getSession();
			session.setAttribute("san_pham", list_san_pham);
			
			resp.sendRedirect("index.jsp");
		}
		
		else if(action != null && action.equals("/trang_chu_cua_hang")) {
			List<San_pham> list_san_pham = san_pham_Service.GetAllProducts(req, resp);
			session = req.getSession();
			session.setAttribute("san_pham", list_san_pham);
			session.setAttribute("so_san_pham", list_san_pham.size());
			
			List<Nguoi_dung> nhan_vien = nguoi_dung_Service.getAllNhanVien(req, resp);
			session.setAttribute("nhan_vien", nhan_vien);
			session.setAttribute("so_nhan_vien", nhan_vien.size());
			
			List<Muc_san_pham> muc_san_pham = muc_san_pham_Service.getAllMucSanPham(); 
			session.setAttribute("muc_san_pham", muc_san_pham);
			session.setAttribute("so_muc_san_pham", muc_san_pham.size());
			
			List<Xem_don_hang> xem_don_hang = order_Service.get_Xem_don_hang(req, resp);
			session.setAttribute("don_hang", xem_don_hang);
			session.setAttribute("so_don_hang", xem_don_hang.size());
			
			Doanh_thu doanh_thu = doanh_thu_Service.getDoanh_thu().get(0);
			session.setAttribute("doanh_thu", doanh_thu);
			
			resp.sendRedirect("chucuahang.jsp");
		}
		
		else if(action != null && action.equals("/nhan_vien")) {
			List<Xac_nhan_don_hang> don_hang = new Order_Service().list_don_hang_can_xac_nhan(req, resp);
			
			session.setAttribute("don_hang", don_hang);
			resp.sendRedirect("staffOrderList.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action != null && action.equals("/login")) {
			try {
				Nguoi_dung nguoi_dung = nguoi_dung_Service.Login(req, resp);
				HttpSession session = req.getSession();
				session.setAttribute("acc", nguoi_dung);
				
				if(nguoi_dung.getPhan_quyen_nguoi_dung().equals(Phan_quyen_nguoi_dung.KHACH_HANG.toString())){
					resp.sendRedirect("trang_chu");
				}
				
				else if(nguoi_dung.getPhan_quyen_nguoi_dung().equals(Phan_quyen_nguoi_dung.CHU_CUA_HANG.toString())){
					resp.sendRedirect("trang_chu_cua_hang");
				}
				
				else if(nguoi_dung.getPhan_quyen_nguoi_dung().equals(Phan_quyen_nguoi_dung.NHAN_VIEN.toString())){
					resp.sendRedirect("nhan_vien");
				}
			}
			catch (Exception e) {
				req.setAttribute("message1", e.getMessage());
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
		}
		
		else if(action != null && action.equals("/sign_up")) {
			try {
				nguoi_dung_Service.Sign_up(req, resp);
				postJsonMessage(resp, "Tạo tài khoản thành công");
				
			} catch (Exception e) {
				postJsonMessage(resp, e.getMessage());
			}
		}
		
	}
	
	private void postJsonMessage( HttpServletResponse resp, String message) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(message);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
}
