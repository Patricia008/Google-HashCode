package dataStructures;

public class Route
{
    private int rStart;
    private int rEnd;
    private int cStart;
    private int cEnd;
    private int tStart;
    private int tEnd;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private double weight;

    public int getrStart() { return rStart; }
    public void setrStart(int rStart) { this.rStart = rStart; }

    public int getrEnd() { return rEnd; }
    public void setrEnd(int rEnd) { this.rEnd = rEnd; }

    public int getcStart() { return cStart; }
    public void setcStart(int cStart) { this.cStart = cStart; }

    public int getcEnd() { return cEnd; }
    public void setcEnd(int cEnd) { this.cEnd = cEnd; }

    public int gettStart() { return tStart; }
    public void settStart(int tStart) { this.tStart = tStart; }

    public int gettEnd() { return tEnd; }
    public void settEnd(int tEnd) { this.tEnd = tEnd; }

    public int getLength() {
        return Math.abs(rEnd - rStart) + Math.abs(cEnd - cStart);
    }
}
