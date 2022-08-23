#include <vector>
#include <string>
using namespace std;

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

int main()
{
    int n = 2;
    vector<string> vec = {"1", "12"};
    Solution s = Solution();
    vector<string> res = s.generateParenthesis(n);
    return 0;
}