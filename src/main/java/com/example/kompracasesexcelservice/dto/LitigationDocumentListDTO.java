package com.example.kompracasesexcelservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LitigationDocumentListDTO {
    @SerializedName("docdate")
    @Expose
    private String docdate;
    @SerializedName("docname")
    @Expose
    private String docname;
    @SerializedName("fileUrl")
    @Expose
    private String fileUrl;
    @SerializedName("filename")
    @Expose
    private String filename;
}
