package Sport.Factory;

import CustomException.WrongFileFormatException;
import Session.PlayerService;
import Sport.*;
import Sport.Enums.KindOfSport;

public interface SportFactory {

    Sport create(KindOfSport kindOfSport, PlayerService playerService) throws WrongFileFormatException;
}
