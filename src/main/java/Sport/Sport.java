package Sport;

import CustomException.WrongFileFormatException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Sport {
    /*
To create a new sport (sport name), you must:
1. Add a case to the factory with (sport name) in upper case.
2. Create a class (sport name)player in the entity package in accordance
with the previous entities.
2. Create a class (sport name) in the sport package by implementing the sport interface.
Define "add player" method. All methods will be similar to the previous ones,
and differ in the number of entity fields (sport name)player.
The constructor must accept the PlayerService.
     */

    //TODO overload addPlayer()
    void chargePoints();

    void defineWinnerTeam();

    void parseLine(List<String> allLines) throws WrongFileFormatException;

    default void regex(String input) throws WrongFileFormatException {
        String regex = "\\w\\D";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new WrongFileFormatException();
        }
    }

    default void start(List<String> allLines) throws WrongFileFormatException {
        this.parseLine(allLines);
        this.defineWinnerTeam();
        this.chargePoints();
    }
}
