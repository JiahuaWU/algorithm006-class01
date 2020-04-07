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
 * �ο�������⣺
 */
public class LeetCode_493_379 {

    /**
     * �鲢����
     *
     * ִ����ʱ : 72 ms , ������ Java �ύ�л����� 45.87% ���û�
     * �ڴ����� : 52.9 MB , ������ Java �ύ�л����� 16.67% ���û�
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        return merge2(nums,0,nums.length-1);
    }

    /**
     * �鲢����
     *
     * ִ����ʱ : 72 ms , ������ Java �ύ�л����� 45.87% ���û�
     * �ڴ����� : 52.9 MB , ������ Java �ύ�л����� 16.67% ���û�
     * @param nums
     * @return
     */
    public int reversePairs2(int[] nums) {
        return merge2(nums,0,nums.length-1);
    }

    private int merge2(int[] array, int left, int right) {
        if(left>=right) return 0;

        int mid= (right + left) >>1;
        int cnt=merge2(array,left,mid)+merge2(array,mid+1,right);

        for(int i=left,j=mid+1;i<=mid;i++){
            while (j<=right && array[i]/2.0 > array[j]) j++;
            cnt+= j-(mid+1);
        }

        //Arrays.sort(array,left,right+1);
        merge(array,left,mid,right);
        return cnt;
    }

    public static void main(String[] args) {
        /*int[] ints = new LeetCode_493_379().mergeSort(new int[]{3, 2, 34, 2}, 0, 3);
        System.out.println(Arrays.toString(ints));*/
        int mid1= 2+ (2) >>1;
        int mid2= 2+ (2) / 2;
        System.out.println(mid1);
        System.out.println(mid2);
    }

    public int[] mergeSort(int[] array,int left,int right){
        if(right<=left) return array;
        int mid=(left+right) >>1;

        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        return merge(array,left,mid,right);
    }

    private int[] merge(int[] array, int left, int mid, int right) {
        int[] temp=new int[right-left+1];
        int i = left ,j=mid+1,k=0;

        while(i<=mid && j<=right){
            temp[k++]=array[i] <=array[j] ? array[i++] :array[j++];
        }

        while (i<=mid) temp[k++] = array[i++];
        while (j<=right) temp[k++] = array[j++];

        for (int p=0;p<temp.length ; p++){
            array[left+p] =temp[p];
        }
        return array;
    }



}
