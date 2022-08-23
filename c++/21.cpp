
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2)
    {
        ListNode *mergeList = new ListNode(-1);
        ListNode *mergeListTail = mergeList;
        ListNode *p1 = list1;
        ListNode *p2 = list2;
        while (p1 != nullptr && p2 != nullptr)
        {
            if (p1->val <= p2->val)
            {
                mergeListTail->next = p1;
                p1 = p1->next;
            }
            else
            {
                mergeListTail->next = p2;
                p2 = p2->next;
            }
            mergeListTail = mergeListTail->next;
        }

        if (p1 != nullptr)
            mergeListTail->next = p1;
        else
            mergeListTail->next = p2;

        return mergeList->next;
    }

    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2)
    {
        if (list1 == nullptr)
            return list2;
        else if (list2 == nullptr)
            return list1;
        else if (list1->val <= list2->val)
        {
            list1->next = mergeTwoLists(list1->next, list2);
            return list1;
        }
        else
        {
            list2->next = mergeTwoLists(list1, list2->next);
            return list2;
        }
    }
};