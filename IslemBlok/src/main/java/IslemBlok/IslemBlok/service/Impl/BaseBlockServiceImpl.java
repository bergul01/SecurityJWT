package IslemBlok.IslemBlok.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import IslemBlok.IslemBlok.entity.BaseBlock;
import IslemBlok.IslemBlok.exception.ResourceNotFoundException;
import IslemBlok.IslemBlok.repository.BaseBlockRepository;
import IslemBlok.IslemBlok.service.BaseBlockService;

@Service
@Primary
public class BaseBlockServiceImpl implements BaseBlockService{

		//Final : Bir kere atanıp sonrasında değiştirilemeyeceğini garanti ettik.
		private final BaseBlockRepository baseBlockRepository;

		@Autowired
		public BaseBlockServiceImpl(BaseBlockRepository baseBlockRepository) {
		
			this.baseBlockRepository = baseBlockRepository;
		}
		
		@Override public BaseBlock updateBlock(Long id, BaseBlock blockDetails) {
			BaseBlock block = baseBlockRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Block not found with id: " + id));
			block.setName(blockDetails.getName());
			
			return baseBlockRepository.save(block);
		}
		
		
		@Override
	    public BaseBlock saveBlock(BaseBlock block) {
	        return baseBlockRepository.save(block);
	    }

	    @Override
	    public BaseBlock getBlockById(Long id) {
	        return baseBlockRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Block not found with id: " + id));
	    }

	    @Override
	    public List<BaseBlock> getBlocksByProjectId(Long projectId) {
	        return baseBlockRepository.findByProjectId(projectId);
	    }

	    @Override
	    public void deleteBlock(Long id) {
	        baseBlockRepository.deleteById(id);
	    }
	    
	    @Override public Object runBlock(Long id) {
	    	BaseBlock block = baseBlockRepository.findById(id)
	    			.orElseThrow(() -> new ResourceNotFoundException("Block not found with id: " + id));
	    	return block.execute(); 
	    }

		
	
	
	
	
}
