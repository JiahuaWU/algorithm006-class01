package G20200343030379;

import javafx.concurrent.Worker;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 151. ��ת�ַ�����ĵ���
 *
 * ����һ���ַ����������ת�ַ����е�ÿ�����ʡ�
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ����: "the sky is blue"
 * ���:?"blue is sky the"
 * ʾ�� 2��
 *
 * ����: " ?hello world! ?"
 * ���:?"world! hello"
 * ����: �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
 * ʾ�� 3��
 *
 * ����: "a good ? example"
 * ���:?"example good a"
 * ����: ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 * ?
 *
 * ˵����
 *
 * �޿ո��ַ�����һ�����ʡ�
 * �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
 * ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-words-in-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * ����1����֣���ת�����
 * ����2����ת����ַ�����������תÿ������
 * �ο�������⣺�ٷ����
 */
public class LeetCode_151_379 {

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
     * ִ����ʱ : 7 ms , ������ Java �ύ�л����� 42.16% ���û�
     * �ڴ����� : 40 MB , ������ Java �ύ�л����� 5.15% ���û�
     * �ο����ٷ�
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split(" +");
        Collections.reverse(Arrays.asList(split));
        return String.join(" ",split);
    }

    /**
     * ˫�˶���
     * ִ����ʱ : 7 ms , ������ Java �ύ�л����� 42.16% ���û�
     * �ڴ����� : 39.9 MB , ������ Java �ύ�л����� 5.15% ���û�
     * �ο����ٷ�
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s=s.trim();

        int left=0,right=s.length()-1;
        Deque<String> deque=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();

        while (left<=right){
            char c = s.charAt(left);
            if(c!=' '){
                sb.append(c);
            }else if(c==' ' && sb.length()!=0){
                deque.addFirst(sb.toString());
                sb.setLength(0);
            }

            left++;
        }
        deque.addFirst(sb.toString());

        return String.join(" ",deque);
    }


    /**
     * ������������漰���ϣ�ֻ�����飬Ч������
     *
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 39.7 MB , ������ Java �ύ�л����� 5.15% ���û�
     * �ο����ο����а����
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        s=s.trim();
        //ʹ��������ʽ��Ч�ʻ���һ����
        //String[] split = s.split(" +");
        String[] split = s.split(" ");
        StringBuilder sb=new StringBuilder();

        for (int i = split.length-1; i >=0; i--) {
            if(!split[i].equals("")){
                sb.append(split[i]).append(' ');
            }
        }

        return sb.toString().trim();
    }
}