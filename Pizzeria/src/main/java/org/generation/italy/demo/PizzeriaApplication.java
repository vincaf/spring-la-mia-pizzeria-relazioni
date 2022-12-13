package org.generation.italy.demo;

import java.time.LocalDate;
import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.pojo.Promotion;
import org.generation.italy.demo.service.DrinkService;
import org.generation.italy.demo.service.PizzaService;
import org.generation.italy.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzeriaApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private PromotionService promotionService;
	
	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		// promotions
		
		Promotion promotion_1 = new Promotion(LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-24"), "Sconto Natalizio");
		Promotion promotion_2 = new Promotion(LocalDate.parse("2023-12-28"), LocalDate.parse("2023-12-31"), "Sconto Fine anno");
		
		promotionService.save(promotion_1);
		promotionService.save(promotion_2);
		
		// pizza
		
		Pizza pizza_1 = new Pizza("Margherita", "Troppo buona", 7, promotion_1);
		Pizza pizza_2 = new Pizza("Marinara", "Ci sta, bel sapore", 6, promotion_2);
		Pizza pizza_3 = new Pizza("Fritta", "Croccante e buona frittura", 8, null);
		
		pizzaService.save(pizza_1);
		pizzaService.save(pizza_2);
		pizzaService.save(pizza_3);
		
		List<Pizza> pizzas = pizzaService.findAll();
		System.out.println(pizzas);
		
		// drinks
		
		Drink drink_1 = new Drink("Birra chiara", "Leggera e buona", 5);
		Drink drink_2 = new Drink("Birra scura", "Sapore corposo", 5);
		Drink drink_3 = new Drink("Soft drink", "Coca cola o Fanta", 3);
		
		drinkService.save(drink_1);
		drinkService.save(drink_2);
		drinkService.save(drink_3);
		
		List<Drink> drinks = drinkService.findAll();
		System.out.println(drinks);
		
		// delete (uncomment below to activate)
		// promotionService.deletePromotionById(1);
		
		// pizza + promotions
		
		System.out.println("\n----------\n");
		
		for (Pizza pizza : pizzas) {
			System.err.println(pizza + "\n" + pizza.getPromotion());
		}

		System.out.println("\n----------\n");
		
		List<Promotion> promotions = promotionService.findAllWPizza();

		for (Promotion promotion : promotions) {
			System.err.println("\n" + promotion);
			for (Pizza pizza : promotion.getPizzas()) {
				System.err.println("-----\n" + pizza);
			}
		}
	}
}
