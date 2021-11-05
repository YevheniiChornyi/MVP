package Sport;

import CustomException.WrongFileFormatException;
import Player.BasketballPlayer;
import Session.PlayerService;
import org.tinylog.Logger;
import java.util.ArrayList;
import java.util.List;

public class Basketball implements Sport {
    public Basketball(PlayerService playerService) {
        this.playerService = playerService;
    }

    private final PlayerService playerService;
    String winner;

    List<BasketballPlayer> basketballPlayers = new ArrayList<>();

    public void addPlayer(String name, String nickname, Integer number, String teamName,
                          Integer scoredPoints, Integer rebounds, Integer assist) {

        basketballPlayers.add(new BasketballPlayer(name, nickname, number, teamName, scoredPoints,
                rebounds, assist));
        playerService.ifNotExist(name, nickname);
    }

    public void chargePoints() {
        Logger.debug("team winner {} \n", winner);
        for (BasketballPlayer player :
                basketballPlayers) {
            Logger.debug("Handball player {} {} {}", player.getTeamName(), player.getNickname(), player.getRatingPoints());

            if (player.getTeamName().equals(winner)) {
                playerService.findByNickname(player.getNickname(), player.getName()).addPoints(player.getRatingPoints() + 10);
                continue;
            }
            playerService.findByNickname(player.getNickname(), player.getName()).addPoints(player.getRatingPoints());
        }

    }

    public void defineWinnerTeam() {

        String team1 = basketballPlayers.get(0).getTeamName();
        String team2 = null;
        int team1score = 0;
        int team2score = 0;

        for (BasketballPlayer player :
                basketballPlayers) {
            if (!player.getTeamName().equals(team1)) {
                team2 = player.getTeamName();
                break;
            }
        }
        for (BasketballPlayer player :
                basketballPlayers) {
            if (player.getTeamName().equals(team1)) team1score += player.getScoredPoints();
            else team2score += player.getScoredPoints();
        }
        Logger.debug("team score {} = {} {} = {} \n", team1, team1score, team2, team2score);
        if (team1score > team2score) {
            winner = team1;
            return;
        }
        winner = team2;
    }

    @Override
    public void parseLine(List<String> allLines) throws WrongFileFormatException {
        for (String string :
                allLines) {
            if (string.equals(allLines.get(0))) continue;
            String[] split = string.split(";");
            regex(split[0]);
            regex(split[1]);
            regex(split[3]);
            String name = split[0];
            String nickname = split[1];
            try {
                Integer number = Integer.parseInt(split[2]);
                String teamName = split[3];
                Integer scoredPoints = Integer.parseInt(split[4]);
                Integer rebounds = Integer.parseInt(split[5]);
                Integer assist = Integer.parseInt(split[6]);
                this.addPlayer(name, nickname, number, teamName, scoredPoints, rebounds, assist);
            } catch (NumberFormatException exception) {
                throw new WrongFileFormatException();
            }
        }
    }
}
