class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> subset = new ArrayList<>();

        if(n < 2 || s < 2) {
            return subset;
        }

        int st = 2;

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int p = 2; p * p <= n; p++) {
            if(isPrime[p]) {
                for(int i = p * p; i <= n; i+= p) {
                    isPrime[i] = false;
                }
            }
        }

        long currentSum = 0;

        for(int i = 2; i <= n; i++) {
            if(isPrime[i]) {
                if(currentSum + i <= s) {
                    subset.add(i);
                    currentSum += i;
                } else {
                    break;
                }
            }
        }
        

        return subset;
    }
}