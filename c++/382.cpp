#include<stdlib.h>

struct ListNode {
    int val;
    ListNode* next;
};

class Solution {
    ListNode *head;

public:
    Solution(ListNode *head) {
        this->head = head;
    }

    int getRandom() {
        int i = 1, ans = 0;
        for (auto node = head; node; node = node->next) {
            if (rand() % i == 0) { // 1/i 的概率选中（替换为答案）
                ans = node->val;
            }
            ++i;
        }
        return ans;
    }
};

class Solution2 {
    ListNode* head;

public:
    Solution2(ListNode* head) {
        this->head = head;
    }

    int getRandom() {
        int i = 1;
        ListNode* node = this->head;
        int res = 0;

        while(node) {
            if (rand() % i == 0) {
                res = node->val;
            }
            i++;
            node = node->next;
        }
        return res;
    }
};