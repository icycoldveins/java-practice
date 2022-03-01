import java.net.http.HttpResponse.BodyHandler;
import java.util.Arrays;
import java.util.LinkedList;

public class olympus {
    public static void main(String[] args) {
        String s="III";
        int mars=romantoInt(s);
        System.out.println(mars);

    }

    // given an array return the two sums
    public static int[] twoSum(int[] nums, int target) {
        int[] marker = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    marker[0] = i;
                    marker[1] = j;
                    return marker;
                }
            }
        }
        return marker;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (x == res || x == res / 10);
    }

    //
    public static int romantoInt(String str) {
        int[]a=new int[26];
        a['I'-'A']=1;
        a['V'-'A']=5;
        a['X'-'A']=10;
        a['L'-'A']=50;
        a['C'-'A']=500;
        a['M'-'A']=1000;
        char prev='A';
        int sum=0;
        for(char s: str.toCharArray()){
            if(a[s-'A']>a[prev-'A']){
                sum=sum-2*a[prev-'A'];
            }
            sum=sum+a[s-'A'];
            prev=s;
        }
    
        


        return sum;
    }
}
