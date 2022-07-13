
def dfs(g, u, discovered):
    for e in g.incident_edges(u):
        v = e.opposite(u)
        if v not in discovered:
            discovered[v] = e
            dfs(g, v, discovered)


def dfs_complete(g):
    forest = {}
    for v in g.vertices():
        if v not in forest:
            forest[v] = None
            dfs(g, v, forest)
    return forest
