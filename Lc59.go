func generateMatrix(n int) [][]int {
	dir := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	out := make([][]int, n)
	for i, _ := range out {
		out[i] = make([]int, n)
	}
	r, c, d, count := 0, 0, 0, 0

	for count < n*n {
		out[r][c] = count + 1
		r += dir[d][0]
		c += dir[d][1]
		count++

		if count == n*n {
			break
		}

		for r < 0 || c < 0 || r >= n || c >= n || out[r][c] != 0 {
			r -= dir[d][0]
			c -= dir[d][1]
			d = (d + 1) % 4
			r += dir[d][0]
			c += dir[d][1]
		}
	}
	return out
}