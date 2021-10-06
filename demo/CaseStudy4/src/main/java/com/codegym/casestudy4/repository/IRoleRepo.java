package com.codegym.casestudy4.repository;

import com.codegym.casestudy4.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepo extends CrudRepository<Role,Long> {
}
