package com.example.testsr.controller;

import com.example.testsr.model.Pan;
import com.example.testsr.repository.PanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/pan")
public class PanController {
    @Autowired
    private PanRepo panRepo;

    @GetMapping
    public List<Pan> getAllPan() {
        return panRepo.findAll();
    }

    @PostMapping
    public Pan createPan(@RequestBody Pan pan) {
        return panRepo.save(pan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pan> getPanById(@PathVariable int id) {
        return panRepo.findById(id)
                .map(pan -> ResponseEntity.ok().body(pan))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pan> updatePan(@PathVariable int id, @RequestBody Pan panDetails) {
        return panRepo.findById(id)
                .map(pan -> {
                    pan.setName(panDetails.getName());
                    pan.setPrice(panDetails.getPrice());
                    Pan updatedPan = panRepo.save(pan);
                    return ResponseEntity.ok(updatedPan);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePan(@PathVariable int id) {
        return panRepo.findById(id)
                .map(pan -> {
                    panRepo.delete(pan);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
