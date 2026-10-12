
// class Solution {
//     public int resilientSubarray(int[] nums, int k) {
//         int currentLen = 1;
//         int maxLen = 1;
//         int n = nums.length;

//         for (int i = 1; i < n; i++) {
//             if (nums[i - 1] % k == nums[i] % k) {
//                 currentLen++;
//             } else {
//                 currentLen = 1;
//             }

//             maxLen = Math.max(currentLen, maxLen);
//         }

//         return maxLen;
//     }
// }

class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int currentLen = 1;
        int maxLen = 1;
        int n = nums.length;
        int remainder = nums[0] % k;

        for (int i = 1; i < n; i++) {
            if (nums[i] % k == remainder) {
                currentLen++;
            } else {
                int d = k / gcd(k, remainder);
                int validLen = 1 + ((currentLen - 1) / d) * d;
                maxLen = Math.max(maxLen, validLen);

                remainder = nums[i] % k;
                currentLen = 1;
            }
        }

        int d = k / gcd(k, remainder);
        int validLen = 1 + ((currentLen - 1) / d) * d;
        maxLen = Math.max(maxLen, validLen);

        return maxLen;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
