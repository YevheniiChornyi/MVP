package Player;
import org.tinylog.Logger;

public class Player implements Comparable<Player> {
    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public int getScore() {
        return score;
    }

    private final String name;
    private final String nickname;
    private int score;

    @Override
    public String toString() {
        return "Player " +
                 name + '\'' +
                ", also called " + nickname +
                ", with score " + score;
    }

    public Player(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
        this.score = 0;
    }

    public void addPoints(int points){
        Logger.debug("addPoints/points before:{} {} \n",this::getNickname,this::getScore);
        this.score += points;
        Logger.debug("addPoints/points after:{} {} \n",this::getNickname,this::getScore);
    }

    public int compareTo(Player player) {
        return this.getScore() - player.getScore();
    }
}
