package com.facisa.user.entities.enums;

    public enum ManifestacaoStatus {
        AGUARDANDO_ANALISE(1),
        SOLICITACAO_ATENDIDA(2),
        SOLICITACAO_CANCELADA(3);

        private int code;

        private ManifestacaoStatus(int code){
            this.code = code;
        }

        public int getCode(){
            return code;
        }

        public static ManifestacaoStatus valueOf(int code){
            for (ManifestacaoStatus value : ManifestacaoStatus.values()){
                if (value.getCode() == code){
                    return value;
                }
            }
            throw new IllegalArgumentException("Codigo invalido de ManifestacaoStatus");
        }
    }
