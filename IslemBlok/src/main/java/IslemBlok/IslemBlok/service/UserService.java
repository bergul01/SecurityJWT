package IslemBlok.IslemBlok.service;

import IslemBlok.IslemBlok.entity.User;

public interface UserService {

	User saveUser(User user);

	User updateUser(Long id, User userDetails);
	
	User getUserById(Long id);

	User getUserByUsername(String username);

	void deleteUser(Long id);

}
