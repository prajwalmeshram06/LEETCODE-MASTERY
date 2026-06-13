char* mapWordWeights(char** words, int wordsSize, int* weights, int weightsSize) {
    char ch = 122;
    int k =0;
    char *result = (char *)malloc((wordsSize + 1) * sizeof(char));
    int weightIdx = 0;

    for (int i = 0; i < wordsSize; i++) {
        int sum = 0;
        int charIdx = 0;

        while (words[i][charIdx] != '\0') {
            sum += weights[words[i][charIdx] - 'a'];
            charIdx++;
        }
        sum = sum % 26;
        ch -= sum;
        result[k] = ch;
        k++;
        ch = 122;
    }
    result[k] = '\0';
    return result;
}