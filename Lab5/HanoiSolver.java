public class HanoiSolver {
    Stack<Integer> A = new Stack<Integer>();
    Stack<Integer> B = new Stack<Integer>();
    Stack<Integer> C = new Stack<Integer>();
    int diskNum;
    public HanoiSolver(int n) {
        for (int i = n; i >= 1; i--) {
            A.push(i);
        }
        diskNum = n;
    }

    public int solve() {
        int moves = 0;
        if (diskNum%2 == 1) {// odd number
            while(C.size() != diskNum) {
                if (C.isEmpty() || (!A.isEmpty() && A.peek() < C.peek())) {
                    C.push(A.pop());
                }
                else {
                    A.push(C.pop());
                }
                moves++;
                if (C.size() == diskNum)
                    break;
                if (B.isEmpty() || (!A.isEmpty() && A.peek() < B.peek())) {
                    B.push(A.pop());
                }
                else {
                    A.push(B.pop());
                }
                moves++;
                if (B.isEmpty() || (!C.isEmpty() && C.peek() < B.peek())) {
                    B.push(C.pop());
                }
                else {
                    C.push(B.pop());
                }
                moves++;
            }
        }
        else { // even number
            while(C.size() != diskNum) {
                if (B.isEmpty() || (!A.isEmpty() && A.peek() < B.peek())) {
                    B.push(A.pop());
                }
                else {
                    A.push(B.pop());
                }
                moves++;
                if (C.isEmpty() || (!A.isEmpty() && A.peek() < C.peek())) {
                    C.push(A.pop());
                }
                else {
                    A.push(C.pop());
                }
                moves++;
                if (C.size() == diskNum)
                    break;
                if (B.isEmpty() || (!C.isEmpty() && C.peek() < B.peek())) {
                    B.push(C.pop());
                }
                else {
                    C.push(B.pop());
                }
                moves++;
            }
        }
        return moves;
    }

}
