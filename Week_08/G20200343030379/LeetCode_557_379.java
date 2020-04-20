package G20200343030379;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

/**
 * 557. ��ת�ַ����еĵ��� III
 *
 * ����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��
 *
 * ʾ��?1:
 *
 * ����: "Let's take LeetCode contest"
 * ���: "s'teL ekat edoCteeL tsetnoc"?
 * ע�⣺���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 */
public class LeetCode_557_379 {

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
     * �����෴ת��
     * ִ����ʱ : 6 ms , ������ Java �ύ�л����� 83.13% ���û�
     * �ڴ����� : 40.4 MB , ������ Java �ύ�л����� 5.75% ���û�
     * �ο����ٷ����
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] sp = s.trim().split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < sp.length; i++) {
            sb.append(new StringBuffer(sp[i]).reverse()+" ");
        }
        return sb.toString().trim();
    }

    /**
     * �ֶ�������
     * ִ����ʱ : 3 ms , ������ Java �ύ�л����� 99.49% ���û�
     * �ڴ����� : 39.9 MB , ������ Java �ύ�л����� 5.75% ���û�
     * �ο����ύ�ٶȴ������а� https://leetcode-cn.com/submissions/detail/61114549/
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int start=0,end=0;
        while (end<s.length()){
            //���� �����žͲ�Ҫ��˫���ţ�ʱ�临�ӶȲ�һ��
            end = s.indexOf(' ', start);
            if(end<=0){
                end=s.length();
            }

            resver(chars,start,end-1);
            start=end+1;
        }
        return new String(chars);
    }

    public void resver(char[] c,int i,int j){
        while (i<j){
            char temp=c[i];
            c[i++]=c[j];
            c[j--]=temp;
        }
    }
}