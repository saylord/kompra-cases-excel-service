package com.example.kompracasesexcelservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LitigationDTO {
//    @SerializedName("id")
//    @Expose
//    private Integer id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("caseList")
    @Expose
    private List<LitigationCaseDTO> caseList;
    @SerializedName("totalCases")
    @Expose
    private int totalCases;
    @SerializedName("identifier")
    @Expose
    private String identifier;
}
