import java.util.Arrays;
import java.util.Comparator;

class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {


    @Override
    public int compare(Player o1, Player o2) {
        int scoreCompare = Integer.compare(o1.score, o2.score);
        int nameCompare = o1.name.compareTo(o2.name);
//        return scoreCompare == 0 ? -scoreCompare : nameCompare;
        if (scoreCompare == 0) {
            return nameCompare;
        } else {
            return -scoreCompare;
        }
    }
}

public class ComparatorTest {

    public static void main(String[] args) {
        Player p1 = new Player("aakansha ", 75);
        Player p2 = new Player("aleksa ", 150);
        Player p3 = new Player("amy ", 100);
        Player p4 = new Player("david ", 100);
        Player p5 = new Player("heraldo  ", 50);
        Player[] players = new Player[]{p1, p2, p3, p4, p5};
        Checker checker = new Checker();
        Arrays.sort(players, checker);
        for (Player player : players) {
            System.out.println(player.name);
            System.out.println(player.score);
            System.out.println("--------");
        }

    }
}
