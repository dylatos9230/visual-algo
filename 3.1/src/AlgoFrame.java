import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;


public class AlgoFrame extends JFrame {
  private final int canvasWidth;
  private final int canvasHeight;

  
  public AlgoFrame (final String title, final int canvasWidth, final int canvasHeight ) {
    super(title);
    this.canvasHeight = canvasHeight;
    this.canvasWidth = canvasWidth;
    AlogCanvas canvas = new AlogCanvas();
    setContentPane(canvas);
    pack();

    setSize(canvasWidth, canvasHeight);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setVisible(true);
  }
  public AlgoFrame (final String title){
    this(title, 1024,768);
  }


  public int getCanvasWidth() {
    return canvasWidth;
  }
  
  public int getCanvasHeight() {
    return canvasHeight;
  }
  private int[] money;
  public void render(int[] money) {
    this.money = money;
    this.repaint();
  }
  public class AlogCanvas extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g;
      // anti-alising
      RenderingHints hints = new RenderingHints(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON
      );
      hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

      g2d.addRenderingHints(hints);
      AlgoVizHelper.setColor(g2d, AlgoVizHelper.Blue);
      int w = canvasWidth/money.length;
      for(int i = 0; i<money.length; i++){
        if(money[i] > 0) {
          AlgoVizHelper.setColor(g2d, AlgoVizHelper.Blue);
          AlgoVizHelper.fillRectangle(g2d,
                  i * w + 1, canvasHeight / 2 - money[i], w - 1, money[i]);
      }
      else{
        AlgoVizHelper.setColor(g2d, AlgoVizHelper.Red);
        AlgoVizHelper.fillRectangle(g2d,
                  i * w + 1, canvasHeight / 2, w - 1, -money[i]);
      }
      }

    }
    @Override
    public Dimension getPreferredSize() {
      return new Dimension(canvasWidth,canvasHeight);
    }
  }
}
