package application;

import entities.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {
    static void main() {
        Path caminho = Path.of("mensagem.txt");
        List<Employee> funcionarios = new ArrayList<>();
        double salarioDigitado;

        while (true) {
            try {
                salarioDigitado = Double.parseDouble(IO.readln("Informe o salário base: "));

                if (!Double.isFinite(salarioDigitado) || salarioDigitado < 0) {
                    IO.println("Informe um salário válido.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                IO.println("Entrada inválida. Digite um número.");
            }
        }

        final double salarioBase = salarioDigitado;

        String inicialDigitada;

        while (true) {
            inicialDigitada = IO.readln("Informe a inicial do nome: ").strip();

            if (inicialDigitada.matches("\\p{L}")) {
                break;
            }

            IO.println("Informe apenas uma letra.");
        }

        final String inicialNome = inicialDigitada.toUpperCase(Locale.ROOT);

        try{
            for(String linha: Files.readAllLines(caminho)){
                String[] partes = linha.split(",");
                String nome = partes[0];
                String email = partes[1];
                double salario = Double.parseDouble(partes[2]);
                funcionarios.add(new Employee(nome, email, salario));
            }

            List<String> emailOrdenados = funcionarios.stream()
                    .filter(emp -> emp.getSalary() > salarioBase)
                    .map(Employee::getEmail)
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .toList();

            double soma = funcionarios.stream()
                    .filter(emp -> emp.getName().toUpperCase(Locale.ROOT).startsWith(inicialNome))
                    .mapToDouble(Employee::getSalary)
                    .sum();

            IO.println("\nEmail das pessoas cujo salário é maior que %.2f".formatted(salarioBase));
            emailOrdenados.forEach(IO::println);

            IO.println("\nSoma do salário das pessoas cujo nome começa com %s: %.2f".formatted(inicialNome, soma));
        }catch (IOException e){
            IO.println(e.getMessage());
        }
    }
}
