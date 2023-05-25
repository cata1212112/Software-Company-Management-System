package Exceptions;

public class EmailAlreadyInUse extends Exception{
    public EmailAlreadyInUse(String mail) {
        super("Email: " + mail + " already in use!");
    }
}
