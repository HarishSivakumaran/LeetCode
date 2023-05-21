import "math"

func shortestBridge(grid [][]int) int {
	min := math.MaxInt
	border := [][][]int{}

	for r, _ := range grid {
		for c, val := range grid[r] {
			if val == 1 {
				bor := [][]int{}
				_ = getBorders(r, c, grid, &bor)
				border = append(border, bor)
			}
		}
	}

	for _, val1 := range border[0] {
		for _, val2 := range border[1] {
			if abs(val1[0], val2[0])+abs(val1[1], val2[1]) < min {
				min = abs(val1[0], val2[0]) + abs(val1[1], val2[1])
			}
		}
	}

	return min - 1
}

func abs(i, j int) int {
	diff := i - j
	if diff < 0 {
		diff = -1 * diff
	}
	return diff
}

func getBorders(r int, c int, grid [][]int, border *[][]int) bool {
	var dir [][]int = [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}

	if r < 0 || c < 0 || r >= len(grid) || c >= len(grid) || grid[r][c] == 0 {
		return false
	}

	if grid[r][c] == 2 {
		return true
	}

	grid[r][c] = 2
	lands := 0

	for _, d := range dir {
		if getBorders(r+d[0], c+d[1], grid, border) {
			lands++
		}
	}

	if lands < 4 {
		*border = append(*border, []int{r, c})
	}

	return true
}