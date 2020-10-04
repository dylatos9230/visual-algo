import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;
import java.util.LinkedList;


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
  private Circle circle;
  private LinkedList<Point> points;

  public void render(Circle circle, LinkedList<Point> points) {
    this.circle = circle;
    this.points = points;
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
      
      AlgoVizHelper.setStrokeWidth(g2d, 3);
      AlgoVizHelper.setColor(g2d, AlgoVizHelper.Blue);
      AlgoVizHelper.strokeCircle(g2d, circle.getX(), circle.getY(), circle.getR());

      for(int i = 0; i<points.size(); i++){
        Point p = points.get(i);
        if(circle.contain(p))
          AlgoVizHelper.setColor(g2d, AlgoVizHelper.Red);
        else  
          AlgoVizHelper.setColor(g2d, AlgoVizHelper.Green);
        AlgoVizHelper.fillCircle(g2d, p.x, p.y, 3);
      }
    }
    @Override
    public Dimension getPreferredSize() {
      return new Dimension(canvasWidth,canvasHeight);
    }
  }
}
