import java.awt.*;

public class AlgoVisualizer {
  private static int DELAY = 100;
  private AlgoFrame frame; // Visaul
  private MergeSortData mergeSortData;
  // private int[] tmp;
  private int N;
  public AlgoVisualizer(int sceneWidth, int sceneHeight,int N) {
    mergeSortData = new MergeSortData(N,sceneHeight);
    this.N = N;
    EventQueue.invokeLater(()->{
      frame = new AlgoFrame("Merge Sort", sceneWidth, sceneHeight);
      new Thread(()-> {
          run();
      }).start();
    });
  }
  public void run() {
    frame.render(mergeSortData);
    AlgoVizHelper.pause(DELAY);
    int[] tmp = new int[N];
    mergeSort(mergeSortData.data, 0, N-1,tmp);
    frame.render(mergeSortData);
    AlgoVizHelper.pause(DELAY);
  }
  public void mergeSort(int[] data,int start, int end,int[] tmp){
    if(start < end){
      int mid = (end+start)/2;
      int lStart = start;
      int lEnd = mid;
      int rStart = mid+1;
      int rEnd = end;
      mergeSort(data, lStart, lEnd, tmp);
      mergeSort(data, rStart, rEnd, tmp);
      int t = 0;
      int left = lStart;
      int right = rStart;
      mergeSortData.setRange(start, end);
      frame.render(mergeSortData);
      while(left<=lEnd&&right<=rEnd){
        if(data[right]>=data[left]){
          tmp[t++] = data[left++];
        }else {
          tmp[t++] = data[right++];
        }
      } 
      while(left<=lEnd){
        tmp[t++] = data[left++];
        // System.out.println(Arrays.toString(tmp));
      } 
      while(right<=rEnd){
        tmp[t++] = data[right++];
      } 
      t = 0;
      while(start <= end){
        mergeSortData.setMergeIndex(start); 
        data[start++] = tmp[t++];
        frame.render(mergeSortData);
        AlgoVizHelper.pause(DELAY);
      }
    }
  }

  public static void main(String[] args) {
    int sceneWidth = 1000;
    int sceneHeight = 800;
    AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,100);
    // merg
  }
}
