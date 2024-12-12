package IslemBlok.IslemBlok.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IslemBlok.IslemBlok.repository.BaseBlockRepository;
import IslemBlok.IslemBlok.service.InputBlockService;

@Service
public class InputBlockServiceImpl extends BaseBlockServiceImpl implements InputBlockService{

	@Autowired
	public InputBlockServiceImpl(BaseBlockRepository baseBlockRepository) {
		super(baseBlockRepository);
	}

	


}
