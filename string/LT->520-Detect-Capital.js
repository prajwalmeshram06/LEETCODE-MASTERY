/**
 * @param {string} word
 * @return {boolean}
 */
var detectCapitalUse = function(word) {
    let iscapital = 0;

    for(let i = 0; i < word.length; i++) {
        let ch = word[i];
        if(i === 0) {
            if(ch >= 'A' && ch <= 'Z') {
                iscapital = 1;
            } else if(ch >= 'a' && ch <= 'z') {
                iscapital = 2; 
            }
        }
        if(i === 1 && ch >= 'A' && ch <= 'Z' && iscapital === 1) {
            iscapital = 3;
        }
        if(iscapital === 2 && ch >= 'A' && ch <= 'Z') {
            return false;
        }
        if(iscapital === 3 && ch >= 'a' && ch <= 'z') {
            return false;
        }
        if(iscapital === 1 && i > 0 && ch >= 'A' && ch <= 'Z') {
            return false;
        }
    }
    return true;
};