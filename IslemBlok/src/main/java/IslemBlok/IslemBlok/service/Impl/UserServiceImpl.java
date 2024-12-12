package IslemBlok.IslemBlok.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IslemBlok.IslemBlok.entity.User;
import IslemBlok.IslemBlok.exception.ResourceNotFoundException;
import IslemBlok.IslemBlok.repository.UserRepository;
import IslemBlok.IslemBlok.service.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
		@Autowired
		private final UserRepository userRepository;


	    @Override
	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }
	    
	    @Override public User updateUser(Long id, User userDetails) {
	    	User user = userRepository.findById(id)
	    			.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	    	user.setUsername(userDetails.getUsername());
	    	user.setPassword(userDetails.getPassword());
	    	
	    	return userRepository.save(user); 
	    }

	    @Override
	    public User getUserById(Long id) {
	       
	    	return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	    }

	    @Override
	    public User getUserByUsername(String username) {
	    	return userRepository.findByUsername(username).orElseThrow(() -> new  ResourceNotFoundException("User not found with username:" + username));
	    }

	    @Override
	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }

		

}
