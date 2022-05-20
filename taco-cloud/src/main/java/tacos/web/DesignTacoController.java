package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.domain.Ingredient;
import tacos.domain.Ingredient.Type;
import tacos.domain.Taco;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO","Flour Tortilla",Type.WRAP),
				new Ingredient("COTO","Corn Tortilla",Type.WRAP),
				new Ingredient("GRBF","Ground Beef",Type.PROTEIN),
				new Ingredient("CARN","Carnitas",Type.PROTEIN),
				new Ingredient("TMTO","Diced Tomatoes",Type.VEGGIES),
				new Ingredient("LETC","Lettuce",Type.VEGGIES),
				new Ingredient("CHED","Cheddar",Type.CHEESE),
				new Ingredient("SLSA","Salsa",Type.SAUSE),
				new Ingredient("SRCR","Sour Cream",Type.SAUSE)
				);
		
		Type [] types = Ingredient.Type.values();
		for(Type type:types) {
			model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
		}
		model.addAttribute("design",new Taco());
		
		return "design";
		}
	
	@PostMapping
	public String processDesignForm(@ModelAttribute("design")Taco design) {
		log.info("design :" + design);
		return "redirect:orders/current";
	}
	
	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}
}
