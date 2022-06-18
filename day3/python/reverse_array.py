def performOperations(arr, operations):
    for op in operations:
        i1 = op[0]
        i2 = op[1]
        l = len(arr)
        if i1 == 0:
            arr[i1:i2+1] = arr[i2::-1]
        elif i2 == l-1:
            # arr[i1:i2+1] = arr[i2+1:i1-1:-1]
            arr[i1:i2 + 1] = arr[:i1 - 1:-1]
        else:
            arr[i1:i2+1] = arr[i2:i1-1:-1]
    return arr


print(performOperations([5, 2, 4, 1], [[0, 2], [2, 3]]))

