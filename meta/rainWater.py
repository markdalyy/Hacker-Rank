def getTrappedRainWater(arr):
    water = 0
    for i in range(1, len(arr) - 1):
        max_left = max(arr[:i])
        max_right = max(arr[i + 1:])
        if arr[i] < max_left and arr[i] < max_right:
            water += min(max_left, max_right) - arr[i]
    return water
