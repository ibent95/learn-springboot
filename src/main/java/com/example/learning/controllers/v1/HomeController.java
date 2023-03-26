
package com.example.learning.controllers.v1;

import com.example.learning.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ibent95
 */
@RestController
public class HomeController {
    
    private final CommonService commonSvc;

    @Autowired
    public HomeController(CommonService commonSvc) {
        this.commonSvc = commonSvc;
    }

    @RequestMapping(path="/", method=RequestMethod.GET)
    public String index() {
        return "Hello world: " + this.commonSvc.generateUuid(true) + " <br> <a href='/students'>Students</a>";
    }

}
