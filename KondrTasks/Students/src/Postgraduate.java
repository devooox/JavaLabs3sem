public class Postgraduate extends Student{
    private Academic supervisor;

    public Postgraduate(String name, String login, String email, String academicName){
        super(name, login, email);
        supervisor = new Academic(academicName);
    }

    public Academic getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Academic supervisor) {
        this.supervisor = supervisor;
    }
}
