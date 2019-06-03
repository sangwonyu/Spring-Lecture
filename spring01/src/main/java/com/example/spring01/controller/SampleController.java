package com.example.spring01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring01.model.dto.ProductDTO;

//ajax 처리 전용 컨트롤러 (백그라운드에서 실행)
//스프링 4.0이상 부터 사용 가능 
@RestController
public class SampleController {
	
	@ResponseBody //JSON 형식으로 데이터를 리턴함
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		// JSON 데이터가 처리됨 
		return new ProductDTO("냉장고", 500000);
	}
	/* 
	 * @RestController 대신 @Controller 을 사용해도 됨 
	 * 하지만 현업에서는 3.0버전을 사용하고 있음
	 * 만약 3.0버전에서 @Controller을 사용한다면 반드시 
	 * @ResponseBody를 해주어야 합니다. 
	 * 
	 * @RestController는 @ResponseBody를 생략 가능합니다. 
	 * 위 코드는 페이지로 이동하는 것이 아니라 데이터가 전달되는 것임.
	 * */
	
}
