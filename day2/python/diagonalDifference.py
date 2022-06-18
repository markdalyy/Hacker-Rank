def diagonalDifference(arr):
    ltr_sum = 0
    rtl_sum = 0
    for i in range(len(arr)):
        ltr_sum += arr[i][i]
        rtl_sum += arr[i][-i-1]
    return abs(ltr_sum - rtl_sum)