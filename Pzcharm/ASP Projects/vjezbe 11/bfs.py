
def bfs(g, s, discovered):
    level = [s]
    while len(level) > 0:
        next_level = []
        for u in level:
            for e in g.incident_edges(u):
                v = e.opposite(u)
                if v not in discovered:
                    discovered[v] = None
                    next_level.append(v)
        level = next_level


def bfs_complete(g):
    forest = {}
    for v in g.vertices():
        if v not in forest:
            forest[v] = None
            bfs(g, v, forest)
    return forest
