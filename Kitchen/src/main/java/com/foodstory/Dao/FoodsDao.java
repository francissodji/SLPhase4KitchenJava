package com.foodstory.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodstory.Model.Foods;

@Repository
public interface FoodsDao extends CrudRepository<Foods, Integer>{
@Query(value="Select * from foods where namefood like ?1"
	, nativeQuery= true)
	List<Foods> findAllFoodsFromSearch(String searchstring);
}
