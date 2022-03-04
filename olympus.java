import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class olympus {
    public static void main(String[] args) {
        int[] nums1 = new int[5];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        nums1[3] = 0;
        nums1[4] = 0;
        nums1[5] = 0;
        int m = 3;
        int n = 3;
        int[] nums2 = new int[3];
        nums2[0] = 2;
        nums2[1] = 5;
        nums2[2] = 6;
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

    // roman to int
    public static int romantoInt(String str) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 500;
        a['M' - 'A'] = 1000;
        char prev = 'A';
        int sum = 0;
        for (char s : str.toCharArray()) {
            if (a[s - 'A'] > a[prev - 'A']) {
                sum = sum - 2 * a[prev - 'A'];
            }
            sum = sum + a[s - 'A'];
            prev = s;
        }
        return sum;

    }

    public static String longestcommonprefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
        return pre;
    }

    public static int removeDuplicates(int[] nums) {
        // nums[0,0,0,1,2,2,3]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static int removeElement(int[] nums, int val) {
        // [3,2,2,3] val=3
        // returning [2,2,3,3]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static int strStr(String haystack, String needle) {
        int n = (haystack.indexOf(needle));
        return n;
    }

    public static int searchInsert(int[] nums, int target) {
        // nums [1,3,5,6]
        // target=2;
        // output=1
        int other = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (target > nums[i]) {
                other = i + 1;
            }
        }
        return other;
    }

    public static int maxSubArray(int[] A) {
        // [-2,1,-3,4,-1,2,1,-5,4]
        int maxsofar = A[0], maxendinghere = A[0];
        for (int i = 1; i < A.length; i++) {
            maxsofar = Math.max(maxsofar + A[i], A[i]);
            maxendinghere = Math.max(maxsofar, maxendinghere);
        }
        return maxendinghere;
    }

    public static int lengthOfLastWord(String s) {
        // here is the string s
        // return the length of the last word
        // hello world
        // world with length 5
        int counter = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) != ' ') {
                counter++;
            } else {
                if (counter > 0) {
                    return counter;
                }
            }

        }
        return counter;
    }

    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static String addBinary(String a, String b) {
        // 111
        // 101
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if (carry != 0)
            res.append(carry);
        return res.reverse().toString();
    }

    public static int climbStairs(int n) {
        // base cases
        // 3 then 1+1+1, 1+2,2+1
        // 4 then 1+1+1+1, 1+2+1, 2+1+1,2+2
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }

    public static  void merge(int nums1[], int m, int nums2[], int n) {
        //m the elements that should be merged
        //last n elements are set to 0;
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];
    }
    

    public List<List<Integer>>generate(int numrows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> rows = new ArrayList<Integer>();
        for (int i = 0; i < numrows; i++) {
            rows.add(0,1);
            for (int j = 1; j < rows.size()-1; j++) {
                rows.set(j,rows.get(j)+rows.get(j+1));
                allrows.add(new ArrayList<Integer>(rows));
            }
            
        }
        return allrows;
    }
}
