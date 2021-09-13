package com.foodstory.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodstory.Model.Foods;
import com.foodstory.Model.Users;
import com.foodstory.Service.FoodsService;

@RestController
@RequestMapping("/api/foods")
public class FoodsController {

	@Autowired
	private FoodsService foodsService;
	
	
	//list Food
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allfoods", produces = "application/json")
	public List<Foods> getAllFood () 
	{

		List<Foods> allFoods = null;
		try {
			allFoods = foodsService.loadAllFoods();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allFoods;
	}
	
	//Search Food
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allsearchfoods/{namefood}", produces = "application/json")
	public List<Foods> getAllSearchFood (@PathVariable("namefood") String foodLikeName) 
	{

		List<Foods> allFoods = null;
		String foodLikeNameConcat = "%"+foodLikeName+"%";
		try {
			allFoods = foodsService.loadSearchFoodsByName(foodLikeNameConcat);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allFoods;
	}
	
	//Add food
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/newfood", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addNewFood(@RequestBody Foods theFood) {

		foodsService.addFoods(theFood);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(theFood.getIdfood())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	//Search Food
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path = "/deletefood/{idfood}", produces = "application/json")
	public boolean deleteAFood (@PathVariable("idfood") Integer theIdFood) 
	{

		boolean itIsDelete = false;
		
		try {
			itIsDelete = foodsService.deleteFood(theIdFood);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return itIsDelete;
	}
	
	
	//get one food
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/onefood/{idfood}", produces = "application/json")
	public Optional<Foods> getOneFood (@PathVariable("idfood") Integer theIdFood) 
	{

		Optional<Foods> aMedec = null;
		try {
			aMedec = foodsService.loadFoodById(theIdFood);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return aMedec;
	}
}
