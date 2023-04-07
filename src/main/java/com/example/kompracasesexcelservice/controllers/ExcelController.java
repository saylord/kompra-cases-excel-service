package com.example.kompracasesexcelservice.controllers;

import com.example.kompracasesexcelservice.dto.LitigationDTO;
import com.example.kompracasesexcelservice.services.ILitigationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/litigation")
public class ExcelController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    String API_TOKEN = "test_API_v2";
    String identifier = "150140024604";
    @Autowired
    private ILitigationService litigationService;

    @GetMapping("/getJson")
    public ResponseEntity<LitigationDTO> getAllLitigations(@RequestParam(value = "identifier") String identifier) {
        log.debug("entering get json");
        LitigationDTO litigations;
        try {
            if (!Objects.equals(this.identifier, identifier)) {
                log.warn("please enter another identifier");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            litigations = litigationService.fetchLitigations(identifier, API_TOKEN);
            if (litigations == null) {
                log.warn("received 0 results in getting json objects");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(litigations, HttpStatus.OK);
        } catch (Exception e) {
            log.error("error happened in getJson endpoint", e);
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/export")
//    public ResponseEntity<ResponseMessage> exportToExcel(@RequestParam("identifier") String identifier) {
//        String url = "";
//
//    }
}
