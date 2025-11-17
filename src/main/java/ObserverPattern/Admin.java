package ObserverPattern;

public class Admin extends Observer{

    public Admin(Subject ssubject){
        this.ssubject = ssubject;
        this.ssubject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Admin " + ssubject.getState() );
    }
}
