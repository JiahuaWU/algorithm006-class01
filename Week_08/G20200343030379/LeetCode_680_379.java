package G20200343030379;

import java.util.Arrays;
import java.util.Stack;

/**
 * 680. ��֤�����ַ��� ��
 * ����һ���ǿ��ַ��� s�����ɾ��һ���ַ����ж��Ƿ��ܳ�Ϊ�����ַ�����
 *
 * ʾ�� 1:
 *
 * ����: "aba"
 * ���: True
 * ʾ�� 2:
 *
 * ����: "abca"
 * ���: True
 * ����: �����ɾ��c�ַ���
 * ע��:
 *
 * �ַ���ֻ������ a-z ��Сд��ĸ���ַ�������󳤶���50000��
 *
 * ���ⷽ����
 *    ����ָ��
 *
 * �ο�������⣺
 * https://leetcode.com/problems/valid-palindrome-ii/discuss/107714/Java-solution-isPalindrome
 * https://leetcode.com/problems/valid-palindrome-ii/discuss/107716/Java-O(n)-Time-O(1)-Space
 */
public class LeetCode_680_379 {

    public static void main(String[] args) {
    }

    /**
     * ִ����ʱ : 9 ms , ������ Java �ύ�л����� 75.51% ���û�
     * �ڴ����� : 40.2 MB , ������ Java �ύ�л����� 6.67% ���û�
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        //ƥ����ͬ���������м�ƽ�
        while(l<r && s.charAt(l)==s.charAt(r)){
            l++;
            r--;
        }

        //�����򷵻�
        if(l>=r){
            return true;
        }

        //û�н�����ɾ������һ��
        return isPalin(s,l+1,r) || isPalin(s,l,r-1);

    }

    private boolean isPalin(String s, int l, int r) {
        while (l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }


    /**
     * ִ����ʱ : 7 ms , ������ Java �ύ�л����� 94.76% ���û�
     * �ڴ����� : 40.3 MB , ������ Java �ύ�л����� 6.67% ���û�
     * @param s
     * @return
     */
    public boolean validPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int l=0,r=s.length()-1;
        //ƥ����ͬ���������м�ƽ�
        while(l<r && chars[l]==chars[r]){
            l++;
            r--;
        }

        //�����򷵻�
        if(l>=r){
            return true;
        }

        //û�н�����ɾ������һ��
        return isPalin2(chars,l+1,r) || isPalin2(chars,l,r-1);

    }

    private boolean isPalin2(char[] chars, int l, int r) {
        while (l<r){
            if(chars[l]==chars[r]){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }

}