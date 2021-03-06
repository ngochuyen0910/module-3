package repository.product;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void create(Product product);

    Product findById(int id);

    void edit(Product product);

    void delete(int id);
}
