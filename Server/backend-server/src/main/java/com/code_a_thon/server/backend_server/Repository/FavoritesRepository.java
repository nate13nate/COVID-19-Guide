package com.code_a_thon.server.backend_server.Repository;

import com.code_a_thon.server.backend_server.Entity.CustomerProperties.FavoriteBussinessId;
import org.springframework.data.repository.CrudRepository;

public interface FavoritesRepository extends CrudRepository<FavoriteBussinessId, Long> {
}
