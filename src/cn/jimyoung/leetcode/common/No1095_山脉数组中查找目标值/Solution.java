package cn.jimyoung.leetcode.common.No1095_山脉数组中查找目标值;

interface MountainArray {
    int get(int index);
    int length();
}
class MountainArrayImpl implements MountainArray{
    private int[] array;
    MountainArrayImpl(int[] array){
        this.array = array;
    }
    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int length() {
        return array.length;
    }
}
public class Solution {
    public static void main(String[] args) {
        MountainArray test = new MountainArrayImpl(new int[]{1,2,3,5,3});
        System.out.println(new Solution().findInMountainArray(0, test));
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int mountainTop = findMountainTop(mountainArr);
        int res = findFrontTop(mountainArr,0,mountainTop,target);
        if(res == -1){
            return findBehindTop(mountainArr,mountainTop+1,len-1, target);
        }else {
            return res;
        }
    }

    public int findMountainTop(MountainArray mountainArr) {
        int left = 0, right = mountainArr.length()-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //就算数组里只有两个元素，由于mid是向下取整的，会取到left，所以mid+1不会数组下标越界
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //循环之后left == right
        return left;
    }

    public int findFrontTop(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int temp = mountainArr.get(mid);
            if (temp == target) return mid;
            if (temp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int findBehindTop(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int temp = mountainArr.get(mid);
            if (temp == target) return mid;
            if (temp > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
