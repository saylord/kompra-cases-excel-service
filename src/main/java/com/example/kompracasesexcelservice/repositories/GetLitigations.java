package com.example.kompracasesexcelservice.repositories;

import com.example.kompracasesexcelservice.dto.LitigationList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetLitigations {

    @GET("/api/v2/cases")
    Call<LitigationList> getAllLitigations(@Query("identifier") String identifier, @Query("api-token") String apiToken);
}
