package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Promotion;
import org.generation.italy.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/promotion")
public class PromotionController {

	@Autowired
	private PromotionService promotionService;

	@GetMapping
	public String index(Model model) {

		List<Promotion> promotions = promotionService.findAll();
		model.addAttribute("promotions", promotions);
		return "promotions";
	}
}