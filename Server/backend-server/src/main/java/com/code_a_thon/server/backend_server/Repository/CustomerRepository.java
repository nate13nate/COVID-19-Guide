package com.code_a_thon.server.backend_server.Repository;

import com.code_a_thon.server.backend_server.Entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
}
