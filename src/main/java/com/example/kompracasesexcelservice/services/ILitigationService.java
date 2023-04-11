package com.example.kompracasesexcelservice.services;

import com.example.kompracasesexcelservice.dto.LitigationDTO;

public interface ILitigationService {
    LitigationDTO fetchLitigations(String identifier, String apitoken) throws Exception;
}
