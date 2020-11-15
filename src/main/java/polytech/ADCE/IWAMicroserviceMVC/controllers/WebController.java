package polytech.ADCE.IWAMicroserviceMVC.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import polytech.ADCE.IWAMicroserviceMVC.models.Position;
import polytech.ADCE.IWAMicroserviceMVC.services.MyProducer;
import polytech.ADCE.IWAMicroserviceMVC.services.socket.PositionMessage;

import java.util.Date;

@Controller
public class WebController {

    @Autowired
    private Environment env;

    private MyProducer producer;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @MessageMapping("/position")
    public boolean positions(PositionMessage message) throws Exception {
        this.setProducer(new MyProducer(env));
        this.getProducer().openConnection();
        Position position = new Position(
                message.getUserId(),
                message.getLongitude(),
                message.getLatitude(),
                new Date()
        );
        this.getProducer().sendPosition(position);
        this.getProducer().closeConnection();
        System.out.println(position.toJSON());
        return true;
    }

    public MyProducer getProducer() {
        return producer;
    }

    public void setProducer(MyProducer producer) {
        this.producer = producer;
    }
}
