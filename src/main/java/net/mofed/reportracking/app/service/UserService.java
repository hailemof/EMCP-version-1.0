package net.mofed.reportracking.app.service;

import net.mofed.reportracking.app.exception.UsernameOrIdNotFound;
import net.mofed.reportracking.app.model.User;
import net.mofed.reportracking.app.util.ChangePasswordForm;

public interface UserService {
	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws UsernameOrIdNotFound;
	
	public User changePassword(ChangePasswordForm form) throws Exception;

	public User getUserByUsername(String un);

	
}

