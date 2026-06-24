var reportSpam = function(message, bannedWords) {
    let banned = new Set(bannedWords);

    let count = 0;

    for (let word of message) {
        if (banned.has(word)) {
            count++;
            if (count >= 2) return true;
        }
    }

    return false;
};