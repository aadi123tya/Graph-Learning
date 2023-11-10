import java.util.*;
class practice {
  

    public static boolean isReach(int sx, int sy, int fx, int fy, int t, int dt,HashMap<Integer,HashMap<Integer,boolean>> hm ) {
        if (t < dt) return false;
         if(hm.containsKey(sx)&&hm.get(sx).containsKey(sy))return hm.get(sx).get(sy);
        if (sx == fx && sy == fy && dt <= t) return true;
       
        boolean top = isReach(sx - 1, sy, fx, fy, t, dt + 1);
        boolean left = isReach(sx, sy - 1, fx, fy, t, dt + 1);
        boolean right = isReach(sx, sy + 1, fx, fy, t, dt + 1);
        boolean bottom = isReach(sx + 1, sy, fx, fy, t, dt + 1);
        
        
        boolean x = isReach(sx + 1, sy+1, fx, fy, t, dt + 1);
        boolean y = isReach(sx - 1, sy-1, fx, fy, t, dt + 1);
        boolean z = isReach(sx + 1, sy-1, fx, fy, t, dt + 1);
        boolean k = isReach(sx - 1, sy+1, fx, fy, t, dt + 1);
        if (top || left || right || bottom||x||y||z||k){
            hm.put(sx,new HashMap<>());
            hm.get(sx).put(sy,true);
            return true;}
            hm.put(sx,new HashMap<>());
            hm.get(sx).put(sy,false);
        return false;
    }

    public static  boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        HashMap<Integer,HashMap<Integer,Boolean>> hm = new HashMap<>();
        return isReach(sx, sy, fx, fy, t, 0,hm);
    }
}
