package core.view;

import core.domain.Company;

import java.util.Scanner;

public class ConsoleView {

    private Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        ConsoleView app = new ConsoleView();

        Company company = new Company();

        System.out.println(company);
    }
}
