import java.awt.*;

public class AlgoVisualizer {
  private static int DELAY = 40;
  private AlgoFrame frame; // Visaul
  private InsertionSortData data;
  public AlgoVisualizer(int sceneWidth, int sceneHeight,int N) {
    data = new InsertionSortData(N,sceneHeight);
    EventQueue.invokeLater(()->{
      frame = new AlgoFrame("Selection sort", sceneWidth, sceneHeight);
      new Thread(()-> {
          run();
      }).start();
    });
  }
  public void run() {
    frame.render(data);
    AlgoVizHelper.pause(DELAY);
    for (int k = 0; k < data.N(); k++) {
      data.orderedIndex = k;
      for (int i = k; i>0&&data.get(i)<data.get(i-1);i-- ) {
        data.curIndex = i;
        data.swap(i,i-1);
        frame.render(data);
        AlgoVizHelper.pause(DELAY);
      }
    }
    data.orderedIndex = data.N();
    data.curIndex = -1;
    frame.render(data);
    AlgoVizHelper.pause(DELAY);
  }
  public static void main(String[] args) {
    int sceneWidth = 1000;
    int sceneHeight = 800;
    AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,100);
  }
}
