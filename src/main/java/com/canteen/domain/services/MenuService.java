package src.main.java.com.canteen.domain.services;

import src.main.java.com.canteen.domain.models.Dish;
import src.main.java.com.canteen.domain.models.Menu;
import src.main.java.com.canteen.domain.repositories.DishRepository;
import src.main.java.com.canteen.domain.repositories.MenuRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.List;

public class MenuService {
    private final MenuRepository menuRepository;
    private final DishRepository dishRepository;

    public MenuService(MenuRepository menuRepository, DishRepository dishRepository) {
        this.menuRepository = menuRepository;
        this.dishRepository = dishRepository;
    }

    public List<Menu> getTodayMenu() {
        return menuRepository.findByDate(LocalDate.now());
    }

    public List<Menu> getMenuByDate(LocalDate date) {
        return menuRepository.findByDate(date);
    }

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Dish createDish(String name, String description, Integer cookingTime, BigDecimal price) {
        Dish dish = new Dish(null, name, description, cookingTime, price);
        return dishRepository.save(dish);
    }

    public boolean addDishToMenu(Long dishId, LocalDate date, Integer quantity) {
        return dishRepository.findById(dishId)
                .map(dish -> {
                    Menu menu = new Menu(null, dishId, date, quantity);
                    menuRepository.save(menu);
                    return true;
                })
                .orElse(false);
    }

    public List<Dish> searchDishesByName(String name) {
        return dishRepository.findByName(name);
    }
}