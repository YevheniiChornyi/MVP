package Session;

import CustomException.WrongFileFormatException;
import Sport.Enums.KindOfSport;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.tinylog.Logger;


public class Tournament {

    final private PlayerService playerService = new PlayerServiceImpl();

    final private String path = "src/main/resources/matches";
    // directory with input files
    final private File dir = new File(path);
    File[] arrFiles = dir.listFiles();


    List<File> fileList;

    {
        assert arrFiles != null;
        fileList = Arrays.asList(arrFiles);
    }

    public void startTournament() throws WrongFileFormatException {
        this.splitFiles();
        System.out.println("MVP is " + playerService.chooseMVP());
        this.playerService.getPlayers();
    }

    private void splitFiles() throws WrongFileFormatException {
        Logger.debug("Files{} {} {} ", path, arrFiles[0], arrFiles[1]);
        KindOfSport kindOfSport = KindOfSport.UNKNOWN;
        for (File file :
                fileList) {
            List<String> allLines = this.newMatch(file.getPath());


            for (KindOfSport value :
                    KindOfSport.values()) {
                if (value.name().equals(allLines.get(0))) {
                    kindOfSport = value;
                }
            }
            Match match = new MatchImpl(kindOfSport, playerService, allLines);
            match.startMatch();

        }
    }

    private List<String> newMatch(String path) {

        List<String> allLines = null;

        {
            try {
                allLines = Files.readAllLines(Paths.get(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return allLines;
    }

}
