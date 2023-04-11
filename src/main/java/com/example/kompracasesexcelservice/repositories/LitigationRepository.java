package com.example.kompracasesexcelservice.repositories;

import com.example.kompracasesexcelservice.dto.LitigationDTO;

public interface LitigationRepository {
    LitigationDTO fetch(String searchFilter, String apiToken) throws Exception;
}
