class Solution {
public:
    string largestGoodInteger(string num) {  
        string ans = "",temp="";
        for(int i=0;i<num.size()-2;i++){
            if(num[i]==num[i+1] && num[i]==num[i+2]){
                ans +=num[i];
                ans +=num[i+1];
                ans +=num[i+2];
                if(ans>temp){
                    temp=ans;
                }
                ans="";
            }
        }
        return temp;
    }
};
