package com.example.kompracasesexcelservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LitigationCaseDTO {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("lastUpdated")
    @Expose
    private Long lastUpdated;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("date")
    @Expose
    private Long date;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("part")
    @Expose
    private String part;
    @SerializedName("organ")
    @Expose
    private String organ;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("plaintiff")
    @Expose
    private String plaintiff;
    @SerializedName("defendant")
    @Expose
    private String defendant;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("company")
    @Expose
    private Integer company;
    @SerializedName("type")
    @Expose
    private LitigationTypeDTO type;
    @SerializedName("year")
    @Expose
    private int year;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("documentList")
    @Expose
    private List<LitigationDocumentListDTO> documentList;
}
