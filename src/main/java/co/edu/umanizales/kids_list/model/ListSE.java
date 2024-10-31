package co.edu.umanizales.kids_list.model;


public class ListSE {

    Node head;

    public  ListSE(){
        this.head = null;
    }

    public void addToEnd(Kid kid){
        Node newNode = new Node(kid);

        if (head == null){
            head = newNode;

        }
        else{
            Node current = head;
            while (current.next != null) {
                current =  current.next;

            }
            current.next = newNode;
        }
    }

    public void printList(){
        Node current = head;
        while (current != null){
            System.out.printf(current.kid.id, current.kid.name);
            current = current.next;

        }

    }
    public void addToStart(Kid kid){
        Node newNode = new Node(kid);
        newNode.next = this.head;
        this.head = newNode;

    }

    public void addInPosition(int position, Kid kid){
        Node newNode = new Node(kid);

        if (position == 1){
            this.addToStart(kid);
        }

        Node current = this.head;
        int number = 0;

        while(current != null && number < position - 1 ){
            current = current.next;
            number++;

        }
        newNode.next = current.next;
        current.next = newNode;

    }
    public ListSE invertList(){
        ListSE newList = new ListSE();
        Node current = this.head;

        while(current != null){
            newList.addToStart(current.kid);
            current = current.next;

        }
        return newList;
    }
    public void deleteById(String id){
        Node current = this.head;
        if(head == null){
            System.out.print("there's no elements");
            }

        if(head.kid.id == id){
            this.head = this.head.next;
            return;
        }
        while(current.next.kid.id != id){
            current = current.next;

        }
        current.next = current.next.next;

    }
    public void deleteByPosition(int position){
        if(position == 1){
            this.head = this.head.next;
            }

        else{
            int count = 0;
            Node current  = this.head;
            while(count < position-1){
                current = current.next;
                count++;
            }
            current.next = current.next.next;

        }

    }
    public void swapEnds(){
        if(this.head == null || this.head.next == null){
            System.out.print("insufficient nodes");
            return;
        }
        Node prevLast = null;
        Node last = this.head;
        Node first = this.head;

        while(last.next !=null){
            prevLast = last;
            last = last.next;
        }
        // two nodes
        if(this.head == prevLast){
            this.head = last;
            this.head.next = prevLast;
            prevLast.next = null;
            }
        else{
            prevLast.next = this.head;
            last.next = this.head.next;
            this.head = last;
            prevLast.next.next = null;


            }




        }
        public void mixByGender(){
            ListSE boys = new ListSE();
            ListSE girls = new ListSE();

            Node tmp = this.head;
            while (tmp!=null){
                if(tmp.kid.gender == 'M'){
                    boys.addToEnd(tmp.kid);

                }
                else{
                    girls.addToEnd(tmp.kid);
                }
                tmp = tmp.next;
            }
            this.head = null;
            Node boyNode = boys.head;
            Node girlNode = girls.head;

            while(boys !=null  || girls !=null){
                if(boyNode !=null){
                    this.addToEnd(boyNode.kid);
                    boyNode = boyNode.next;
                }
                if(girlNode !=null){
                    this.addToEnd(girlNode.kid);
                    girlNode = girlNode.next;
                }
            }
        }


}

