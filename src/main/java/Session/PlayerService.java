package Session;

import Player.Player;

import java.util.List;

public interface PlayerService {

    void createPlayer(String name, String nickname);

    List<Player> chooseMVP();

    Player findByNickname(String nickname, String name);

    void ifNotExist(String name, String nickname);

    void getPlayers();
}
