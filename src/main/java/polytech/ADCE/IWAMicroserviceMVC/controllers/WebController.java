package polytech.ADCE.IWAMicroserviceMVC.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import polytech.ADCE.IWAMicroserviceMVC.models.Position;
import polytech.ADCE.IWAMicroserviceMVC.services.MyProducer;

import java.util.Date;

@Controller
public class WebController {
    @RequestMapping(value = "/")
    public String index() {
        MyProducer producer = new MyProducer();
        producer.openConnection();
        Position position = new Position(1, 50.0000000, 30.0000000, new Date());
        producer.sendPosition(position);
        return "index";
    }
}
