package G20200343030379;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *438. �ҵ��ַ�����������ĸ��λ��
 * ����һ���ַ��� s ��һ���ǿ��ַ��� p���ҵ� s �������� p ����ĸ��λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ������
 *
 * �ַ���ֻ����СдӢ����ĸ�������ַ��� s �� p �ĳ��ȶ������� 20100��
 *
 * ˵����
 *
 * ��ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
 * �����Ǵ������˳��
 * ʾ�� 1:
 *
 * ����:
 * s: "cbaebabacd" p: "abc"
 *
 * ���:
 * [0, 6]
 *
 * ����:
 * ��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����ĸ��λ�ʡ�
 * ��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����ĸ��λ�ʡ�
 *  ʾ�� 2:
 *
 * ����:
 * s: "abab" p: "ab"
 *
 * ���:
 * [0, 1, 2]
 *
 * ����:
 * ��ʼ�������� 0 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
 * ��ʼ�������� 1 ���Ӵ��� "ba", ���� "ab" ����ĸ��λ�ʡ�
 * ��ʼ�������� 2 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
 *
 * ���ⷽ����
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/javayou-hua-labuladongda-lao-hua-dong-chuang-kou-t/
 *
 * �ο�������⣺
 */
public class LeetCode_438_379 {

    public static void main(String[] args) {
    }


    /**
     * ִ����ʱ : 32 ms , ������ Java �ύ�л����� 45.14% ���û�
     * �ڴ����� : 41.3 MB , ������ Java �ύ�л����� 5.88% ���û�
     *
     * ��⣺https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
     * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/javayou-hua-labuladongda-lao-hua-dong-chuang-kou-t/
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        Queue<Integer> res=new LinkedList<>();
        int left=0,right=0;
        Map<Character,Integer> window=new HashMap<>();
        Map<Character,Integer> need=new HashMap<>();

        //��ʼ����λ��
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);
        }

        int match=0;
        while (right<s.length()){
            //����Ƿ�����λ��ƥ��
            char c = s.charAt(right);
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);

                //���ִ�����ͬ��ƥ��+1
                if(need.get(c).equals(window.get(c))){
                    match++;
                }
            }

            right++;

            //������λ��
            while (match==need.size()){
                if((right-left)==p.length()){
                    res.add(left);
                }

                char c1 = s.charAt(left);
                if(need.containsKey(c1)){
                    //�Ƴ���ߵ�ֵ
                    window.put(c1,window.get(c1)-1);
                    if(window.get(c1)<need.get(c1)){
                        match--;
                    }
                }
                left++;
            }

        }
        return new ArrayList<>(res);
    }

    /**
     * ���鷨��⣺https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/javayou-hua-labuladongda-lao-hua-dong-chuang-kou-t/
     *
     * ִ����ʱ : 7 ms , ������ Java �ύ�л����� 91.64% ���û�
     * �ڴ����� : 40.8 MB , ������ Java �ύ�л����� 5.88% ���û�
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int[] windows =new int[26];
        int[] needs = new int[26];
        List<Integer> res=new ArrayList<>();

        for (char c : p.toCharArray()) {
            int ci=c - 'a';
            needs[ci]++;
        }

        int left=0,right=0,total=p.length();
        while (right < s.length()){
            int cr = s.charAt(right) - 'a';
            //ƥ����
            if(needs[cr]>0){
                windows[cr]++;
                if(windows[cr]<=needs[cr]){
                    total--;
                }
                //System.out.println(Arrays.toString(windows)+"=="+total+"right");
            }


            while (total==0){
                if(right - left + 1  == p.length()){
                    res.add(left);
                }
                int cl = s.charAt(left) - 'a';
                if(needs[cl]>0){
                    windows[cl] --;
                    if(windows[cl] < needs[cl]){
                        total++;
                    }
                    //System.out.println(Arrays.toString(windows)+"=="+total+"left");

                }
                left++;
            }
            right ++;
        }

        return res;
    }


    /**
     * Ĭд�棬�������Ż�
     * ִ����ʱ : 7 ms , ������ Java �ύ�л����� 91.64% ���û�
     * �ڴ����� : 40.8 MB , ������ Java �ύ�л����� 5.88% ���û�
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams3(String s, String p) {
        int[] windows=new int[26];
        int[] needs=new int[26];
        List<Integer> res=new ArrayList<>();
        int left=0,right=0,total=p.length();
        for (int i = 0; i < p.length(); i++) {
            int c=p.charAt(i)-'a';
            needs[c]++;
        }


        while (right<s.length()){
            int cr=s.charAt(right)-'a';
            if(needs[cr]>0){
                windows[cr]++;
                if(windows[cr]<=needs[cr]){
                    total--;
                }

            }


            while (total == 0){
                if(right-left+1 == p.length()){
                    res.add(left);
                }
                int cl = s.charAt(left)-'a';
                if(needs[cl]>0){
                    windows[cl]--;
                    if(windows[cl]<needs[cl]){
                        total++;
                    }
                }

                left++;
            }

            right++;
        }

        return res;

    }

}