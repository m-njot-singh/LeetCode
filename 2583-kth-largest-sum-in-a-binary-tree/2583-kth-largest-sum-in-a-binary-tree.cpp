class Solution {
public:
    long long kthLargestLevelSum(TreeNode* root, int k) {
             vector<long long>sum;
            queue<TreeNode*> q;
            q.push(root);

            while(!q.empty())
            {
                int s = q.size();
                long long levelsum=0;
                for(int i=0; i<s; i++)
                {
                    TreeNode* x=q.front();
                    q.pop();
                    levelsum += x->val;
                    
                    if(x->left != NULL)
                       q.push(x->left);

                    if(x->right != NULL)
                       q.push(x->right);  
                
                }
                sum.push_back(levelsum);
            }

        sort(sum.begin(),sum.end());
        if(k > sum.size())
           return -1;

         return (sum[sum.size()-k]);

        
    }
};