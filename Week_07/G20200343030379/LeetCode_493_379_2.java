package G20200343030379;

import java.util.Arrays;

/**
 * 493. ��ת��
 *
 * ����һ������?nums?�����?i < j?��?nums[i] > 2*nums[j]?���Ǿͽ�?(i, j)?����һ����Ҫ��ת�ԡ�
 *
 * ����Ҫ���ظ��������е���Ҫ��ת�Ե�������
 *
 * ʾ�� 1:
 *
 * ����: [1,3,2,3,1]
 * ���: 2
 * ʾ�� 2:
 *
 * ����: [2,4,3,5,1]
 * ���: 3
 * ע��:
 *
 * ��������ĳ��Ȳ��ᳬ��50000��
 * ���������е��������ֶ���32λ�����ı�ʾ��Χ�ڡ�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺������ʦ��Ƶ����վ���
 */
public class LeetCode_493_379_2 {

    public static void main(String[] args) {
        new LeetCode_493_379_2().reversePairs(new int[]{2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647});
    }

    /**
     * ���ù鲢����
     * ִ����ʱ : 88 ms , ������ Java �ύ�л����� 28.35% ���û�
     * �ڴ����� : 49.1 MB , ������ Java �ύ�л����� 94.44% ���û�
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    /**
     * https://u.geekbang.org/lesson/10?article=212223
     * ������ʦ 17:50 ��ʼ��
     * ʱ�临�Ӷȣ�arrays.sort����*ͳ��   n(logN) * logN
     * ʱ�临�Ӷȣ��鲢����*ͳ��     O(N) * logN
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int mergeSort(int[] nums, int left, int right) {
        if(left>=right) return 0;
        int mid=(left+right)/2;

        int cnt=mergeSort(nums,left,mid)+mergeSort(nums,mid+1,right);

        for(int i=left,j=mid+1;i<=mid;i++){
            while(j<=right && nums[i]/2.0>nums[j]){
                j++;
            }
            cnt+=j-(mid+1);
        }

        //ʱ�临�Ӷ� n��logn��
        Arrays.sort(nums,left,right+1);

        //����ǹ鲢������� O(N)
        return cnt;
    }



    /*private int mergeSort(int[] nums, int left, int right) {
        if(left>=right)return 0;
        int mid=(left+right)/2;
        //System.out.println(Arrays.toString(nums)+"=========left:"+left+"=====mid:"+mid+"======right="+right+"====");
        int cnt=mergeSort(nums,left,mid)+mergeSort(nums,mid+1,right);

        for(int i=left,j=mid+1;i<=mid;i++){
            while (j<=right && nums[i]/2.0>nums[j]){
                j++;
            }
            cnt+=j-(mid+1);
        }

        Arrays.sort(nums,left,right+1);
        //System.out.println("����"+Arrays.toString(nums)+"=========left:"+left+"=====mid:"+mid+"======right="+right+"====");
        return cnt;
    }*/



   /* private int mergeSort(int[] nums, int left, int right) {
        if(left>=right) return 0;
        int mid=(right+left)/2;
        System.out.println(Arrays.toString(nums)+"=========left:"+left+"=====mid:"+mid+"======right="+right+"====");
        int cnt=mergeSort(nums,left,mid) +mergeSort(nums,mid+1,right);

        for (int i=left,j=mid+1;i<=mid;i++){
            while (j<=right && nums[i]/2.0 > nums[j]) {
                j++;
            }
            cnt+=j-(mid+1);
        }
        Arrays.sort(nums,left,right+1);
        System.out.println("����"+Arrays.toString(nums)+"=========left:"+left+"=====mid:"+mid+"======right="+right+"====");
        return cnt;
    }*/


}
