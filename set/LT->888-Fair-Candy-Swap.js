/**
 * @param {number[]} aliceSizes
 * @param {number[]} bobSizes
 * @return {number[]}
 */
var fairCandySwap = function(aliceSizes, bobSizes) {
    let aSum = aliceSizes.reduce((a, b) => a + b, 0);
    let bSum = bobSizes.reduce((a, b) => a + b, 0);
    let diff = (aSum - bSum) / 2;
    let set = new Set(aliceSizes);
    for(let x of bobSizes) {
        if(set.has(diff + x)) {
            return [diff + x, x];
        }
    }
};