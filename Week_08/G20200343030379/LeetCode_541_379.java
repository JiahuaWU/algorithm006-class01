package G20200343030379;

import java.util.HashMap;
import java.util.Map;

/**
 * 541. ��ת�ַ��� II
 *
 * ����һ���ַ�����һ������ k������Ҫ�Դ��ַ�����ͷ�����ÿ�� 2k ���ַ���ǰk���ַ����з�ת�����ʣ������ k ���ַ�
 * ����ʣ�������ȫ����ת�������С�� 2k �����ڻ���� k ���ַ�����תǰ k ���ַ�������ʣ����ַ�����ԭ����
 *
 * ʾ��:
 *
 * ����: s = "abcdefg", k = 2
 * ���: "bacdfeg"
 * Ҫ��:
 *
 * ���ַ���ֻ����Сд��Ӣ����ĸ��
 * �����ַ����ĳ��Ⱥ� k ��[1, 10000]��Χ�ڡ�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-string-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ⷨ��
 *  1��������
 *  2��
 *
 * �ο�������⣺
 */
public class LeetCode_541_379 {

    public static void main(String[] args) {
        //ʮ����ת������
        //String s = Integer.toBinaryString(-2147483648);
        new LeetCode_541_379().reverseStr("abcdefg",2);
    }

    /**
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 97.69% ���û�
     * �ڴ����� : 40 MB , ������ Java �ύ�л����� 5.97% ���û�
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int start=0;
        for (int i = 0; i < chars.length; i=i+2*k) {
            //int end=chars.length>i+k-1?i+k-1:chars.length-1;
            //����д��
            int end=Math.min(i+k-1,chars.length-1);
            start=i;

            while (end>start){
                char temp=chars[end];
                chars[end]=chars[start];
                chars[start]=temp;
                start++;
                end--;
            }
        }

        return new String(chars);


    }


    /**
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 97.73% ���û�
     * �ڴ����� : 39.7 MB , ������ Java �ύ�л����� 6.35% ���û�
     * @param s
     * @param k
     * @return
     */
    public String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i=k*2+i) {
            int start=i;
            int end=Math.min(chars.length-1,k+i-1);

            while (start<end){
                char temp=chars[end];
                chars[end--]=chars[start];
                chars[start++]=temp;
            }
        }
        return new String(chars);
    }

}