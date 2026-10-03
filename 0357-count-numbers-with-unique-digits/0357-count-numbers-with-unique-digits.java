class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        map.put(1, 10);
        map.put(2, 91);
        map.put(3, 739);
        map.put(4, 5275);
        map.put(5, 32491);
        map.put(6, 168571);
        map.put(7, 712891);
        map.put(8, 2345851);
        map.put(9, 5611771);
        map.put(10, 8877691);

        return map.get(n);
    }
}