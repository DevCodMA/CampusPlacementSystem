

package campus_placement_system;
import java.util.ArrayList;
/**
 *
 * @author majma
 */
public class Campus_Placement_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            
            int arr[] = {5,6,6,6,3,3,2,2,2,1,1,1,1};
            ArrayList<Integer> ls = new ArrayList<>();
            int counter = 0, j = 0;
            for(int i=0; i < arr.length; i++){
                if(!ls.contains(arr[i])){
                    ls.add(arr[i]);
                }
            }
            System.err.println(ls);
        
    }
    
}
