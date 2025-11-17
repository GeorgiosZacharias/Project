package ObserverPattern;

public class User extends Observer {
    public User(Subject ssubject){
        this.ssubject = ssubject;
        this.ssubject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("--------------------");
        System.out.println( "User " + ssubject.getState()  );
    }
}
