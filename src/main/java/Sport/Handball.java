package Sport;

import CustomException.WrongFileFormatException;
import Player.HandballPlayer;
import Session.PlayerService;
import java.util.ArrayList;
import java.util.List;
import org.tinylog.Logger;

public class Handball implements Sport {
    public Handball(PlayerService playerService) {
        this.playerService = playerService;
    }

    private final PlayerService playerService;
    private String winner;


    List<HandballPlayer> handballPlayers = new ArrayList<>();

    public void addPlayer(String name, String nickname, Integer number,
                          String teamName, Integer goalsMade, Integer goalsReceived) {
        handballPlayers.add(new HandballPlayer(name, nickname, number, teamName, goalsMade, goalsReceived));
        playerService.ifNotExist(name, nickname);
    }

    public void chargePoints() {
        Logger.debug("team winner {} \n", winner);

        for (HandballPlayer player :
                handballPlayers) {
            Logger.debug("Handball player {} {} {}", player.getTeamName(), player.getNickname(), player.getRatingPoints());
            if (player.getTeamName().equals(winner)) {
                playerService.findByNickname(player.getNickname(), player.getName()).addPoints(player.getRatingPoints() + 10);
                continue;
            }
            playerService.findByNickname(player.getNickname(), player.getName()).addPoints(player.getRatingPoints());
        }
    }

    public void defineWinnerTeam() {
        String team1 = handballPlayers.get(0).getTeamName();
        String team2 = null;
        int team1score = 0;
        int team2score = 0;

        for (HandballPlayer player :
                handballPlayers) {
            if (!player.getTeamName().equals(team1)) {
                team2 = player.getTeamName();
                break;
            }
        }
        for (HandballPlayer player :
                handballPlayers) {
            if (player.getTeamName().equals(team1)) team1score += player.getGoalsMade();
            else team2score += player.getGoalsMade();
        }
        Logger.debug("team score {} = {} {} = {} \n", team1, team1score, team2, team2score);
        if (team1score > team2score) {
            winner = team1;
        } else {
            winner = team2;
        }
    }

    @Override
    public void parseLine(List<String> allLines) throws WrongFileFormatException {
        for (String str :
                allLines) {
            if (str.equals(allLines.get(0))) continue;
            String[] split = str.split(";");
            regex(split[0]);
            regex(split[1]);
            regex(split[3]);
            String name = split[0];
            String nickname = split[1];
            try {
                Integer number = Integer.parseInt(split[2]);
                String teamName = split[3];
                Integer goalsMade = Integer.parseInt(split[4]);
                Integer goalsReceived = Integer.parseInt(split[5]);

                this.addPlayer(name, nickname, number, teamName, goalsMade, goalsReceived);
            } catch (NumberFormatException exception) {
                throw new WrongFileFormatException();
            }
        }
    }
}
