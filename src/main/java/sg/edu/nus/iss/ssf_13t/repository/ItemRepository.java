package sg.edu.nus.iss.ssf_13t.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.ssf_13t.model.Item;

@Repository
public class ItemRepository {
    private static final File productsCSV = new File("src/main/resources/db/products.csv");
    private final List<Item> products;
    
    public ItemRepository() {
        this.products = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(productsCSV))) {
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] values = line.split(",");
                Item item = new Item(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[4]);
                products.add(item);
            }
        } catch (IOException e) {
            System.out.println("Error reading products file.");
        }
    }

    public Item findById(String id) {
        return products.stream()
            .filter(item -> item.getId().equals(id))
            .findFirst()
            .get();
    }

    public List<Item> getAllItems() {
        return products;
    }
}
