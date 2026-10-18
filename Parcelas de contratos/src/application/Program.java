package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.OnlinePaymentService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
    static void main() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        IO.println("Entre os dados do contrato:");
        int numero = Integer.parseInt(IO.readln("Número: "));
        String stringData = IO.readln("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(stringData, fmt);
        double valorContrato = Double.parseDouble(IO.readln("Valor do contrato: "));
        Contract contract = new Contract(numero, data, valorContrato);

        int mesesParcela = Integer.parseInt(IO.readln("Entre com o numero de parcelas: "));
        if (mesesParcela < 1){
            IO.println("O número de parcelas não pode ser menor do que 1!");
            while (true){
                mesesParcela = Integer.parseInt(IO.readln("Entre com o numero de parcelas: "));
                if(mesesParcela < 1){
                    IO.println("O número de parcelas não pode ser menor do que 1!");
                }else{
                    break;
                }
            }
        }

        OnlinePaymentService ops = new PaypalService();
        ContractService cs = new ContractService(ops);

        cs.processContract(contract, mesesParcela);

        IO.println("Parcelas:");
        IO.println(contract);
    }
}
