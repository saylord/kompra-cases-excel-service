package com.example.kompracasesexcelservice.services;

import com.example.kompracasesexcelservice.dto.LitigationDTO;

import java.util.List;

public interface ILitigationService {
    LitigationDTO fetchLitigations(String identifier, String apitoken) throws Exception;
}
