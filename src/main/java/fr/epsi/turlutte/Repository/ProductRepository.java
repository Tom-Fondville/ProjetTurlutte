package fr.epsi.turlutte.Repository;

import fr.epsi.turlutte.common.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product,Long > {

}
