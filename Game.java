import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class StartF {
  JFrame main;
  static int width = 1000;
  static int height = 700;
  JButton Bchoose3, Bchoose4;
  JLabel logo, credit;
  StartF() {
    Font f = new Font("monospaced", Font.BOLD, 26);
    main = new JFrame("Tic Tac Toe Game");
    main.setLayout(null);
    Container c = main.getContentPane();
    c.setBackground(new Color(265220));
    logo = new JLabel(new ImageIcon("./Logo.png"));
    logo.setBounds(430, 80, 130, 130);
    credit = new JLabel(new ImageIcon("./credit.png"));
    credit.setBounds(250, 550, 530, 130);
    Bchoose3 = new JButton("Play with AI");
    Bchoose4 = new JButton("Play with Friend");
    Bchoose3.setFont(f);
    Bchoose3.setBounds(330, 300, 310, 40);
    Bchoose3.setBorder(BorderFactory.createLineBorder(new Color(6610455)));
    Bchoose3.setForeground(new Color(6610455));
    Bchoose3.setBackground(new Color(265220));
    Bchoose4.setFont(f);
    Bchoose4.setBounds(330, 250, 310, 40);
    Bchoose4.setBorder(BorderFactory.createLineBorder(new Color(6610455)));
    Bchoose4.setForeground(new Color(6610455));
    Bchoose4.setBackground(new Color(265220));
    c.add(Bchoose3);
    c.add(Bchoose4);
    c.add(logo);
    c.add(credit);
    Handling handl = new Handling();
    Bchoose3.addActionListener(handl);
    Bchoose4.addActionListener(handl);
    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.setSize(width, height);
    main.setLocationRelativeTo(null);
    main.setVisible(true);
  }
  class Handling implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

      if (e.getSource() == Bchoose3) {
        JOptionPane.showMessageDialog(null, "Sorry, This feature be working on soon", null, JOptionPane.INFORMATION_MESSAGE);
      } else if (e.getSource() == Bchoose4) {

        ChooseSettings cc = new ChooseSettings();
        main.setVisible(false);

      }

    }
  }
}
class ChooseSettings {

  ButtonGroup g1;
  JFrame main;
  static JRadioButton rb1, rb2;
  static int width = 1000;
  static int height = 700;
  JButton Bchoose1, Bchoose2;
  JLabel logo, credit;

  ChooseSettings() {
    Font f = new Font("monospaced", Font.BOLD, 26);
    main = new JFrame("Tic Tac Toe Game");
    main.setLayout(null);
    Container c = main.getContentPane();
    c.setBackground(new Color(265220));
    g1 = new ButtonGroup();

    Bchoose1 = new JButton("Select X");
    Bchoose2 = new JButton("Select Y");

    rb1 = new JRadioButton("X");
    rb2 = new JRadioButton("O");
    Bchoose1.setFont(f);
    Bchoose1.setBounds(330, 300, 310, 40);
    Bchoose1.setBorderPainted(false);
    Bchoose1.setForeground(new Color(6610455));
    Bchoose1.setBackground(new Color(265220));
    Bchoose2.setFont(f);
    Bchoose2.setBounds(330, 250, 310, 40);
    Bchoose2.setBorderPainted(false);
    Bchoose2.setForeground(new Color(6610455));
    Bchoose2.setBackground(new Color(265220));
    logo = new JLabel(new ImageIcon("./Logo.png"));
    logo.setBounds(430, 80, 130, 130);
    credit = new JLabel(new ImageIcon("./credit.png"));
    credit.setBounds(250, 550, 530, 130);

    g1.add(rb1);
    c.add(Bchoose1);
    c.add(Bchoose2);
    c.add(logo);
    c.add(credit);

    Handling handl = new Handling();
    Bchoose1.addActionListener(handl);
    Bchoose2.addActionListener(handl);

    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.setSize(width, height);
    main.setLocationRelativeTo(null);
    main.setVisible(true);

  }
  class Handling implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

      if (e.getSource() == Bchoose1) {
        rb1.setSelected(true);
        Game r = new Game();
        main.setVisible(false);
      } else if (e.getSource() == Bchoose2) {
        rb2.setSelected(true);
        Game r = new Game();
        main.setVisible(false);

      }

    }
  }
}
public class Game {
  static int width = 1000;
  static int height = 700;
  JFrame f;
  String ch, ch2;
  JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
  Game() {
    Color gr = new Color(6610455);
    Color bbk = new Color(265220);
    Font t = new Font(null, Font.PLAIN, 30);
    Font tt = new Font(null, Font.PLAIN, 40);
    if (ChooseSettings.rb1.isSelected()) {
      ch = "X";
      ch2 = "O";
    } else if (ChooseSettings.rb2.isSelected()) {
      ch = "O";
      ch2 = "X";
    }
    f = new JFrame("Tic Tac Toe Game");
    f.setSize(width, height);
    f.setVisible(true);
    JLabel l1 = new JLabel("Player 1  ");
    JLabel ls1 = new JLabel(ch);
    l1.setForeground(gr);
    ls1.setForeground(gr);
    l1.setFont(t);
    ls1.setFont(t);
    JLabel l2 = new JLabel("Player 2  ");
    JLabel ls2 = new JLabel(ch2);
    l2.setFont(t);
    ls2.setFont(t);
    l2.setForeground(gr);
    ls2.setForeground(gr);
    l1.setBounds(100, 50, 150, 60);
    l2.setBounds(800, 50, 150, 60);
    ls1.setBounds(140, 125, 100, 60);
    ls2.setBounds(840, 125, 100, 60);
    JPanel panel = new JPanel();
    GridLayout GL = new GridLayout(3, 3);
    panel.setLayout(GL);
    panel.setBounds(300, 80, 400, 400);
    b1 = new JButton();
    b2 = new JButton();
    b3 = new JButton();
    b4 = new JButton();
    b5 = new JButton();
    b6 = new JButton();
    b7 = new JButton();
    b8 = new JButton();
    b9 = new JButton();

    b1.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 10, Color.BLACK));
    b2.setBorder(BorderFactory.createMatteBorder(0, 10, 10, 10, Color.BLACK));
    b3.setBorder(BorderFactory.createMatteBorder(0, 10, 10, 0, Color.BLACK));
    b4.setBorder(BorderFactory.createMatteBorder(10, 0, 10, 10, Color.BLACK));
    b5.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));
    b6.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 0, Color.BLACK));
    b7.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 10, Color.BLACK));
    b8.setBorder(BorderFactory.createMatteBorder(10, 10, 0, 10, Color.BLACK));
    b9.setBorder(BorderFactory.createMatteBorder(10, 10, 0, 0, Color.BLACK));

    b1.setOpaque(true);
    b2.setOpaque(true);
    b3.setOpaque(true);
    b4.setOpaque(true);
    b5.setOpaque(true);
    b6.setOpaque(true);
    b7.setOpaque(true);
    b8.setOpaque(true);
    b9.setOpaque(true);
    b1.setFont(tt);
    b2.setFont(tt);
    b3.setFont(tt);
    b4.setFont(tt);
    b5.setFont(tt);
    b6.setFont(tt);
    b7.setFont(tt);
    b8.setFont(tt);
    b9.setFont(tt);
    b1.setForeground(bbk);
    b2.setForeground(bbk);
    b3.setForeground(bbk);
    b4.setForeground(bbk);
    b5.setForeground(bbk);
    b6.setForeground(bbk);
    b7.setForeground(bbk);
    b8.setForeground(bbk);
    b9.setForeground(bbk);
    b1.setBackground(gr);
    b2.setBackground(gr);
    b3.setBackground(gr);
    b4.setBackground(gr);
    b5.setBackground(gr);
    b6.setBackground(gr);
    b7.setBackground(gr);
    b8.setBackground(gr);
    b9.setBackground(gr);

    panel.add(b1);
    panel.add(b2);
    panel.add(b3);
    panel.add(b4);
    panel.add(b5);
    panel.add(b6);
    panel.add(b7);
    panel.add(b8);
    panel.add(b9);
    HandlingGame h = new HandlingGame();
    b1.addActionListener(h);
    b2.addActionListener(h);
    b3.addActionListener(h);
    b4.addActionListener(h);
    b5.addActionListener(h);
    b6.addActionListener(h);
    b7.addActionListener(h);
    b8.addActionListener(h);
    b9.addActionListener(h);
    panel.setBackground(new Color(300));
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = f.getContentPane();
    c.add(l1);
    c.add(l2);
    c.add(ls1);
    c.add(ls2);
    c.add(panel);
    c.setBackground(new Color(265220));
    f.setLocationRelativeTo(null);
    f.setLayout(null);
  }
  class HandlingGame implements ActionListener {

    class End {
      JButton play_a, k_it;
      JLabel l_ag;
      JFrame g;
      End() {
        Color gr = new Color(6610455);
        Color bbk = new Color(265220);
        Font t = new Font("Serif", Font.PLAIN, 50);
        Font tt = new Font("Serif", Font.PLAIN, 24);
        g = new JFrame("Game Over");
        g.setSize(width, height);
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setLocationRelativeTo(null);

        Container b = g.getContentPane();
        b.setLayout(null);
        b.setBackground(new Color(265220));
        play_a = new JButton("Play Again");
        k_it = new JButton("Cancel");
        play_a.setForeground(bbk);
        play_a.setBackground(gr);
        k_it.setForeground(bbk);
        k_it.setBackground(gr);
        l_ag = new JLabel("Game Over");
        l_ag.setFont(t);
        l_ag.setForeground(gr);
        play_a.setFont(tt);
        k_it.setFont(tt);

        l_ag.setBounds(400, 150, 700, 100);

        play_a.setBounds(410, 300, 220, 50);
        k_it.setBounds(410, 400, 220, 50);
        b.add(play_a);
        b.add(k_it);
        b.add(l_ag);

        HandleTheEnd bh = new HandleTheEnd();
        play_a.addActionListener(bh);
        k_it.addActionListener(bh);

      }
      class HandleTheEnd implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (e.getSource() == play_a) {
            ChooseSettings y = new ChooseSettings();
            g.setVisible(false);

          } else if (e.getSource() == k_it) {
            System.exit(0);
          }
        }
      }
    }
    public void isWin() {
      if (!(ch.isEmpty())) {
        if ((b1.getText().equals(ch) && b2.getText().equals(ch) && b3.getText().equals(ch) || (b1.getText().equals(ch) && b4.getText().equals(ch) && b7.getText().equals(ch))) ||
          (b1.getText().equals(ch) && b5.getText().equals(ch) && b9.getText().equals(ch)) || (b2.getText().equals(ch) && b5.getText().equals(ch) && b8.getText().equals(ch)) || (b4.getText().equals(ch) && b5.getText().equals(ch) && b6.getText().equals(ch)) || (b7.getText().equals(ch) && b8.getText().equals(ch) && b9.getText().equals(ch)) || (b3.getText().equals(ch) && b5.getText().equals(ch) && b7.getText().equals(ch)) || (b3.getText().equals(ch) && b6.getText().equals(ch) && b9.getText().equals(ch))) {

          JOptionPane.showMessageDialog(null, "Player" + ch + " win");
          End E = new End();
          f.setVisible(false);

        } else if ((b1.getText().equals(ch2) && b2.getText().equals(ch2) && b3.getText().equals(ch2) || (b1.getText().equals(ch2) && b4.getText().equals(ch2) && b7.getText().equals(ch2))) ||
          (b1.getText().equals(ch2) && b5.getText().equals(ch2) && b9.getText().equals(ch2)) || (b2.getText().equals(ch2) && b5.getText().equals(ch2) && b8.getText().equals(ch2)) || (b4.getText().equals(ch2) && b5.getText().equals(ch2) && b6.getText().equals(ch2)) || (b7.getText().equals(ch2) && b8.getText().equals(ch2) && b9.getText().equals(ch2)) || (b3.getText().equals(ch2) && b5.getText().equals(ch2) && b7.getText().equals(ch2)) || (b3.getText().equals(ch2) && b6.getText().equals(ch2) && b9.getText().equals(ch2))) {
          JOptionPane.showMessageDialog(null, "Player " + ch2 + " win");
          End E = new End();
          f.setVisible(false);
        } else {
          if (b1.isEnabled() == false && b2.isEnabled() == false && b3.isEnabled() == false && b4.isEnabled() == false && b5.isEnabled() == false && b6.isEnabled() == false && b7.isEnabled() == false && b8.isEnabled() == false && b9.isEnabled() == false) {
            JOptionPane.showMessageDialog(null, "Tie, No one Win (:");
            End E = new End();
            f.setVisible(false);
          }

        }
      }

    }
    Random t = new Random();
    int ran;
    String re;
    @Override
    public void actionPerformed(ActionEvent e) {
      if (ch.equals("O")) {
        if (e.getSource() == b1) {
          b1.setText(ch);
          b1.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b2) {
          b2.setText(ch);
          b2.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b3) {
          b3.setText(ch);
          b3.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b4) {
          b4.setText(ch);
          b4.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b5) {
          b5.setText(ch);
          b5.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b6) {
          b6.setText(ch);
          b6.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b7) {
          b7.setText(ch);
          b7.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b8) {
          b8.setText(ch);
          b8.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b9) {
          b9.setText(ch);
          b9.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        }

      } else if (ch.equals("X")) {
        if (e.getSource() == b1) {
          b1.setText(ch);
          b1.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b2) {
          b2.setText(ch);
          b2.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b3) {
          b3.setText(ch);
          b3.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b4) {
          b4.setText(ch);
          b4.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b5) {
          b5.setText(ch);
          b5.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b6) {
          b6.setText(ch);
          b6.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b7) {
          b7.setText(ch);
          b7.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b8) {
          b8.setText(ch);
          b8.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        } else if (e.getSource() == b9) {
          b9.setText(ch);
          b9.setEnabled(false);
          re = ch;
          ch = ch2;
          ch2 = re;
        }
      }
      isWin();
    }
  }
  public static void main(String al5al[]) {

    StartF gg = new StartF();

  }

}