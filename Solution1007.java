class Solution1007 {
  public int minDominoRotations(int[] tops, int[] bottoms) {
    int minRotations = Math.min(countRotations(tops[0], tops, bottoms),
            countRotations(bottoms[0], tops, bottoms));
    minRotations = Math.min(minRotations, countRotations(tops[0], bottoms, tops));
    minRotations = Math.min(minRotations, countRotations(bottoms[0], bottoms, tops));
    return minRotations==tops.length ? -1:minRotations;
  }

  public int countRotations(int value, int[] tops, int[] bottoms){
    int rotations = 0;
    for(int i=0; i<tops.length; i++){
      if(tops[i] == value){
        continue;
      } else if(bottoms[i] == value){
        rotations++;
      } else{
        return tops.length;
      }
    }

    return rotations;
  }
}