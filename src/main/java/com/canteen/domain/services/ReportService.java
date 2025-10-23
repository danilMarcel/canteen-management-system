package src.main.java.com.canteen.domain.services;




import src.main.java.com.canteen.domain.models.Product;
import src.main.java.com.canteen.domain.repositories.ProductRepository;

import java.util.List;



public class ReportService {
    private final ProductRepository productRepository;

    public ReportService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void generateLowStockReport() {
        List<Product> lowStockProducts = productRepository.findProductsRunningLow();

        if (lowStockProducts.isEmpty()) {
            System.out.println("Все продукты в норме!");
        } else {
            System.out.println("\n=== ОТЧЕТ: Продукты, которые заканчиваются ===");
            for (Product product : lowStockProducts) {
                System.out.printf("• %s - осталось %s %s (мин: %s)%n",
                        product.getName(), product.getCurrentQuantity(),
                        product.getUnit(), product.getMinQuantity());
            }
        }
    }

    public void generateInventoryReport() {
        List<Product> allProducts = productRepository.findAll();

        System.out.println("\n=== ОТЧЕТ: Инвентаризация склада ===");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s%n",
                "ID", "Название", "Кол-во", "Ед.", "Мин.запас");
        System.out.println("--------------------------------------------------------");

        for (Product product : allProducts) {
            System.out.printf("%-5d %-20s %-10s %-10s %-10s%n",
                    product.getProductId(),
                    product.getName(),
                    product.getCurrentQuantity(),
                    product.getUnit(),
                    product.getMinQuantity());
        }
    }
}