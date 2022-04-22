public class Test {

    public static void main(String[] args){
        PriorityQueue pqMax = new PriorityQueue<>(new MaxComparator<>());
        PriorityQueue<Bid> pqMin = new PriorityQueue<>(new MinComparator<>());

        Bid pelle  = new Bid("pelle", 1);
        Bid sara   = new Bid("sara", 2);
        Bid niklas = new Bid("niklas", 3);

        Bid bruh   = new Bid("bruh", 10);


        pqMax.add(pelle);
        pqMax.add(sara);
        pqMax.add(niklas);
        pqMax.add(12);

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
