from graph import Node

if __name__ == '__main__':
    mapa = {}
    node = Node('osam')
    mapa[3] = 'tri'
    mapa[node] = 'node - 8'
    print(mapa[3])
    print(mapa[node])
