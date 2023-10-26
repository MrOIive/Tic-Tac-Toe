import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class MyPanel extends JPanel implements MouseListener{

  final int PANEL_WIDTH = 500;
  final int PANEL_HEIGHT = 500;
  final int IMAGE_SIZE = 75;
  Image backgroundImage;
  char PLAYER1 = 'X';
  char PLAYER2 = 'O';
  char[] turn = { 'O', 'X'};
  Rectangle[][] imageBounds = new Rectangle[3][3];
  static Image[][] player = new Image[3][3];
  public static OutlineLabel label;
  public static OutlineLabel XLabel;
  public static OutlineLabel OLabel;
  
  MyPanel() {}

  public void makePanel() {
    this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
    this.addMouseListener(this);
    this.setLayout(null);

    label = new OutlineLabel(3);
    label.setFont(new Font("Comic Sans", Font.BOLD, 50));
    label.setBounds(0,0,500,500);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setOutlineColor(Color.BLACK);
    label.setForeground(Color.WHITE);

    XLabel = new OutlineLabel("X's score: 0",1);
    XLabel.setFont(new Font("Comic Sans", Font.BOLD, 12));
    XLabel.setOutlineColor(Color.BLACK);
    XLabel.setForeground(Color.WHITE);
    XLabel.setBounds(40, 0, 460, 25);

    OLabel = new OutlineLabel("O's score: 0",1);
    OLabel.setFont(new Font("Comic Sans", Font.BOLD, 12));
    OLabel.setOutlineColor(Color.BLACK);
    OLabel.setForeground(Color.WHITE);
    OLabel.setBounds(365, 0, 135, 25);
    
    this.add(label);
    this.add(OLabel);
    this.add(XLabel);
    
    int addX = 75;
    int addY = 75;
    for (int x = 0; x < 3; x++) {
      for (int y = 0; y < 3; y++) {
        imageBounds[x][y] = new Rectangle(addX, addY, IMAGE_SIZE, IMAGE_SIZE);
        addX += 135;
      }
      addX = 75;
      addY += 140;
    }

    backgroundImage = new ImageIcon("ttt.png").getImage();
    
    for (int x = 0; x < 3; x++) {
      for (int y = 0; y < 3; y++) {
        player[x][y] = new ImageIcon("white.png").getImage();
      }
    }
  }
  
  protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(backgroundImage, 0, 0, 500, 500, null);
    int addX = 75;
    int addY = 75;
    for (int x = 0; x < 3; x++) {
      for (int y = 0; y < 3; y++) {
        Image image = player[x][y];
        g2D.drawImage(image, addX, addY, IMAGE_SIZE, IMAGE_SIZE, null);
        addX += 135;
      }
      addX = 75;
      addY += 140;
    }
	}
  @Override
  public void mouseClicked(MouseEvent e) {}
  @Override
  public void mousePressed(MouseEvent e) {
    if (Main.wait == true) {
      Point point = e.getPoint();
      for (int x = 0; x < 3; x++) {
        for (int y = 0; y < 3; y++) {
          if (imageBounds[x][y].contains(point) && Main.board[x][y] == '.'){
            if (turn[Main.turncount] == PLAYER1) {
              Main.board[x][y] = PLAYER1;
              player[x][y] = new ImageIcon("lttrX.png").getImage();
            } else {
              Main.board[x][y] = PLAYER2;
              player[x][y] = new ImageIcon("lttrO.jpg").getImage();
            }
            repaint();
            Main.px = x;
            Main.py = y;
            Main.wait = false;
            break;
          }
        }
      }
    }
  }
  @Override
  public void mouseReleased(MouseEvent e) {}
  @Override
  public void mouseEntered(MouseEvent e) {}
  @Override
  public void mouseExited(MouseEvent e) {}

  public void resetGraphics() {
    for (int x = 0; x < 3; x++) {
      for (int y = 0; y < 3; y++) {
        player[x][y] = new ImageIcon("white.png").getImage();
        Main.board[x][y] = '.';
      }
    }
    label.setText("");
    repaint();
  } 
}