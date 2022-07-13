import struct

INPUT_FILE = 'tacke.txt'
OUTPUT_FILE = 'tacke.bin'
DELIMITER = ' '
FORMAT = 'ddd'

if __name__ == '__main__':
    with open(INPUT_FILE, 'r') as fin, open(OUTPUT_FILE, 'wb') as fout:
        header_bytes = struct.pack('ii', 4, 3)
        fout.write(header_bytes)
        for line in fin.readlines():
            tokens = line.strip().split(DELIMITER)
            points = [float(token) for token in tokens]
            points_bytes = struct.pack(FORMAT, *points)
            fout.write(points_bytes)
