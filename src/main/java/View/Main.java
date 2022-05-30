package View;

import Connector.Exceptions.JDBCConnectionException;
import DAO.ActorsDAO;
import DAO.Exceptions.DAOException;
import DAO.FilmsDAO;
import Models.Actor;
import Models.Film;
import Models.Manager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws JDBCConnectionException, DAOException {

        Manager manager = new Manager();

        System.out.println(manager.getStartMessage());
        System.out.println(manager.getChoiceMessage());

        Scanner in = new Scanner(System.in);

        // Переменная для ответов читателя
        String answer = in.nextLine();
        boolean exit_is_needed = false;

        while (!exit_is_needed)
        {
            switch (answer) {
                case "1" -> {
                    FilmsDAO B = new FilmsDAO();

                    List<Film> films = B.getAllFilms();
                    if (films.isEmpty())
                    {
                        System.out.println("We're sorry, but there are no films.");
                    }
                    else {
                        for (Film b : films)
                            System.out.println(b.toString());
                    }
                    System.out.println("\n" + manager.getChoiceMessage());
                    answer = in.nextLine();
                }
                case "2" -> {
                    FilmsDAO B = new FilmsDAO();

                    List<Film> films = B.getFilmsWithGoodRating();
                    if (films.isEmpty())
                    {
                        System.out.println("We're sorry, but there are no films.");
                    }
                    else {
                        for (Film b : films)
                            System.out.println(b.toString());
                    }
                    System.out.println("\n" + manager.getChoiceMessage());
                    answer = in.nextLine();
                }
                case "3" -> {
                    ActorsDAO B = new ActorsDAO();

                    System.out.println("Please, enter film name:");
                    String film_name = in.nextLine();
                    List<Actor> actors = B.getActorsOfFilm(film_name);
                    if (actors.isEmpty())
                    {
                        System.out.println("We're sorry, but there are no such film ot film has no actors");
                    }
                    else {
                        for (Actor b : actors)
                            System.out.println(b.toString());
                    }
                    System.out.println("\n" + manager.getChoiceMessage());
                    answer = in.nextLine();
                }
                case "4" -> {
                    ActorsDAO B = new ActorsDAO();

                    List<Actor> b = B.getActorsWithOneOrMoreFilms();
                    if (b == null)
                    {
                        System.out.println("We're sorry, but there are no such actor");
                    }
                    else {
                        for (Actor a: b) {
                            System.out.println(a.toString());
                        }
                    }
                    System.out.println("\n" + manager.getChoiceMessage());
                    answer = in.nextLine();
                }
                case "5" -> {
                    FilmsDAO B = new FilmsDAO();
                    System.out.println("Enter film id: ");
                    int id = Integer.parseInt(in.nextLine());
                    System.out.println("Enter film title: ");
                    String title = in.nextLine();
                    System.out.println("Enter film date(yyyy-mm-dd): ");
                    String created = in.nextLine();
                    System.out.println("Enter film country: ");
                    String country = in.nextLine();
                    System.out.println("Enter film raiting: ");
                    Double raiting = Double.valueOf(in.nextLine());
                    System.out.println("Enter director id: ");
                    String dir = in.nextLine();
                    B.insertFilm(id, title, created, country, raiting, dir);
                    System.out.println("\n" + manager.getChoiceMessage());
                    answer = in.nextLine();
                }
                case "6" -> {
                    FilmsDAO B = new FilmsDAO();
                    System.out.println("Enter film id: ");
                    int id = Integer.parseInt(in.nextLine());
                    B.deleteFilm(id);
                    System.out.println("\n" + manager.getChoiceMessage());
                    answer = in.nextLine();
                }
                case "exit" -> {
                    exit_is_needed = true;
                    System.out.println(manager.getExitMessage());
                }
                default -> {
                    System.out.println(manager.getMistakeMessage() + "\n" + manager.getChoiceMessage());
                    answer = in.nextLine();
                }
            }
        }
    }
}
