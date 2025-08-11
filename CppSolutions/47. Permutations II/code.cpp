// the problem is to find all unique permutations of a list of numbers that may contain duplicates. (backtracking)

class Solution {
public:
    void fun(vector<vector<int>> &ans,vector<int> &a,vector<bool> &visited,vector<int> &nums){
        if(a.size()==nums.size()){
            ans.push_back(a);
            return ;
        }
        for(int i=0;i<nums.size();i++){
            if(i>0 && nums[i]==nums[i-1]  && !visited[i-1])
                continue;
            if(!visited[i]){
                visited[i]=true;
                a.push_back(nums[i]);
                fun(ans,a,visited,nums);
                visited[i]=false;
                a.pop_back();
            }
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>> ans;
        vector<int> a;
        vector<bool> visited(nums.size(),false);
        fun(ans,a,visited,nums);
        return ans;
    }
};