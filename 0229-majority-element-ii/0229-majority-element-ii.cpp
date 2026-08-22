class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int n = nums.size() ;
        int e1,e2 ;
        int c1 = 0 ;
        int c2 = 0 ;
        for(int i=0;i<n;i++){
            if(c1 == 0 && e2 != nums[i]){
                e1 = nums[i] ;
                c1 = 1 ;
            }
            else if(c2 == 0 && e1 != nums[i]){
                e2 = nums[i] ;
                c2 = 1 ;
            }
            else if(nums[i] == e1){
                c1++ ;
            }
            else if(nums[i] == e2){
                c2++ ;
            }
            else{
                c1-- ;
                c2-- ;
            }
        }
        vector<int> ans ;
        int curr = 0 ;
        int curr2 = 0 ;
        for(int i=0;i<n;i++){
            if(e1 == nums[i]){
                curr++ ;
            }
            else if(e2 == nums[i]){
                curr2++ ;
            }
        }
        if(curr > n/3){
            ans.push_back(e1) ;
        }
        if(curr2 > n/3){
            ans.push_back(e2) ;
        }
        return ans ;
    }
};