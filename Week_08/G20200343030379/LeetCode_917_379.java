package G20200343030379;

import java.util.Arrays;
import java.util.Stack;

/**
 * 917. ������ת��ĸ
 *
 * ����һ���ַ���?S������?����ת��ġ�?�ַ��������в�����ĸ���ַ���������ԭ�أ���������ĸ��λ�÷�����ת��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺"ab-cd"
 * �����"dc-ba"
 * ʾ�� 2��
 *
 * ���룺"a-bC-dEf-ghIj"
 * �����"j-Ih-gfE-dCba"
 * ʾ�� 3��
 *
 * ���룺"Test1ng-Leet=code-Q!"
 * �����"Qedo1ct-eeLg=ntse-T!"
 * ?
 *
 * ��ʾ��
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122?
 * S �в�����?\ or "
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-only-letters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * ���ⷽ����
 *  1��ջ��
 *  2������ָ��
 *
 * �ο�������⣺
 */
public class LeetCode_917_379 {

    public static void main(String[] args) {
        //ʮ����ת������
        //String s = Integer.toBinaryString(-2147483648);
        String[] s = "1       1".split(" ");
        System.out.println(s.length);
        System.out.println(Arrays.toString(s));
        for (String s1 : s) {
            System.out.println(s1+"==="+s1.length());
        }
    }

    /**
     * ִ����ʱ : 2 ms , ������ Java �ύ�л����� 31.12% ���û�
     * �ڴ����� : 38.2 MB , ������ Java �ύ�л����� 6.45% ���û�
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetter(c)){
                stack.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetter(c)){
                sb.append(stack.pop());
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * ����ָ��
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 83.51% ���û�
     * �ڴ����� : 37.8 MB , ������ Java �ύ�л����� 6.45% ���û�
     * @param S
     * @return
     */
    public String reverseOnlyLetters2(String S) {
         StringBuilder sb=new StringBuilder();
         int j= S.length()-1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetter(c)){
                //�ų�����ĸ
                while(!Character.isLetter(S.charAt(j))){
                    j--;
                }
                sb.append(S.charAt(j--));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}