package Controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.San_Pham.San_pham_Service;
import Model.DAL.DAO.implemet.Anh_san_pham_DAO;
import Model.DAL.DAO.implemet.Mau_sac_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.DAO.implemet.Size_DAO;
import Model.DTO.San_Pham.San_pham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/get_product_by_ajax", "/update_product", "/load_product", "/remove_product"})
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = -886812143546363698L;
	
	San_pham_Service san_pham_Service = new San_pham_Service(new San_pham_DAO(), new Muc_san_pham_DAO(), new Mau_sac_DAO(), new Size_DAO(), new Anh_san_pham_DAO());
	
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
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action.equals("/remove_product")) {
			System.out.println("Herl;looo");
			
			san_pham_Service.remove_Product(req, resp);
			
			postJsonMessage(resp, "Xóa sản phẩm thành công");
		}
		
		else if(action.equals("/update_product")) {
			san_pham_Service.update_product(req, resp);
			
			postJsonMessage(resp, "Cập nhật sản phẩm thành công");
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
