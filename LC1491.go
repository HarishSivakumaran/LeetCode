// 1491. Average Salary Excluding the Minimum and Maximum Salary

func average(salary []int) float64 {
	max := math.MinInt
	min := math.MaxInt
	sum := 0

	for _, val := range salary {
		sum += val

		if val > max {
			max = val
		}

		if val < min {
			min = val
		}
	}

	sum -= max
	sum -= min

	return float64(sum) / float64((len(salary) - 2))
}