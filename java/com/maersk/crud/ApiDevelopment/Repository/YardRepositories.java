package com.maersk.crud.ApiDevelopment.Repository;

import com.maersk.crud.ApiDevelopment.YardResponseDTO.YardResponse;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface YardRepositories  extends JpaRepository<YardResponse, Long>{

       List<YardResponse> findByName(String YardName);

       //YardResponse save(YardResponse xyz);

       YardResponse findById(long id);

}