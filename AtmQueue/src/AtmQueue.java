import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmQueue {

    public static void main(String[] args) {
        AtmQueue atmQueue = new AtmQueue();
        atmQueue.createapp();
    }

    public void createapp() {
        // Create Queue
        Queue queue = new Queue();

        // Create Frame
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 1));
        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create Components
        JTextField nameField = new JTextField();
        JButton addToQueue = new JButton("Add To Queue");
        addToQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add to Queue
                String nameEntered = nameField.getText();
                queue.enqueue(nameEntered);
                nameField.setText("");
                queue.printQueue();
                System.out.println(nameEntered + " Just joined the Queue");
            }
        });
        JButton removeFromQueue = new JButton("Remove From Queue");
        removeFromQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove from Queue
                String removedName = queue.dequeue();
                if (removedName != null){
                    queue.printQueue();
                    System.out.println(removedName + " is done using the ATM.");
                } else {
                    System.out.println("The Queue is Empty. No one is currently in need of the ATM");
                }
            }
        });
        // Add Components to Frame
        frame.add(nameField);
        frame.add(addToQueue);
        frame.add(removeFromQueue);

        // Make frame visible
        frame.setVisible(true);
    }
}


class Queue {
    public String[] array = new String[10];
    public int size = 10;
    public int front = -1;
    public int back = -1;

    public void enqueue(String item) {
        // write code
        if (isFull()) {
            System.out.println("This Queue is full!");
            return;
        }

        if (front == -1) front = 0;
        back++;
        array[back] = item;
    }

    public String dequeue() {
        // write code here
        if (isEmpty()) { return null; }

        String element = array[front];
        if (front >= back) {
            front = -1; back = -1;
        } else {
            front++;
        }
        return element;
    }

    public boolean isEmpty() { return front == back; }
    public boolean isFull() { return back == size - 1; }

    public void printQueue() {
        for (int i = front; i <= back; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}
