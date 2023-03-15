package fr.epsi.turlutte.Repository;

import fr.epsi.turlutte.common.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart,Long > {
}