package com.code_a_thon.server.backend_server.Repository;

import com.code_a_thon.server.backend_server.Entity.BusinessProperties.HoursOfOperation;
import org.springframework.data.repository.CrudRepository;

public interface HoursOfOperationRepository extends CrudRepository<HoursOfOperation, Long> {
}
