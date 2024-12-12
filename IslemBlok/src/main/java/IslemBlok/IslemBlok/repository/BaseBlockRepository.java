package IslemBlok.IslemBlok.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import IslemBlok.IslemBlok.entity.BaseBlock;

public interface BaseBlockRepository extends JpaRepository<BaseBlock, Long>{

	List<BaseBlock> findByProjectId(Long projectId);
	//tüm bloklar için genel işlem.
}
