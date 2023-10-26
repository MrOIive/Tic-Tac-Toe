import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements KeyListener {
  MyPanel panel;
  
  MyFrame() {

    panel = new MyPanel();
    panel.makePanel();
    
    this.setTitle("Tic-Tac-Toe");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500,500);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setIconImage(new ImageIcon("iconttt.png").getImage());
    this.addKeyListener(this);
    this.add(panel);
    this.pack();
    this.setVisible(true);
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {
    if (Main.restart = true)
      switch (e.getKeyCode()) {
        case KeyEvent.VK_R: Main.restart = false;
          break;
      }
  }
}