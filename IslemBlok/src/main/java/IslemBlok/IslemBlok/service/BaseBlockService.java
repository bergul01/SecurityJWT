package IslemBlok.IslemBlok.service;

import java.util.List;

import IslemBlok.IslemBlok.entity.BaseBlock;

public interface BaseBlockService {
	
    BaseBlock saveBlock(BaseBlock block);
    
    BaseBlock updateBlock(Long id, BaseBlock blockDetails);
    
    BaseBlock getBlockById(Long id);

    List<BaseBlock> getBlocksByProjectId(Long projectId);

    void deleteBlock(Long id);
    
    Object runBlock(Long id);

}
