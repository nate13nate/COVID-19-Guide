package com.code_a_thon.server.backend_server.Repository;

import com.code_a_thon.server.backend_server.Entity.BusinessProperties.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
