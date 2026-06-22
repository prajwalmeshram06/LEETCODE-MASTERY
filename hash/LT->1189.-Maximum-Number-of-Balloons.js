/**
 * @param {string} text
 * @return {number}
 */
var maxNumberOfBalloons = function(text) {
    let freq = new Map();
    for (let ch of text) {
        freq.set(ch, (freq.get(ch) || 0) + 1);
    }
    const b = freq.get('b') || 0;
    const a = freq.get('a') || 0;
    const l = Math.floor((freq.get('l') || 0) / 2);
    const o = Math.floor((freq.get('o') || 0) / 2);
    const n = freq.get('n') || 0;
    return Math.min(b, a, l, o, n);
};