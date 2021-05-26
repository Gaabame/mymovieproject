package pl.sda.view.domain;

import java.util.Scanner;

public class PutMovieIdToSearchFromConsole {

    private final Scanner scanner;

    public PutMovieIdToSearchFromConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public String putSearchedMovieId(){
        System.out.println("Wpisz id filmu");
        return scanner.nextLine();
    }
}

