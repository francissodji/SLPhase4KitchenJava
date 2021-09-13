package com.foodstory.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodstory.Dao.FoodsDao;
import com.foodstory.Model.Foods;


@Service
public class FoodsService {

	@Autowired
	private FoodsDao foodsDao;
	
	
	public boolean addFoods(Foods foods)
	{
		boolean isadd = false;
		
		
		if(foodsDao.save(foods) != null)
		{
			isadd = true;
		}
		return isadd;
	}
	
	
	//load all foods
	public List<Foods> loadAllFoods()
	{
		List<Foods> allFoods = null;
		
		
		allFoods = (List<Foods>)foodsDao.findAll();
		
		return allFoods;
	}
	
	
	
	//Search
	public List<Foods> loadSearchFoodsByName(String thesearchItem)
	{
		List<Foods> allFoods = null;
		
		
		allFoods = (List<Foods>)foodsDao.findAllFoodsFromSearch(thesearchItem);
		
		return allFoods;
	}
	
	//delete food
	public boolean deleteFood(Integer theIdFood)
	{
		boolean itIsDelete = false;
		
		if(theIdFood > 0)
		{
			foodsDao.deleteById(theIdFood);
			itIsDelete = true;
		}
		
		return itIsDelete;
	}
	
	//find medecin by Id
	public Optional<Foods> loadFoodById(Integer theIdFood)
	{
		Optional<Foods> aFood = null;
		try {
			
			aFood = foodsDao.findById(theIdFood);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return aFood;
	}
}
