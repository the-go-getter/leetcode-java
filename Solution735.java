import java.util.Stack;

class Solution735 {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> survivors = new Stack<>();
    for(int asteroid: asteroids){
      if(asteroid > 0 || survivors.isEmpty()){
        survivors.push(asteroid);
      } else if(asteroid < 0){
        while(!survivors.isEmpty()){
          int survivor = survivors.pop();
          if(survivor < 0){
            survivors.push(survivor);
            survivors.push(asteroid);
            break;
          } else if(survivor + asteroid > 0){
            survivors.push(survivor);
            break;
          } else if(survivor + asteroid == 0){
            break;
          } else if((survivor + asteroid < 0) && survivors.isEmpty()){
            survivors.push(asteroid);
            break;
          }
        }
      }
    }


    int[] result = new int[survivors.size()];
    int index = survivors.size()-1;
    while(!survivors.isEmpty()){
      result[index--] = survivors.pop();
    }
    return result;
  }
}
