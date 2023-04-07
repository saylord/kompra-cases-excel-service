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

//    public List<LitigationDTO> fetchManual(String searchFilter, String apiToken) throws Exception {
//        List<LitigationDTO> allLitigations = new ArrayList<LitigationDTO>();
//
//        String rawJson = networkRepository.request("https://kompra.kz/api/v2/cases?identifier=150140024604&api-token=test_API_v2");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        LitigationDTO litigationDTO = objectMapper.readValue(rawJson, LitigationDTO.class);
//        System.out.println(rawJson);
//        JSONObject root = new JSONObject(rawJson);
//
//        for (int i = 0; i < root.length(); i++) {
//            LitigationDTO litigation = new LitigationDTO();
//            // The JSON data
//            String status = root.getString("status");
//            int totalCases = root.getInt("totalCases");
//            String identifier = root.getString("identifier");
//
//            // Getting the list of litigation cases
//            JSONArray litigationCaseList = root.getJSONArray("caseList");
//            List<LitigationCaseDTO> litigationCases = new ArrayList<>();
//            for (int j = 0; j < litigationCaseList.length(); j++) {
//                JSONObject jsonLitigation = litigationCaseList.getJSONObject(j);
//
//                LitigationCaseDTO litigationCase = new LitigationCaseDTO();
//                Long idCase = jsonLitigation.getLong("id");
//                Long created = jsonLitigation.getLong("created");
//                Long lastUpdated = jsonLitigation.getLong("lastUpdated");
//                String category = jsonLitigation.getString("category");
//                Object date = null;
//                if (jsonLitigation.get("date") != null) {
//                    date = jsonLitigation.get("date");
//                }
//                String number = jsonLitigation.getString("number");
//                String part = jsonLitigation.getString("part");
//                String organ = jsonLitigation.getString("organ");
//                String result = jsonLitigation.getString("result");
//                Object plaintiff = null;
//                if (jsonLitigation.get("plaintiff") != null) {
//                    plaintiff = jsonLitigation.get("plaintiff");
//                }
//                Object defendant = null;
//                if (jsonLitigation.get("defendant") != null) {
//                    defendant = jsonLitigation.get("defendant");
//                }
//                Object statusCase = null;
//                if (jsonLitigation.get("status") != null) {
//                    statusCase = jsonLitigation.get("status");
//                }
//                Object company = null;
//                if (jsonLitigation.get("company") != null) {
//                    company = jsonLitigation.get("company");
//                }
//
//                JSONObject jsonLitigationType = jsonLitigation.getJSONObject("type");
//                LitigationTypeDTO litigationType = new LitigationTypeDTO();
//                Long idType = jsonLitigationType.getLong("id");
//                String name = jsonLitigationType.getString("name");
//                litigationType.setId(idType);
//                litigationType.setName(name);
//
//                int year = jsonLitigation.getInt("year");
//                String identifierCase = jsonLitigation.getString("identifier");
//
////                List<LitigationDocumentListDTO> allDocs = new ArrayList<>();
////                System.out.println(jsonLitigation.get("documentList"));
////                if (jsonLitigation.get("documentList") != null) {
////                    System.out.println(jsonLitigation);
////                    JSONArray litigationDocumentList = jsonLitigation.getJSONArray("documentList");
////
////                    for (int k = 0; k < litigationDocumentList.length(); k++) {
////                        JSONObject jsonDocument = litigationDocumentList.getJSONObject(k);
////                        if (jsonDocument == null) {
////                            break;
////                        }
////                        LitigationDocumentListDTO document = new LitigationDocumentListDTO();
////                        Long idDocument = jsonDocument.getLong("id");
////                        Long createdDoc = jsonDocument.getLong("created");
////                        Long lastUpdatedDoc = jsonDocument.getLong("lastUpdated");
////                        String nameDoc = jsonDocument.getString("name");
////                        String type = jsonDocument.getString("type");
////                        String file = jsonDocument.getString("file");
////
////                        document.setId(idDocument);
////                        document.setCreated(createdDoc);
////                        document.setLastUpdated(lastUpdatedDoc);
////                        document.setName(nameDoc);
////                        document.setType(type);
////                        document.setFile(file);
////
////                        allDocs.add(document);
////                    }
////
////                }
//
//
//                litigationCase.setId(idCase);
//                litigationCase.setCreated(created);
//                litigationCase.setLastUpdated(lastUpdated);
//                litigationCase.setCategory(category);
//                litigationCase.setDate(date);
//                litigationCase.setNumber(number);
//                litigationCase.setPart(part);
//                litigationCase.setOrgan(organ);
//                litigationCase.setResult(result);
//                litigationCase.setPlaintiff(plaintiff);
//                litigationCase.setDefendant(defendant);
//                litigationCase.setStatus(statusCase);
//                litigationCase.setCompany(company);
//                litigationCase.setType(litigationType);
//                litigationCase.setYear(year);
//                litigationCase.setIdentifier(identifierCase);
////                litigationCase.setDocumentLists(Collections.singletonList(allDocs));
//
//                litigationCases.add(litigationCase);
//            }
//            litigation.setStatus(status);
//            litigation.setTotalCases(totalCases);
//            litigation.setIdentifier(identifier);
//            litigation.setCaseLists(litigationCases);
//
//            allLitigations.add(litigation);
//        }
////        System.out.println(allLitigations);
//
//        return allLitigations;
//    }

    @Override
    public LitigationDTO fetch(String searchFilter, String apiToken) throws Exception {
//        Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl("https://kompra.kz/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//
//        GetLitigations getLitigations = retrofit.create(GetLitigations.class);
//
//        Call<LitigationList> allLitigations = getLitigations.getAllLitigations(searchFilter, apiToken);
//        Response<LitigationList> execute = allLitigations.execute();
//        System.out.println(String.valueOf(execute.raw().body()));
//        LitigationList litigationList = execute.body();
////
//        return litigationList.getLitigations();
        String rawJson = networkRepository.request("https://kompra.kz/api/v2/cases?identifier=150140024604&api-token=test_API_v2");

        ObjectMapper objectMapper = new ObjectMapper();
        LitigationDTO litigation = objectMapper.readValue(rawJson, LitigationDTO.class);
        return litigation;
    }
}
