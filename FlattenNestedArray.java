import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FlattenNestedArray {
    public static List<Object> flatten(List<Object> list, int n) {
		int current = 0;
		List<Object> ans = new ArrayList<>();
        for(Object o : list){
			System.out.println(o);
		}
		solve(list, ans, n, current);
		return ans;
    }

	public static void solve(List<?> list, List<Object> ans, int n, int current){	
			for(int i=0; i<list.size(); i++){
				Object obj = list.get(i);
				if(obj instanceof List<?> && n > current){
					++current;
					solve((List<?>)obj, ans, n, current);
					--current;
				} else {
					ans.add(obj);
				}
			}
	}

    public static void main(String[] args) {
        List<Object> arr = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, Arrays.asList(9, 10, 11), 12), Arrays.asList(13, 14, 15));
        List<Object> flattenedArray = flatten(arr, 2);
        System.out.println("Answer is : " + flattenedArray); // Output: [1, 2, 3, 4, 6, 7, 8]
    }
}
