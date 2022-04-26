
import java.io.*;
import java.util.*;

public class Lab2 {
    public static String pureMain(String[] commands) {

        PriorityQueue<Bid> sell_pq = new PriorityQueue<>(new MinComparator<>());
        PriorityQueue<Bid> buy_pq = new PriorityQueue<>(new MaxComparator<>());

        StringBuilder sb = new StringBuilder();
        StringBuilder ob = new StringBuilder(); // orderbook

        for (int line_no = 0; line_no < commands.length; line_no++) {
            String line = commands[line_no];
            if (line.equals("")) continue;

            String[] parts = line.split("\\s+");
            if (parts.length != 3 && parts.length != 4)
                throw new RuntimeException("line " + line_no + ": " + parts.length + " words");
            String name = parts[0];
            if (name.charAt(0) == '\0')
                throw new RuntimeException("line " + line_no + ": invalid name");
            String action = parts[1];
            int price;
            try {
                price = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new RuntimeException(
                        "line " + line_no + ": invalid price");
            }

            Bid bid = new Bid(name, price);

            switch (action) {
                case "K" -> buy_pq.add(bid);
                case "S" -> sell_pq.add(bid);
                case "NK" -> {

                    int newPrice;
                    try {
                        newPrice = Integer.parseInt(parts[3]);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(
                                "line " + line_no + ": invalid price");
                    }

                    Bid newBid = new Bid(name, newPrice);

                    buy_pq.updateElement(newBid, bid);

                }
                case "NS" -> {

                    int newPrice;
                    try {
                        newPrice = Integer.parseInt(parts[3]);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(
                                "line " + line_no + ": invalid price");
                    }

                    Bid newBid = new Bid(name, newPrice);

                    sell_pq.updateElement(newBid, bid);

                }

                default -> throw new RuntimeException(
                        "line " + line_no + ": invalid action");
            }

            if (sell_pq.size() == 0 || buy_pq.size() == 0) continue;

            // comparing the two priority-queues, if a match deleting the elements from the queues and printing
            // out the order
            if (sell_pq.getHighestPrioElem().price <= buy_pq.getHighestPrioElem().price) {

                ob.append(buy_pq.getHighestPrioElem().name);
                ob.append(" buys a share from ");
                ob.append(sell_pq.getHighestPrioElem().name + " for ");
                ob.append(buy_pq.getHighestPrioElem().price + "kr \n");

                sell_pq.deleteHighestPrioElem();
                buy_pq.deleteHighestPrioElem();
            }
        }

        sb.append("Order book:\n");
        sb.append(ob);

        sb.append("Sellers: ");
        sb.append(sell_pq.showHeap()).append("\n");

        sb.append("Buyers: ");
        sb.append(buy_pq.showHeap());

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader actions;
        if (args.length != 1) {
            actions = new BufferedReader(new InputStreamReader(System.in));
        } else {
            actions = new BufferedReader(new FileReader(args[0]));
        }

        List<String> lines = new LinkedList<String>();
        while (true) {
            String line = actions.readLine();
            if (line == null) break;
            lines.add(line);
        }
        actions.close();

        System.out.println(pureMain(lines.toArray(new String[lines.size()])));
    }
}

