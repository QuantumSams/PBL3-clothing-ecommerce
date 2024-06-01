package Controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.Nguoi_Dung.Nguoi_dung_Service;
import Model.BLL.Service.San_Pham.San_pham_Service;
import Model.DAL.DAO.implemet.Anh_san_pham_DAO;
import Model.DAL.DAO.implemet.Mau_sac_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.Nguoi_dung_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.DAO.implemet.Size_DAO;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/add_product", "/add_image", "/load_nhan_vien_by_json", "/thong_tin_nhan_vien"})
public class AdminController extends HttpServlet{

	private static final long serialVersionUID = 3077274296845015069L;
	
	San_pham_Service san_pham_Service = new San_pham_Service(new San_pham_DAO(), new Muc_san_pham_DAO(), new Mau_sac_DAO(), new Size_DAO(), new Anh_san_pham_DAO());
	Nguoi_dung_Service nguoi_dung_Service = new Nguoi_dung_Service(new Nguoi_dung_DAO());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getServletPath();
		
		if(action != null && action.equals("/add_product")) {
			san_pham_Service.Load_properties(req, resp);
			req.getRequestDispatcher("/Crud.jsp").forward(req, resp);
		}
		else if(action != null && action.equals("/load_nhan_vien_by_json")) {
			List<Nguoi_dung> list_nhan_vien = nguoi_dung_Service.getNhanVienByName(req, resp);
			
			ObjectMapper mapper = new ObjectMapper();
		    String json = mapper.writeValueAsString(list_nhan_vien);
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(json);
		}
		else if(action != null && action.equals("/thong_tin_nhan_vien")) {
			List<Nguoi_dung> list = nguoi_dung_Service.getNguoiDungByID(req, resp);
			HttpSession session = req.getSession();
			session.setAttribute("nhan_vien", list.get(0));
			req.getRequestDispatcher("userInfor.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action != null && action.equals("/add_product")) {
			san_pham_Service.add_product(req, resp);
			postJsonMessage(resp, "Tạo sản phẩm thành công");
		}
		
		else if(action != null && action.equals("/")) {
			
		}
		else if(action != null && action.equals("/")) {
			
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
