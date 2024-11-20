package sg.edu.nus.iss.ssf_13t.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.ssf_13t.model.Item;
import sg.edu.nus.iss.ssf_13t.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


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
        model.addAttribute("username", session.getAttribute("username"));
        return "store";
    }

    @PostMapping("/buy")
    public String getMethodName(@RequestBody MultiValueMap<String, String> entity,
        BindingResult result, HttpSession session, Model model) {
        String id = entity.getFirst("id");
        System.out.println(id);
        Item item = itemService.findById(id);
        if (item.isSoldOut()) {
            ObjectError err = new ObjectError("itemSoldOut",
                "%s is already sold out.".formatted(item.getName()));
            result.addError(err);
            return "store";
        }
        item.buy();
        return "redirect:/store";
    }
    
    
}
