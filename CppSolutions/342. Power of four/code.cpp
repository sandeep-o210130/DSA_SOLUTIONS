// This is same like the Power of Two problem, but with a different condition for powers of four.
// A number is a power of four if it is a power of two and the number of trailing zeros in its binary representation is even.
// We can also use the property that a power of four modulo 3 is always 1

class Solution {
public:
    bool isPowerOfFour(int n) {
        return n>0 && (n&(n-1))==0 && n%3==1;
    }
};