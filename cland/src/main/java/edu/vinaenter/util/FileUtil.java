package edu.vinaenter.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import edu.vinaenter.constant.GlobalConstant;

public class FileUtil {
	
	//creatre method tp upload file
	public static String upload(MultipartFile file, HttpServletRequest request) {
		if(file!=null) {
			if(!GlobalConstant.EMPTY.equals(file.getOriginalFilename())) {
				
				//String userDir = System.;
				String dirPath = request.getServletContext().getRealPath("") + "WEB-INF"
				+ File.separator + "resources" + File.separator + GlobalConstant.DIR_UPLOAD;
				System.out.println(dirPath);
				File saveDir = new File(dirPath);
				if (!saveDir.exists()) {
					saveDir.mkdirs();
				}
				String fileName = rename(file.getOriginalFilename());
				String filePath = dirPath + File.separator + fileName;
				try {
					file.transferTo(new File(filePath));
				} catch (Exception e) {
					// TODO: handle exception
				}
				return fileName;
			}
		}
		return GlobalConstant.EMPTY;
	}
	
	
	
	public static String uploadFile(String fileName, HttpServletRequest
			 request, CommonsMultipartFile commonsMultipartFile) {
		if(!"".equals(fileName)) {
			String dirPath = request.getServletContext().getRealPath(GlobalConstant.DIR_UPLOAD);
			File saveDir = new File(dirPath);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			
			String filePath = dirPath + File.separator + fileName;
			try {
				commonsMultipartFile.transferTo(new File(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return GlobalConstant.EMPTY;
			}
			return fileName;
		}
		return GlobalConstant.EMPTY;
	}
	public static String rename(String fileName) {
		if (!GlobalConstant.EMPTY.equals(fileName)) {
			StringBuilder sb = new StringBuilder();
			sb.append(FilenameUtils.getBaseName(fileName)).append("-").
			append(System.nanoTime()).append(".").
			append(FilenameUtils.getExtension(fileName));
	
			return sb.toString() ;
		}
		return GlobalConstant.EMPTY;
	}
}
