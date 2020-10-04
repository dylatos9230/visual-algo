import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class AlgoVisualizer {
  private static int DELAY = 40;
  private Circle circle;
  private LinkedList<Point> points;
  private int insideCircle;
  private AlgoFrame frame; // Visaul
  private int N;
  public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
    this.N = N;
    if(sceneHeight!=sceneWidth)
      throw new IllegalArgumentException("This demo must be run in a square!");
    circle = new Circle(sceneWidth/2,sceneHeight/2,sceneWidth/2);
    points = new LinkedList<Point>();

    
    EventQueue.invokeLater(()->{
      frame = new AlgoFrame("get Pi with Monte Carlo", sceneWidth, sceneHeight);
      new Thread(()-> {
        while(true){
          run();
        }
      }).start();
    });
  }
  public void run() {
    while(true){
      for (int k = 0; k < N; k++) {
        int circleArea = insideCircle;
        int squareArea = points.size();
        
        double piEstimation =4* (double) circleArea/ squareArea;
        System.out.println(piEstimation);
        for(int i=0; i<5000; i++){
          int x = (int)(Math.random() * frame.getCanvasWidth());
          int y = (int)(Math.random() * frame.getCanvasHeight());

          Point p = new Point(x,y);
          points.add(p);
          if(circle.contain(p)){
            insideCircle++;
          }
        }
        frame.render(circle,points);
        AlgoVizHelper.pause(DELAY);
      }
    }
  }
  public static void main(String[] args) {
    int sceneWidth = 800;
    int sceneHeight = 800;
    int N = 10000;
    AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,N);
    visualizer.run();
  }
}
