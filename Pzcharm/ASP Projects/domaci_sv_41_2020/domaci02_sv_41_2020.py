from random import random
from queue1 import Queue


class Task(object):

    def __init__(self, name):
        self._name = name
        self._percent = 0
        self._processed = False

    @property
    def name(self):
        return self._name

    @property
    def percent(self):
        return self._percent

    @property
    def processed(self):
        return self._processed

    def process(self):
        self._percent += round(random() * 10)
        if self._percent >= 100:
            self._processed = True
            self._percent = 100


class Processor(object):

    def __init__(self):
        self._tasks = Queue()
        for i in range(10):
            self._tasks.enqueue(Task(f"task{i+1}"))

    def processing(self):
        while not self._tasks.is_empty():
            print("------------------------")
            for i in range(len(self._tasks)):
                task = self._tasks.dequeue()
                task.process()
                print(f"{task.name} - {task.percent}%")
                if not task.processed:
                    self._tasks.enqueue(task)


if __name__ == '__main__':
    processor = Processor()
    processor.processing()
