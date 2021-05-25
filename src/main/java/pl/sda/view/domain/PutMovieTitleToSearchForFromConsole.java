package pl.sda.view.domain;

import java.util.Scanner;

public class PutMovieTitleToSearchForFromConsole {
    private final Scanner scanner;

    public PutMovieTitleToSearchForFromConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public String putSearchedMovieTitle(){
        System.out.println("Wpisz tytuł filmu");
        return scanner.nextLine();
    }

}
