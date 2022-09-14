package se.b3.kodtest.montyhall.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameServiceImpl implements GameService{

    private int boxChosen;
    private boolean[] boxes;
    private int boxShown;

    private void init(){
        Random random = new Random();
        boolean[] initBoxes = {false,false,false};
        int winningBox =random.nextInt(3);
        initBoxes[winningBox] = true;
        this.boxChosen = random.nextInt(3);
        this.boxes = initBoxes;
        int show = random.nextInt(3);
        while(boxes[show] || show == this.boxChosen){
            show = random.nextInt(3);
        }
        this.boxShown = show;
    }

    @Override
    public String[] startSimulation(int amountOfChoices) {
        if(amountOfChoices < 1){
            throw new IllegalArgumentException("Amount under 1");
        }
        String[] winsStaySwitch = new String[2];
        int winsStay = 0;
        int winsSwitch = 0;
        for(int choice= 0; choice < amountOfChoices ;choice++){
            init();
            winsStay += boxStayWin();
            winsSwitch += boxSwitchWin();

        }
        winsStaySwitch[0] = "Staying:" + winToString(winsStay,amountOfChoices);
        winsStaySwitch[1] = "Switching" +  winToString(winsSwitch,amountOfChoices);
        return winsStaySwitch;
    }

    private int boxStayWin(){
        return this.boxes[this.boxChosen] ? 1 : 0;
    }

    private int boxSwitchWin(){
        return this.boxes[3 - this.boxChosen - this.boxShown] ? 1 : 0;
    }

    private String winToString(int wins, int amountOfChoices){
        double percentage = (double) wins * 100 / amountOfChoices;
        return "Amount of wins " + wins + ", with " + percentage +"% chance";
    }
}
