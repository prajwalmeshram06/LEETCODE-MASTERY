/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
 int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}
int* sortedSquares(int* nums, int numsSize, int* returnSize) {
    int *result = (int *)malloc(numsSize * sizeof(int));
    int k = 0;
    (*returnSize) = numsSize;
    for(int i = 0; i < numsSize; i++) {
        result[k] = nums[i] * nums[i];
        k++;
    }
    qsort(result, k, sizeof(int), compare);
    return result;
}