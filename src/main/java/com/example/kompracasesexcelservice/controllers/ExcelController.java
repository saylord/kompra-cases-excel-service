package com.example.kompracasesexcelservice.controllers;

import com.example.kompracasesexcelservice.dto.LitigationDTO;
import com.example.kompracasesexcelservice.services.ILitigationService;
import com.example.kompracasesexcelservice.utils.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/litigation")
public class ExcelController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    final static String API_TOKEN = "test_API_v2";
    @Autowired
    private ILitigationService litigationService;

    @GetMapping("/getJson")
    public ResponseEntity<LitigationDTO> getAllLitigations(@RequestParam(value = "identifier") String identifier) {
        log.debug("entering get json");
        LitigationDTO litigations;
        try {
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

    @GetMapping("/export")
    public ResponseEntity<Resource> exportLitigation(@RequestParam(value = "identifier") String identifier) {
        try {
            LitigationDTO litigations;
            litigations = litigationService.fetchLitigations(identifier, API_TOKEN);
            if (litigations == null) {
                log.warn("received 0 results in getting json objects");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            String fileName = "LitigationExport"+ identifier + ".xlsx";

            ByteArrayInputStream in = ExcelUtils.exportLitigation(litigations.getCaseList(), fileName);
            InputStreamResource inputStreamResource = new InputStreamResource(in);

            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment: filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8))
                    .contentType(MediaType.parseMediaType("application/vnd.ms-excel; charset=UTF-8"))
                    .body(inputStreamResource);
        } catch (Exception e) {
            log.error("error happened in getJson endpoint", e);
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
