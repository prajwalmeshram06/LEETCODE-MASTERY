/**
 * @param {number[]} nums
 * @return {number[]}
 */
var frequencySort = function(nums) {
    let freq = new Map;
    for(let x of nums) {
        freq.set(x, (freq.get(x) || 0) + 1);
    }
    nums.sort((a, b) => {
        if (freq.get(a) === freq.get(b)) {
            return b - a;
        }
        return freq.get(a) - freq.get(b);
    });
    return nums;
};