package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.HomeController;
import com.example.spring01.model.dto.ProductDTO;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/") // URL pattern mapping 으로 get이나 post 방식 모두 사용 가능 
	public String main(Model model) {
		//model : 데이터의 담을 그릇 역할, map(키,값)
		//model.addAttribute("변수","값")
		model.addAttribute("message", "저의 홈페이지 입니다.");
		return "Main";
	}

		@RequestMapping(value="gugu.do", method=RequestMethod.GET)
	public String gugu(Model model) {
				int dan=7;
				String result = "";
				for(int i=1;i<=9;i++) {
					result += dan +"X" +i+ "=" + (dan*i)  + "<br>";
				}
				model.addAttribute("result", result);
				return "test/gugu";
		}
		
		@RequestMapping("test")
		public void test() {
		// 리턴 타입이 void 인 경우에는 RequestMapping과 동일한 페이지로 이동합니다. 
		// test.jsp로 바로 넘어간다는 의미.
		}
		
		//tset/doA 매핑시키기
		@RequestMapping("test/doA") 
			public String doA(Model model) {
			model.addAttribute("message", "홈페이지 방문을 환영합니다.");
				logger.info("doA called....");
				return "test/doB"; // a를 누르면  b로 이동 
						// 만약에 void이면 test/doA로 이동
			}
		
		// test/doB 매핑시키기
		@RequestMapping("test/doB")
		public void doB() {
			System.out.println("dob");
		}
		
		//test/doC 매핑시키기
		// ModelAndView 로 객체와 출력 페이지 함께 가지고 전달
		//Model : 데이터 저장소, view : 화면 출력
		//데이터와 포워드할 페이지 정보 함께 전달
		//forword : 주소 그대로, 화면 전환, 대량의 데이터 전달 
		//redirect : 주소 변경, 화면 전환, 소량의 get  방식 전달 
		@RequestMapping("test/doC") 
		public ModelAndView doC() {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("product", new ProductDTO("샤프",1000));
			return  new ModelAndView("test/doC", "map", map);
		}
		
		
}
