package com.bagus.findhawker.hawker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HawkerController {
    @Autowired
    HawkerService hawkerService;

    @RequestMapping(value = "/hawkers", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HawkersEntity> getHawkers(
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {
        GetHawkersRequest request = new GetHawkersRequest(latitude, longitude);
        return ResponseEntity.ok(hawkerService.getHawkers(request));
    }
}


