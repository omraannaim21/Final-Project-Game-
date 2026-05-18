//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java. util. Random;

class Character {

    int health;
    int maxHealth; // Testing full health limit
    int damage; // Testing each character receiving their own attack power

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

        Random rn = new Random();

        Character w = new Wizard();
        Character a = new Archer();
        Character s = new Swordsman();

        // Temp null Character selection, must select to activate character
        final Character[] selectedCharacter = {null};

        w.health = 150;
        w.maxHealth = 150; // Testing health max
        w.damage = rn.nextInt(0,150); // Characters unique damage variable

        s.health = 75;
        s.maxHealth = 75; // Testing health max
        s.damage = rn.nextInt(0,75); // Characters unique damage variable

        a.health = 100;
        a.maxHealth = 100; // Testing health max
        a.damage = rn.nextInt(0,100); // Characters unique damage variable

        JFrame frame = new JFrame("Final Game");

        // Adjusted Grid to accommodate new label
        JPanel panel = new JPanel(new GridLayout(4, 3, 5, 5));


        JButton wizard = new JButton("Wizard");
        JButton archer = new JButton("Archer");
        JButton swordsman = new JButton("Swordsman");

        wizard.setBackground(Color.GREEN);
        archer.setBackground(Color.RED);
        swordsman.setBackground(Color.cyan);


        JButton restBtn = new JButton("Rest");
        JButton trainBtn = new JButton("Train");
        JButton attackBtn = new JButton("Attack");
        attackBtn.setVisible(false);


        JLabel restLbl = new JLabel("");
        JLabel trainLbl = new JLabel("");
        JLabel attackLbl = new JLabel("");

        // Added label of selecting character
        JLabel selectedLbl = new JLabel("No Character Selected");

        // Added health label
        JLabel healthLbl = new JLabel("Health: ");

        panel.add(wizard);
        panel.add(restBtn);
        panel.add(restLbl);
        panel.add(archer);
        panel.add(trainBtn);
        panel.add(trainLbl);
        panel.add(swordsman);
        panel.add(attackBtn);
        panel.add(attackLbl);

        // Adds selected labels from above
        panel.add(selectedLbl);

        // Health label added to panel
        panel.add(healthLbl);


        // player selection button functions & health update of selected character added
        wizard.addActionListener(e -> {
            selectedCharacter[0] = w;
            selectedLbl.setText("Selected: Wizard");


            healthLbl.setText("Health: " + selectedCharacter[0].health + " / " + selectedCharacter[0].maxHealth);
        }); // shows health / max health

        archer.addActionListener(e -> {
            selectedCharacter[0] = a;
            selectedLbl.setText("Selected: Archer");

            healthLbl.setText("Health: " + selectedCharacter[0].health + " / " + selectedCharacter[0].maxHealth);
        }); // shows health / max health

        swordsman.addActionListener(e -> {
            selectedCharacter[0] = s;
            selectedLbl.setText("Selected: Swordman");

            healthLbl.setText("Health: " + selectedCharacter[0].health + " / " + selectedCharacter[0].maxHealth);
        }); // shows health / max health


        // Attack button with condition of selecting character. Testing different functionalities, commented below.
        attackBtn.addActionListener(e -> {
            if (selectedCharacter[0] == null) {
                attackLbl.setText("Select Character First");

                return;
            }
            selectedCharacter[0].attack();

            selectedCharacter[0].health -=
                    selectedCharacter[0].damage; // selected character loses health based on their own damage number


            trainLbl.setText("");
            restLbl.setText("");
            attackBtn.setVisible(false);

            if (selectedCharacter[0].health < 0) {
                selectedCharacter[0].health = 0;
            }                                   // prevents health from going to 0

            attackLbl.setText(
                    selectedCharacter[0].attack);

            healthLbl.setText("Health: " + selectedCharacter[0].health
                    + " / " + selectedCharacter[0].maxHealth); // Attack button updates health on screen. Shows health / max health

            if (selectedCharacter[0].health == 0)
                restLbl.setText("Rest to heal character");

        });


        // Train button functionality. Testing other functions, commented below
        trainBtn.addActionListener(e -> {
            if (selectedCharacter[0] == null) {
                trainLbl.setText(
                        "Select Character First");

                return;
            }

            attackBtn.setVisible(true);

            attackLbl.setText("");
            restLbl.setText("");
            selectedCharacter[0].train();
            selectedCharacter[0].maxHealth += 5; // Training makes character strong by plus 5 health


            trainLbl.setText(
                    selectedCharacter[0].train);

            healthLbl.setText(
                    "Health: " + selectedCharacter[0].health + " / " + selectedCharacter[0].maxHealth);
        });  // health / max health


        //Rest button functionality. Testing different features, commented below
        restBtn.addActionListener(e -> {
            if (selectedCharacter[0] == null) {
                restLbl.setText(
                        "Select Character First"
                );

                return;
            }
            selectedCharacter[0].rest();
            selectedCharacter[0].health += rn.nextInt(0, 150);  // plus 10 increases health, updating stats requirement

            if (selectedCharacter[0].health > selectedCharacter[0].maxHealth) { // Checking if health went high
                selectedCharacter[0].health = selectedCharacter[0].maxHealth; // Brings health back down to max
            }

            attackLbl.setText("");
            trainLbl.setText("");

            restLbl.setText(
                    selectedCharacter[0].rest);

            healthLbl.setText("Health: " + selectedCharacter[0].health
                    + " / " + selectedCharacter[0].maxHealth); // Rest button updates health screen. Shows health / max health
        });



        frame.add(panel);
        frame.setSize(425, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
