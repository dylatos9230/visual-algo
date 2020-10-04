public class SelectSortData {
  private int[] data;
  public int orderedIndex = -1;
  public int curIndex = -1;
  public int hitIndex = -1;
  public SelectSortData(int N,int boundary){
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
  public String toString(){
    String dataStirng = new String();
    for (int i : data) {
      String curstring = i+",";
      dataStirng.concat(curstring);
    }
    return dataStirng;
  }
  public void setState(int orderedIndex,int curIndex,int hitIndex){
    this.orderedIndex = orderedIndex;
    this.curIndex = curIndex;
    this.hitIndex = hitIndex;
  }
}
