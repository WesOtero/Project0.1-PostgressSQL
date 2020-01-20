package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public interface UserDAO {
	public void createPet(User pet);

	public User readPet(int id);

	public void updatePet(User pet, int id);

	public void deletePet(User pet);

	public List<User> readAllPets();

	public List<User> readPetsByType(String type);

}
