import java.util.LinkedList;
import java.util.Queue;

class Solution286 {
  public void wallsAndGates(int[][] rooms) {
    Queue<int[]> gates = new LinkedList<>();
    int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

    for(int row = 0; row < rooms.length; row++){
      for(int col = 0; col < rooms[row].length; col++){
        if(rooms[row][col] == 0){
          gates.add(new int[] {row, col});
        }
      }
    }

    while(!gates.isEmpty()){
      int[] gate = gates.poll();
      int gateRow = gate[0];
      int gateCol = gate[1];

      for(int[] direction: directions){
        int roomRow = gateRow + direction[0];
        int roomCol = gateCol + direction[1];

        if(roomRow<0 || roomRow>=rooms.length || roomCol<0 ||
                roomCol >= rooms[roomRow].length || rooms[roomRow][roomCol] != Integer.MAX_VALUE){
          continue;
        } else{
          rooms[roomRow][roomCol] = Math.min(rooms[roomRow][roomCol], rooms[gateRow][gateCol]+1);
          gates.add(new int[]{roomRow, roomCol});
        }
      }
    }
  }
}