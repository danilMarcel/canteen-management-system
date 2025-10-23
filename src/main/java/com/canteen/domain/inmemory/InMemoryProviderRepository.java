package src.main.java.com.canteen.domain.inmemory;


import src.main.java.com.canteen.domain.models.Provider;
import src.main.java.com.canteen.domain.repositories.ProviderRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryProviderRepository implements ProviderRepository {
    private final Map<Long, Provider> providers = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public InMemoryProviderRepository() {
        initializeTestData();
    }

    private void initializeTestData() {
        save(new Provider(1L, "ООО Свежие Овощи", "г. Москва, ул. Зеленая, д. 1", "Иванов Иван", "+7-999-111-11-11"));
        save(new Provider(2L, "ЗАО Мясной Двор", "г. Москва, ул. Мясницкая, д. 25", "Петрова Мария", "+7-999-222-22-22"));
        save(new Provider(3L, "ОАО МолПродукт", "г. Москва, пр-т Молочный, д. 10", "Сидоров Алексей", "+7-999-333-33-33"));
    }

    @Override
    public List<Provider> findAll() {
        return new ArrayList<>(providers.values());
    }

    @Override
    public Optional<Provider> findById(Long id) {
        return Optional.ofNullable(providers.get(id));
    }

    @Override
    public Provider save(Provider provider) {
        if (provider.getProviderId() == null) {
            provider.setProviderId(idGenerator.getAndIncrement());
        }
        providers.put(provider.getProviderId(), provider);
        return provider;
    }

    @Override
    public void delete(Long id) {
        providers.remove(id);
    }
}
