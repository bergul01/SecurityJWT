package IslemBlok.IslemBlok.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import IslemBlok.IslemBlok.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	

	List<Project> findByUserId(Long userId); //kullanıcının tüm projeleri bulma.
	
}
