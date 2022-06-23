class LRUCache:

    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}
        return

    def get(self, x):
        if x in self.cache:
            return self.cache[x]
        return -1

    def set(self, x, y):
        self.cache[x] = y