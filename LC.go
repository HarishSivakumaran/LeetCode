func distanceLimitedPathsExist(n int, edgeList [][]int, queries [][]int) []bool {

    for i := 0; i < len(queries); i++ {
        queries[i] = append(queries[i], i)
    }

    sort.Slice(queries, func (i int, j int) bool {
        return queries[i][2] < queries[j][2];
    })

    sort.Slice(edgeList, func (i int, j int) bool {
        return edgeList[i][2] < edgeList[j][2];
    })

    parent := make([]int, n)
    rank := make([]int, n)
    out := make([]bool, len(queries))

    for i := 0; i < n; i++{
        parent[i] = i
        rank[i] = 1
    }

    var edgeIndex int = 0

    for _, q := range queries{
        for edgeIndex < len(edgeList) && edgeList[edgeIndex][2] < q[2] {
            p1 := findRoot(parent, edgeList[edgeIndex][0])
            p2 := findRoot(parent, edgeList[edgeIndex][1])
            edgeIndex++
            if p1 == p2 {
                continue
            }

            if rank[p1] > rank[p2] {
                rank[p1] += rank[p2]
                parent[p2] = p1
            }else{
                rank[p2] += rank[p1]
                parent[p1] = p2
            }
        }

        p1 := findRoot(parent, q[0])
        p2 := findRoot(parent, q[1])
        out[q[3]] = p1 == p2
        
    }

    return out

}

func findRoot(parent []int, i int) int{
    for parent[i] != i {
        parent[i] = parent[parent[i]]
        i = parent[i]
    }
    return i
}

