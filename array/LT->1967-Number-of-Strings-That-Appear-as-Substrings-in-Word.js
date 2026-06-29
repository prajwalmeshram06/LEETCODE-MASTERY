/**
 * @param {string[]} patterns
 * @param {string} word
 * @return {number}
 */
var numOfStrings = function(patterns, word) {
    let count = 0;
    for(let x of patterns) {
        if(word.includes(x)) {
            count++;
        }
    }
    return count;
};