public class Undergraduate extends Student{
    private Academic tutor;

    public Undergraduate(String name, String login, String email, String academicName){
        super(name, login, email);
        tutor = new Academic(academicName);
    }

    public Academic getTutor() {
        return tutor;
    }

    public void setTutor(Academic tutor) {
        this.tutor = tutor;
    }
}
