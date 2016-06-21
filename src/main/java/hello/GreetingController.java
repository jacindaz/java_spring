package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/greeting", method=GET)
    // @RequestMapping maps all HTTP operations by default
    // could do @RequestMapping("/greeting", method=GET) to be more explicit
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        // value="name" binds the "name" key from params to this method
        // must be present, otherwise the default will be "World"
        // kinda like strong params in Rails

        // adding "name" to the Model object makes it accessible to the view
        // (so maybe like an instance var in Rails in the controller?)
        model.addAttribute("name", name);
        return "greeting";
    }

}