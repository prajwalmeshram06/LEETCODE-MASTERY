/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include<stdio.h>
#include<stdlib.h>
int* separateDigits(int* nums, int numsSize, int* returnSize) {
    int k = 0;
    char str[1000];
    int total = 0;

    for(int i = 0; i < numsSize; i++) {
        snprintf(str, sizeof(str), "%d", nums[i]);
        total += strlen(str);
    }

    int *result = malloc(total * sizeof(int));
    for(int i = 0; i < numsSize; i++) {
        snprintf(str, sizeof(str), "%d", nums[i]);
        for(int j = 0; str[j] != '\0'; j++) {
            result[k] = str[j] - '0';
            k++;
        }
    }
    (*returnSize) = k;
    return result;
}