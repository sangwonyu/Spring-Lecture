package com.example.spring02.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/") // URL pattern mapping 으로 get이나 post 방식 모두 사용 가능 
	public String main(Model model) {
		//model : 데이터의 담을 그릇 역할, map(키,값)
		//model.addAttribute("변수","값")
		model.addAttribute("message", "어떤 고민을 하고 계십니까. 고민을 해결해드립니다.!");
		return "include/Main";
	}
	
	@RequestMapping("randomFood")
	public String randomFood(Model model) {
		String[] food = {"국밥","돈가스","버거킹","떡볶이","우동","베트남"};
		int todayNum = (int)(Math.random()*6);
		System.out.println(todayNum);
		String todayFood = food[todayNum];
		
		model.addAttribute("todayFood",todayFood);
		return "randomPage/foodPage";
	}
	
	@RequestMapping("randomTravel")
	public String randomTravel(Model model) {
		String[] hotSpot = {"부산-해운대","부산-광안리","강원도","서울","제주도","미국","태국","유럽"};
		int todayNum = (int)(Math.random()*8);
		System.out.println(todayNum);
		String todaySpot = hotSpot[todayNum];
		
		model.addAttribute("hotSpot",todaySpot);
		return "randomPage/travelPage";
	}
}
