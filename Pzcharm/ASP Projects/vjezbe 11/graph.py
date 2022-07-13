
class Node(object):
    __slots__ = '_value'

    def __init__(self, value=None):
        self._value = value

    @property
    def value(self):
        return self._value


class Graph(object):

    # KLASA VERTEX
    class Vertex(object):
        __slots__ = '_element'

        def __init__(self, x=None):
            self._element = x

        @property
        def element(self):
            return self._element

        def __str__(self):
            return str(self._element)

    # KLASA EDGE
    class Edge(object):
        __slots__ = '_origin', '_destination', '_element'

        def __init__(self, origin, destination, element=None):
            self._origin = origin
            self._destination = destination
            self._element = element

        @property
        def origin(self):
            return self._origin

        @property
        def destination(self):
            return self._destination

        @property
        def element(self):
            return self._element

        def endpoints(self):
            return self._origin, self._destination

        def opposite(self, v):
            if not isinstance(v, Graph.Vertex):
                raise TypeError('v mora biti instanca klase Vertex.')

            if v == self._destination:
                return self._origin
            elif v == self._origin:
                return self._destination

            raise ValueError('Ova ivica ne povezuje cvor v.')

        def __str__(self):
            return '({0},{1},{2})'.format(self._origin, self._destination, self._element)

    def __init__(self, directed=False):
        self._outgoing = {}
        self._incoming = {} if directed else self._outgoing

    def _validate_vertex(self, v):
        if not isinstance(v, Graph.Vertex):
            raise TypeError('v mora biti instanca klase Vertex.')
        if v not in self._outgoing:
            raise ValueError('v ne pripada ovom grafu.')

    def is_directed(self):
        return self._outgoing is not self._incoming

    def vertex_count(self):
        return len(self._outgoing)

    def vertices(self):
        return self._outgoing.keys()

    def edge_count(self):
        total = sum(len([edges]) for edges in self._outgoing.values())
        return total if self.is_directed() else total // 2

    def edges(self):
        result = set()
        for edges in self._outgoing.values():
            result.update(edges.values())
        return result

    def get_edge(self, u, v):
        self._validate_vertex(u)
        self._validate_vertex(v)
        try:
            return self._outgoing[u][v]
        except KeyError:
            return None

    def degree(self, v, outgoing=True):
        self._validate_vertex(v)
        adj = self._outgoing if outgoing else self._incoming
        return len(adj[v])

    def incident_edges(self, v, outgoing=True):
        self._validate_vertex(v)
        adj = self._outgoing if outgoing else self._incoming
        return adj[v].values()

    def insert_vertex(self, x=None):
        v = self.Vertex(x)
        self._outgoing[v] = {}
        if self.is_directed():
            self._incoming[v] = {}
        return v

    def insert_edge(self, u, v, x=None):
        if self.get_edge(u, v) is not None:
            raise ValueError('u i v su vec povezani.')
        edge = self.Edge(u, v, x)
        self._outgoing[u][v] = edge
        self._outgoing[v][u] = edge
