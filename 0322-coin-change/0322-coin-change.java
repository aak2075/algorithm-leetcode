class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[100000];

        f[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            if (f[i] == -1) {
                continue;
            }

            int max = 99999999;
            int min = max;
            for (int coin : coins) {
                int lastIdx = i - coin;
                if (lastIdx < 0) {
                    continue;
                }
                if (f[lastIdx] == -1) {
                    continue;
                }
                if (f[lastIdx] < min) {
                    min = f[lastIdx];
                }
            }
            if (min == max) {
                f[i] = -1;
            } else {
                f[i] = min + 1;
            }
        }

        return f[amount];
    }
}