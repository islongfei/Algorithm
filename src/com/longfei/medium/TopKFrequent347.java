package com.longfei.medium;

import java.util.*;

/**
 * 前 K 个高频元素
 *
 * @author islongfei
 * @date 2020.09.06
 */
public class TopKFrequent347 {

    /**
     * solution 1. O(Nlogk) 小顶堆（优先队列）：hashMap 统计频次，优先队列对 count 排序
     * solution 2. O(N) 桶排序：hashMap 统计频次，将频次作为数组的 index，降序遍历数据去重 k 个不为空的 index 即可
     */
    public int[] topKFrequent(int[] nums, int k) {
        // k 为 num， value 为频次
        Map<Integer, Integer> map = new HashMap<>();
        //指定数组大小，避免扩容
        //List<Integer> res = new ArrayList<>(k);
        int res[] = new int[k];

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            //根据 k-v 中的 v 对 map 排序， 重新 compare 方便后续的堆排序过程
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        //构建小顶堆
        for (Integer num : map.keySet()) {
            if (pq.size() < k) {
                pq.add(num);
            } else if (map.get(num) > map.get(pq.peek())) {
                pq.remove();
                pq.add(num);
            }
        }
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) res[i] = pq.remove();
        }
        return res;
    }


    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] res = new int[k];
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        ///将频率作为桶的下标，桶内存放出现为该频率的数字
        List<Integer>[] bucket = new List[nums.length + 1];//length + 1, 存 0 的 index
        for (Integer key : map.keySet()) {
            int i = map.get(key);
            if (bucket[i] == null) {
                bucket[i] = new ArrayList<>();
            }
            bucket[i].add(key);
        }

        //res.size() < k 666
        for (int i = bucket.length - 1; i >= 0 && list.size() < k; i--) {
            if (bucket[i] == null) continue;
            list.addAll(bucket[i]);
        }
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
