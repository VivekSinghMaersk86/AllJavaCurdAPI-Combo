package com.maersk.crud.ApiDevelopment.Service;

import com.maersk.crud.ApiDevelopment.YardResponseDTO.YardResponse;
import java.util.List;

public interface YardService {

    List<YardResponse> getAllYard();

    List<YardResponse> findByYardName(String YardName);

    void updateYardById(long id , YardResponse yardResponse);

    void deleteYardById(long id);

    YardResponse findById(long id);

    void CreateNewYard(YardResponse yardResponse);

   // void saveYard(YardResponse yardResponse);

    boolean isYardExist(YardResponse yardResponse);

}
