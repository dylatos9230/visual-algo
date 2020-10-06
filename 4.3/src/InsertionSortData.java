public class InsertionSortData {
  private int[] data;
  public int orderedIndex = -1;
  public int curIndex = -1;
  public InsertionSortData(int N,int boundary){
    data = new int[N];
    for (int i = 0; i < N; i++) {
      data[i] = (int)(Math.random()*boundary)+1;
    }
  }
  public int N(){
    return data.length;
  }
  public int get(int i){
    if(i<0||i>data.length){
      throw new IllegalArgumentException("Invalid index to access Sort data");
    }
    return data[i];
  }

  public void swap(int i, int j){
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }
}
