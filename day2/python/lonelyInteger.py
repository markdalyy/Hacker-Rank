def lonelyinteger(a):
    count = {}

    for i in range(len(a)):
        elem = a[i]
        if elem in count:
            count[elem] += 1
        else:
            count[elem] = 1
    for key in count:
        if count[key] == 1:
            return key
