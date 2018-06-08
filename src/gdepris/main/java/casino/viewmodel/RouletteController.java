package casino.viewmodel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/roulette")
public class RouletteController {

	@GetMapping("/")
	public ModelAndView roll(){

		return new ModelAndView("roulette", "datas", null);
	}
	
}
