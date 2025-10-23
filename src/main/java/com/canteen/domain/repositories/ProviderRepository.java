package src.main.java.com.canteen.domain.repositories;

import src.main.java.com.canteen.domain.models.Provider;

import java.util.List;
import java.util.Optional;

public interface ProviderRepository {
    List<Provider> findAll();
    Optional<Provider> findById(Long id);
    Provider save(Provider provider);
    void delete(Long id);
}