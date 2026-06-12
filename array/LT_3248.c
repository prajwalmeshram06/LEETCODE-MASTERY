int finalPositionOfSnake(int n, char** commands, int commandsSize) {
    int pos = 0;
    int k = (n * n) - 1;
    int row = 0;
    int col = 0;

    for(int i = 0; i < commandsSize; i++) {
        if(row <= n && col <= n) {
            if(strcmp(commands[i], "UP") == 0) {
                row--;
            }
            if(strcmp(commands[i], "DOWN") == 0) {
                row++;
            }
            if(strcmp(commands[i], "LEFT") == 0) {
                col--;
            }
            if(strcmp(commands[i], "RIGHT") == 0) {
                col++;
            }
        }
    }
    pos = (row * n) + col;
    return pos;
}