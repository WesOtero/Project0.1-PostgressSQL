package com.revature.dao;

import java.util.List;

import com.revature.pojo.Car;

public interface CarDAO {
	public void createPet(Car pet);

	public Car readPet(int id);

	public void updatePet(Car pet, int id);

	public void deletePet(Car pet);

	public List<Car> readAllPets();

	public List<Car> readPetsByType(String type);
}
