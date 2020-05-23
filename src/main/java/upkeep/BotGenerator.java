package upkeep;

import dao.pojo.Robot;
import logic.joueur.IABasic;

public class BotGenerator {
    static public IABasic getLogic(Robot robot) {
        switch(robot.getProgramme()) {
            case "Random":
                return new IABasic(robot);
            default:
                return null;
        }
    }
}
