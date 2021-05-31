package pl.sda.view.domain;

import java.util.Scanner;

public class PutMovieIdToSearchFromConsole {

    private final Scanner scanner;

    public PutMovieIdToSearchFromConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public String putSearchedMovieImdbId(){
        System.out.println("Wpisz id filmu");
        return scanner.nextLine();
    }

    public Long putSearchedMovieIdFromBase(){
        System.out.println("Wpisz id filmu");
        return scanner.nextLong();
    }
}

