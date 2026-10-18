package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService ops;

    public ContractService(OnlinePaymentService ops) {
        this.ops = ops;
    }

    public void processContract(Contract contract, int months){
        double valorParcela = contract.getTotalValue() / months;

        for(int i = 1; i <= months; i++){
            double valorComJuros = ops.interest(valorParcela, i);
            double valorTotal = ops.paymentFee(valorComJuros);
            LocalDate mesDaProximaParcela = contract.getDate().plusMonths(i);
            contract.addInstallment(new Installment(mesDaProximaParcela, valorTotal));
        }
    }
}
