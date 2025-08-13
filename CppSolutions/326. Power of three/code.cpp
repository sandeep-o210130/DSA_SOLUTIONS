// There is simple math
// Logic:- any prime number divided by itself gives  modulus 0. 
// So we find the largest power of 3 that is less than or equal to INT_MAX.
// Then we check if that number is divisible by n, if it is then n is a power of three.


class Solution {
public:
    bool isPowerOfThree(int n) {
        if(n<=0)
            return false;
        int e = log(INT_MAX)/log(3);
        int N = (int) pow(3,e);
        return N%n==0;
    }
};