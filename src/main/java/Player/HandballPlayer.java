package Player;

public class HandballPlayer {
    public HandballPlayer(String name, String nickname, Integer number, String teamName,
                          Integer goalsMade, Integer goalsReceived) {
        this.name = name;
        this.nickname = nickname;
        this.number = number;
        this.teamName = teamName;
        this.goalsMade = goalsMade;
        this.goalsReceived = goalsReceived;
    }

    private final String name;
    private final String nickname;
    private final Integer number;
    private final String teamName;
    private final Integer goalsMade;
    private final Integer goalsReceived;

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getNumber() {
        return number;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getGoalsMade() {
        return goalsMade;
    }

    public Integer getGoalsReceived() {
        return goalsReceived;
    }

    public Integer getRatingPoints() {
        return (2 * goalsMade - goalsReceived);
    }
}
