package Player;

import org.tinylog.Logger;
import java.util.*;

public class PlayerServiceImpl implements PlayerService{

    List<Player> players = new ArrayList<Player>();
    List<Player> mvp = new ArrayList<Player>();

    public void getPlayers(){
        Logger.debug(players);
    }

    public void createPlayer(String name, String nickname) {
        players.add(new Player(name, nickname));
    }
// when reader
    public List<Player> chooseMVP() {
        Player max = Collections.max(players);
        for (Player player:
                players ) {
            if(max.getScore() == player.getScore()){ mvp.add(player);}
        }
        return mvp;
    }

    public Player findByNickname(String nickname, String name) {
        for (Player player:
                players) {
            if (player.getNickname().equals(nickname)) {return player;}
        }
        throw new IllegalArgumentException();

    }

    @Override
    public void ifNotExist(String name, String nickname) {
        boolean isExist = false;
        for (Player player:
                players) {
            if (player.getNickname().equals(nickname)) {isExist = true;}
        }
        if (!isExist) {
            createPlayer(name, nickname);
        }
    }
}
