package Session;

import CustomException.WrongFileFormatException;
import Player.PlayerService;
import Sport.Factory.Factory;
import Sport.Enums.KindOfSport;
import Sport.Sport;

import java.util.List;

public class MatchImpl implements Match{

    private final KindOfSport kindOfSport;
    private final PlayerService playerService;
    private final List<String> allLines;

    public MatchImpl(KindOfSport kindOfSport, PlayerService playerService, List<String> allLines) {
        this.kindOfSport = kindOfSport;
        this.playerService = playerService;
        this.allLines = allLines;
    }

    public void startMatch() throws WrongFileFormatException {
        Factory factory = new Factory();
        Sport sport = factory.create(kindOfSport, playerService);
        sport.start(allLines);
    }
}


