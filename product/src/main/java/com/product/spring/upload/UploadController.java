package com.product.spring.upload;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	//xml에 설정된 리소스 참조
	//bean의 id가 uploadPath인 태그를 참조
	@Resource(name="uploadPath")
		String uploadPath;
	
	@RequestMapping(value="/upload/uploadForm", method=RequestMethod.GET)
	public void uploadForm(){
		// /upload/uploadForm.jsp 포워딩
	}
	//처음 주소는 get이라 위로 가서 uploadForm.jsp로 가고 업로드 폼에서 클릭하고 들어오는 것이 post이기 때문에 
	//아래로 간다.
	/*
	 * 업로드 버튼 클릭=> 임시 디렉토리에 업로드 => 파일 정보가 file에 저장 => 지정된 디렉토리에 저장
	 */
	@RequestMapping(value="/upload/uploadForm", method=RequestMethod.POST)
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav) throws Exception {
		String saveName = file.getOriginalFilename();
		logger.info("파일이름:" + file.getOriginalFilename() );
		logger.info("파일 크기 : " + file.getSize());
		logger.info("컨텐츠 타입 : " + file.getContentType());
		saveName = uploadFile(saveName, file.getBytes());
		return mav;
	}
	// 파일 이름이 중복되지 않도록 처리
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		//uuid 생성( Universal Unique Identifier, 범용고유식별자)
		UUID uid = UUID.randomUUID();
		String saveName=uid.toString() +"_" +originalName;
		File target = new File(uploadPath, saveName);
		//임시 디렉토리에 저자왼 업로드된 파일을 지정된 디렉토리로 복사
		//FileCopyUtils.copy(바이트 배열, 파일 객체)
		FileCopyUtils.copy(fileData, target);
		return saveName;
	}
}
