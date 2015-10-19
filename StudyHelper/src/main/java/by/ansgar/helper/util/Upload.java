package by.ansgar.helper.util;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import by.ansgar.helper.controller.AddPageController;

public class Upload {

	private static final Logger LOG = Logger.getLogger(AddPageController.class);
	
	public static String path;
	
	public static synchronized void doUpload(MultipartFile multipartFile) {
		
		String orgName = multipartFile.getOriginalFilename();
		String filePlaceToUpload = "C:/";
		String filePath = filePlaceToUpload + orgName;
		File dest = new File(filePath);

		try {
			multipartFile.transferTo(dest);
			path = dest.toString();
		} catch (IllegalStateException e) {
			e.printStackTrace();
			LOG.warn(e);
		} catch (IOException e) {
			e.printStackTrace();
			LOG.warn(e);
		}
	}

}
