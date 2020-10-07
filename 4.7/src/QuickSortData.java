public class QuickSortData {
  public int[] data;
  public int orderedIndex = -1;
  public int curIndex = -1;
  public int pivot = -1;
  public int smallerIndex  = -1;
  public int lo = -1;
  public int hi = -1;
  public QuickSortData(int N,int boundary){
    data = new int[N];
    for (int i = 0; i < N; i++) {
      data[i] = (int)(Math.random()*boundary)+1;
    }
    lo = N;
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
  public void setStatus(int curIndex,int pivot, int smallerIndex,int lo,int hi){
    this.curIndex = curIndex;
    this.pivot = pivot;
    this.smallerIndex = smallerIndex;
    if(hi>=this.hi){
      this.hi = hi;
    }
    if(lo<this.lo){
      this.lo = lo;
    }
  }
  public void setStatus(int curIndex,int pivot, int smallerIndex){
    this.curIndex = curIndex;
    this.pivot = pivot;
    this.smallerIndex = smallerIndex;
  }
}
