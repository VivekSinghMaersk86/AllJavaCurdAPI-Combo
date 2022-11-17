package com.maersk.crud.ApiDevelopment.ServiceImpl;

import com.maersk.crud.ApiDevelopment.Repository.YardRepositories;
import com.maersk.crud.ApiDevelopment.Service.YardService;
import com.maersk.crud.ApiDevelopment.YardResponseDTO.YardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service("yardService")
public class YardServiceImpl implements YardService{

    @Autowired
    private YardRepositories yardRepositories;

    @Override
    public List<YardResponse> getAllYard() {

        List<YardResponse> yardlist=yardRepositories.findAll();

        return yardlist;
    }

     @Override
      public List<YardResponse> findByYardName(String YardName) {

         List<YardResponse>   yardList=yardRepositories.findByName(YardName);

       return yardList;
       }

      @Transactional(propagation = Propagation.REQUIRED )
       public void updateYardById(long id ,YardResponse yardResponse){

          YardResponse yardResponse1 =yardRepositories.findById(id);
          yardResponse1.setName(yardResponse.getName());
          yardRepositories.save(yardResponse1);

         }

        public void deleteYardById(long id){

        YardResponse currentYardorg = yardRepositories.findById(id);
                  yardRepositories.delete(currentYardorg);
        }

       public void CreateNewYard(YardResponse yardResponse){

           //YardResponse yardResponseorg = new YardResponse();
           //yardResponseorg.setCategoryType(yardResponse.getCategoryType());
           //yardResponseorg.setEquipmentType(yardResponse.getEquipmentType());

          yardRepositories.save(yardResponse);
       }

     public YardResponse findById(long id) {

        return yardRepositories.findById(id);
     }

     public boolean isYardExist(YardResponse yardResponse) {

        return findByYardName(yardResponse.getName()) != null;
     }

//      public void saveYard(YardResponse yardResponse) {
//         yardRepositories.save(yardResponse);
//      }


}
