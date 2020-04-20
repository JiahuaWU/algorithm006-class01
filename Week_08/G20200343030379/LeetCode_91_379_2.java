package G20200343030379;

import java.util.Arrays;

/**
 * 91. ���뷽��
 *
 * һ��������ĸ?A-Z ����Ϣͨ�����·�ʽ�����˱��룺
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * ����һ��ֻ�������ֵķǿ��ַ������������뷽����������
 *
 * ʾ�� 1:
 *
 * ����: "12"
 * ���: 2
 * ����:?�����Խ���Ϊ "AB"��1 2������ "L"��12����
 * ʾ��?2:
 *
 * ����: "226"
 * ���: 3
 * ����:?�����Խ���Ϊ "BZ" (2 26), "VF" (22 6), ���� "BBF" (2 2 6) ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/decode-ways
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 */
public class LeetCode_91_379_2 {
    public static void main(String[] args) {
        new LeetCode_91_379_2().numDecodings2("126");
    }
    //��̬�滮 ���ҵ���
    /**
     * dp[i]=dp[i+1]+dp[i+2]
     *
     * ���룺1212
     * 2
     * 12
     * 212= 2 12
     * 1212=1 212�� 12 12
     *
     * 0:������
     * <=26  dp[i]=dp[i+1]+dp[i+2]
     * >26  dp[i]=dp[i+1]
     *
     *
     * /**
     * �������Ϊ7������Ȼ��1��7->G
     * ���Ϊ67������Ȼ����1��67->FG
     * ���Ϊ067�����Ϊ0��
     * ���Ϊ2067�� ���ΪnumDecodings��20 67��+ numDecodings��2 067��= numDecodings��20 67��->TFG
     * ���Ϊ22067�� ���ΪnumDecodings��2 2067��+ numDecodings��22 067��= numDecodings��2 2067��->BTFG
     *
     * ���ߣ�reedfan
     * ���ӣ�https://leetcode-cn.com/problems/decode-ways/solution/java-di-gui-dong-tai-gui-hua-kong-jian-ya-suo-by-r/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������//
     *
     *
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 38.1 MB , ������ Java �ύ�л����� 6.67% ���û�
     *
     * �ο���⣺https://leetcode-cn.com/problems/decode-ways/solution/java-di-gui-dong-tai-gui-hua-kong-jian-ya-suo-by-r/
     * https://leetcode.com/problems/decode-ways/discuss/30357/DP-Solution-(Java)-for-reference
     * @param s
     * @return
     */
    /**
     *    126
     * dp:3211
     *
     *    326
     * dp:2211
     */
    public int numDecodings(String s) {
        //����һ����ʱλ,�̶�ֵΪ1
        int dp[]=new int[s.length()+1];
        dp[s.length()]=1;

        if(s.charAt(s.length()-1)=='0'){
            dp[s.length()-1]=0;
        }else{
            dp[s.length()-1]=1;
        }

        //��������
        for (int i = s.length()-2; i >=0; i--) {
            //�ж��Ƿ�0
            //���ⳡ�� "00" ,���0
            if(s.charAt(i)=='0'){
                dp[i] = 0;
                continue;
            }

            //>=26
            if((s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0') <=26){
                dp[i] = dp[i+2] + dp[i+1];
            }else{
                dp[i] = dp[i+1];
            }

        }
        return dp[0];
    }


    //��̬�滮 ������,�������˼·�ǲ�ͬ��
    /**
     * dp[i]=dp[i+1]+dp[i+2]
     *
     * ���룺1212
     * 2
     * 12
     * 212= 2 12  212
     * 1212=1 212�� 12 12
     *
     * 0:������
     * <=26  dp[i]=dp[i+1]+dp[i+2]
     * >26  dp[i]=dp[i+1]
     *
     * �ο���⣺https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation
     *
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 38 MB , ������ Java �ύ�л����� 6.67% ���û�
     * @param s
     * @return
     */
    /**
     *     126
     * dp:1123
     *
     *     326
     * dp:1112
     *
     *     306
     * dp:1111
     */
    public int numDecodings2(String s) {
        int dp[]=new int[s.length()+1];
        //��ʼ��
        dp[0]=1;
        if(s.charAt(0)=='0'){
            dp[1]=0;
        }else{
            dp[1]=1;
        }

        //��������
        //i <= s.length() Ӧ�ó�������λ������� 13
        for (int i = 2; i <= s.length(); i++) {

            if((s.charAt(i-1)-'0')!=0){
                dp[i] = dp[i-1];
            }

            int ten= (s.charAt(i-2)-'0') * 10 + (s.charAt(i-1)-'0');
            if(ten>=10 && ten<=26){
                dp[i] =dp[i] + dp[i-2];
            }

        }
        //System.out.println(Arrays.toString(dp));

        return dp[s.length()];
    }

}
