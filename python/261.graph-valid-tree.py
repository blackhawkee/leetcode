from asyncio.windows_events import NULL


class Solution:

    def validTree(self, n, edges):
        if not n:
            return True

        adj = {i: [] for i in range(n)}

        for n1, n2 in edges:
            adj[n1].append(n2)
            adj[n2].append(n1)

        visited = set()

        def dfs(i, prev):
            if(i in visited):
                return False

            visited.add(i)

            for j in adj[i]:
                if j == prev:
                    continue
                if not dfs(j, i):
                    return False
            return True

        return n == len(visited) and dfs(0, -1)
