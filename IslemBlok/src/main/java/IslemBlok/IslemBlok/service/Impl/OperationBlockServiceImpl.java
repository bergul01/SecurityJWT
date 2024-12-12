package IslemBlok.IslemBlok.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IslemBlok.IslemBlok.repository.BaseBlockRepository;
import IslemBlok.IslemBlok.service.OperationBlockService;

@Service
public class OperationBlockServiceImpl extends BaseBlockServiceImpl implements OperationBlockService{

	@Autowired
	public OperationBlockServiceImpl(BaseBlockRepository baseBlockRepository) {
		super(baseBlockRepository);
		
	}

	
}
