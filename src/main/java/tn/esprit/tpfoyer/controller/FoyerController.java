package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entitiy.Foyer;
import tn.esprit.tpfoyer.service.FoyerServiceImpl;
import tn.esprit.tpfoyer.service.IFoyerService;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerController {

    IFoyerService foyerService;
    @PostMapping("/saveFoyer")
    public Foyer saveFoyer(@RequestBody Foyer foyer) {
        return foyerService.saveFoyer(foyer);
    }
    @GetMapping("findById/{id}")
    public Foyer findById(@PathVariable Long id) {
        return foyerService.findFoyer(id);
    }

}
