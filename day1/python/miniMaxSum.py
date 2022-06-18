def miniMaxSum(arr):
    # Write your code here
    arr.sort()
    min_sum = 0
    for i in range(0, len(arr) - 1):
        min_sum += arr[i]
    max_sum = min_sum - arr[0] + arr[-1]
    print(min_sum, max_sum)


miniMaxSum([])

