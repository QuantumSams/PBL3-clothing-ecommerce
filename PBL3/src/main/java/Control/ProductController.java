package Control;

import java.io.IOException;

import Service.San_Pham.San_pham_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/get_product_by_ajax"})
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = -886812143546363698L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		San_pham_Service san_pham_Service = new San_pham_Service();
		
		if(action.equals("/get_product_by_ajax")) {
			san_pham_Service.search_product_by_json(req, resp);
		}
	}

}
