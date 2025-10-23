package src.main.java.com.canteen.domain.inmemory;


import src.main.java.com.canteen.domain.models.Menu;
import src.main.java.com.canteen.domain.repositories.MenuRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryMenuRepository implements MenuRepository {
    private final Map<Long, Menu> menus = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public InMemoryMenuRepository() {
        initializeTestData();
    }

    private void initializeTestData() {
        save(new Menu(1L, 1L, LocalDate.now(), 50));
        save(new Menu(2L, 2L, LocalDate.now(), 30));
        save(new Menu(3L, 3L, LocalDate.now(), 40));
        save(new Menu(4L, 4L, LocalDate.now().plusDays(1), 25));
    }

    @Override
    public List<Menu> findAll() {
        return new ArrayList<>(menus.values());
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return Optional.ofNullable(menus.get(id));
    }

    @Override
    public Menu save(Menu menu) {
        if (menu.getMenuId() == null) {
            menu.setMenuId(idGenerator.getAndIncrement());
        }
        menus.put(menu.getMenuId(), menu);
        return menu;
    }

    @Override
    public void delete(Long id) {
        menus.remove(id);
    }

    @Override
    public List<Menu> findByDate(LocalDate date) {
        return menus.values().stream()
                .filter(menu -> menu.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Menu> findByDishId(Long dishId) {
        return menus.values().stream()
                .filter(menu -> menu.getDishId().equals(dishId))
                .collect(Collectors.toList());
    }
}
