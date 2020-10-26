package com.code_a_thon.server.backend_server.Repository;

import com.code_a_thon.server.backend_server.Entity.CustomerProperties.SubscribedBusinessId;
import org.springframework.data.repository.CrudRepository;

public interface SubscribedRepository extends CrudRepository <SubscribedBusinessId, Long> {
}
