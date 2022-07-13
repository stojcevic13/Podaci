import struct

header_fmt = 'ii'
header_size = struct.calcsize(header_fmt)


if __name__ == '__main__':
    with open('tacke.bin', 'rb') as fin:
        header_bytes = fin.read(header_size)
        num_points, dimension = struct.unpack(header_fmt, header_bytes)

        point_fmt = 'd' * dimension
        point_size = struct.calcsize(point_fmt)
        centroid = [0] * dimension
        for i in range(num_points):
            point_bytes = fin.read(point_size)
            point = struct.unpack(point_fmt, point_bytes)
            print(point)
            centroid = [centroid[i] + point[i] for i in range(dimension)]
        centroid = [centroid[i] / num_points for i in range(dimension)]
        print(centroid)
