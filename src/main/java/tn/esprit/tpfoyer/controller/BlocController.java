package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entitiy.Bloc;
import tn.esprit.tpfoyer.service.BlocServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/bloc")
@AllArgsConstructor
public class BlocController {
    BlocServiceImpl blocService;

    @PostMapping("/affecterChambres")
    public ResponseEntity<Bloc> affecterChambresABloc(@RequestParam List<Long> numChambre, @RequestParam long idBloc) {
        Bloc bloc = blocService.affecterChambresABloc(numChambre, idBloc);
        return ResponseEntity.ok(bloc);
    }
}
