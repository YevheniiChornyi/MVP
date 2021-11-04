package Sport.Factory;

import CustomException.WrongFileFormatException;
import Player.PlayerService;
import Sport.*;
import Sport.Enums.KindOfSport;

public class Factory implements SportFactory{

    public Sport create (KindOfSport kindOfSport, PlayerService playerService) throws WrongFileFormatException {
        switch (kindOfSport) {
            case HANDBALL: return new Handball(playerService);
            case BASKETBALL: return new Basketball(playerService);
            default: throw new WrongFileFormatException();
        }
    }


}
