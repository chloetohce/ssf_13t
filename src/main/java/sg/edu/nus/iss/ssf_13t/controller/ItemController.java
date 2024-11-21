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
        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("item", new Item());
        return "store";
    }

    @PostMapping("/buy")
    public String buyPage(@Valid @ModelAttribute Item item, BindingResult result, Model model) {

        String id = item.getId();
        // System.out.println("ID: " + id);
        // System.out.println("Name: " + item.getName());
        Item itemFromDb = itemService.findById(id);

        if (result.hasErrors()) {
            model.addAttribute("errorItemId", id);
            return "store";
        }

        itemFromDb.buy();
        return "redirect:/store";
    }

    @ModelAttribute("items")
    public List<Item> populateItems() {
        return itemService.getAllItems();
    }
    
}
