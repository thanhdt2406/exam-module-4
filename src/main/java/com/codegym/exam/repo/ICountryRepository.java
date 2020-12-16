package com.codegym.exam.repo;

import com.codegym.exam.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends CrudRepository<Country,Long> {
}
