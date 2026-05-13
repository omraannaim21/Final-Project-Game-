//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;

class Character {

    int health;
    String attack;
    String rest;
    String train;

    public void attack (){

        attack = "attacking";
    }

    public void train (){

        train = "training";
    }

    public void rest() {
        rest = "healing ... back to full hp";
    }

}

class Wizard extends Character {

    @Override
    public void attack() {
        attack = "casting spells . . . ";
    }

    @Override
    public void train() {
        train = "learning new spells ... staff acquired";
    }


}

class Archer extends Character {

    @Override
    public void attack() {
        attack = "shooting arrows . . .";
    }

    @Override
    public void train() {
        train = "collecting arrows . . . upgrading bow";
    }

}

class Swordsman extends Character {

    @Override
    public void attack() {
        attack = "swinging sword . . .";
    }

    @Override
    public void train() {
        train = "sparring . . . upgrading sword";
    }
}

public class Main {
    public static void main(String[] args) {

        Character w = new Wizard();
        Character a = new Archer();
        Character s = new Swordsman();

        w.health = 150;
        s.health = 75;
        a.health = 100;

        JFrame frame = new JFrame("Final Game");


        JPanel panel = new JPanel(new GridLayout(3,3, 5, 5));
        JButton wizard = new JButton("Wizard");
        JButton archer = new JButton("Archer");
        JButton swordsman = new JButton("Swordsman");

        JButton restBtn = new JButton("Rest");
        JButton trainBtn = new JButton("Train");
        JButton attackBtn = new JButton("Attack");

        JLabel restLbl = new JLabel("");
        JLabel trainLbl = new JLabel("");
        JLabel attackLbl = new JLabel("");

        panel.add(wizard); panel.add(restBtn); panel.add(restLbl);
        panel.add(archer); panel.add(trainBtn); panel.add(trainLbl);
        panel.add(swordsman); panel.add(attackBtn); panel.add(attackLbl);



        frame.add(panel);
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



    }
}