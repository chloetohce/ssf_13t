package sg.edu.nus.iss.ssf_13t.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.ssf_13t.model.Item;
import sg.edu.nus.iss.ssf_13t.repository.ItemRepository;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void buy(String id) {
        Item item = itemRepository.findById(id);
        item.buy();
    }

    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    public Item findById(String id) {
        return itemRepository.findById(id);
    }
}
