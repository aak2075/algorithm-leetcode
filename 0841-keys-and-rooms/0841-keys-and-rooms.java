class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(BFS(rooms, 0)) {
            return true;
        }
        return false;
    }
    
    public boolean BFS(List<List<Integer>> rooms, int start) {
        LinkedList<Integer> stack = new LinkedList<>();
        List<Integer> visit = new ArrayList<>();    
        List<Integer> result = new ArrayList<>();
        
        stack.push(start);
        visit.add(start);
        int tmp = start;
        while(!stack.isEmpty()) {
            int pop = stack.pop();
            result.add(pop);
            List<Integer> near = rooms.get(pop);
            for(Integer i : near) {
                if (!visit.contains(i)) {
                    stack.push(i);
                    visit.add(i);
                }
            }
        }
        
        if(result.size() == rooms.size()) {
            return true;
        }
        return false;
    }
}