package LeetCode;

import java.util.*;

/**
 * @program:practice
 * @description
 * 员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。

 * @Author:xiameng
 * @create:2020-04-04 12:20
 **/
class Employee {
    public int id;  //员工id
    public int importance;  //重要度
    // the id of direct subordinates
    public List<Integer> subordinates;
};

public class Solution690 {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() == 0){
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        int add = 0;
        queue.offer(id);
        while (!(queue.size()==0)){
            int tmp = queue.poll();
            for (Employee e:employees) {
                if(tmp==e.id){
                    add += e.importance;
                    for (int i:e.subordinates) {
                        queue.add(i);
                    }
                }
            }
        }
        return add;
    }
}