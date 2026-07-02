/**
 * @param {number[]} rolls
 * @param {number} mean
 * @param {number} n
 * @return {number[]}
 */
var missingRolls = function(rolls, mean, n) {
    let sum = rolls.reduce((acc, curr) => acc + curr, 0);
    let totalSum = mean * (rolls.length + n);
    let missing = totalSum - sum;

    if (missing < n || missing > n * 6) {
        return [];
    }

    let ans = [];

    // Start with all 1s
    for (let i = 0; i < n; i++) {
        ans.push(1);
    }

    let extra = missing - n; // amount still to distribute
    let j = 0;

    while (j < n && extra > 0) {
        let add = Math.min(extra, 5); // each die can increase by at most 5
        ans[j] += add;
        extra -= add;
        j++;
    }

    return ans;
};