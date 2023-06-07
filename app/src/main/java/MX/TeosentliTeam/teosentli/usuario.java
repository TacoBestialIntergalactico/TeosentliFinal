package MX.TeosentliTeam.teosentli;

public class usuario {
    private String id;
    private String nUsusario;
    private String mail;
    private String pass;

    public usuario(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getnUsusario() {
        return nUsusario;
    }

    public void setnUsusario(String nUsusario) {
        this.nUsusario = nUsusario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
