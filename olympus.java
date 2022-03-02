import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class olympus {
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 0;
        nums[1] = 9;
        nums[2] = 9;
        int[] marker = plusOne(nums);
        System.out.println(Arrays.toString(marker));

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
        for (int i = 0; i < A.length; i++) {
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
}
