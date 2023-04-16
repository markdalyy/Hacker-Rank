def plusMinus(arr):
    pos_count = 0
    neg_count = 0
    zero_count = 0
    for num in arr:
        if num > 0:
            pos_count += 1
        elif num < 0:
            neg_count += 1
        else:
            zero_count += 1
    total = pos_count + neg_count + zero_count
    # pos_ratio = pos_count/total
    # neg_ratio = neg_count/total
    # zero_ratio = zero_count/total
    # print(f"{pos_ratio:.6f}\n{neg_ratio:.6f}\n{zero_ratio:.6f}")
    pos_ratio = round(pos_count / total, 6)
    neg_ratio = round(neg_count / total, 6)
    zero_ratio = round(zero_count / total, 6)
    print(pos_ratio)
    print(neg_ratio)
    print(zero_ratio)


plusMinus([])

