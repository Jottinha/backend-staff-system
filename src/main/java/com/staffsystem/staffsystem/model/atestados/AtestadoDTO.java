package com.staffsystem.staffsystem.model.atestados;

import java.util.Date;

public record AtestadoDTO(int diasAfastado, Date dataAfastamento, String linkReferencia, String nomeColaborador, int validado) {
}
