package Player;

public class BasketballPlayer {
    public BasketballPlayer(String name, String nickname, Integer number, String teamName,
                            Integer scoredPoints, Integer rebounds, Integer assist) {
        this.name = name;
        this.nickname = nickname;
        this.number = number;
        this.teamName = teamName;
        this.scoredPoints = scoredPoints;
        this.rebounds = rebounds;
        this.assist = assist;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getScoredPoints() {
        return scoredPoints;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getRebounds() {
        return rebounds;
    }

    public Integer getAssist() {
        return assist;
    }

    private final String name;
    private final String nickname;
    private final Integer number;
    private final String teamName;
    private final Integer scoredPoints;
    private final Integer rebounds;
    private final Integer assist;

    public Integer getRatingPoints() {
        return (scoredPoints * 2 + rebounds + assist);
    }


}
