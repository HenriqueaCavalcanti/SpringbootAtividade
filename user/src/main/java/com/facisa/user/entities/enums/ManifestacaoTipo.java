package com.facisa.user.entities.enums;

    public enum ManifestacaoTipo {
        RECLAMACAO(1),
        SUGESTAO(2),
        ELOGIO(3);

        private int code;

        private ManifestacaoTipo(int code){
            this.code = code;
        }

        public int getCode(){
            return code;
        }

        public static ManifestacaoTipo valueOf(int code){
            for (ManifestacaoTipo value : ManifestacaoTipo.values()){
                if (value.getCode() == code){
                    return value;
                }
            }
            throw new IllegalArgumentException("Codigo invalido de ManifestacaoTipo");
        }
    }
