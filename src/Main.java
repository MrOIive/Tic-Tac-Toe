public class Main { 
  static int P1SCORE = 0;
  static int P2SCORE = 0;
  static int turncount = 0;
  static char[] turn = { 'O', 'X'};
  static char PLAYER1 = 'X';
  static char PLAYER2 = 'O';
  static boolean GAMEOVER = false;
  public static boolean wait = false;
  public static int px;
  public static int py;
  public static boolean restart = false;
  static char[][] board = { { '.', '.', '.'}, { '.', '.', '.'}, { '.', '.', '.'} };
    
  public static void start() {
    
    turncount = 0;
    
    while (!GAMEOVER) {
        turncount++;
        turncount = turncount % 2;
        wait = true;
        while (true) {
          System.out.print("");
          if (!wait) {
            break;
          }
        }
        int row = 0;
        int col = 0;
        int diag = 0;
        int rdiag = 0;
      
        for (int i = 0; i < 3;  i++) {
          if (board[px][i] == turn[turncount]) {
            col++;
          } 
          if (board[i][py] == turn[turncount]) {
            row++;
          }
          if (board[i][i] == turn[turncount]) {
            diag++;
          }  
          if (board[i][3-(i+1)] == turn[turncount]) {
            rdiag++;
          } 
        }
      
        if (row == 3 || col == 3 || diag == 3 || rdiag == 3) {
          GAMEOVER = true;
          MyPanel.label.setText(turn[turncount] + " WINS");
          if (PLAYER1 == turn[turncount]) {
            P1SCORE++;
          } else {
            P2SCORE++;
          }
          MyPanel.XLabel.setText("X's score: " + Main.P1SCORE);
          MyPanel.OLabel.setText("O's score: " + Main.P2SCORE);
          restart = true;
          while (true) {
            System.out.print("");
            if (!restart) {
              break;
            }
          }
          GAMEOVER = false;
          new MyPanel().resetGraphics();
          start();
        } else {

          int noDot = 0;
          for (int i = 0; i < 3; i++) {
            for (int j = 0;j < 3; j++) {
              if (board[i][j] != '.') {
                noDot++;
              }
            }
          }
          if (noDot == 9) {
            GAMEOVER = true;
            MyPanel.label.setText("TIES GAME");
            restart = true;
            while (true) {
              System.out.print("");
              if (!restart) {
                break;
              }
            } 
            GAMEOVER = false;
            new MyPanel().resetGraphics();
            start();
          }
        }         
      }
    }   
  public static void main(String[] args) {
    new MyFrame();
    start();
  }
} 