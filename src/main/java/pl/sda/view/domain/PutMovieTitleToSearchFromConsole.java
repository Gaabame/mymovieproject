package pl.sda.view.domain;

import java.util.Scanner;

public class PutMovieTitleToSearchFromConsole {
    private final Scanner scanner;

    public PutMovieTitleToSearchFromConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public String putSearchedMovieTitle(){
        System.out.println("Wpisz tytuł filmu");
        return scanner.nextLine();
    }
}
