package Models;

public class Manager {


    public Manager(){}


    public String getStartMessage()
    {
        return "Hello, I will help you figure out this DATABASE.";
    }

    public String getChoiceMessage()
    {
        String s = "Choose your option or type exit: \n" +
                "1) List all films\n" +
                "2) List films with good raiting\n" +
                "3) Get actors of film\n" +
                "4) Get actors that directed on or more films\n"+
                "5) Insert film\n"+
                "6) Delete film";
        return s;
    }

    public String getMistakeMessage()
    {
        return "Your answer is incorrect. Please, try again.";
    }

    public String getExitMessage()
    {
        return "Thanks for visiting our database, goodbye!";
    }
}
