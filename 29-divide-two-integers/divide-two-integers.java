class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case: -2^31 / -1 = 2^31 (exceeds 2^31 - 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Use long to prevent overflow during absolute value conversion
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Bit manipulation to find how many times divisor fits in dividend
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int count = 1;
            
            // Double the divisor as much as possible without exceeding dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                count <<= 1;
            }

            absDividend -= tempDivisor;
            quotient += count;
        }

        return isNegative ? -quotient : quotient;
    }
}
