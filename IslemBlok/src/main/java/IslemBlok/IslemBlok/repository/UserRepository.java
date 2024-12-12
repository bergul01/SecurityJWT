package IslemBlok.IslemBlok.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import IslemBlok.IslemBlok.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional<User> findByUsername(String username); //Kullanıcı adına göre kullanıcı bulma.
}
