package com.medicalclinic.api.domain.payment;

public enum PaymentStatus {
    PENDING,      // O pagamento está pendente e ainda não foi processado.
    COMPLETED,    // O pagamento foi concluído com sucesso.
    FAILED,       // O pagamento falhou devido a um erro.
    CANCELLED,    // O pagamento foi cancelado pelo usuário ou pelo sistema.
}
