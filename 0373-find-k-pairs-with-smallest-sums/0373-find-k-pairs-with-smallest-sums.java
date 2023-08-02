class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(pair -> pair.first + pair.second));

    for (int i = 0; i < nums1.length && i < k; i++)
      minHeap.add(new Pair(nums1[i], nums2[0], 0));

    for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
      Pair pair = minHeap.poll();
      result.add(List.of(pair.first, pair.second));
      int secondIndex = pair.secondIndex;

      if (secondIndex < nums2.length - 1)
        minHeap.add(new Pair(pair.first, nums2[secondIndex + 1], secondIndex + 1));
    }

    return result;
  }

  private record Pair(int first, int second, int secondIndex) { }
}