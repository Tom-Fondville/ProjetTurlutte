package fr.epsi.turlutte.Repository;

import fr.epsi.turlutte.common.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { }