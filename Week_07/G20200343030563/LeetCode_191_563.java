public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //��mask���ƣ������ǲ��ϵİ�n���ƣ���Ϊ���ƶ��ڸ���ǰ��ӵ���1
        int count = 0;
        int mask = 0x1;
        for (int i = 0; i < 64; i++){
            if ((n & mask) != 0) count++;
            mask <<= 1;
        }

        return count;  
    }
}