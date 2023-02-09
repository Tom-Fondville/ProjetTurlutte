package fr.epsi.turlutte.Repository;

import fr.epsi.turlutte.common.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long > {
}
