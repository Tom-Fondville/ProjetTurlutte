package fr.epsi.turlutte.Repository;

import fr.epsi.turlutte.common.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long > {
}