package org.japb.app.datos.controller;

import lombok.extern.log4j.Log4j2;
import org.japb.app.datos.services.ImplReadFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("japb/home")
public class HomeController {

    @Autowired
    ImplReadFiles implReadFiles;

    @GetMapping("paises-zk")
    public ResponseEntity<List<String>> test() {
        List<String> matchedLines = implReadFiles.readFile();
        return ResponseEntity.ok(matchedLines);
    }

}
