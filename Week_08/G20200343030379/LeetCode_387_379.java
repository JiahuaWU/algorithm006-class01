package G20200343030379;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 387. �ַ����еĵ�һ��Ψһ�ַ�
 *
 * ����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��
 *
 * ����:
 *
 * s = "leetcode"
 * ���� 0.
 *
 * s = "loveleetcode",
 * ���� 2.
 * ?
 *
 * ע����������Լٶ����ַ���ֻ����Сд��ĸ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * ����1��������
 * ����2����ϣ��
 * ����3�������ϣ��
 * �ο�������⣺�ٷ����
 */
public class LeetCode_387_379 {

    public static void main(String[] args) {
        //ʮ����ת������
        //String s = Integer.toBinaryString(-2147483648);
        new LeetCode_387_379().firstUniqChar2("leetcode");

    }

    /***
     * ִ����ʱ : 35 ms , ������ Java �ύ�л����� 47.67% ���û�
     * �ڴ����� : 39.8 MB , ������ Java �ύ�л����� 5.05% ���û�
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c)==1){
                return i;
            }
        }
        return -1;

       /* //Ҫ��������������������ֵ
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getValue());
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;*/

    }

    /**
     * ִ����ʱ : 7 ms , ������ Java �ύ�л����� 87.65% ���û�
     * �ڴ����� : 40.1 MB , ������ Java �ύ�л����� 5.05% ���û�
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        int[] nums=new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            nums[c-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(nums[c-'a']==1){
                return i;
            }
        }
        return -1;

    }
}