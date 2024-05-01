package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Entity.San_Pham.Danh_muc_san_pham;
import Service.Danh_Muc.Danh_muc_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/load_category"})
public class Load_Category extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		new Danh_muc_Service().load_category_by_json(req, resp);
	}
}
