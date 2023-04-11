package com.example.kompracasesexcelservice.repositories.implementations;

import com.example.kompracasesexcelservice.dto.*;
import com.example.kompracasesexcelservice.repositories.LitigationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LitigationRepositoryImpl implements LitigationRepository {
    @Autowired
    NetworkRepositoryImpl networkRepository;

    @Override
    public LitigationDTO fetch(String identifier, String apiToken) throws Exception {
        String url = "https://kompra.kz/api/v2/cases?identifier=" + identifier + "&api-token=" + apiToken;
        String rawJson = networkRepository.request(url);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(rawJson, LitigationDTO.class);
    }

}
