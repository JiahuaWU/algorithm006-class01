package G20200343030379;

import java.util.Arrays;

/**
 * 300. �����������
 * ����һ��������������飬�ҵ���������������еĳ��ȡ�
 *
 * ʾ��:
 *
 * ����: [10,9,2,5,3,7,101,18]
 * ���: 4
 * ����: ��������������� [2,3,7,101]�����ĳ����� 4��
 * ˵��:
 *
 * ���ܻ��ж�������������е���ϣ���ֻ��Ҫ�����Ӧ�ĳ��ȼ��ɡ�
 * ���㷨��ʱ�临�Ӷ�Ӧ��Ϊ O(n2) ��
 * ����: ���ܽ��㷨��ʱ�临�ӶȽ��͵� O(n log n) ��?
 *
 * ���ⷽ����
 *  1����̬�滮
 *  2����̬�滮+���ֲ��ҷ�
 *
 * �ο�������⣺
 *  ��̬�滮+���ֲ��ң�https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 *  �ٷ�������а񣨶�̬�滮+���ֲ���(�Ż���)����https://leetcode-cn.com/submissions/detail/62318487/
 */
public class LeetCode_300_379 {


    /**
     * 1����̬�滮��
     * ʱ�临�Ӷ� N^2
     * ִ����ʱ : 13 ms , ������ Java �ύ�л����� 62.41% ���û�
     * �ڴ����� : 37.6 MB , ������ Java �ύ�л����� 5.26% ���û�
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        //����0,i �������г���
        int[] dp=new int[nums.length];

        //��ʼ�����ȶ���1
        Arrays.fill(dp,1);

        int maxLength=0;
        for (int i = 0; i < nums.length; i++) {
            int curMax=0;
            for (int j = 0; j < i; j++){
                //nums[j]��� nums[i]�ұ�
                if(nums[j] < nums[i]){//��ʾ����
                    curMax=Math.max(curMax,dp[j]+1);
                }
            }
            dp[i]=Math.max(curMax,dp[i]);
            maxLength = Math.max(maxLength,dp[i]);
        }

        return maxLength;
    }
    /**
     * 1.2����̬�滮�����ٱ���ʹ��,������Ҫ��θ��ǣ�ʱ�临�Ӷȸ�����
     * ʱ�临�Ӷ� N^2
     * �ռ临�Ӷȣ�O(N)
     *
     * ִ����ʱ : 15 ms , ������ Java �ύ�л����� 45.71% ���û�
     * �ڴ����� : 37.7 MB , ������ Java �ύ�л����� 5.26% ���û�
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        //����0,i �������г���
        int[] dp=new int[nums.length];

        //��ʼ�����ȶ���1
        Arrays.fill(dp,1);

        int maxLength=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++){
                //nums[j]��� nums[i]�ұ�
                if(nums[j] < nums[i]){//��ʾ����
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }

        return maxLength;
    }


    /**
     * 2����̬�滮+���ֲ��ң�
     * ʱ�临�Ӷ�  O(NlogN)
     * �ռ临�Ӷȣ� O(N)
     *
     * ִ����ʱ : 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 37.5 MB , ������ Java �ύ�л����� 5.26% ���û�
     * @param nums
     * @return
     */
    public int lengthOfLIS3(int[] nums) {
        //�����������������
        int[] tail=new int[nums.length];
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {

            //ֱ�����ֲ��ҷ�
            int left=0,right=maxLength;
            while(left < right){
                //λ����д��
                int mid = (left + right) >> 1;
                //int mid = (left + right) / 2;
                if(tail[mid] < nums[i]){ //�Ұ�߲���
                    left = mid + 1;
                }else{ // ���߲���
                    right = mid;
                }
            }
            tail[left] = nums[i];
            //�Ƿ�����λ��д�룬���������ɵ�λ��
            if(maxLength == right) maxLength+=1;
        }

        return maxLength;
    }

    /**
     * 2.1����̬�滮+���ֲ��ң����ֲ����жϷ���ͬ����
     * ʱ�临�Ӷ�  O(NlogN)
     * �ռ临�Ӷȣ� O(N)
     *
     * ִ����ʱ : 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 37.5 MB , ������ Java �ύ�л����� 5.26% ���û�
     * @param nums
     * @return
     */
    public int lengthOfLIS4(int[] nums) {
        //�����������������
        int[] tail=new int[nums.length];
        int maxLength = 0;
        for (int num : nums) {

            int left=0,right=maxLength;
            while (left<right){
                int mid=(left+right) >> 1;
                if(num<= tail[mid]){
                    right = mid;
                }else{
                    left=mid+1;
                }
            }
            if(right==maxLength) maxLength+=1;
            tail[left]=num;
        }
        return maxLength;
    }

    /**
     * 2.2����̬�滮+���ֲ��ң��Ż���֦�棩��
     * ִ����ʱ : 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 37.6 MB , ������ Java �ύ�л����� 5.26% ���û�
     * @param nums
     * @return
     */
    public int lengthOfLIS5(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int tail[]=new int[nums.length];

        //���������
        int maxLength=0;
        tail[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            //����ֱ�ӱ���
            if(nums[i] > tail[maxLength]){
                tail[++maxLength]=nums[i];
                continue;
            }


            //ֱ�����ֲ���
            int left=0,right=maxLength;
            while(left < right){
                //��2
                int mid = (left + right) >> 1;
                if(nums[i] > tail[mid]){ //���߲���
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            tail[left]=nums[i];
            //if(maxLength == right) maxLength+=1;

        }
        return maxLength+1;
    }

    public static void main(String[] args) {
        new LeetCode_300_379().lengthOfLIS3(new int[]{2,3,7});
    }
}