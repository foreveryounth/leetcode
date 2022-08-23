#include <vector>
#include <string>
using namespace std;

class Solution2;
class Solution
{
private:
    void generate(string cur, vector<string> &res, int n, int score, int len)
    {
        if (len == n * 2)
        {
            if (score == 0)
                res.push_back(cur);
            return;
        }

        if (score + 1 <= n * 2)
            generate(cur + '(', res, n, score + 1, len + 1);
        if (score - 1 >= 0)
            generate(cur + ')', res, n, score - 1, len + 1);
    }

public:
    vector<string> generateParenthesis(int n)
    {
        if (n == 0)
            return {""};
        else if (n == 1)
            return {"()"};

        vector<string> res;
        vector<string> cur;
        generate("", res, n, 0, 0);
        return res;
    }
};

class Solution2
{
public:
    vector<string> generateParenthesis(int n)
    {
        if (n == 0)
            return {""};
        else if (n == 1)
            return {"()"};

        vector<vector<string>> dp(n + 1);
        dp[0] = {""};
        dp[1] = {"()"};
        for (int i = 2; i <= n; i++)
        {
            for (int p = 0; p < i; p++)
            {
                int q = i - 1 - p;
                for (string str1 : dp[p])
                    for (string str2 : dp[q])
                        dp[i].push_back(string("(" + str1 + ")" + str2));
            }
        }
        return dp[n];
    }
};

int main()
{
    int n = 3;
    vector<string> vec = {"1", "12"};
    Solution2 s = Solution2();
    vector<string> res = s.generateParenthesis(n);
    return 0;
}