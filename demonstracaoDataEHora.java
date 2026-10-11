import java.time.*;

void main(){
    LocalDate data = LocalDate.now();

    //Criação de variáveis para consulta de data, baseadas na data de agora, now()
    int diaDoMesNumerico = data.getDayOfMonth();
    IO.println("Dia: " + diaDoMesNumerico);

    DayOfWeek diaDaSemanaPorEscrito = data.getDayOfWeek();
    IO.println("Dia por escrito: " + diaDaSemanaPorEscrito);

    int diaNumericoEmRelacaoAoAno = data.getDayOfYear();
    IO.println("Dia em relação aos 365 dias: " + diaNumericoEmRelacaoAoAno);
    IO.println();

    int mesNumerico = data.getMonthValue();
    IO.println("Mês: " + mesNumerico);

    Month mesPorEscrito = data.getMonth();
    IO.println("Mês por escrito: " + mesPorEscrito);
    IO.println();

    int ano = data.getYear();
    IO.println("Ano: " + ano);
    IO.println("-------------------------------------------\n");

    //Calculo da idade, utilizando período, considerando a data toda e não somente o ano
    LocalDate dataNascimento = LocalDate.of(2002, 4, 5);
    Period periodo = Period.between(dataNascimento, data);
    IO.println("Ano atual: " + ano);
    IO.println("Ano de nascimento: " + dataNascimento.getYear());
    IO.println("Período desde o nascimento: " + periodo.getYears() + " anos, " + periodo.getMonths() + " meses, " + periodo.getDays() + " dias");
    IO.println("-------------------------------------------\n");

    //Atualização de datas
    LocalDate amanha = data.plusDays(1);
    LocalDate ontem = data.minusDays(1);
    IO.println("Data atual: " + data);
    IO.println("Data de amanhã: " + amanha);
    IO.println("Data de ontem: " + ontem);
    IO.println("-------------------------------------------\n");

    LocalDate semanaQueVem = data.plusWeeks(1);
    LocalDate semanaPassada = data.minusWeeks(1);
    IO.println("Data da semana que vem: " + semanaQueVem);
    IO.println("Data da semana Passada: " + semanaPassada);
    IO.println("-------------------------------------------\n");

    LocalDate mesQueVem = data.plusMonths(1);
    LocalDate mesPassado = data.minusMonths(1);
    IO.println("Data atual, mês que vem: " + mesQueVem);
    IO.println("Data atual, mês passado: " + mesPassado);
    IO.println("-------------------------------------------\n");

    LocalDate anoQueVem = data.plusYears(1);
    LocalDate anoPassado = data.minusYears(1);
    IO.println("Data atual, ano que vem: " + anoQueVem);
    IO.println("Data atual, ano passado: " + anoPassado);
    IO.println("-------------------------------------------\n");

    //Comparação de datas
    LocalDate outraData = LocalDate.of(2030, 1, 1);

    boolean antes = data.isBefore(outraData);
    boolean depois = data.isAfter(outraData);
    boolean iguais = data.isEqual(outraData);

    IO.println("A data " + data + " é anterior a data " + outraData + "? " + antes);
    IO.println("A data " + data + " é posterior a data " + outraData + "? " + depois);
    IO.println("A data " + data + " é igual a data " + outraData + "? " + iguais);
    IO.println("-------------------------------------------\n");

    //Descobrir informações sobre o mês
    int qtdDias = data.lengthOfMonth();
    int qtdDiasAno = data.lengthOfYear();
    boolean anoBissexto = data.isLeapYear();

    IO.println("Quantidade de dias no mês de " + mesPorEscrito + ": " + qtdDias);
    IO.println("Quantidade de dias no ano de "  + ano + ": " + qtdDiasAno);
    IO.println("O ano " + ano + " é um ano bissexto? " + anoBissexto);
    IO.println("-------------------------------------------\n");

    //Descobrir primeiro/último dia do mês
    LocalDate primeiroDia = data.withDayOfMonth(1);
    LocalDate ultimoDia = data.withDayOfMonth(data.lengthOfMonth());

    IO.println("Primeiro dia do mês de " + mesPorEscrito + ": " + primeiroDia);
    IO.println("Último dia do mês de " + mesPorEscrito + ": " + ultimoDia);
    IO.println("-------------------------------------------\n");

    // Formatação de datas
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String dataFormatada = data.format(formato);

    IO.println("Data formatada: " + dataFormatada);
}