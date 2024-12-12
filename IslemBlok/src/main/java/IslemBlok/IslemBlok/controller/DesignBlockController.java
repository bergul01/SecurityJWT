package IslemBlok.IslemBlok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IslemBlok.IslemBlok.entity.BaseBlock;
import IslemBlok.IslemBlok.service.BaseBlockService;

@RestController
@RequestMapping("/design")
public class DesignBlockController {

    private final BaseBlockService baseBlockService;

    @Autowired
    public DesignBlockController(BaseBlockService baseBlockService) {
        this.baseBlockService = baseBlockService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseBlock> getDesignBlockById(@PathVariable Long id) {
        return ResponseEntity.ok(baseBlockService.getBlockById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseBlock> updateDesignBlock(@PathVariable Long id, @RequestBody BaseBlock blockDetails) {
        return ResponseEntity.ok(baseBlockService.updateBlock(id, blockDetails));
    }

    @PostMapping("/{id}/run")
    public ResponseEntity<Object> runDesignBlock(@PathVariable Long id) {
        return ResponseEntity.ok(baseBlockService.runBlock(id));
    }
}