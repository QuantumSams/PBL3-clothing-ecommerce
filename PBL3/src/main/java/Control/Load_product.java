package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
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
		List<Mau_sac> l = new ArrayList<>(); 
		l.add(new Mau_sac(1, "Màu đỏ", "Đường dẫn đến ảnh màu đỏ"));
		l.add(new Mau_sac(2, "Màu xanh", "Đường dẫn đến ảnh màu xanh"));
		l.add(new Mau_sac(3, "Màu vàng", "Đường dẫn đến ảnh màu vàng"));
		l.add(new Mau_sac(4, "Màu tím", "Đường dẫn đến ảnh màu tím"));
		
		
		
		req.setAttribute("mau_sac", l);
		
		req.getRequestDispatcher("/Crud.jsp").forward(req, resp);
	}

}
