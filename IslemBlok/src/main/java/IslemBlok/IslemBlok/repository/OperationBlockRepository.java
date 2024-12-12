package IslemBlok.IslemBlok.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import IslemBlok.IslemBlok.entity.OperationBlock;

public interface OperationBlockRepository extends JpaRepository<OperationBlock, Long>{
	
	List<OperationBlock> findByOperationType(String operationType); // Belirli bir işlem türüne göre blok bulma.


}
