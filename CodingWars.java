import java.util.*;


//Question :
//There are N coders, which have to form team. For forming team, following condition needs to be satisfy. You have to find how many such teams can be formed.
//        any three coders with position(i, j, k) and rating (Ri, Rj, Rk) can form team when (Ri < Rj < Rk or Ri > Rj > Rk) and (1 <= i <= j <= k <= N)

//test 1 :
//N = 5
//Ratings : 5 2 3 1 4
//output : 3
//(5,2,1), (5,3,1), (2,3,4)




public class CodingWars {
    public static int find(List<Integer> ratings) {
        int n = ratings.size();
        int ans = 0;

        for (int j = 1; j < n - 1; j++) { 
            int a = 0, b = 0, c = 0, d = 0;

            for (int i = 0; i < j; i++) {
                if (ratings.get(i) < ratings.get(j)) 
                    a++;
                else if (ratings.get(i) > ratings.get(j)) 
                    b++;
            }

            for (int k = j + 1; k < n; k++) {
                if (ratings.get(k) > ratings.get(j)) d++;
                else if (ratings.get(k) < ratings.get(j)) c++;
            }

            ans += (a * d) + (b * c);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ratings = Arrays.asList(5, 2, 3, 1, 4);
        System.out.println(find(ratings));
    }
}
