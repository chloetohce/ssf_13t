package sg.edu.nus.iss.ssf_13t.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.ssf_13t.model.Test;


@Controller
@RequestMapping("test")
public class TestController {

    @GetMapping()
    public String testPage() {
        return "test";
    }
    

    @PostMapping("/submit")
    public String handleSubmit(@ModelAttribute Test item) {
        // Process the submitted item
        System.out.println("Submitted Item ID: " + item.getId());
        System.out.println("Name: " + item.getName());
        System.out.println("Age: " + item.getAge());
    
        return "redirect:/test";
    }
    

    @ModelAttribute("items")
    public List<Test> populateItems() {
        // Populate the list of items (example)
        return List.of(
                new Test(1L, "Alice", 30),
                new Test(2L, "Bob", 25));
    }

}
