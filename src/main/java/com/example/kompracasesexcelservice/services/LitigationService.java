package com.example.kompracasesexcelservice.services;

import com.example.kompracasesexcelservice.dto.LitigationDTO;
import com.example.kompracasesexcelservice.repositories.LitigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LitigationService implements ILitigationService {
    @Autowired
    LitigationRepository litigationRepository;

    @Override
    public LitigationDTO fetchLitigations(String identifier, String apitoken) throws Exception {
        return litigationRepository.fetch(identifier, apitoken);
    }

}
