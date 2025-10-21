package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	/**
	 * Maps the root path "/" and "/greeting" to the "greeting" template.
	 * Passes a 'name' attribute to the Thymeleaf template.
	 * * @param name The name to greet, defaults to "World".
	 * @param model The model to pass attributes to the view.
	 * @return The name of the Thymeleaf template ("greeting").
	 */
	@GetMapping({"/", "/greeting"})
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
		// Add the 'name' attribute to the Model, which Thymeleaf can access
		model.addAttribute("name", name);

		// Returns the template name (will resolve to src/main/resources/templates/greeting.html)
		return "greeting";
	}

}
