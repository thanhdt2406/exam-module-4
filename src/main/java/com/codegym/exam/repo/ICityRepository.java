package com.codegym.exam.repo;

import com.codegym.exam.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends CrudRepository<City,Long> {
}
