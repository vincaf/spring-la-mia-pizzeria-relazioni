package org.generation.italy.demo;

import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.DrinkService;
import org.generation.italy.demo.service.PizzaService;
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
	
	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		Pizza pizza_1 = new Pizza("Margherita", "Troppo buona", 7);
		Pizza pizza_2 = new Pizza("Marinara", "Ci sta, bel sapore", 6);
		Pizza pizza_3 = new Pizza("Fritta", "Croccante e buona frittura", 8);
		
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
	}
}
