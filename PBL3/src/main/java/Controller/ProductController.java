package Controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.San_Pham.Muc_san_pham_Service;
import Model.BLL.Service.San_Pham.San_pham_Service;
import Model.DAL.DAO.implemet.Anh_san_pham_DAO;
import Model.DAL.DAO.implemet.Mau_sac_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.DAO.implemet.Size_DAO;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.San_pham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/get_product_by_ajax", "/add_product", 
							"/update_product", "/load_product", 
							"/remove_product", "/them_mau", "/them_size",
							"/xoa_size", "/xoa_mau", "/tim_kiem_san_pham", "/sua_muc_san_pham"})
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = -886812143546363698L;
	
	San_pham_Service san_pham_Service = new San_pham_Service(new San_pham_DAO(), new Muc_san_pham_DAO(), new Mau_sac_DAO(), new Size_DAO(), new Anh_san_pham_DAO());
	Muc_san_pham_Service muc_san_pham_Service = new Muc_san_pham_Service(new Muc_san_pham_DAO(), new San_pham_DAO());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action.equals("/get_product_by_ajax")) {
			ObjectMapper mapper = new ObjectMapper();
		    String json = mapper.writeValueAsString(san_pham_Service.searchProductByName(req, resp));
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(json);
		}
		
		else if(action != null && action.equals("/add_product")) {
			san_pham_Service.Load_properties(req, resp);
			req.getRequestDispatcher("/Crud.jsp").forward(req, resp);
		}
		
		else if(action.equals("/update_product")) {
			san_pham_Service.Load_properties(req, resp);
			San_pham san_pham = san_pham_Service.getProductByID(req, resp).get(0);
			
			HttpSession session = req.getSession();
			session.setAttribute("product", san_pham);
			req.getRequestDispatcher("CrudUpdate.jsp").forward(req, resp);
		}
		
		else if(action.equals("/load_product")) {
			San_pham san_pham = san_pham_Service.getProductByID(req, resp).get(0);
			
			HttpSession session = req.getSession();
			session.setAttribute("product", san_pham);
			req.getRequestDispatcher("product.jsp").forward(req, resp);
		}
		
		else if(action.equals("/tim_kiem_san_pham")) {
			List<San_pham> san_pham = san_pham_Service.searchProductByName(req, resp);
			
			ObjectMapper mapper = new ObjectMapper();
		    String json = mapper.writeValueAsString(san_pham);
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(json);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action != null && action.equals("/add_product")) {
			san_pham_Service.add_product(req, resp);
			postJsonMessage(resp, "Tạo sản phẩm thành công");
		}
		else if(action.equals("/remove_product")) {
			san_pham_Service.remove_Product(req, resp);
			List<San_pham> san_pham = san_pham_Service.GetAllProducts(req, resp);

			ObjectMapper mapper = new ObjectMapper();
		    String json = mapper.writeValueAsString(san_pham);
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(json);
		}
		
		else if(action.equals("/update_product")) {
			san_pham_Service.update_product(req, resp);
			
			postJsonMessage(resp, "Cập nhật sản phẩm thành công");
		}
		
		else if(action.equals("/them_mau")) {
			san_pham_Service.them_mau(req, resp);
			
			postJsonMessage(resp, "Thêm màu thành công");
		}	
		
		else if(action.equals("/them_size")) {
			san_pham_Service.them_size(req, resp);
			
			postJsonMessage(resp, "Thêm size thành công");
		}
		
		else if(action.equals("/xoa_mau")) {
			san_pham_Service.them_mau(req, resp);
			
			postJsonMessage(resp, "Xóa màu thành công");
		}	
		
		else if(action.equals("/xoa_size")) {
			san_pham_Service.them_size(req, resp);
			
			postJsonMessage(resp, "Xóa size thành công");
		}
		
		else if(action.equals("/sua_muc_san_pham")) {
			san_pham_Service.update_Muc_san_pham(req, resp);
			List<Muc_san_pham> muc_san_pham = muc_san_pham_Service.getAllMucSanPham(); 
			
			System.out.println("sua muc san  pham");
			
			ObjectMapper mapper = new ObjectMapper();
		    String json = mapper.writeValueAsString(muc_san_pham);
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(json);
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
