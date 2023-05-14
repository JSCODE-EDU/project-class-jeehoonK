package jscode.jscodeproject.api;

import jscode.jscodeproject.domain.Bulletin;
import jscode.jscodeproject.service.BulletinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BulletinApiController {

    private final BulletinService bulletinService;

    @PostMapping("/bulletins")
    public Bulletin saveBulletin(@RequestBody Bulletin bul){
        Bulletin bulletin = new Bulletin();
        bulletin.setText(bul.getTitle());
        bulletin.setTitle(bul.getText());
        bulletinService.write(bulletin);
        return bulletin;
    }

    @GetMapping("/bulletins")
    public List<Bulletin> searchAll() {
        List<Bulletin> bulletins = bulletinService.findBulletins();
        return bulletins;
    }

    @GetMapping("/bulletins/{bulletinId}")
    public Bulletin searchById(@PathVariable Long bulletinId){
        Bulletin bulletin = bulletinService.findOne(bulletinId);
        return bulletin;
    }

    @PatchMapping("/bulletins/{bulletinId}")
    public Bulletin updateBulletin(@PathVariable Long bulletinId, @RequestBody Bulletin bul){
        Bulletin bulletin = bulletinService.updateBulletin(bulletinId, bul.getTitle(), bul.getText());
        return bulletin;
    }

    @DeleteMapping("/bulletins/{bulletinId}")
    public void deleteBulletin(@PathVariable Long bulletinId){
        bulletinService.deleteOne(bulletinId);
    }





}
