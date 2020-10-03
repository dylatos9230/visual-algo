import java.awt.*;
import java.util.Arrays;

public class AlgoVisualizer {
  private int[] money; // Data
  private AlgoFrame frame; // Visaul
  public AlgoVisualizer(int sceneWidth, int sceneHeight) {
    money = new int[100];
    for(int i = 0; i<money.length; i++){
      money[i] = 100;
    }
    
    EventQueue.invokeLater(()->{
      frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
      new Thread(()-> {
        while(true){
          run();
        }
      }).start();
    });
  }
  public void run() {
    final int DELAY = 40;
    while(true){
      Arrays.sort(money);
      frame.render(money);

      AlgoVizHelper.pause(DELAY);
      for (int k = 0; k < 50; k++) {
        
        for(int i=0; i<money.length; i++){
            int j = (int)(Math.random()*money.length);
            money[i] -= 1;
            money[j] += 1;
        }
      }
    }
  }
  public static void main(String[] args) {
    int sceneWidth = 1000;
    int sceneHeight = 800;
    AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    visualizer.run();
  }
}
