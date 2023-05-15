package jscode.jscodeproject.api;

import jscode.jscodeproject.domain.Bulletin;
import jscode.jscodeproject.service.BulletinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //controller + responsebody
@RequiredArgsConstructor
@RequestMapping("/bulletins")
public class BulletinApiController {

    private final BulletinService bulletinService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Bulletin saveBulletin(@RequestBody Bulletin bul){
        bulletinService.write(bul);
        return bul;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Bulletin> searchAll() {
        List<Bulletin> bulletins = bulletinService.findBulletins();
        return bulletins;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{bulletinId}")
    public Bulletin searchById(@PathVariable Long bulletinId){
        Bulletin bulletin = bulletinService.findOne(bulletinId);
        return bulletin;
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{bulletinId}")
    public Bulletin updateBulletin(@PathVariable Long bulletinId, @RequestBody Bulletin bul){
        Bulletin bulletin = bulletinService.updateBulletin(bulletinId, bul.getTitle(), bul.getText());
        return bulletin;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{bulletinId}")
    public String deleteBulletin(@PathVariable Long bulletinId){
        bulletinService.deleteOne(bulletinId);
        return "ok";
    }

}
