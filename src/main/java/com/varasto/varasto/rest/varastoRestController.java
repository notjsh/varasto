package com.varasto.varasto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varasto.varasto.data.Tavara;
import com.varasto.varasto.service.varastoService;

@RestController
public class varastoRestController {

    varastoService vsc;

    @Autowired
    public varastoRestController(varastoService vsc) {
        this.vsc = vsc;
    }

    // tavaraluettelo
    @GetMapping("/tavarat")
    public List<Tavara> haeTavaras() {
        return vsc.haeLista();
    }

    // tavaran lisäys
    @PostMapping("/atavara")
    public String addTavara(@RequestBody Tavara tavara) {
        if (vsc.addTavara(tavara)) {
            return "Tavara hyllytetty onnistuneesti";
        }
        return "Hyllypaikka on jo käytössä";
    }

    // tavaran poisto
    @DeleteMapping("/dtavara")
    public String removeTavara(@RequestBody Tavara tavara) {
        vsc.poistaTavara(tavara.getId());
        return "Tavara poistettu";
    }

    // tavaran etsintä id:lla
    @GetMapping("/tavara/{id}")
    public ResponseEntity<Tavara> getTavara(@PathVariable int id) {
        Tavara t = vsc.etsiTavara(id);

        if (t != null) {
            return new ResponseEntity<>(t, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // hyllypaikan vaihtaminen id:n kanssa
    @PostMapping("/siirra")
    public String siirraTavara(@RequestBody Tavara tavara) {
        if (vsc.siirraHylly(tavara.getId(), tavara.getHyllyKirjain(), tavara.getHyllyNumero())) {
            return "Tavara siiretty onnistuneesti";
        }
        return "Tapahtui virhe, tarkista antamasi tiedot";
    }
}
