package Control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import javax.imageio.ImageIO;

import DAO.AbstractDao;
import Entity.Nguoi_Dung.Nguoi_dung;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns = {"/fileuploadservlet"})

//@MultipartConfig(
//		fileSizeThreshold = 512 * 512 * 10,
//		maxFileSize = 1024 *  1024 * 10,
//		maxRequestSize = 1024 * 1024 * 100
//		)


public class Upload extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		Part filePath = req.getPart("file");
//		String fileName = filePath.getSubmittedFileName();
//		
//		HttpSession session = req.getSession();
//		
//		for(Part part : req.getParts()) {
//			part.write("img/anh_nguoi_dung/"+ fileName);
//		}
//		Nguoi_dung acc = (Nguoi_dung)session.getAttribute("acc");
//		acc.setAnh_dai_dien("img/anh_nguoi_dung/"+fileName);
//		try {
//			DAO_Nguoi_dung.cap_nhat_tai_khoan(acc);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("img/anh_nguoi_dung/"+fileName);
////		/*
////		 * try { //DAO.UploadBLOB(filePath, id); } catch (ClassNotFoundException e) {
////		 * System.out.println("loi"); }
////		 */
////		
////		session.setAttribute("id", id);
//		
//		
//		req.getRequestDispatcher("userInfor.jsp").forward(req, resp);;
//	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadDir = "img/anh_nguoi_dung";

        // Tạo thư mục nếu nó không tồn tại
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String fileName = "";

        System.out.println(request.getParts());
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(uploadDir + File.separator + fileName);
            // Lưu trữ đường dẫn của hình ảnh trong cơ sở dữ liệu (tuỳ chọn)
        }
        HttpSession session = request.getSession();
        Nguoi_dung acc = (Nguoi_dung)session.getAttribute("acc");
		acc.setAnh_dai_dien("img/anh_nguoi_dung" + File.separator + fileName);
		request.setAttribute("acc", acc);
		try {
			String sql2 = "UPDATE thong_tin_nguoi_dung SET anh_dai_dien = ? WHERE id = ?;";
			
			new AbstractDao().update(sql2, acc.getAnh_dai_dien(), acc.getId_nguoi_dung());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("userInfor.jsp").forward(request, response);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
