public class Test {

    public static void main(String[] args){
        PriorityQueue<Bid> pqMax = new PriorityQueue<>(new MaxComparator<Bid>());
        PriorityQueue<Bid> pqMin = new PriorityQueue<>(new MinComparator<Bid>());

        Bid pelle  = new Bid("pelle", 1);
        Bid sara   = new Bid("sara", 2);
        Bid niklas = new Bid("niklas", 3);

        Bid bruh   = new Bid("bruh", 10);


        pqMax.add(pelle);
        pqMax.add(sara);
        pqMax.add(niklas);

        pqMin.add(pelle);
        pqMin.add(sara);
        pqMin.add(niklas);


        //System.out.println(pqMax.getHighestPrioElem());
        //pqMax.deleteHighestPrioElem();
        //System.out.println(pqMax.getHighestPrioElem());

        pqMax.updateElement(bruh, pelle);

        System.out.println(pqMax.getHighestPrioElem());




    }
}