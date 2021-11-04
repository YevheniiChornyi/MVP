package Sport;

import CustomException.WrongFileFormatException;
import Session.Match;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Sport{

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
