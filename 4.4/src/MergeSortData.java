public class MergeSortData {
  public int[] data;
  public int orderedIndex = -1;
  public int curIndex = -1;
  public int l = -1;
  public int r = -1;
  public int mergeIndex = -1;
  public MergeSortData(int N,int boundary){
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
  public int[] getData(){
    return data;
  }
  public void setRange(int l, int r){
    this.l = l;
    this.r = r;
  } 
  public void setMergeIndex(int index){
    this.mergeIndex = index;
  }
}
