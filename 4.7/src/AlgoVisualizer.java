import java.awt.*;
import java.util.Arrays;

public class AlgoVisualizer {
  private static int DELAY = 40;
  private AlgoFrame frame; // Visaul
  private QuickSortData quickSortData;
  public AlgoVisualizer(int sceneWidth, int sceneHeight,int N) {
    // System.out.println(pi);
    quickSortData = new QuickSortData(N,sceneHeight);
    // quickSort(quickSortData.data, 0, quickSortData.N()-1);
    // System.out.println(Arrays.toString(quickSortData.data));
    EventQueue.invokeLater(()->{
      frame = new AlgoFrame("Quick Sort", sceneWidth, sceneHeight);
      new Thread(()-> {
          run();
      }).start();
    });
  }
  public void run() {
    frame.render(quickSortData);
    AlgoVizHelper.pause(DELAY);
    // for (int k = 0; k < data.N(); k++) {
    //   data.orderedIndex = k;
    //   for (int i = k; i>0&&data.get(i)<data.get(i-1);i-- ) {
    //     data.curIndex = i;
    //     data.swap(i,i-1);
    //     frame.render(data);
    //     AlgoVizHelper.pause(DELAY);
    //   }
    // }
    // data.orderedIndex = data.N();
    // data.curIndex = -1;
    // frame.render(data);
    // AlgoVizHelper.pause(DELAY);
    quickSort(quickSortData.data, 0, quickSortData.N()-1);
  }
  private void quickSort(int[] data, int lo,int hi){
    if(lo<hi){
      int curPi = partition(data, lo, hi);
      // System.out.println(curPi);
      // System.out.println(lo);
      // System.out.println(hi);
      // System.out.println("+++++++++++++");
      quickSort(data, lo, curPi-1);
      quickSort(data, curPi+1, hi);
      quickSortData.setStatus(-1, -1, -1, lo, hi);
      frame.render(quickSortData);
      AlgoVizHelper.pause(200);
    }
    
  }
  private int partition(int[] data, int lo,int hi){
    int pi = data[hi];

    int curIndex = lo;
    int smaller = lo;
    while(smaller<=hi){
      if(data[smaller]<=pi){
        quickSortData.swap(curIndex, smaller);
        quickSortData.setStatus(curIndex, hi, smaller);
        frame.render(quickSortData);
        AlgoVizHelper.pause(DELAY);
        if(smaller < hi){
          curIndex++;
          quickSortData.setStatus(curIndex, hi, smaller);
          frame.render(quickSortData);
          AlgoVizHelper.pause(DELAY);
        }
      }
      smaller++;
      quickSortData.setStatus(curIndex, hi, smaller);
      frame.render(quickSortData);
      AlgoVizHelper.pause(DELAY);
    }
    return curIndex;
  }
  public static void main(String[] args) {
    int sceneWidth = 1000;
    int sceneHeight = 800;
    AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,100);
  }
}
