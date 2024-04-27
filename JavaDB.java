import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;

public class JavaDB extends JFrame implements ActionListener {
  JButton connectButton, exitButton, insertButton, deleteButton, deleteAllButton, searchButton, updateButton,
  clearButton, printButton, hideButton;
  JTextField carID, carName, carModel, carManufacturer, carPrice;
  JPanel panel;
  JComboBox Jbox;

  JTable tb;
  static String col[] = {
    "ID",
    "Name",
    "Manufacturer",
    "Model",
    "Price",
    "Status"
  };
  String row[][] = new String[100][6];
  JScrollPane sp;

  static String database_name = ""; //change this
  static String database_table = ""; //change this
  // Change info according to the user;
  private static String url = "jdbc:derby://localhost:1527/" + database_name + ";" + "create=true ";
  private static String username = "username"; //change this
  private static String password = "password"; //change this
  private static String path = "./"; //change this
  JFrame fa;
  Connection connection;
  Statement statement;

  JLabel companyLogo, carIDL, carNameL, carModelL, carManufacturerL, carPriceL, carStatusL, infoL, errorL;

  public JavaDB() {
    super("Car Management System");
    setSize(1915, 1080);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);

    Font f = new Font("monospaced", Font.BOLD, 26);
    Font g = new Font("monospaced", Font.BOLD, 20);
    panel = new JPanel();
    panel.setBounds(900, 100, 900, 750);
    panel.setBackground(new Color(16676915));
    panel.setLayout(null);
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

    getContentPane().setBackground(new Color(36, 56, 55));
    companyLogo = new JLabel(new ImageIcon(path + "Logo1.png"));
    companyLogo.setBounds(50, 0, 500, 400);
    connectButton = new JButton("Connect To DataBase");
    connectButton.setForeground(new Color(36, 56, 55));
    connectButton.setBackground(new Color(16676915));
    connectButton.setBounds(150, 400, 300, 40);
    connectButton.setFont(g);
    exitButton = new JButton("Exit");
    exitButton.setBounds(150, 450, 300, 40);
    exitButton.setForeground(new Color(36, 56, 55));
    exitButton.setBackground(new Color(16676915));
    exitButton.setFont(g);
    insertButton = new JButton("Insert");
    insertButton.setForeground(new Color(16676915));
    insertButton.setBackground(new Color(36, 56, 55));
    insertButton.setFont(g);
    insertButton.setBounds(100, 400, 250, 40);
    updateButton = new JButton("Update");
    updateButton.setForeground(new Color(16676915));
    updateButton.setBackground(new Color(36, 56, 55));
    updateButton.setFont(g);
    updateButton.setBounds(100, 560, 250, 40);
    deleteButton = new JButton("Delete");
    deleteButton.setForeground(new Color(16676915));
    deleteButton.setBackground(new Color(36, 56, 55));
    deleteButton.setBounds(100, 480, 250, 40);
    deleteButton.setFont(g);

    deleteAllButton = new JButton("Delete All");
    deleteAllButton.setForeground(new Color(16676915));
    deleteAllButton.setBackground(new Color(36, 56, 55));
    deleteAllButton.setFont(g);
    deleteAllButton.setBounds(400, 480, 250, 40);
    searchButton = new JButton("Serach");
    searchButton.setForeground(new Color(16676915));
    searchButton.setBackground(new Color(36, 56, 55));
    searchButton.setFont(g);
    searchButton.setBounds(400, 400, 250, 40);
    clearButton = new JButton("Clear");
    clearButton.setForeground(new Color(16676915));
    clearButton.setBackground(new Color(36, 56, 55));
    clearButton.setFont(g);
    clearButton.setBounds(400, 560, 250, 40);
    printButton = new JButton("Print");
    printButton.setForeground(new Color(16676915));
    printButton.setBackground(new Color(36, 56, 55));
    printButton.setFont(g);
    printButton.setBounds(400, 640, 250, 40);
    hideButton = new JButton("Hide");
    hideButton.setForeground(new Color(16676915));
    hideButton.setBackground(new Color(36, 56, 55));
    hideButton.setFont(g);
    hideButton.setBounds(100, 640, 250, 40);
    hideButton.setVisible(false);

    errorL = new JLabel("Error: Record not found");
    errorL.setFont(g);
    errorL.setBackground(Color.red);
    errorL.setForeground(Color.WHITE);
    errorL.setOpaque(true);
    errorL.setVisible(false);
    errorL.setBounds(50, 550, 600, 40);
    errorL.setVisible(false);

    carID = new JTextField();
    carID.setBackground(new Color(36, 56, 55));
    carID.setForeground(new Color(16676915));
    carID.setCaretColor(new Color(16676915));

    carID.setFont(g);
    carIDL = new JLabel("ID");
    carIDL.setFont(f);
    carName = new JTextField();
    carName.setBackground(new Color(36, 56, 55));
    carName.setForeground(new Color(16676915));
    carName.setCaretColor(new Color(16676915));
    carName.setFont(g);
    carNameL = new JLabel("Name");
    carNameL.setFont(f);
    carModel = new JTextField();
    carModel.setBackground(new Color(36, 56, 55));
    carModel.setForeground(new Color(16676915));
    carModel.setCaretColor(new Color(16676915));

    carModel.setFont(g);
    carModelL = new JLabel("Model");
    carModelL.setFont(f);
    carManufacturer = new JTextField();
    carManufacturer.setBackground(new Color(36, 56, 55));
    carManufacturer.setForeground(new Color(16676915));
    carManufacturer.setCaretColor(new Color(16676915));
    carManufacturer.setFont(g);
    carManufacturerL = new JLabel("Manufacturer");
    carManufacturerL.setFont(f);
    carPrice = new JTextField();
    carPrice.setCaretColor(new Color(16676915));
    carPrice.setBackground(new Color(36, 56, 55));
    carPrice.setForeground(new Color(16676915));
    carPrice.setFont(g);
    carPriceL = new JLabel("Price");
    carPriceL.setFont(f);
    carStatusL = new JLabel("Status");
    carStatusL.setFont(f);
    String[] status = {
      "Used",
      "New"
    };
    Jbox = new JComboBox < > (status);
    Jbox.setSelectedIndex(0);
    Jbox.setBounds(600, 260, 200, 40);
    Jbox.setBackground(new Color(36, 56, 55));
    Jbox.setForeground(new Color(16676915));
    Jbox.setFont(f);

    infoL = new JLabel("Car Info: ");
    infoL.setFont(f);

    infoL.setBounds(20, 10, 200, 40);
    carID.setBounds(140, 100, 200, 40);
    carIDL.setBounds(50, 100, 100, 40);
    carName.setBounds(600, 100, 200, 40);
    carNameL.setBounds(500, 100, 100, 40);
    carManufacturer.setBounds(600, 180, 200, 40);
    carManufacturerL.setBounds(400, 180, 200, 40);
    carModel.setBounds(140, 180, 200, 40);
    carModelL.setBounds(50, 180, 100, 40);
    carStatusL.setBounds(500, 260, 100, 40);
    carPrice.setBounds(140, 260, 200, 40);
    carPriceL.setBounds(50, 260, 100, 40);

    connectButton.addActionListener(this);
    exitButton.addActionListener(this);
    insertButton.addActionListener(this);
    deleteButton.addActionListener(this);
    deleteAllButton.addActionListener(this);
    searchButton.addActionListener(this);
    updateButton.addActionListener(this);
    clearButton.addActionListener(this);
    printButton.addActionListener(this);
    hideButton.addActionListener(this);

    panel.setVisible(false);

    panel.add(carID);
    panel.add(carIDL);
    panel.add(carManufacturerL);
    panel.add(carManufacturer);
    panel.add(carName);
    panel.add(carNameL);
    panel.add(carModel);
    panel.add(carModelL);
    panel.add(carPrice);
    panel.add(carPriceL);
    panel.add(carStatusL);
    panel.add(infoL);
    panel.add(Jbox);
    panel.add(insertButton);
    panel.add(deleteButton);
    panel.add(deleteAllButton);
    panel.add(searchButton);
    panel.add(updateButton);
    panel.add(clearButton);
    panel.add(printButton);
    panel.add(hideButton);
    getContentPane().add(companyLogo);
    getContentPane().add(connectButton);
    getContentPane().add(panel);
    getContentPane().add(exitButton);

    tb = new JTable(row, col);

    tb.setFont(new Font("monospaced", Font.PLAIN, 20));
    tb.setForeground(new Color(36, 56, 55));
    tb.setBackground(new Color(16676915));
    tb.setEnabled(false);
    tb.getColumnModel().getColumn(2).setPreferredWidth(100);
    tb.setRowHeight(30);

    tb.getTableHeader().setFont(new Font("monospaced", Font.BOLD, 20));
    tb.getTableHeader().setBackground(new Color(16676915));
    tb.getTableHeader().setForeground(new Color(36, 56, 55));
    sp = new JScrollPane(tb);

    sp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    sp.setBounds(50, 550, 800, 400);
    sp.setBackground(new Color(36, 56, 55));
    sp.setVisible(false);
    tb.setVisible(false);
    getContentPane().add(errorL);
    getContentPane().add(sp);

    setVisible(true);
  }

  public JavaDB(String h) {

  }

  public String get_username() {
    return username;
  }

  public String get_password() {
    return password;
  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == connectButton) {
      try {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        panel.setVisible(true);
        connectButton.setVisible(false);

      } catch (SQLException E) {
        JOptionPane.showMessageDialog(this, "Error: \n" + E);
      }

    }
    if (e.getSource() == insertButton) {
      int cid = Integer.parseInt(carID.getText());
      int pid = Integer.parseInt(carPrice.getText());

      try {

        String sql = "INSERT INTO " + database_table + "(ID, Name, Manufacturer,Model,Price,Status) VALUES (" + cid +
          "," +
          "'" + carName.getText() + "'" + "," + "'" + carManufacturer.getText() + "'" + "," + "'" +
          carModel.getText() + "'" + "," + pid + "," + "'" + (String) Jbox.getSelectedItem() + "'" + ")";
        statement.executeUpdate(sql);
        JOptionPane.showMessageDialog(this, "insertion done ");
        carManufacturer.setText("");
        carID.setText("");
        carModel.setText("");
        carName.setText("");
        carPrice.setText("");
      } catch (Exception e2) {
        JOptionPane.showMessageDialog(this, "Sorry Record not added \n" + e2);
      }
    }
    if (e.getSource() == searchButton) {

      int cid = Integer.parseInt(carID.getText());
      sp.setVisible(false);
      tb.setVisible(false);
      for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 6; j++) {
          row[i][j] = null;
        }
      }
      try {

        String sql = "SELECT * FROM " + database_table + " WHERE ID=" + cid;
        ResultSet rs = null;
        rs = statement.executeQuery(sql);
        int i = 0;

        while (rs.next()) {
          int j = 0;
          String id = String.valueOf(rs.getInt("ID"));
          String name = rs.getString("Name");
          String m = rs.getString("Model");
          String ma = rs.getString("Manufacturer");
          String pr = String.valueOf(rs.getInt("Price"));
          String st = rs.getString("Status");
          String f[][] = {
            {
              id,
              name,
              ma,
              m,
              pr,
              st
            }
          };
          while (j != 6) {
            row[i][j] = f[0][j];
            j++;

          }
          break;

        }
        if (row[0][0] != null) {
          errorL.setVisible(false);
          sp.setVisible(true);
          tb.setVisible(true);
          hideButton.setVisible(true);

        } else {
          errorL.setVisible(true);
        }

      } catch (Exception e2) {
        JOptionPane.showMessageDialog(this, "Sorry Record is not found \n" + e2);
      }
    }
    if (e.getSource() == printButton) {
      sp.setVisible(false);
      tb.setVisible(false);
      for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 6; j++) {
          row[i][j] = null;
        }
      }

      try {

        String sql = "SELECT * FROM " + database_table;
        ResultSet rs = null;
        rs = statement.executeQuery(sql);

        int i = 0;

        while (rs.next()) {
          int j = 0;
          String id = String.valueOf(rs.getInt("ID"));
          String name = rs.getString("Name");
          String m = rs.getString("Model");
          String ma = rs.getString("Manufacturer");
          String pr = String.valueOf(rs.getInt("Price"));
          String st = rs.getString("Status");
          String f[][] = {
            {
              id,
              name,
              ma,
              m,
              pr,
              st
            }
          };
          while (j != 6) {
            row[i][j] = f[0][j];
            j++;

          }
          i++;
        }
        errorL.setVisible(false);
        sp.setVisible(true);
        tb.setVisible(true);

        hideButton.setVisible(true);

      } catch (Exception e2) {
        JOptionPane.showMessageDialog(this, "Sorry Record is not found \n" + e2);
      }
    }
    if (e.getSource() == updateButton) {
      int cid = Integer.parseInt(carID.getText());
      int pid = Integer.parseInt(carPrice.getText());
      try {
        String sql = "UPDATE " + database_table + " SET Name=" + "'" + carName.getText() + "'" + "," + "Manufacturer=" +
          "'" + carManufacturer.getText() + "'" + "," +
          "Price=" + pid + "," + "Status=" + "'" + (String) Jbox.getSelectedItem() + "'" + "WHERE ID=" + cid;
        statement.executeUpdate(sql);
        JOptionPane.showMessageDialog(this, "Record updated ");
        carManufacturer.setText("");
        carID.setText("");
        carModel.setText("");
        carName.setText("");
        carPrice.setText("");
      } catch (Exception e2) {
        JOptionPane.showMessageDialog(this, "Sorry Record not updated \n" + e2);
      }
    }
    if (e.getSource() == deleteButton) {
      int cid = Integer.parseInt(carID.getText());
      try {
        String sql = "DELETE FROM " + database_table + " WHERE ID=" + cid;
        statement.executeUpdate(sql);
        JOptionPane.showMessageDialog(this, " Record deleted ");
      } catch (Exception e2) {
        JOptionPane.showMessageDialog(this, "Sorry Record not deleted \n" + e2);
      }
    }
    if (e.getSource() == deleteAllButton) {
      try {
        String sql = "DELETE FROM " + database_table;
        statement.executeUpdate(sql);
        JOptionPane.showMessageDialog(this, "all Records are deleted ");
      } catch (Exception e2) {
        JOptionPane.showMessageDialog(this, "Sorry Records are not deleted \n" + e2);
      }
    }
    if (e.getSource() == clearButton) {
      carManufacturer.setText("");
      carID.setText("");
      carModel.setText("");
      carName.setText("");
      carPrice.setText("");
    }
    if (e.getSource() == exitButton) {
      System.exit(0);

    }
    if (e.getSource() == hideButton) {
      sp.setVisible(false);
      hideButton.setVisible(false);
    }
  }

}

class Start extends JFrame implements MouseListener, ActionListener {
  JButton button1, button2;
  JTextField userField;
  JPasswordField pass_Field;
  private static String username;
  private static String password;
  private static String path = "./"; //change this
  JavaDB u = new JavaDB(null);
  boolean b = true;
  JPanel panel;

  JLabel labelU, labelP, Logo, labelS, labelI, labelB;

  public Start() {

    super("Car Management System");
    Start.username = u.get_username();
    Start.password = u.get_password();
    Font f = new Font("monospaced", Font.BOLD, 22);
    Font g = new Font("monospaced", Font.BOLD, 20);
    Font b = new Font("monospaced", Font.BOLD, 36);
    Border bb = BorderFactory.createLineBorder(new Color(0, 0, 0), 6);
    setSize(1915, 1080);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    getContentPane().setBackground(new Color(36, 56, 55));
    Logo = new JLabel(new ImageIcon(path + "Logo1.png"));
    userField = new JTextField(username);
    pass_Field = new JPasswordField(password);

    labelU = new JLabel(new ImageIcon(path + "test.png"));
    labelP = new JLabel(new ImageIcon(path + "lock(1).png"));
    labelS = new JLabel(new ImageIcon(path + "eye1.png"));
    labelB = new JLabel("log In");

    labelB.setFont(b);
    labelB.setForeground(new Color(36, 56, 55));
    labelI = new JLabel("Error: Incorrect password or username, try again");
    labelI.setFont(g);
    labelI.setBackground(Color.red);
    labelI.setForeground(Color.WHITE);
    labelI.setOpaque(true);
    labelI.setVisible(false);

    panel = new JPanel();
    panel.setSize(500, 570);
    panel.setBackground(new Color(16676915));
    panel.setLayout(null);
    panel.setBorder(bb);
    panel.setLocation(700, 400);
    button1 = new JButton("Log In");
    button1.setFont(g);
    button1.setForeground(new Color(16676915));
    button1.setBackground(new Color(36, 56, 55));
    button2 = new JButton("Exit");
    button2.setFont(g);
    button2.setForeground(new Color(16676915));
    button2.setBackground(new Color(36, 56, 55));
    userField.setFont(f);
    pass_Field.setFont(f);

    userField.setBounds(850, 520, 220, 30);
    pass_Field.setBounds(850, 570, 220, 30);

    button1.setBounds(850, 620, 220, 40);
    button2.setBounds(850, 700, 220, 40);
    Logo.setBounds(700, 0, 500, 400);
    labelB.setBounds(885, 300, 200, 300);
    labelU.setBounds(800, 515, 36, 36);
    labelP.setBounds(800, 565, 36, 36);
    labelS.setBounds(750, 565, 36, 36);
    labelI.setBounds(700, 740, 600, 40);
    labelS.addMouseListener(this);
    button1.addActionListener(this);
    button2.addActionListener(this);

    getContentPane().add(button1);
    getContentPane().add(button2);
    getContentPane().add(userField);
    getContentPane().add(pass_Field);
    getContentPane().add(Logo);
    getContentPane().add(labelB);
    getContentPane().add(labelU);
    getContentPane().add(labelP);
    getContentPane().add(labelS);
    getContentPane().add(labelI);
    getContentPane().add(panel);
    setVisible(true);

  }

  public void actionPerformed(ActionEvent e) {
    String password = String.valueOf(pass_Field.getPassword()).trim();
    if (e.getSource() == button1) {
      if (userField.getText().equals(Start.username) && password.equals(Start.password)) {
        this.dispose();
        new JavaDB();
      } else {

        labelI.setVisible(true);
      }
    }
    if (e.getSource() == button2) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    new Start();
  }

  @Override
  public void mousePressed(MouseEvent e) {
    if (b) {
      pass_Field.setEchoChar((char) 0);
      labelS.setIcon(new ImageIcon(path + "eye-crossed1.png"));
      b = false;
    } else if (!b) {
      pass_Field.setEchoChar('*');
      labelS.setIcon(new ImageIcon(path + "eye1.png"));
      b = true;
    }

  }

  @Override
  public void mouseClicked(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

}