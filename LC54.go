// 54. Spiral Matrix

func spiralOrder(matrix [][]int) []int {
	dir := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	out := make([]int, len(matrix)*len(matrix[0]))
	i := 0
	d := 0
	r, c := 0, 0
	for i < len(matrix)*len(matrix[0]) {
		out[i] = matrix[r][c]
		i++
		matrix[r][c] = -1000
		r += dir[d][0]
		c += dir[d][1]
		if i >= len(matrix)*len(matrix[0]) {
			break
		}
		for c < 0 || r < 0 || c >= len(matrix[0]) || r >= len(matrix) || matrix[r][c] == -1000 {
			r -= dir[d][0]
			c -= dir[d][1]
			d = (d + 1) % 4
			r += dir[d][0]
			c += dir[d][1]
		}
	}

	return out
}