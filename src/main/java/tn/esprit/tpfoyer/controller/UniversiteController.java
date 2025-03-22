package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entitiy.Universite;
import tn.esprit.tpfoyer.service.UniversiteServiceImpl;
@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteController {
    UniversiteServiceImpl universiteService;

    @PostMapping("/affecterFoyer")
    public ResponseEntity<Universite> affecterFoyerAUniversite(@RequestParam long idFoyer, @RequestParam String nomUniversite) {
        Universite universite = universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
        return ResponseEntity.ok(universite);
    }

    @PostMapping("/desaffecterFoyer")
    public ResponseEntity<Universite> desaffecterFoyerAUniversite(@RequestParam long idUniversite) {
        Universite universite = universiteService.desaffecterFoyerAUniversite(idUniversite);
        return ResponseEntity.ok(universite);
    }
}
