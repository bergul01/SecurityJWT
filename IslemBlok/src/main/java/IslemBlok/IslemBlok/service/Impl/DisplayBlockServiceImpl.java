package IslemBlok.IslemBlok.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IslemBlok.IslemBlok.repository.BaseBlockRepository;
import IslemBlok.IslemBlok.service.DisplayBlockService;

@Service
public class DisplayBlockServiceImpl extends BaseBlockServiceImpl implements DisplayBlockService{

	@Autowired
	public DisplayBlockServiceImpl(BaseBlockRepository baseBlockRepository) {
		super(baseBlockRepository);
	}

}
