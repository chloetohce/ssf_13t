package sg.edu.nus.iss.ssf_13t.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.ssf_13t.model.Item;
import sg.edu.nus.iss.ssf_13t.service.ItemService;


@Controller
@RequestMapping("/store")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = {"","/"})
    public String storePage(HttpSession session, Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        model.addAttribute("singleItem", new Item());
        model.addAttribute("username", session.getAttribute("username"));
        return "store";
    }

    @PostMapping("/buy")
    public String buyPage(@Valid @ModelAttribute("singleItem") Item item,
            BindingResult result, HttpSession session, Model model) {
        String id = item.getId();
        System.out.println("ID: " + id);
        System.out.println("Name: " + item.getName());
        Item itemFromDb = itemService.findById(id);

        if (itemFromDb.isSoldOut()) {
            // Add a global error to the BindingResult
            ObjectError err = new ObjectError("global", "%s is already sold out.".formatted(itemFromDb.getName()));
            result.addError(err);
            return "store"; // Return to the same page with the error
        }
        itemFromDb.buy();
        return "redirect:/store";
    }
    
}
