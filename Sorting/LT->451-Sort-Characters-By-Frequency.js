/**
 * @param {string} s
 * @return {string}
 * can be done by bucket sort most optimised
 */
var frequencySort = function(s) {
    let arr = s.split('');
    let freq = new Map;
    for(let x of arr) {
        freq.set(x, (freq.get(x) || 0) + 1);
    } 
    arr.sort((a, b) => {
        if (freq.get(a) === freq.get(b)) {
            return a.localeCompare(b);
        }
        return freq.get(b) - freq.get(a);
    });
    return arr.join("");
};