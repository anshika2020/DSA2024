# n is the size of the array and k is the size of subarray

def maxSum(arr, n, k):
    if (n < k):
        return -1
    # get the sum of first window
    sum = 0
    for i in range(k):
        sum += arr[i]

        # Compute sums of remaining windows by
        # removing first element of previous
        # window and adding last element of
        # current window.
        current_sum = sum
        for i in range(k, n):
            current_sum += arr[i] - arr[i - k]
            sum = max(sum, current_sum)

        return sum

    # driver code


arr = [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
k = 3
n = len(arr)
print(maxSum(arr, n, k))
