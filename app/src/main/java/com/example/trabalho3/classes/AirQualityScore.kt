package com.example.trabalho3.classes

enum class AirQualityScore(val text: String, val implications: String) {
    BOM ("Bom", "A qualidade do ar é considerada satisfatória, a poluição do ar representa pouco ou nenhum risco"),
    MODERADO ("Moderado", "A qualidade do ar é aceitável. No entanto, para alguns poluentes pode haver um problema de saúde moderada para um número muito pequeno de pessoas que são mais sensíveis à poluição do ar."),
    RUIM ("Ruim", "Não Saudável para Grupos Sensíveis. Membros de grupos sensíveis podem ter efeitos na a saúde. O público em geral não é susceptível de ser afetado."),
    MUITO_RUIM ("Muito Ruim", "Toda a população pode começar a sentir os efeitos na saúde. Membros de grupos sensíveis podem apresentar efeitos mais sérios de saúde."),
    PESSIMO ("Péssimo", "As advertências de saúde de situações de emergência. Toda a população é mais susceptível de ser afectada."),
    PERIGOSO ("Perigoso", "Alerta de saúde: todos podem experimentar efeitos mais graves para a saúde.")
}
