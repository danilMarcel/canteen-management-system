package src.main.java.com.canteen.domain.inmemory;


import src.main.java.com.canteen.domain.models.Dish;
import src.main.java.com.canteen.domain.repositories.DishRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryDishRepository implements DishRepository {
    private final Map<Long, Dish> dishes = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public InMemoryDishRepository() {
        initializeTestData();
    }

    private void initializeTestData() {
        save(new Dish(1L, "Борщ", "Традиционный русский борщ", 90, new BigDecimal("120.00")));
        save(new Dish(2L, "Котлета в панировке", "Куриная котлета", 45, new BigDecimal("180.00")));
        save(new Dish(3L, "Пюре картофельное", "Картофельное пюре с маслом", 30, new BigDecimal("80.00")));
        save(new Dish(4L, "Салат овощной", "Свежий овощной салат", 15, new BigDecimal("90.00")));
    }

    @Override
    public List<Dish> findAll() {
        return new ArrayList<>(dishes.values());
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return Optional.ofNullable(dishes.get(id));
    }

    @Override
    public Dish save(Dish dish) {
        if (dish.getDishId() == null) {
            dish.setDishId(idGenerator.getAndIncrement());
        }
        dishes.put(dish.getDishId(), dish);
        return dish;
    }

    @Override
    public void delete(Long id) {
        dishes.remove(id);
    }

    @Override
    public List<Dish> findByName(String name) {
        return dishes.values().stream()
                .filter(dish -> dish.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
