package G20200343030379;

import java.util.Arrays;
import java.util.Stack;

/**
 * 205. ͬ���ַ���
 *
 * ���������ַ���?s?��?t���ж������Ƿ���ͬ���ġ�
 *
 * ���?s?�е��ַ����Ա��滻�õ�?t?����ô�������ַ�����ͬ���ġ�
 *
 * ���г��ֵ��ַ�����������һ���ַ��滻��ͬʱ�����ַ���˳�������ַ�����ӳ�䵽ͬһ���ַ��ϣ����ַ�����ӳ���Լ�����
 *
 * ʾ�� 1:
 *
 * ����: s = "egg", t = "add"
 * ���: true
 * ʾ�� 2:
 *
 * ����: s = "foo", t = "bar"
 * ���: false
 * ʾ�� 3:
 *
 * ����: s = "paper", t = "title"
 * ���: true
 * ˵��:
 * ����Լ���?s?�� t ������ͬ�ĳ��ȡ�
 *
 * ͨ������33,919�ύ����71,797
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/isomorphic-strings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *
 * �ο�������⣺
 *  1�����ȿ��������������ԭ����ͣ����ģ�
 *      https://leetcode-cn.com/problems/isomorphic-strings/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-42/
 *  2��https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution
 *  3��https://leetcode.com/problems/isomorphic-strings/discuss/57810/Short-Java-solution-without-maps
 *
 *
 *
 */
public class LeetCode_205_379 {

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
     * ִ����ʱ : 5 ms , ������ Java �ύ�л����� 92.90% ���û�
     * �ڴ����� : 40.1 MB , ������ Java �ύ�л����� 5.26% ���û�
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int[] m=new int[256];
        int[] n=new int[256];

        for (int i = 0; i < s.length(); i++) {
            char l = s.charAt(i);
            char r = t.charAt(i);
            //��ǰ��ӳ��ֵ�Ƿ���ͬ
            if(m[l]!=n[r]){
                return false;
            }else{
                //�Ƿ��Ѿ��޸Ĺ����޸Ĺ��Ͳ���Ҫ�ٴ���
                if(m[l]==0){
                    m[l]=i+1;
                }
                if(n[r]==0){
                    n[r]=i+1;
                }
            }
        }

        return true;
    }

}