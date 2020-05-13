public class NumOf2Or1 {
    //2的出现次数
    public int numberOf2sInRange(int n) {
        int res=0;
        int low=0;
        int cur=0;
        int high=0;
        int carry=1;
        while((n/carry)!=0){
            high=n/(carry*10);
            cur=n/carry%10;
            low=n-n/carry*carry;
            if(cur<2){
                res+=high*carry;
            }else if(cur==2){
                res+=high*carry+low+1;
            }else{
                res+=(high+1)*carry;
            }
            carry*=10;
        }
        return res;
    }

    //1的个数
    public int countDigitOne(int n) {
        if(n<1) return 0;
        long res=0;
        long low=0;
        long cur=0;
        long high=0;
        long carry=1;
        while((n/carry)!=0){
            high=n/(carry*10);
            cur=n/carry%10;
            low=n%carry;
            if(cur==0){
                res+=high*carry;
            }else if(cur==1){
                res+=high*carry+low+1;
            }else{
                res+=(high+1)*carry;
            }
            carry*=10;
        }
        return (int)res;
    }
}


随机打印M个数，且打印过的不可重复打印
public class PrintRandomM {
    public void print(int[] arr,int k){
        for(int i=0;i<k;i++){
            int index=(int)(Math.random()*(arr.length-i));
            System.out.println(arr[index]);
            swap(arr,index,arr.length-i-1);
        }
    }
    private void swap(int[] arr,int left,int right){
        int tmp=arr[left];
        arr[left]=arr[right];
        arr[right]=tmp;
    }
}

回文数
public class IsPalidNum {
    public boolean isPalidNum(int num){
        if(num==Integer.MIN_VALUE) return false;
        num=Math.abs(num);
        int help=1;
        int tmp=num;
        while(tmp!=0){
            help*=10;
            tmp/=10;
        }
        while(num!=0){
            if(num/help!=num%10){
                return false;
            }
            num=num%help/10;
            help/=100;
        }
        return true;
    }
}


public class Search {
    //旋转有序数组中查找某个元素，数组中可能有重复元素
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]==nums[left]){
                left++;
                continue;
            }
            if(nums[mid]>nums[left]){
                if(target>=nums[left]&&target<=nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(target>=nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return false;
    }

    //旋转有序数组中查找最小值，可能有重复元素
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==nums[right]){
                right--;
                continue;
            }
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }
}


