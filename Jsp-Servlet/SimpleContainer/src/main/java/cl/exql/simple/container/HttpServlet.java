package cl.exql.simple.container;

public abstract class HttpServlet {

    public void init(){
        System.out.println("HttpServlet init...");
    }

    public void service(){

    }

    public void doGet() {
        System.out.println("HttpServlet doGet...");
    }

    public void doPost() {
        System.out.println("HttpServlet doPost...");
    }
}
