char slowestKey(int* releaseTimes, int releaseTimesSize, char* keysPressed) {
    int maxTime = 0;
    char maxKey = '\0';
    for(int i = 0; i < releaseTimesSize; i++) {
        int time = 0;
        char key = keysPressed[i];
        if(i == 0) {
            time = releaseTimes[0];
        } else {
            time = releaseTimes[i] - releaseTimes[i - 1];
        }

        if(maxTime < time) {
            maxTime = time;
            maxKey = key;
        } else if(maxTime == time && maxKey != key) {
            if(key > maxKey) {
                maxKey = key;
            }
        }
    }
    return maxKey;
}