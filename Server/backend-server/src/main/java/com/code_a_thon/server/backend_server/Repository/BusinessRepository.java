package com.code_a_thon.server.backend_server.Repository;

import com.code_a_thon.server.backend_server.Entity.Account;
import com.code_a_thon.server.backend_server.Entity.Business;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface BusinessRepository extends CrudRepository<Business, Long> {
    @Query("select b.id from Business b")
    List<Long> getAllIds();
}