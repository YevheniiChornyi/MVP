package CustomException;

public class WrongFileFormatException extends Exception{
    public WrongFileFormatException() {
        super("If one file is wrong, the whole set of files is considered to be wrong and the MVP " +
                "won’t be calculated.");
    }
}
