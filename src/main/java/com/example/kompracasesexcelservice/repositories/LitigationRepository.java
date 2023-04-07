package com.example.kompracasesexcelservice.repositories;

import com.example.kompracasesexcelservice.dto.LitigationDTO;

import java.util.List;

public interface LitigationRepository {
    LitigationDTO fetch(String searchFilter, String apiToken) throws Exception;
//    List<LitigationDTO> fetchManual(String searchFilter, String apiToken) throws Exception;
}
