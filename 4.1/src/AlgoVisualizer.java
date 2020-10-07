import java.awt.*;

public class AlgoVisualizer {
  private static int DELAY = 5;
  private AlgoFrame frame; // Visaul
  private SelectSortData data;
  public AlgoVisualizer(int sceneWidth, int sceneHeight,int N) {
    data = new SelectSortData(N,sceneHeight);
    System.out.println(data.toString());
    EventQueue.invokeLater(()->{
      frame = new AlgoFrame("Selection Sort", sceneWidth, sceneHeight);
      new Thread(()-> {
          run();
      }).start();
    });
  }
  public void run() {
    frame.render(data);
    AlgoVizHelper.pause(DELAY);
    for (int k = 0; k < data.N(); k++) {
      int minIndex = k;
      data.orderedIndex = minIndex;
      for (int i = k+1; i < data.N(); i++) {
        data.curIndex = i;
        if (data.get(i)<data.get(minIndex)){
          minIndex = i;
          data.hitIndex = i;
        }
        frame.render(data);
        AlgoVizHelper.pause(DELAY);
      }
      data.swap(minIndex,k);
      frame.render(data);
      AlgoVizHelper.pause(DELAY);
    }
    data.orderedIndex = data.N();
    data.curIndex = -1;
    data.hitIndex = -1;
    frame.render(data);
    AlgoVizHelper.pause(DELAY);
  }
  public static void main(String[] args) {
    int sceneWidth = 1000;
    int sceneHeight = 800;
    AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,100);
  }
}
