package com.maersk.crud.ApiDevelopment.controller;

import com.maersk.crud.ApiDevelopment.Service.YardService;
import com.maersk.crud.ApiDevelopment.Util.CustomErrorType;
import com.maersk.crud.ApiDevelopment.YardResponseDTO.YardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class YardController {

    @Autowired
    private YardService YardService;

    @RequestMapping(value = "/AllYardList", method = RequestMethod.GET)
    public ResponseEntity<?> getAllYard() throws Exception {
        List<YardResponse>YardResponseList  = YardService.getAllYard();
        return new ResponseEntity<List<YardResponse>>(YardResponseList , HttpStatus.OK);
    }

      @RequestMapping(value = "/YardResponse/{YardName}", method = RequestMethod.GET)
      public ResponseEntity<?> findByYardName(@PathVariable("YardName") String YardName) throws Exception {
          List<YardResponse>  YardResponseByENList1 = YardService.findByYardName(YardName);
        return new ResponseEntity<List<YardResponse> >(YardResponseByENList1 ,HttpStatus.OK);
    }

    @RequestMapping(value = "/yardResponse", method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json" )
     public void createNewYard(@RequestBody YardResponse yardResponse) throws Exception {

//        if (YardService.isYardExist(yardResponse)) {
//                    new CustomErrorType("Unable to create. A Yard with name " +
//                    yardResponse.getName() + " already exist.");
//
//        }
         YardService.CreateNewYard(yardResponse);
        }

    @RequestMapping(value = "/deleteYard/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteYard(@PathVariable("id") long id) {

        YardResponse yardResponse = YardService.findById(id);
        if (yardResponse == null) {
              return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        YardService.deleteYardById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   @RequestMapping(value ="/updateYard/{id}", method = RequestMethod.PUT ,consumes = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json" )
   public void updateYardById(@PathVariable("id") long id, @RequestBody YardResponse yardResponse){
       System.out.println("Updating yard By  Yard id"+ id);
       YardService.updateYardById(id ,yardResponse);
  }

}
