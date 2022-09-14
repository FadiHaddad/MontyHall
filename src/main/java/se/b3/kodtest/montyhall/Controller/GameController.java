package se.b3.kodtest.montyhall.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.b3.kodtest.montyhall.Service.GameService;


@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/simulation")
    public ResponseEntity<?> initSimulation(@RequestBody String amount){
        try{
            String[] stringValues = gameService.startSimulation(Integer.parseInt(amount));
            return new ResponseEntity<>(stringValues,HttpStatus.OK);
        }catch (IllegalArgumentException exception){
            return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
        }
    }
}
