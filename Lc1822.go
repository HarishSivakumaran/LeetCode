// 1822. Sign of the Product of an Array
func arraySign(nums []int) int {
	noOfNegs := 0

	for _, val := range nums {
		if val == 0 {
			return 0
		}

		if val < 0 {
			noOfNegs++
		}
	}

	if noOfNegs%2 == 0 {
		return 1
	} else {
		return -1
	}

}