// 399. Evaluate Division

func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	adjList := map[string]map[string]float64{}
	out := make([]float64, len(queries))

	for i, eq := range equations {
		if adjList[eq[0]] == nil {
			adjList[eq[0]] = map[string]float64{}
		}

		if adjList[eq[1]] == nil {
			adjList[eq[1]] = map[string]float64{}
		}
		adjList[eq[0]][eq[1]] = values[i]
		adjList[eq[1]][eq[0]] = 1 / values[i]
	}

	for i, q := range queries {
		out[i] = float64(-1)
		found, val := divide(adjList, q[0], q[1], map[string]bool{})
		if found {
			out[i] = val
		}
	}

	return out
}

func divide(adj map[string]map[string]float64, s string, e string, set map[string]bool) (bool, float64) {
	if adj[s][e] != float64(0) {
		return true, adj[s][e]
	}

	set[s] = true
	for k, v := range adj[s] {
		if set[k] == true {
			continue
		}
		found, val := divide(adj, k, e, set)

		if found {
			return true, val * v
		}
	}
	set[s] = false

	return false, -1
}