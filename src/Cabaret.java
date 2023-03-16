import java.util.ArrayList;
public class Cabaret {
    //instance variables
    private String name;
    private ArrayList<Performer> performers;
    //constructor
    public Cabaret (String name) {
        this.name = name;
        performers = new ArrayList<Performer>();
    }
    //getter methods
    public String getName() {
        return name;
    }
    public ArrayList<Performer> getPerformers() {
        return performers;
    }
    //add performer method
    public boolean addPerformer (Performer p) {
        if (!performers.contains(p)) {
            performers.add(p);
            return true;
        } else {
            return false;
        }
    }
    //removePerformer method
    public boolean removePerformer (Performer p) {
        if (performers.contains(p)) {
            performers.remove(p);
            return true;
        } else {
            return false;
        }
    }
    //average age method
    public double averagePerformerAge() {
        int numPerformers = performers.size();
        double sum = 0;
        for (Performer p : performers) {
            sum += p.getAge();
        }
        return sum / numPerformers;
    }
    // over age method
    public ArrayList<Performer> performersOverAge(int age) {
        ArrayList<Performer> old = new ArrayList<Performer>();
        for (Performer p : performers) {
            if (p.getAge() >= age) {
                old.add(p);
            }
        }
        return old;
    }
    //group rehearse method
    public void groupRehearsal() {
        for (Performer p : performers) {
            System.out.print("REHEARSAL CALL! ");
            System.out.println(p.getName() + " ");
            if (p instanceof Performer || p instanceof Dancer) {
                p.rehearse();
            } else {
                ((Comedian) p).rehearse(false);
            }
        }
    }
    //cabaret show method
    public void cabaretShow() {
        for (Performer p: performers) {
            System.out.println("Welcome to the cabaret! Next act up..." + p.getName());
            if (p instanceof Dancer) {
                ((Dancer) p).pirouette(2);
                p.perform();
            } else {
                p.perform();
            }
        }
    }
}

