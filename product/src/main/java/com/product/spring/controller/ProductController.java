package com.product.spring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.product.spring.model.shop.service.ProductService;

@Controller
public class ProductController {
	@Inject
	ProductService productService;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("filemenuCheck");
		return "/include/filemenu";
	}
	
	@RequestMapping("/shop/product/list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/shop/product/product_list"); //이동할 페이지 이름
		mav.addObject("list", productService.listProduct()); // 데이터 저장
		System.out.println("listcheck");
		return mav;// 페이지 이동
	}
}
